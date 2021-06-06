/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submenu;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import com.sun.org.apache.bcel.internal.generic.Select;
import database.dbconnection;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.select;
import javax.swing.JOptionPane;


/**
 *
 * @author User
 */
public final class menu3_detail_transaksi extends javax.swing.JFrame {

    /**
     * Creates new form menu3_detail_transaksi
     */
    public void auto_id() {
     PreparedStatement statement;
        ResultSet result;
        try{
        String sql="select id_pembayaran from pembayaran order by id_pembayaran desc limit 1";
        statement=dbconnection.getConnection().prepareStatement(sql);
        result=statement.executeQuery();
        if(result.next()){
            String no=result.getString("id_pembayaran");
            int co=no.length();
            String txt=no.substring(0, 2);
            String num=no.substring(2,co);
            int n=Integer.parseInt(num);
            n++;
            String anum=Integer.toString(n);
            String ftxt=txt+anum;
            kode.setText(ftxt);
            
        }else{
            kode.setText("PB1");
        }
        }catch(HeadlessException | SQLException ex){
           System.out.println(ex.getMessage());
       }
}
    public double tampilan_totalnilai(String id) {
        PreparedStatement statement;
        ResultSet result;
       
    double a = 0;
    String sql="select totaltransaksi from pembayaran where id_pembayaran=? order by id_pembayaran limit 1";
        try{
        statement=dbconnection.getConnection().prepareStatement(sql);
        statement.setString(1, id);
        result=statement.executeQuery();
        if(result.next()){
            a=result.getDouble("totaltransaksi");
         
        }
         }catch(HeadlessException | SQLException ex){
           System.out.println(ex.getMessage());
       }
return a;
    }
 
    public void tampilan_namapelanggan(){
         PreparedStatement statement;
         ResultSet result;
    
        try{
    
            String sql="Select *From transaksi";
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
    public void tampilan_alamat(){
         PreparedStatement statement;
         ResultSet result;
    
        try{
    
            String sql="Select *From pelanggan";
           statement = dbconnection.getConnection().prepareStatement(sql);
            result=statement.executeQuery();
            while(result.next()){
               alamat.addItem(result.getString("alamat")); 
              
            }result.last();
            int jumlahdata=result.getRow();
            result.first();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
      public void jumlah_transaksi(String nama, String datettrans, String kodetrans){
      
          CallableStatement smt;
         
          try{
           String sql="{call totaltransaksi(?,?, ?)}";
           smt=dbconnection.getConnection().prepareCall(sql);
           smt.setString(1,nama);
           smt.setString(2,datettrans);
           smt.setString(3,kodetrans);
          // smt.registerOutParameter(3, Types.DOUBLE);
           smt.execute();
       
          }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
      public void printdata(String kodetext, String nameuser, String tanggal,String jpengiriman, String alamat) throws IOException, SQLException{
        String path="D:\\";
         PreparedStatement statement;
         ResultSet result;
       com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
      double b=tampilan_totalnilai(kodetext);
       try{
           
           PdfWriter.getInstance(doc, new FileOutputStream(path+""+kodetext+".pdf"));
           doc.open();
           
           String sql="Select *From transaksi where nama_pelanggan=? and tanggal_transaksi=?";
           statement = dbconnection.getConnection().prepareStatement(sql);
           statement.setString(1, nameuser);
           statement.setString(2, tanggal);
           result=statement.executeQuery();
            Paragraph paragraph1=new Paragraph("****************************KWITANSI************************************");
           doc.add(paragraph1);
           Paragraph paragraph2=new Paragraph("\nTanggal :"+tanggal);
           doc.add(paragraph2);
           Paragraph paragraph3=new Paragraph("\n***************************************************************************\n");
           doc.add(paragraph3);
            Paragraph paragraph4=new Paragraph("\nId Transaksi :"+kodetext+"\nNama  :"+nameuser);
           doc.add(paragraph4);
           Paragraph paragraph5=new Paragraph("\nJasa Pengiriman :"+jpengiriman+"\nAlamat  :"+alamat);
           doc.add(paragraph5);
           doc.add(paragraph3);
           Paragraph paragraph6=new Paragraph("\nTOTAL TAGIHAN :"+b);
           doc.add(paragraph6);
            doc.add(paragraph3);
        PdfPTable tb1=new PdfPTable(5);
         tb1.addCell("nama\n");
         tb1.addCell("barang\n");
         tb1.addCell("jumlah\n");
         tb1.addCell("total\n");
         tb1.addCell("Tanggal\n");
           while(result.next()){
         
         tb1.addCell(result.getString(2));
         tb1.addCell(result.getString(3));
         tb1.addCell(result.getString(4));
         tb1.addCell(result.getString(5));
         tb1.addCell(result.getString(6));
        doc.add(tb1);
           } 
           
       }catch(DocumentException | FileNotFoundException e){
            System.out.println(e.getMessage());
       }
       doc.close();
       int a=JOptionPane.showConfirmDialog(null, "ingin print kwitansi?","select", JOptionPane.YES_NO_OPTION);
       if(a==0){
           try{
               if((new File("D:\\"+kodetext+".pdf")).exists()){
                   Process p=Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler D:\\"+kodetext+".pdf");
               }else{
                   System.out.println("File Tidak DItemukan");
               }
           }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
       }
       }
 
     }
     
     public void insert_pembayaran() throws IOException{
       
          PreparedStatement statement; 
          String masukkode= kode.getText();
          String namauser=String.valueOf(namapelanggan.getSelectedItem());
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String date = sdf.format(datetransaksi.getDate());
          String jpembayaran=String.valueOf(metodebayar.getSelectedItem());
          String jpengiriman=String.valueOf(pengiriman.getSelectedItem());
          String pAlamat=String.valueOf(alamat.getSelectedItem());
          String querysql="INSERT INTO pembayaran (id_pembayaran,nama_pelanggan,tanggal_transaksi,jenispembayaran,pengiriman,alamat) VALUES(?,?,?,?,?,?)";
          
       try{
           statement = dbconnection.getConnection().prepareStatement(querysql);
           statement.setString(1, masukkode);
           statement.setString(2, namauser);
           statement.setString(3, date);
           statement.setString(4, jpembayaran);
           statement.setString(5, jpengiriman);
           statement.setString(6, pAlamat);
           
           if(!namauser.isEmpty()){
               statement.executeUpdate();
               jumlah_transaksi(namauser, date, masukkode);
               JOptionPane.showMessageDialog(this, "data berhasil ditambahkan","berhasil", JOptionPane.INFORMATION_MESSAGE);
              
               printdata(masukkode, namauser, date,jpengiriman,pAlamat);
            //  tampilan_transaksi();
             if(namauser.isEmpty()){
               JOptionPane.showMessageDialog(this, "tidak boleh ada data yang kosong", "error", JOptionPane.ERROR_MESSAGE);
                } 
           }else {
                JOptionPane.showMessageDialog(this, "password-confirm tidak cocok", "error", JOptionPane.ERROR_MESSAGE);
           }
           
       }catch(HeadlessException | SQLException ex){
           System.out.println(ex.getMessage());
       }
    }
     
    
    public menu3_detail_transaksi() {
        initComponents();
        tampilan_namapelanggan();
        tampilan_alamat();
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

        pengiriman = new javax.swing.JComboBox<>();
        metodebayar = new javax.swing.JComboBox<>();
        namapelanggan = new javax.swing.JComboBox<>();
        alamat = new javax.swing.JComboBox<>();
        submit = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
        datetransaksi = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        retur = new javax.swing.JLabel();
        transaksi = new javax.swing.JLabel();
        search = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pengiriman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "jne", "jnt", "ambil langsung" }));
        getContentPane().add(pengiriman, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 270, -1));

        metodebayar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "transfer", "langsung" }));
        metodebayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodebayarActionPerformed(evt);
            }
        });
        getContentPane().add(metodebayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 270, -1));

        getContentPane().add(namapelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 270, -1));

        getContentPane().add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 270, -1));

        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 90, 50));

        kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeActionPerformed(evt);
            }
        });
        getContentPane().add(kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 270, -1));
        getContentPane().add(datetransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        jLabel5.setBackground(new java.awt.Color(102, 102, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aset/Frame 10.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 440, 60));

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 50, 30));

        jLabel3.setText("tanggal transaksi");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 90, 20));

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 50, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aset/nexttombol.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 30, 30));

        retur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returMouseClicked(evt);
            }
        });
        getContentPane().add(retur, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 90, 30));

        transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transaksiMouseClicked(evt);
            }
        });
        getContentPane().add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 90, 30));

        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aset/menu3.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        setSize(new java.awt.Dimension(716, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returMouseClicked
        // TODO add your handling code here:
        new menu4_returbarang().setVisible(true);
    }//GEN-LAST:event_returMouseClicked

    private void transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaksiMouseClicked
        // TODO add your handling code here:
        new menu2_transaksi().setVisible(true);
    }//GEN-LAST:event_transaksiMouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
        new menu1_lihatbarang().setVisible(true);
    }//GEN-LAST:event_searchMouseClicked

    private void metodebayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodebayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_metodebayarActionPerformed

    private void kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeActionPerformed

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
        try {
            insert_pembayaran();
        } catch (IOException ex) {
            Logger.getLogger(menu3_detail_transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_submitMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
       new menu4_returbarang().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

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
            java.util.logging.Logger.getLogger(menu3_detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu3_detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu3_detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu3_detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu3_detail_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> alamat;
    private com.toedter.calendar.JDateChooser datetransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField kode;
    private javax.swing.JComboBox<String> metodebayar;
    private javax.swing.JComboBox<String> namapelanggan;
    private javax.swing.JComboBox<String> pengiriman;
    private javax.swing.JLabel retur;
    private javax.swing.JLabel search;
    private javax.swing.JLabel submit;
    private javax.swing.JTextField total;
    private javax.swing.JLabel transaksi;
    // End of variables declaration//GEN-END:variables
}
