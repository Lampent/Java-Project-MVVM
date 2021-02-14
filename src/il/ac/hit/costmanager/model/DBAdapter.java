/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.model;

import il.ac.hit.costmanager.exceptions.CostManagerException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DBAdapter exposing an api for accessing the database.
 * <b> It is important to create new instance of this class for every query. </b>
 *
 * It accomplish two main things.
 * 1. Hides the business logic of executing queries; create a connection, execute the query, and close connection.
 * 2. It save many liens of codes, since the calls to this functions are from more then one place in the application.
 * 3. Wrapping the sql exceptions with custom CostManagerExceptions
 */
public class DBAdapter {
    // connection to the database
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    /**
     * @param query query to be execute to the database.
     * @return ResultSet sets of the the query.
     * @throws CostManagerException informing that error occurred when executing the query.
     */
    public ResultSet executeQuery(String query) throws CostManagerException {
        try {
            connection = DBConnector.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException ex) {
            throw new CostManagerException("Error occurred when executing a query");
        }
    }

    /**
     * @param query update query to be execute to the database.
     * @throws CostManagerException informing that error occurred when executing the query.
     */
    public void executeUpdate(String query) throws CostManagerException {
        try {
            connection = DBConnector.connect();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            throw new CostManagerException("Error occurred when executing an update query");
        }
    }

    /**
     * The function closes the connection properly
     * @throws CostManagerException informing that error occurred when closing the connection.
     */
    public void closeConnection() throws CostManagerException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            throw new CostManagerException("Error when closing the connection");
        }
    }

}
