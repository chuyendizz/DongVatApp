package DAO;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class KhuVucDAO {

    // Load data from the KhuVuc table into the JTable
    public static void loadDataToTable(JTable table) {
    String query = "SELECT * FROM KhuVuc";
    try (Connection conn = Connect_SQL.openConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Clear existing data in the table
        model.setRowCount(0);

        // Add the data to the table
        while (rs.next()) {
            int id = rs.getInt("Id");
            String tenKhuVuc = rs.getString("TenKhuVuc");
            model.addRow(new Object[]{id, tenKhuVuc});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
    }
}
    
    public static void loadDataToTableThongKe(JTable table) {
    // Câu truy vấn để lấy danh sách khu vực cùng với số lượng động vật trong mỗi khu vực
    String query = "SELECT k.Id, k.TenKhuVuc, COUNT(dv.Id) AS SoLuongDongVat " +
                   "FROM KhuVuc k " +
                   "LEFT JOIN DongVat dv ON k.Id = dv.MaKhuVuc " +  // Kết nối với bảng DongVat thông qua MaKhuVuc
                   "GROUP BY k.Id, k.TenKhuVuc";  // Nhóm theo khu vực

    try (Connection conn = Connect_SQL.openConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        // Lấy DefaultTableModel từ JTable
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Clear dữ liệu cũ trong bảng
        model.setRowCount(0);

        // Duyệt qua kết quả và thêm vào bảng
        while (rs.next()) {
            int id = rs.getInt("Id");
            String tenKhuVuc = rs.getString("TenKhuVuc");
            int soLuongDongVat = rs.getInt("SoLuongDongVat");  // Số lượng động vật trong khu vực

            // Thêm một dòng vào bảng với tên khu vực và số lượng động vật
            model.addRow(new Object[]{id, tenKhuVuc, soLuongDongVat});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
    }
}

    
      public static ResultSet getAllKhuVuc() {
        String query = "SELECT * FROM KhuVuc";
        try {
            Connection conn = Connect_SQL.openConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching KhuVuc: " + e.getMessage());
            return null;
        }
    }


    // Insert a new KhuVuc record
    public static void insertKhuVuc(String tenKhuVuc) {
        String query = "INSERT INTO KhuVuc (TenKhuVuc) VALUES (?)";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tenKhuVuc);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inserting data: " + e.getMessage());
        }
    }

    // Update an existing KhuVuc record
    public static void updateKhuVuc(int id, String tenKhuVuc) {
        String query = "UPDATE KhuVuc SET TenKhuVuc = ? WHERE Id = ?";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tenKhuVuc);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating data: " + e.getMessage());
        }
    }

    // Delete a KhuVuc record
    public static void deleteKhuVuc(int id) {
        String query = "DELETE FROM KhuVuc WHERE Id = ?";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting data: " + e.getMessage());
        }
    }
}
