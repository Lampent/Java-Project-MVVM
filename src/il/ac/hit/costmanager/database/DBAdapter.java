package il.ac.hit.costmanager.database;

import il.ac.hit.costmanager.exeptions.CostManagerException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * DBAdapter exposing an interface for accessing the database
 * It accomplish two main things
 * 1. Hides the business logic of executing queries, create a connection and execute the query.
 * 2. It save many liens of codes, since the calls to this functions are from more then one place
 */
public class DBAdapter {

    /**
     * The DBAdapter constructor
     */
    public DBAdapter() {
    }

    /**
     * @param query query to be execute to the database
     * @return ResultSet sets of the resulted rows by the query
     * @throws CostManagerException informing that error occurred when executing the query
     */
    public static ResultSet executeQuery(String query) throws CostManagerException {
        try {
            Connection connection = DBConnector.connect();
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception ex) {
            throw new CostManagerException("Error occurred when executing a query");
        }
    }

    /**
     * @param query update query to be execute to the database
     * @throws CostManagerException informing that error occurred when executing the query
     */
    public static void executeUpdate(String query) throws CostManagerException {
        try {
            Connection connection = DBConnector.connect();
            Statement stmt1 = connection.createStatement();
            stmt1.executeUpdate(query);
        } catch (Exception ex) {
            throw new CostManagerException("Error occurred when executing an update query");
        }
    }

}
