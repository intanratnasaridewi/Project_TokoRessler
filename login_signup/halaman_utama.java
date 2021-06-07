/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_signup;

import java.awt.Color;
import javax.swing.JOptionPane;
import submenu.menu1_lihatbarang;

/**
 *
 * @author User
 */
public class halaman_utama extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public halaman_utama() {
        initComponents();
        setBackground(new Color (0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        setsignup = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aset/nexttombol.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, 30));

        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("lihat barang");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 80, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aset/tombolcari.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login_signup/dashboard_frame.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 170, 30));

        setsignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setsignupMouseClicked(evt);
            }
        });
        getContentPane().add(setsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 384, 140, 20));

        setSize(new java.awt.Dimension(700, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      for (double i=0.0;i<=1.0;i=i+0.1){//looping yang digunakan aga ketika membuka halaan utama agak perlahan
          String nilai=i+"";
          float a= Float.valueOf(nilai);
          this.setOpacity(a);
          try{
              Thread.sleep(30);
          }catch(Exception e){
              
          }
      }
    }//GEN-LAST:event_formWindowOpened

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        int jawab= JOptionPane.showConfirmDialog(this, "klik yes untuk admin, no untuk pelanggan, dan cancel untuk batal");
        switch(jawab){
            case JOptionPane.YES_OPTION:
                JOptionPane.showMessageDialog(this, "anda memilih login");
                new loginadmin().setVisible(true);
                this.dispose();
                break;
            case JOptionPane.NO_OPTION:
                 JOptionPane.showMessageDialog(this, "anda memilih halaman utama");
                  new loginsite().setVisible(true);
                  this.dispose();
                  break;
            case JOptionPane.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "anda memilih cancel");
                break;
        }
      
    }//GEN-LAST:event_jLabel2MouseClicked

    private void setsignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setsignupMouseClicked
       //menu juka sign up maka class sign up akan ditampilkan
        new signupsite().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_setsignupMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       new menu1_lihatbarang().setVisible(true);//jika memilih menu lihat barang maka class lihat barang akan ditampilkan
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
      //konfirmasi ini untuk keluar 
         int jawab= JOptionPane.showConfirmDialog(this, "apakah anda ingin keluar?");
        switch(jawab){
            case JOptionPane.YES_OPTION:
                JOptionPane.showMessageDialog(this, "anda memilih keluar");
                System.exit(0);
                break;
            case JOptionPane.NO_OPTION:
                 JOptionPane.showMessageDialog(this, "anda memilih no");
                 
                  break;
           
        }
    
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(halaman_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(halaman_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(halaman_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(halaman_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new halaman_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel setsignup;
    // End of variables declaration//GEN-END:variables
}
