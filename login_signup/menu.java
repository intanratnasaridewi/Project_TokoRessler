/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_signup;

import submenu.menu1_lihatbarang;
import submenu.menu2_transaksi;
import submenu.menu3_detail_transaksi;
import submenu.menu4_returbarang;
/**
 *
 * @author User
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    public menu() {
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

        tombolmenu1 = new javax.swing.JLabel();
        tombolmenu2 = new javax.swing.JLabel();
        tombolmenu3 = new javax.swing.JLabel();
        tombolmenu4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tombolmenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tombolmenu1MouseClicked(evt);
            }
        });
        getContentPane().add(tombolmenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 180, 40));

        tombolmenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tombolmenu2MouseClicked(evt);
            }
        });
        getContentPane().add(tombolmenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 190, 50));

        tombolmenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tombolmenu3MouseClicked(evt);
            }
        });
        getContentPane().add(tombolmenu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 200, 50));

        tombolmenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tombolmenu4MouseClicked(evt);
            }
        });
        getContentPane().add(tombolmenu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 190, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aset/menuutama.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        setSize(new java.awt.Dimension(716, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tombolmenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombolmenu1MouseClicked
       new menu1_lihatbarang().setVisible(true);
    }//GEN-LAST:event_tombolmenu1MouseClicked

    private void tombolmenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombolmenu2MouseClicked
       new menu2_transaksi().setVisible(true);
    }//GEN-LAST:event_tombolmenu2MouseClicked

    private void tombolmenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombolmenu3MouseClicked
        new menu3_detail_transaksi().setVisible(true);
    }//GEN-LAST:event_tombolmenu3MouseClicked

    private void tombolmenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombolmenu4MouseClicked
     new menu4_returbarang().setVisible(true);
    }//GEN-LAST:event_tombolmenu4MouseClicked

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel tombolmenu1;
    private javax.swing.JLabel tombolmenu2;
    private javax.swing.JLabel tombolmenu3;
    private javax.swing.JLabel tombolmenu4;
    // End of variables declaration//GEN-END:variables

    private Object menu1_lihatbarang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}