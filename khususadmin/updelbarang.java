/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khususadmin;

import database.dbconnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login_signup.halaman_utama;
import login_signup.menu;

/**
 *
 * @author User
 */
public class updelbarang extends javax.swing.JFrame {

    /**
     * Creates new form updelbarang
     */
     public void tampilan_barang(){
        PreparedStatement statement;
        ResultSet result;
        DefaultTableModel model=new DefaultTableModel();//nama tabel
        model.addColumn("nama_barang");//nama yg bakal muncul ditabel
        model.addColumn("harga_barang");//nama yg muncul aka judul kolom
        model.addColumn("stok");//aka judul kolom
        try{
    
            String sql="Select *From barang";
            statement = dbconnection.getConnection().prepareStatement(sql);
            result=statement.executeQuery();
            while(result.next()){
               model.addRow(new Object[]{result.getString(2),result.getString(3), result.getString(4)}); 
               //ini ngambil data dari tabel, getstring 2 berarti ngambil data pada kolom 2, dsb
               data.setModel(model);
               //set datanya ke tabel
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void insert_barang(){
         PreparedStatement statement;
         String nama=name.getText();    
         String hargabarang=harga.getText();
         String stok=jumlah.getText();
         String querysql="INSERT INTO barang(nama_barang,harga_barang,stok) VALUES(?,?,?)";
       try{
           statement = dbconnection.getConnection().prepareStatement(querysql);
           statement.setString(1, nama);
           statement.setString(2,hargabarang );
           statement.setString(3, stok);
           
           if(!nama.isEmpty()||!hargabarang.isEmpty()||!stok.isEmpty()){
               statement.executeUpdate();
               DefaultTableModel model=(DefaultTableModel)data.getModel();
               model.setRowCount(0);
                 tampilan_barang();
           JOptionPane.showMessageDialog(this, "data berhasil ditambahkan","berhasil", JOptionPane.INFORMATION_MESSAGE);
             if(nama.isEmpty()||hargabarang.isEmpty()||stok.isEmpty()){
               JOptionPane.showMessageDialog(this, "tidak boleh ada data yang kosong", "error", JOptionPane.ERROR_MESSAGE);
                } 
           }
           
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }
    public void delete_barang(){
          PreparedStatement statement;
          ResultSet result;
          String nama=name.getText();
         
          String querysql="delete from barang where nama_barang=?";
       try{
            statement = dbconnection.getConnection().prepareStatement(querysql);
            statement.setString(1, nama);
            if(!nama.isEmpty()){
            statement.executeUpdate();
            DefaultTableModel model=(DefaultTableModel)data.getModel();
               model.setRowCount(0);
                 tampilan_barang();
            JOptionPane.showMessageDialog(this, "data berhasil dihapus","berhasil", JOptionPane.INFORMATION_MESSAGE);
            
            }
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }
    public void update_barang(){
          PreparedStatement statement;
          ResultSet result;
          String nama=name.getText();
            String hargabarang=harga.getText();
         String stok=jumlah.getText();
          String querysql="update barang set nama_barang=?, harga_barang=?, stok=? where nama_barang=?";
       try{
            statement = dbconnection.getConnection().prepareStatement(querysql);
            statement.setString(1, nama);
            statement.setString(2, hargabarang);
            statement.setString(3, stok);
            statement.setString(4, nama);
            if(!nama.isEmpty()||!hargabarang.isEmpty()||!stok.isEmpty()){
            statement.executeUpdate();
            DefaultTableModel model=(DefaultTableModel)data.getModel();
               model.setRowCount(0);
                 tampilan_barang();
            JOptionPane.showMessageDialog(this, "data berhasil diupdate","berhasil", JOptionPane.INFORMATION_MESSAGE);
            
            }
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }
   
    public updelbarang() {
        initComponents();
      tampilan_barang();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jumlah = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        hapus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tamvah = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        data = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jumlah.setBorder(null);
        jumlah.setOpaque(false);
        getContentPane().add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 220, 30));

        harga.setBorder(null);
        harga.setOpaque(false);
        getContentPane().add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 220, 30));

        hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusMouseClicked(evt);
            }
        });
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 60, 30));

        jLabel2.setText("harga barang");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, -1, -1));

        tamvah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tamvahMouseClicked(evt);
            }
        });
        getContentPane().add(tamvah, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 60, 30));

        jLabel4.setText("stok ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jLabel3.setText("nama barang");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aset/tombolupdate.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 404, 70, 30));

        name.setBorder(null);
        name.setOpaque(false);
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 220, 40));

        data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(data);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 400, 160));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aset/nexttombol.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 464, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aset/tambah barang.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        setSize(new java.awt.Dimension(716, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseClicked
        // TODO add your handling code here:
        delete_barang();
    }//GEN-LAST:event_hapusMouseClicked

    private void tamvahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tamvahMouseClicked
        // TODO add your handling code here:
        insert_barang();
    }//GEN-LAST:event_tamvahMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        update_barang();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataMouseClicked
       
        DefaultTableModel model=(DefaultTableModel)data.getModel();
        String namabarang=(String) model.getValueAt(data.getSelectedRow(), 0);
        String harga1=(String) model.getValueAt(data.getSelectedRow(), 1);
        String stok=(String) model.getValueAt(data.getSelectedRow(), 2);
        
        name.setText(namabarang);
        harga.setText(harga1);
        jumlah.setText(stok);
    }//GEN-LAST:event_dataMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        int jawab= JOptionPane.showConfirmDialog(this, "klik yes untuk ke menu accept, no untuk keluar, dan cancel untuk batal");
        switch(jawab){
            case JOptionPane.YES_OPTION:
                JOptionPane.showMessageDialog(this, "anda memilih ke menu acceptretur");
                new acceptretur().setVisible(true);
                this.dispose();
                break;
            case JOptionPane.NO_OPTION:
                 JOptionPane.showMessageDialog(this, "anda memilih keluar");
                new halaman_utama().setVisible(true);
                  break;
            case JOptionPane.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "anda memilih cancel");
                break;
        }
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(updelbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updelbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updelbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updelbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updelbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable data;
    private javax.swing.JLabel hapus;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField name;
    private javax.swing.JLabel tamvah;
    // End of variables declaration//GEN-END:variables
}
