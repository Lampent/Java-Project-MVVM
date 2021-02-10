/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.model;

import il.ac.hit.costmanager.database.DBConnector;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The base Data Access Object class of all DAOs in the application.
 * Provides a method for creating the DAO table with a provided schema if not exists,
 * and a variable of tableName a single source of trues for the table name, used in all of the queries.
 */
public abstract class CostManagerDAO {
    protected String tableName;

    /**
     * CostManagerDAO Constructor.
     * Sets the object table name.
     *
     * @param tableName the object table name.
     */
    public CostManagerDAO(String tableName) {
        this.setTableName(tableName);
    }

    /**
     * Sets the object table name.
     * The method is private as it can only be set on creation of the DAO Class.
     *
     * @param tableName the object table name.
     */
    private void setTableName(String tableName) {
        this.tableName = tableName.toUpperCase();
    }

    /**
     * The methods received tableSchema and creates the table if dose not already exists.
     * This method is protected as it exists for the classes extends CostManagerDAO.
     * <p>
     * If experienced unexpected exception a severe logger will be written for the purpose of monitoring.
     * The method is not a result of a user action, rather its an internal and independent action of the application that needs monitoring.
     *
     * @param tableSchema the table schema.
     */
    protected void initializeTable(String tableSchema) {
        try {
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            if (!isTableExists(connection)) {
                statement.execute("create table " + tableName + tableSchema);
            }
        } catch (Exception e) {
            Logger.getLogger(CostManagerDAO.class.getName()).log(Level.SEVERE, "Table " + tableName + " may have not been created properly");
        }
    }

    /**
     * Verifies if the object table exists.
     * The function uses the metadata of the database and searching among its table names for the table name.
     *
     * @param connection the connection to the database.
     * @return boolean value of true if the table already exists and false if it dose not exists.
     * @throws SQLException exception that can occur when trying to get the database meta data.
     */
    private boolean isTableExists(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet rs = metaData.getTables(null, null, null, new String[]{"TABLE"});
        while (rs.next()) {
            if (rs.getString("TABLE_NAME").equals(tableName)) {
                return true;
            }
        }
        return false;
    }
}
