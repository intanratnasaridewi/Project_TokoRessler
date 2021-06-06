/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;

/**
 *
 * @author User
 */
// merupakan class yang digunakan untuk menghubungkan antara database dan java netbeans

public class dbconnection {
      public static Connection getConnection(){
           Connection dbc=null;
           MysqlDataSource datasource=new MysqlDataSource();
           datasource.setServerName("localhost");//set server name
           datasource.setUser("root");//server user
           datasource.setPassword("");//set password=disini kondisinya tidak memiliki password jadi dikosongkan
           datasource.setDatabaseName("toko_reseller");//nama database yang ingin disambungkan
           datasource.setPortNumber(3306);//nama port dari database, bisa dilihat di port xampp saat menyambungkan dengan mysql
           try{
               dbc=datasource.getConnection();//men-try untuk menyambungan ke databasae toko_reseller 
           }catch(Exception ex){
               System.out.println(ex.getMessage());//message yang akan ditampilan jika semisal ada kesalahan query atau penyambungan dengan database
           }
           return dbc;
       }
    
}
