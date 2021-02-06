package il.ac.hit.costmanager.model.cost;

import il.ac.hit.costmanager.database.DBAdapter;
import il.ac.hit.costmanager.exeptions.CostManagerException;

import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * The cost Data Access Object, wraps the access to the database for costs as a separate layer.
 * Implementing and exposing the insert,get and delete functionality of the cost object.
 * Implements the ICostDAO interface
 */
public class CostDAO implements ICostDAO {

    /**
     * The cost DAO constructor
     */
    public CostDAO() {
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
            int costId = 0;
            String query = "Select * from APP.Cost";
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                costId = (res.getInt("costId"));
            }
            costId = costId + 1;
            String sql = "INSERT INTO APP.Cost (costId,catName,cost,date,description) "
                    + "VALUES (" + costId + ",'" + cost.getCategory() + "'," + cost.getCost() + ",'" + cost.getDate() + "','" + cost.getDesc() + "')";
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
