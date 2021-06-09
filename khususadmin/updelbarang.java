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
//class updel barang merupakan class yang berfungsi bagi admin untuk mengedit dtaa barang, menghapus data barang, serta menambahkan data barang
//jadi pada class ini akan terdapat 4 method utama, delete, insert, update, maupun tabel untuk menampillkan barang
public class updelbarang extends javax.swing.JFrame {

    /**
     * Creates new form updelbarang
     */
    //method untuk menampilkan semua barang yang ada pada tabel barang ke tabel di program
     public void tampilan_barang(){
        PreparedStatement statement;
        ResultSet result;
        DefaultTableModel model=new DefaultTableModel();//nama tabel
        model.addColumn("nama_barang");//nama yg bakal muncul ditabel
        model.addColumn("harga_barang");//nama yg muncul aka judul kolom
        model.addColumn("stok");//aka judul kolom
        try{
    
            String sql="Select *From barang";//karena fungsinya untuk menampilkan barang-barang maka, query select all dari table barang
            statement = dbconnection.getConnection().prepareStatement(sql);//untuk memprepare query serta menghubungkannya dengan class dbconnection pada package database
            //yang berfungsi untuk menghubungkan ke database
            result=statement.executeQuery();//mengexecute query
            while(result.next()){
               model.addRow(new Object[]{result.getString(2),result.getString(3), result.getString(4)}); 
               //ini ngambil data dari tabel, getstring 2 berarti ngambil data pada kolom 2, dsb
               data.setModel(model);
               //set datanya ke tabel
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());//pesan yang akan ditampilkan jika terjadi error pada koneksi database ataupun kesalahan pada query
        }
    }
    public void insert_barang(){
         PreparedStatement statement;//prepare statement diperlukan untuk memprepare quey yang akan diexecute
        //jika hanya update, delete, insert yang diperlukan hanya prepareStatement, tetapi jika
        //yang digunakan berhubungan dnegan select, dll maka diperlukan juga resultset
         String nama=name.getText();   //untuk mendapatkan nilai dari filed text nama 
         String hargabarang=harga.getText();//mendapatkan nilai dari text field harga
         String stok=jumlah.getText();//mendapatkan nila dari field text 
         String querysql="INSERT INTO barang(nama_barang,harga_barang,stok) VALUES(?,?,?)";//query yang diguakan untuk proses insert
        //dimana aka dilakukan insert 2 value
       try{
           statement = dbconnection.getConnection().prepareStatement(querysql);//prepare
           statement.setString(1, nama);//value utama, mewakilkan '?' pertama
           statement.setString(2,hargabarang );//value kedua, mewakilkan '?' kedua
           statement.setString(3, stok);//value ketiga, mewakilkan '?' ketiga
           
           if(!nama.isEmpty()||!hargabarang.isEmpty()||!stok.isEmpty()){//kondisi jika smeisal tidak ada value yang kosong alias berhasil
               statement.executeUpdate();//baru query akan di execute
               //tiga baris ini berfungsi untuk merefresh tabel, kalau nggak dikasi biasanya pas update atau insert dia nggak mau otomatis tampil
               //jadi caranya di set dulu ke 0 baru ditampilkan lagi
               DefaultTableModel model=(DefaultTableModel)data.getModel();
               model.setRowCount(0);
                 tampilan_barang();
               //setelah di refresh baru akan munsul pesan kalo data udah berhasil ditambah
           JOptionPane.showMessageDialog(this, "data berhasil ditambahkan","berhasil", JOptionPane.INFORMATION_MESSAGE);
             if(nama.isEmpty()||hargabarang.isEmpty()||stok.isEmpty()){//ini kalo semisal ada salah satu field yang masih kosong maka akan error
               JOptionPane.showMessageDialog(this, "tidak boleh ada data yang kosong", "error", JOptionPane.ERROR_MESSAGE);
                } 
           }
           
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }
    //method yang digunakan untuk menghapus barang
    public void delete_barang(){
          PreparedStatement statement;
          ResultSet result;
          String nama=name.getText();
         
          String querysql="delete from barang where nama_barang=?";//query yang diguakan, dengan pengkondisian jika nama-barang nya itu sama dengan nama barang yang di update 
        //oleh admin
       try{
            statement = dbconnection.getConnection().prepareStatement(querysql);//megkoneksikan dan memprepared
            statement.setString(1, nama);//value yang akan dibandingkan atau yang akan mewakilkan '?' pada query
            if(!nama.isEmpty()){//kalo udah nggak ada yang kosong maka statement akan di execute
            statement.executeUpdate();
                //untuk merefresh tabel
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

    //method ketika user/admin mengeklik salah satu row pada tabel
    //jadi ini berfungsi jika misal row tersebut diklik maka data-data pada row tersebut akan langsung di set di textfield
    private void dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataMouseClicked
       
        DefaultTableModel model=(DefaultTableModel)data.getModel();//tabel nya
        String namabarang=(String) model.getValueAt(data.getSelectedRow(), 0);//akan menselect data pada row yang diselect bagian kolom ke-0(artinya pertama)
        String harga1=(String) model.getValueAt(data.getSelectedRow(), 1);//akan menselect data pada row yang diselect bagian kolom ke-1(artinya kedua)
        String stok=(String) model.getValueAt(data.getSelectedRow(), 2);//akan menselect data pada row yang diselect bagian kolom ke-2(artinya ketiga)
        
        name.setText(namabarang);//ini akan langsung di set textnya ke text field name
        harga.setText(harga1);//ini akan langsung di set textnya ke text field harga
        jumlah.setText(stok);//ini akan langsung di set textnya ke text field jumlah
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
