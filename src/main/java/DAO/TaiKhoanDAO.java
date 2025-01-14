package DAO;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TaiKhoanDAO {

    // Load data from TaiKhoan table to the table in the UI
    public static void loadDataToTable(JTable table) {
        String query = "SELECT Ma, Hoten, Email, MatKhau FROM TaiKhoan";  // Query to fetch all data from the TaiKhoan table
        try (Connection conn = Connect_SQL.openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);  // Clear any existing rows from the table

            // Iterate through the result set and add the data to the table model
            while (rs.next()) {
                int ma = rs.getInt("Ma");
                String hoten = rs.getString("Hoten");
                String email = rs.getString("Email");
                String matkhau = rs.getString("MatKhau"); // Note: store as hash in production apps
                model.addRow(new Object[]{ma, hoten, email, matkhau});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }

    public static void loadDataToTableTraCuu(String tk, JTable tblTraCuuTK) {

    // Câu lệnh SQL tìm kiếm tài khoản theo tên hoặc email với điều kiện LIKE
    String query = "SELECT tk.Ma, tk.HoTen, tk.Email, tk.MatKhau FROM TaiKhoan tk " +
                   "WHERE tk.HoTen LIKE ? OR tk.Email LIKE ?";  // Điều kiện LIKE với ký tự % ở đầu và cuối

    try (Connection conn = Connect_SQL.openConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        // Đặt tham số cho câu lệnh SQL, sử dụng "%" để tìm kiếm một phần tên tài khoản hoặc email
        stmt.setString(1, "%" + tk + "%");
        stmt.setString(2, "%" + tk + "%");

        // Thực hiện truy vấn
        ResultSet rs = stmt.executeQuery();

        // Lấy model của bảng JTable
        DefaultTableModel model = (DefaultTableModel) tblTraCuuTK.getModel();
        model.setRowCount(0);  // Xóa dữ liệu cũ trong bảng

        // Duyệt qua kết quả và thêm vào bảng JTable
        while (rs.next()) {
            int maTK = rs.getInt("Ma");
            String hoTen = rs.getString("HoTen");
            String email = rs.getString("Email");            
            String MatKhau = rs.getString("MatKhau");


            // Thêm mỗi dòng vào bảng JTable
            model.addRow(new Object[]{maTK, hoTen, email, MatKhau});
        }

        // Nếu không tìm thấy kết quả, hiển thị thông báo
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy tài khoản với tên hoặc email: " + tk, "Không có kết quả", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}

    
    // Insert a new TaiKhoan record
    public static void insertTaiKhoan(String hoten, String email, String matkhau) {
        String query = "INSERT INTO TaiKhoan (Hoten, Email, MatKhau) VALUES (?, ?, ?)";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, hoten);
            pstmt.setString(2, email);
            pstmt.setString(3, matkhau);  // Ideally, hash the password before storing it
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Account created successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inserting data: " + e.getMessage());
        }
    }

    // Update an existing TaiKhoan record
    public static void updateTaiKhoan(int ma, String hoten, String email, String matkhau) {
        String query = "UPDATE TaiKhoan SET Hoten = ?, Email = ?, MatKhau = ? WHERE Ma = ?";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, hoten);
            pstmt.setString(2, email);
            pstmt.setString(3, matkhau);  // Ideally, hash the password before updating it
            pstmt.setInt(4, ma);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Account updated successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating data: " + e.getMessage());
        }
    }

    // Delete a TaiKhoan record
    public static void deleteTaiKhoan(int ma) {
        String query = "DELETE FROM TaiKhoan WHERE Ma = ?";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, ma);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Account deleted successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting data: " + e.getMessage());
        }
    }
    
    // Verify login credentials (optional for login functionality)
    public static boolean verifyLogin(String email, String matkhau) {
        String query = "SELECT * FROM TaiKhoan WHERE Email = ? AND MatKhau = ?";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            pstmt.setString(2, matkhau);  // In practice, hash the password
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true; // Found the user
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error during login: " + e.getMessage());
        }
        return false;  // Invalid login
    }
}
