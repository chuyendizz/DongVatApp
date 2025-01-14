package DAO;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TinhTrangDAO {

    // Load data from the TinhTrang table into the JTable
    public static void loadDataToTable(JTable table) {
    String query = "SELECT * FROM TinhTrang";  // Query to fetch all data from the TinhTrang table
    try (Connection conn = Connect_SQL.openConnection();  // Open the connection
         Statement stmt = conn.createStatement();  // Create a statement to execute the query
         ResultSet rs = stmt.executeQuery(query)) {  // Execute the query and get the result set

        DefaultTableModel model = (DefaultTableModel) table.getModel();  // Get the table model
        model.setRowCount(0);  // Clear any existing rows from the table

        // Iterate through the result set and add the data to the table model
        while (rs.next()) {
            int id = rs.getInt("Id");  // Get the Id from the result set
            String tenTinhTrang = rs.getString("TenTinhTrang");  // Get the status name from the result set
            model.addRow(new Object[]{id, tenTinhTrang});  // Add the data as a new row in the table
        }
    } catch (SQLException e) {  // Catch any SQL exceptions
        JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
    }
}
 public static ResultSet getAllTinhTrang() {
        String query = "SELECT * FROM TinhTrang";
        try {
            Connection conn = Connect_SQL.openConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching TinhTrang: " + e.getMessage());
            return null;
        }
    }

    // Insert a new TinhTrang record
    public static void insertTinhTrang(String tenTinhTrang) {
        String query = "INSERT INTO TinhTrang (TenTinhTrang) VALUES (?)";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tenTinhTrang);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inserting data: " + e.getMessage());
        }
    }

    // Update an existing TinhTrang record
    public static void updateTinhTrang(int id, String tenTinhTrang) {
        String query = "UPDATE TinhTrang SET TenTinhTrang = ? WHERE Id = ?";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tenTinhTrang);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating data: " + e.getMessage());
        }
    }

    // Delete a TinhTrang record
    public static void deleteTinhTrang(int id) {
        String query = "DELETE FROM TinhTrang WHERE Id = ?";
        try (Connection conn = Connect_SQL.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting data: " + e.getMessage());
        }
    }
}
