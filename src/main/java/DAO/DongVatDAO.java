package DAO;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DongVatDAO {

    // Load data from DongVat table to the table in the UI
    public static void loadDataToTable(JTable table) {
        String query = "SELECT dv.Id, dv.TenDongVat, dv.TenKhoaHoc, dv.ThoiDiemTimThay, dv.MaKhuVuc, dv.MaTinhTrang, dv.MoTa " +
                "FROM DongVat dv";  // Query to fetch all data from the DongVat table
        try (Connection conn = Connect_SQL.openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);  // Clear any existing rows from the table

            // Iterate through the result set and add the data to the table model
            while (rs.next()) {
                int id = rs.getInt("Id");
                String tenDongVat = rs.getString("TenDongVat");
                String tenKhoaHoc = rs.getString("TenKhoaHoc");
                Timestamp thoiDiemTimThay = rs.getTimestamp("ThoiDiemTimThay");
                int maKhuVuc = rs.getInt("MaKhuVuc");
                int maTinhTrang = rs.getInt("MaTinhTrang");
                String moTa = rs.getString("MoTa");

                // Add a new row with the fetched data
                model.addRow(new Object[]{id, tenDongVat, tenKhoaHoc, thoiDiemTimThay, maKhuVuc, maTinhTrang, moTa});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }

    public static void loadDataToTableTK(String tk, JTable table) {
        String query = "SELECT dv.Id, dv.TenDongVat, dv.TenKhoaHoc, dv.ThoiDiemTimThay, dv.MaKhuVuc, dv.MaTinhTrang, dv.MoTa " +
                "FROM DongVat dv " +
                "WHERE dv.TenDongVat LIKE ?";

        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + tk + "%");

            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                int id = rs.getInt("Id");
                String tenDongVat = rs.getString("TenDongVat");
                String tenKhoaHoc = rs.getString("TenKhoaHoc");
                Timestamp thoiDiemTimThay = rs.getTimestamp("ThoiDiemTimThay");
                int maKhuVuc = rs.getInt("MaKhuVuc");
                int maTinhTrang = rs.getInt("MaTinhTrang");
                String moTa = rs.getString("MoTa");

                model.addRow(new Object[]{id, tenDongVat, tenKhoaHoc, thoiDiemTimThay, maKhuVuc, maTinhTrang, moTa});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy động vật với tên: " + tk, "Không có kết quả", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void insertDongVat(String tenDongVat, int maKhuVuc, Timestamp thoiDiemTimThay, String tenKhoaHoc, int maTinhTrang, String moTa) {
        String query = "INSERT INTO DongVat (TenDongVat, MaKhuVuc, ThoiDiemTimThay, TenKhoaHoc, MaTinhTrang, MoTa) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tenDongVat);
            pstmt.setInt(2, maKhuVuc);
            pstmt.setTimestamp(3, thoiDiemTimThay);
            pstmt.setString(4, tenKhoaHoc);
            pstmt.setInt(5, maTinhTrang);
            pstmt.setString(6, moTa);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inserting DongVat: " + e.getMessage());
        }
    }

    // Cập nhật động vật
    public static void updateDongVat(int id, String tenDongVat, int maKhuVuc, Timestamp thoiDiemTimThay, String tenKhoaHoc, int maTinhTrang, String moTa) {
        String query = "UPDATE DongVat SET TenDongVat = ?, MaKhuVuc = ?, ThoiDiemTimThay = ?, TenKhoaHoc = ?, MaTinhTrang = ?, MoTa = ? WHERE Id = ?";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tenDongVat);
            pstmt.setInt(2, maKhuVuc);
            pstmt.setTimestamp(3, thoiDiemTimThay);
            pstmt.setString(4, tenKhoaHoc);
            pstmt.setInt(5, maTinhTrang);
            pstmt.setString(6, moTa);
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating DongVat: " + e.getMessage());
        }
    }

    // Xóa động vật
    public static void deleteDongVat(int id) {
        String query = "DELETE FROM DongVat WHERE Id = ?";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting DongVat: " + e.getMessage());
        }
    }

    // Lấy tất cả động vật
    public static ResultSet getAllDongVat() {
        String query = "SELECT dv.Id, dv.TenDongVat, dv.TenKhoaHoc, dv.ThoiDiemTimThay, dv.MaKhuVuc, dv.MaTinhTrang, dv.MoTa FROM DongVat dv";
        try {
            Connection conn = Connect_SQL.openConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching DongVat: " + e.getMessage());
            return null;
        }
    }
}
