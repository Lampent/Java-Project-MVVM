/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.model;

import il.ac.hit.costmanager.exeptions.CostManagerException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DBConnector in charge of opening a connection to the database, and return it to those who need it.
 * Contains a single function to return the connection.
 */
public class DBConnector {

    private static final String EMBEDDED_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String PROTOCOL = "jdbc:derby:";

    /**
     * Opens a new connection to the the database with the currect credentials and return it.
     *
     * @return Connection the Connection to the database.
     * @throws CostManagerException in case of it failed to open the connection to the database.
     */
    public static Connection connect() throws CostManagerException {
        Connection connection;
        try {
            Class.forName(EMBEDDED_DRIVER);
            connection = DriverManager.getConnection(PROTOCOL + "costManagement;create=true");
        } catch (Exception e) {
            throw new CostManagerException("Failed to connect to the database");
        }
        return connection;
    }
}

