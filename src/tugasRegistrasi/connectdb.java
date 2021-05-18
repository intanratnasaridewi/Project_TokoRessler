/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasRegistrasi;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
/**
 *
 * @author User
 */
public class connectdb {
    
       public static Connection getConnection(){
           Connection dbc=null;
           MysqlDataSource datasource=new MysqlDataSource();
           datasource.setServerName("localhost");
           datasource.setUser("root");
           datasource.setPassword("");
           datasource.setDatabaseName("tugasbesar");
           datasource.setPortNumber(3306);
           try{
               dbc=datasource.getConnection();
           }catch(Exception ex){
               System.out.println(ex.getMessage());
           }
           return dbc;
       }
    
}
