/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//program untuk melakukan transaksi yang terjadi
package submenu;


import database.dbconnection;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login_signup.menu;

/**
 *
 * @author User
 */
public final class menu2_transaksi extends javax.swing.JFrame {

    /**
     * Creates new form menu2_transaksi
     */
    public void tampilan_nama(){
         PreparedStatement statement;
         ResultSet result;
    
        try{
    
            String sql="Select *From barang";
           statement = dbconnection.getConnection().prepareStatement(sql);
            result=statement.executeQuery();
            while(result.next()){
               nama.addItem(result.getString("nama_barang")); 
              
            }result.last();
            int jumlahdata=result.getRow();
            result.first();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void tampilan_namapelanggan(){
         PreparedStatement statement;
         ResultSet result;
    
        try{
    
            String sql="Select *From pelanggan";
           statement = dbconnection.getConnection().prepareStatement(sql);
            result=statement.executeQuery();
            while(result.next()){
               namapelanggan.addItem(result.getString("nama_pelanggan")); 
              
            }result.last();
            int jumlahdata=result.getRow();
            result.first();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
//    public void tampilan_harga(){
//         PreparedStatement statement;
//         ResultSet result;
//    
//        try{
//    
//            String sql="Select *From transaksi";
//           statement = connection_inner.koneksi().prepareStatement(sql);
//            result=statement.executeQuery();
//            while(result.next()){
//               String harga1=result.getString("harga_barang");
//               harga.setText(harga1);
//              
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
public void auto_id() {
     PreparedStatement statement;
        ResultSet result;
        try{
        String sql="select id_transaksi from transaksi order by id_transaksi desc limit 1";
        statement=dbconnection.getConnection().prepareStatement(sql);
        result=statement.executeQuery();
        if(result.next()){
            String no=result.getString("id_transaksi");
            int co=no.length();
            String txt=no.substring(0, 2);
            String num=no.substring(2,co);
            int n=Integer.parseInt(num);
            n++;
            String anum=Integer.toString(n);
            String ftxt=txt+anum;
            kode.setText(ftxt);
            
        }else{
            kode.setText("TR000");
        }
        }catch(HeadlessException | SQLException ex){
           System.out.println(ex.getMessage());
       }
}
    public void tampilan_transaksi(){
        PreparedStatement statement;
        ResultSet result;
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("no.");
        model.addColumn("nama_pelanggan");
        model.addColumn("nama_barang");
        model.addColumn("jumlah_barang");
        model.addColumn("harga_barang");
        model.addColumn("tanggal_transaksi");
        try{
    
            String sql="Select *From transaksi";
            statement = dbconnection.getConnection().prepareStatement(sql);
            result=statement.executeQuery();
            while(result.next()){
               model.addRow(new Object[]{result.getString(1),result.getString(2), result.getString(3),result.getString(4),result.getDouble(5),result.getDate(6)}); 
               data.setModel(model);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param jumlahbeli
     * @param kodetrans
     * @param nama
     * @param id
     * @return
     */
    public void jumlah_transaksi(String nama, String kodetrans){
         // PreparedStatement statement;
          CallableStatement smt;
         // ResultSet result;
       //   Double Totalharga = null;
         
          try{
           String sql="{call hargatotal(?,?)}";
           smt=dbconnection.getConnection().prepareCall(sql);
           smt.setString(1,nama);
           smt.setString(2,kodetrans);
          // smt.registerOutParameter(3, Types.DOUBLE);
           smt.execute();
       
          }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void insert_transaksi(){
       
          PreparedStatement statement;
          String namabarang= String.valueOf(nama.getSelectedItem());
          String masukkode= kode.getText();
          String namauser=String.valueOf(namapelanggan.getSelectedItem());
          int jumlah1= Integer.parseInt(jumlah.getText());
          String jumlahbeli=Integer.toString(jumlah1);
          java.util.Date date=new java.util.Date();
          java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        
          String querysql="INSERT INTO transaksi (id_transaksi,nama_pelanggan, nama_barang,jumlah_beli, tanggal_transaksi) VALUES(?,?,?,?,?)";
          
       try{
           statement = dbconnection.getConnection().prepareStatement(querysql);
           statement.setString(1, masukkode);
           statement.setString(2, namauser);
           statement.setString(3, namabarang);
           statement.setString(4, jumlahbeli);
           statement.setDate(5, sqlDate);
           
           if(!namabarang.isEmpty()){
               statement.executeUpdate();
                jumlah_transaksi(namabarang, masukkode);
              JOptionPane.showMessageDialog(this, "data berhasil ditambahkan","berhasil", JOptionPane.INFORMATION_MESSAGE);
            
              tampilan_transaksi();
             if(namabarang.isEmpty()){
               JOptionPane.showMessageDialog(this, "tidak boleh ada data yang kosong", "error", JOptionPane.ERROR_MESSAGE);
                } 
           }else {
                JOptionPane.showMessageDialog(this, "password-confirm tidak cocok", "error", JOptionPane.ERROR_MESSAGE);
           }
           
       }catch(HeadlessException | SQLException ex){
           System.out.println(ex.getMessage());
       }
    }
    
    public menu2_transaksi() {
        initComponents();
        tampilan_nama();
        tampilan_namapelanggan();
             auto_id();
  
   
        
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nama = new javax.swing.JComboBox<>();
        tambah = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
        namapelanggan = new javax.swing.JComboBox<>();
        retur = new javax.swing.JLabel();
        pembayaran = new javax.swing.JLabel();
        lihatproduct = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        data = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nama.setBackground(new java.awt.Color(0, 0, 153));
        nama.setBorder(null);
        nama.setOpaque(false);
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 270, 30));

        tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahMouseClicked(evt);
            }
        });
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 110, 40));

        kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeActionPerformed(evt);
            }
        });
        getContentPane().add(kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 280, 30));

        getContentPane().add(namapelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 280, 30));

        retur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returMouseClicked(evt);
            }
        });
        getContentPane().add(retur, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 90, 30));

        pembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pembayaranMouseClicked(evt);
            }
        });
        getContentPane().add(pembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 100, 30));

        lihatproduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lihatproductMouseClicked(evt);
            }
        });
        getContentPane().add(lihatproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 30));

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 110, 50));

        jLabel2.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("barang");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        jumlah.setBackground(new java.awt.Color(0, 0, 153));
        jumlah.setForeground(new java.awt.Color(255, 255, 255));
        jumlah.setBorder(null);
        jumlah.setOpaque(false);
        getContentPane().add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 280, 30));

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
        jScrollPane1.setViewportView(data);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 470, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aset/menu2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        setSize(new java.awt.Dimension(716, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_namaActionPerformed

    private void lihatproductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lihatproductMouseClicked
     new menu1_lihatbarang().setVisible(true);
    }//GEN-LAST:event_lihatproductMouseClicked

    private void pembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembayaranMouseClicked
        // TODO add your handling code here:
        new menu3_detail_transaksi().setVisible(true);
    }//GEN-LAST:event_pembayaranMouseClicked

    private void returMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returMouseClicked
        // TODO add your handling code here:
        new menu4_returbarang().setVisible(true);
    }//GEN-LAST:event_returMouseClicked

    private void tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahMouseClicked
        // TODO add your handling code here:
       
        insert_transaksi();
        
    }//GEN-LAST:event_tambahMouseClicked

    private void kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new menu3_detail_transaksi().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(menu2_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu2_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu2_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu2_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu2_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah; //untuk menampilkan jumlah total
    private javax.swing.JTextField kode; //untuk menginput kode barang
    private javax.swing.JLabel lihatproduct; //untuk melihat barang
    private javax.swing.JComboBox<String> nama; //untuk menampilkan nama barang
    private javax.swing.JComboBox<String> namapelanggan; //untuk menampilkan nama pelanggan
    private javax.swing.JLabel pembayaran; //untuk menampilkan harga pembayaran
    private javax.swing.JLabel retur; //untuk melakukan retur
    private javax.swing.JLabel tambah; //untuk melakukan penambahan barang
    // End of variables declaration//GEN-END:variables
}
