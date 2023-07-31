/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DBUtils {
    public static Connection makeConnection() throws Exception{
        Connection cn=null;
        String IP="localhost";
      //  String instanceName="LAPTOP-JS93416P";
        String port="1433";
        String uid="sa";
        String pwd="12345";
        String db="PlantShop";
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url="jdbc:sqlserver://" +IP+"\\"+ instanceName+":"+port
//                 +";databasename="+db+";user="+uid+";password="+pwd;
        
         String url="jdbc:sqlserver://" +IP+"\\"+":"+port
                 +";databasename="+db+";user="+uid+";password="+pwd;
        Class.forName(driver);
        cn=DriverManager.getConnection(url);
        return cn;
    }
}
