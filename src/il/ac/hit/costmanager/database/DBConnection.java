/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.database;

import il.ac.hit.costmanager.exeptions.CostManagerException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Birbal
 */
public class DBConnection {

    static Connection conn = null;
    static String error = "Sorry for inconvenience.Internal error.";

    /**
     * @return Connection
     */
    public static Connection dbconnector() throws CostManagerException {
        try {
            // new Security();
            String un = "root";
            // new Security();
            String pw = " ";
            // new Security();
            String url = "jdbc:derby://localhost:1527/costManagement";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(url, un, pw);
        } catch (Exception e) {
            throw new CostManagerException(e.getMessage());
        }
        return conn;
    }
}

