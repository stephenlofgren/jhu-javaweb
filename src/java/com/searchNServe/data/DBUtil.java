/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchNServe.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jjose
 */
public class DBUtil {

    private static Connection connection;

    static {
        initializeDB();
    }
    
    
    
    /*
    * The method creates a Connection object. Loads the embedded driver,
    * starts and connects to the database using the connection URL.
     */
    public static Connection getConnection(){
            return connection;
    }

    public static void initializeDB()  {
        try
        {
            String protocol = "jdbc:derby:";
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            
//            String protocol = "jdbc:derby://localhost:1527/";
//            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            Properties props = new Properties(); // connection properties
            String dbName = "derbyDB"; // the name of the database
            

            connection = DriverManager.getConnection(protocol + dbName
                    + ";create=true", props);

            connection.setAutoCommit(false);

            /* Creating a statement object that we can use for running various
             * SQL statements commands against the database.*/
            Statement s = connection.createStatement();

            // User table created
            String createTable = "create table useraccount (fullname varchar(30), "
                    + "username varchar(30), "
                    + "password varchar(30))";
            
            System.out.println(createTable);        
            s.execute(createTable);
            
            // Inserting into User table
            PreparedStatement psInsert 
                    = connection.prepareStatement(
                        "insert into useraccount values (?, ?, ?)");

            psInsert.setString(1, "Jason Jose");
            psInsert.setString(2, "jjose");
            psInsert.setString(3, "password123");
            psInsert.executeUpdate();

            psInsert.setString(1, "Stephen Lofgren");
            psInsert.setString(2, "slofgren");
            psInsert.setString(3, "password123");
            psInsert.executeUpdate();

            psInsert.setString(1, "Bertram Richardson");
            psInsert.setString(2, "brichardson");
            psInsert.setString(3, "password123");
            psInsert.executeUpdate();        
            
            System.out.println("--> DB initialized");
            
        }
        catch (Exception ex)
        {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void destroyDB(){
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
            
            System.out.println("--> DB destroyed");
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
