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
 * QueryExecutor a class for executing a query.
 * To use it simply create new instance of it (passing the query in the constructor), and execute it and finish it.
 * <b> It is important to create new instance of this class for every query! </b>
 * <p>
 * It accomplish three main things.
 * 1. Hides the business logic of executing queries; create a connection, execute the query, and close connection.
 * 2. It save many liens of codes, since the calls to this functions are from more then one place in the application.
 * 3. Wrapping the database exceptions with suitable custom CostManagerExceptions.
 */
public class QueryExecutor {
    private final String query;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    /**
     * The constructor of QueryExecutor, receive the query to be executed.
     * The query is then set to a final global variable to be used in the execution.
     * The query variable is final because it is can not change, each instance of QueryExecutor is for a single query.
     *
     * @param query the query to be executed.
     */
    public QueryExecutor(String query) {
        this.query = query;
    }

    /**
     * Opens a connection and executing the query.
     *
     * @return ResultSet sets of the the query.
     * @throws CostManagerException informing that error occurred when executing the query.
     */
    public ResultSet executeQuery() throws CostManagerException {
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
     * Opens a connection and executing the query as an update query.
     *
     * @throws CostManagerException informing that error occurred when executing the query.
     */
    public void executeUpdateQuery() throws CostManagerException {
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
     *
     * @throws CostManagerException informing that error occurred when closing the connection.
     */
    public void closeQuery() throws CostManagerException {
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
