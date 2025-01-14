package View;
import javax.swing.JOptionPane;

public class MessageDialog {

    // Phương thức hiển thị thông báo lỗi
    public static void showErrorDialog(java.awt.Component parentComponent, String message, String title) {
        JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.ERROR_MESSAGE);
    }

    // Phương thức hiển thị thông báo thông tin
    public static void showInfoDialog(java.awt.Component parentComponent, String message, String title) {
        JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Phương thức hiển thị cảnh báo
    public static void showWarningDialog(java.awt.Component parentComponent, String message, String title) {
        JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.WARNING_MESSAGE);
    }
}
