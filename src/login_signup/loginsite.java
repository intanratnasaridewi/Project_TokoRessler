/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_signup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import tugasRegistrasi.connectdb;
import tugasRegistrasi.home;

/**
 *
 * @author User
 */
public class loginsite extends javax.swing.JFrame {

    /**
     * Creates new form loginsite
     */
    public loginsite() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        namalogin = new javax.swing.JTextField();
        passwordlogin = new javax.swing.JPasswordField();
        forgot = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        signup = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login_signup/login_frame.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 400));

        namalogin.setText("jTextField1");
        getContentPane().add(namalogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 160, 30));

        passwordlogin.setText("jPasswordField1");
        getContentPane().add(passwordlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 160, 30));

        forgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotMouseClicked(evt);
            }
        });
        getContentPane().add(forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 90, 20));

        jLabel2.setText("jLabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 130, 30));

        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupMouseClicked(evt);
            }
        });
        getContentPane().add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 120, 20));

        setSize(new java.awt.Dimension(316, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void forgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseClicked
       
    }//GEN-LAST:event_forgotMouseClicked

    private void signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseClicked
        new signupsite().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signupMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        PreparedStatement statement;
       ResultSet result;
        String name=namalogin.getText();
       String Password=String.valueOf(passwordlogin.getPassword());
       String querysql="SELECT*FROM tb_pelanggan WHERE nama=? AND password=?";
       try{
           statement = connectdb.getConnection().prepareStatement(querysql);
           statement.setString(1, name);
           statement.setString(2, Password);
           result=statement.executeQuery();
           if(result.next()){
               home hm=new home();
               hm.setVisible(true);
               hm.pack();
               hm.setLocationRelativeTo(null);
               this.dispose();
           }else if(name.isEmpty()||Password.isEmpty()){
               JOptionPane.showMessageDialog(this, "nama/password tidak boleh kosong", "error", JOptionPane.ERROR_MESSAGE);
           }
           else{
               JOptionPane.showMessageDialog(null,"nama/password tidak cocok", "error",2);
           }
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       
    }//GEN-LAST:event_jLabel2MouseClicked

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginsite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginsite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginsite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginsite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginsite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField namalogin;
    private javax.swing.JPasswordField passwordlogin;
    private javax.swing.JLabel signup;
    // End of variables declaration//GEN-END:variables
}
