package il.ac.hit.costmanager.database;

import il.ac.hit.costmanager.exeptions.CostManagerException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DBConnector in charge of opening a connection to the database, and return it to those who need it.
 * No one can access the credential of the DB user.
 * Contains a single function to return the connection.
 */
public class DBConnector {

    /**
     * The DBConnector constructor
     */
    public DBConnector() {
    }

    /**
     * Opens a new connection to the the database with the currect credentials and return it.
     * @return Connection the Connection to the database.
     * @throws CostManagerException in case of it failed to open the connection to the database.
     */
    public static Connection connect() throws CostManagerException {
        Connection connection = null;
        try {
            // DB user credentials
            String username = "root";
            String password = " ";
            String url = "jdbc:derby://localhost:1527/costManagement";
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // connection to the DB
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new CostManagerException("Failed to connect into the database");
        }
        return connection;
    }
}

