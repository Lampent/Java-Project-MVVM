/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Birbal
 */
public class DbConnection {

    static Connection conn = null;
    static String error = "Sorry for inconvenience.Internal error.";

    public static Connection dbconnector() throws SQLException {
        try {
            // new Security();
            String un = "root";
            // new Security();
            String pw = "";
            // new Security();
            String url = "jdbc:mysql://localhost:3306/costmanagement";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, un, pw);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println(e);
        }

        return conn;
    }
}
