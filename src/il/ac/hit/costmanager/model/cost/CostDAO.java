/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.model.cost;

import il.ac.hit.costmanager.model.DBAdapter;
import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.CostManagerDAO;

import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * The cost Data Access Object, wraps the access to the database for costs as a separate layer.
 * Implementing and exposing the insert,get and delete functionality of the cost object.
 * Implements the ICostDAO interface
 */
public class CostDAO extends CostManagerDAO implements ICostDAO {

    /**
     * The cost DAO constructor
     * Sets the tableName variable thorough CostManagerDAO constructor.
     * Calls the initializeTable method that creates the table with the provided schema in case not already exists.
     * The Cost id is auto generated integer.
     */
    public CostDAO() {
        super("cost");
        this.initializeTable("(costId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)" +
                " ,catName VARCHAR(255) ,cost DOUBLE ,date DATE ,description VARCHAR(255), PRIMARY KEY (costId))");
    }

    /**
     * Inserts a cost into the database.
     *
     * @param cost the cost to be inserted.
     * @throws CostManagerException exception if failed to insert the cost.
     */
    @Override
    public void insertCost(Cost cost) throws CostManagerException {
        try {
            String sql = "INSERT INTO APP.Cost (catName,cost,date,description) "
                    + "VALUES ('" + cost.getCategory() + "'," + cost.getCost() + ",'" + cost.getDate() + "','" + cost.getDesc() + "')";
            DBAdapter.executeUpdate(sql);
        } catch (Exception e) {
            throw new CostManagerException("Failed to insert cost to DB");
        }
    }

    /**
     * Gets the total cost of all the cost from the database with the same category name as provided from.
     *
     * @param categoryName a category name.
     * @return the total cost of all the costs with the provided category.
     * @throws CostManagerException exception if failed to get all costs.
     */
    @Override
    public double getTotalCost(String categoryName) throws CostManagerException {
        double catTotal = 0;
        try {
            String query = "SELECT * FROM App.Cost WHERE catName='" + categoryName + "'";
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                catTotal = catTotal + (res.getDouble("cost"));
            }
        } catch (Exception e) {
            throw new CostManagerException("Failed to get the total cost of category from DB");
        }
        return catTotal;
    }

    /**
     * Gets all the costs from the database.
     *
     * @return list of all costs
     * @throws CostManagerException exception if failed to get all costs.
     */
    @Override
    public ArrayList<Cost> getCosts() throws CostManagerException {
        ArrayList<Cost> costs = new ArrayList<>();
        try {
            String query = "SELECT * FROM App.Cost";
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                Cost ad = new Cost(res.getString("catName"), res.getString("date"), res.getString("description"), res.getDouble("cost"));
                costs.add(ad);
            }
        } catch (Exception ex) {
            throw new CostManagerException("Failed to get costs from DB");
        }
        return costs;
    }

    /**
     * Gets all the costs from the database between two provided dates.
     *
     * @param startDate the starting date
     * @param endDate   the end date
     * @return list of all the costs in between the starting date and the end date
     */
    @Override
    public ArrayList<Cost> getCostDateRange(String startDate, String endDate) throws CostManagerException {
        ArrayList<Cost> costs = new ArrayList<>();
        try {
            String query = "SELECT * FROM App.Cost WHERE date BETWEEN '" + startDate + "' and '" + endDate + "'";
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                Cost ad = new Cost(res.getString("catName"), res.getString("date"), res.getString("description"), res.getDouble("cost"));
                costs.add(ad);
            }
        } catch (Exception e) {
            throw new CostManagerException("Failed to get costs by date range from DB");
        }
        return costs;
    }
}
