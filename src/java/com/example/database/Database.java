/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AhmadSulha
 */
public class Database {

    Connection conn = null;

    public Database(String url, String database, String username, String password) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(url + database +
                    ";create=true;user=" + username + ";password=" + password);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public String executeSql(double weight, double shippingPrice) {
        
        String sqlExecutionStatus;
        String sqlStatement = "INSERT INTO shipping(SHIPPING_WEIGHT, TOTAL_SHIPPING_PRICE) "
                + "VALUES (" + weight + ", " + shippingPrice + ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlStatement);
            sqlExecutionStatus = "Data inserted into the database successfully";
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            sqlExecutionStatus = "Failed to insert data into the database";
        }
        return sqlExecutionStatus;
    }
}
