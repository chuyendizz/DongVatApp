package View;


import javax.swing.table.DefaultTableModel;
import DAO.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Home
 */

public final class Login extends JFrame {
     public Login() {
        initComponents();
        //ShowDuLieu();
    }
    //Đỗ dữ liệu từ Database vào arraylist
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane_Home = new javax.swing.JTabbedPane();
        jPanel_DangNhap = new javax.swing.JPanel();
        jPanel_DangNhap1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtUser1 = new javax.swing.JTextField();
        jpwdPass1 = new javax.swing.JPasswordField();
        btnLogin1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Cancel = new javax.swing.JButton();
        jPanel_HuongDan = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thư viện HIU");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTabbedPane_Home.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane_Home.setAlignmentX(2.0F);
        jTabbedPane_Home.setAlignmentY(2.0F);
        jTabbedPane_Home.setAutoscrolls(true);
        jTabbedPane_Home.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTabbedPane_Home.setInheritsPopupMenu(true);

        jPanel_DangNhap1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setText("Tên đăng nhập:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel13.setText("Mật khẩu:");

        txtUser1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtUser1.setText("admin");

        jpwdPass1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jpwdPass1.setText("admin");

        btnLogin1.setBackground(new java.awt.Color(204, 255, 204));
        btnLogin1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnLogin1.setText("Đăng nhập");
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/secrecy-icon.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("ĐĂNG NHẬP");

        btn_Cancel.setBackground(new java.awt.Color(255, 204, 204));
        btn_Cancel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btn_Cancel.setText("Thoát");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_DangNhap1Layout = new javax.swing.GroupLayout(jPanel_DangNhap1);
        jPanel_DangNhap1.setLayout(jPanel_DangNhap1Layout);
        jPanel_DangNhap1Layout.setHorizontalGroup(
            jPanel_DangNhap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DangNhap1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel_DangNhap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_DangNhap1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel2))
                    .addGroup(jPanel_DangNhap1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel_DangNhap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_DangNhap1Layout.createSequentialGroup()
                                .addComponent(btnLogin1)
                                .addGap(53, 53, 53)
                                .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addGroup(jPanel_DangNhap1Layout.createSequentialGroup()
                                .addGroup(jPanel_DangNhap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel_DangNhap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jpwdPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(4825, Short.MAX_VALUE))
        );
        jPanel_DangNhap1Layout.setVerticalGroup(
            jPanel_DangNhap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DangNhap1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel_DangNhap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_DangNhap1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel_DangNhap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel_DangNhap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpwdPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel_DangNhap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(456, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_DangNhapLayout = new javax.swing.GroupLayout(jPanel_DangNhap);
        jPanel_DangNhap.setLayout(jPanel_DangNhapLayout);
        jPanel_DangNhapLayout.setHorizontalGroup(
            jPanel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DangNhapLayout.createSequentialGroup()
                .addComponent(jPanel_DangNhap1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_DangNhapLayout.setVerticalGroup(
            jPanel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DangNhapLayout.createSequentialGroup()
                .addComponent(jPanel_DangNhap1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane_Home.addTab("ĐĂNG NHẬP", jPanel_DangNhap);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("                                      HƯỚNG DẪN SỬ DỤNG PHẦN MỀM QUẢN LÝ THƯ VIỆN \n  ĐĂNG KÝ MƯỢN SÁCH\n  - Người dùng cần phải đăng nhập tài khoản vào phần mềm để có thể đăng ký mượn sách.\n  - Nếu người dùng không đăng nhập, phần mềm sẽ yêu cầu người dùng đăng nhập.\n  - Mỗi sinh viên chỉ được mượn tối đa 5 quyển sách. Giảng viên sẽ đuược mượn tối \n đa 10 quyển sách.\n\n  *Lưu ý: Người mượn sách cần phải bảo quản sách và trả sách đúng thời hạn, nếu không \n    sẽ bị phạt và có thể bị khóa tài khoản.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel_HuongDanLayout = new javax.swing.GroupLayout(jPanel_HuongDan);
        jPanel_HuongDan.setLayout(jPanel_HuongDanLayout);
        jPanel_HuongDanLayout.setHorizontalGroup(
            jPanel_HuongDanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_HuongDanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_HuongDanLayout.setVerticalGroup(
            jPanel_HuongDanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_HuongDanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel_HuongDanLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 243, Short.MAX_VALUE))
        );

        jTabbedPane_Home.addTab("HƯỚNG DẪN", jPanel_HuongDan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
       StringBuilder sb = new StringBuilder();

    // Validate that the username and password are not empty

    // If validation fails, show the error message
    if (sb.length() > 0) {
        MessageDialog.showErrorDialog(this, sb.toString(), "Lỗi");
    } else {
        // Proceed with login using TaiKhoanDAO
        try {
            String username = txtUser1.getText();  // Assuming username is the email address
            String password = new String(jpwdPass1.getPassword());  // Get the entered password

            // Check login using TaiKhoanDAO
            boolean loginSuccess = TaiKhoanDAO.verifyLogin(username, password);

            // If login is successful
            if (loginSuccess) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công.");

                // Proceed based on user role - You could use the email or another method to check roles
                if (username.startsWith("admin")) {
                    // If the user is admin, show the admin interface
                    this.dispose();
                    new AdminJFrame().setVisible(true);
                } 
            } else {
                // If login fails
                MessageDialog.showErrorDialog(this, "Sai tên đăng nhập hoặc mật khẩu.", "Lỗi");
            }
        } catch (Exception e) {
            // If an error occurs (e.g., database connection issue)
            System.out.println(e);
            MessageDialog.showErrorDialog(this, "Lỗi kết nối đến cơ sở dữ liệu.", "Lỗi");
        }
}

    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin1;
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel_DangNhap;
    private javax.swing.JPanel jPanel_DangNhap1;
    private javax.swing.JPanel jPanel_HuongDan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane_Home;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPasswordField jpwdPass1;
    private javax.swing.JTextField txtUser1;
    // End of variables declaration//GEN-END:variables

    private void setTendangnhap(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
