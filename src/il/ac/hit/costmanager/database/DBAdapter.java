/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.database;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Birbal
 */
public class DBAdapter {

    public static ResultSet executeQuery(String query) throws CostManagerException {
        try {
            Connection connection = DBConnection.dbconnector();
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch(Exception ex) {
            throw new CostManagerException("Error accourd when execioting a query");
        }
    }
    
    public static void executeUpdate(String sql) throws CostManagerException {
        try {
            Connection connection = DBConnection.dbconnector();
            Statement stmt1 = connection.createStatement();
            stmt1.executeUpdate(sql);
        } catch(Exception ex) {
            throw new CostManagerException("Error accourd when execioting an update query");
        }
    }

}
