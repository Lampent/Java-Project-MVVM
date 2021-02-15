/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.model.cost;

import il.ac.hit.costmanager.exceptions.CostManagerException;

import java.util.ArrayList;

/**
 * Interface of a cost data access object.
 * Includes insert, get and delete functions of the cost object.
 */
public interface ICostDAO {

    /**
     * @param cost the cost to be inserted.
     * @throws CostManagerException exception if failed to insert the cost.
     */
    void insertCost(Cost cost) throws CostManagerException;

    /**
     * @param categoryName a category name
     * @return the total cost of all the costs with the provided category.
     * @throws CostManagerException exception if failed to calculate the total cost.
     */
    double getTotalCost(String categoryName) throws CostManagerException;

    /**
     * @param categoryName a category name
     * @param startDate the date from which the cost will be summed
     * @param endDate the end date of the cost that will be summed.
     * @return total cost of all the costs of a category between the provided dates.
     * @throws CostManagerException exception if failed to get calculate the total cost.
     */
    double getTotalCost(String categoryName, String startDate, String endDate) throws CostManagerException;

    /**
     * @return list of all costs
     * @throws CostManagerException exception if failed to get all costs.
     */
    ArrayList<Cost> getCosts() throws CostManagerException;

    /**
     * @param startDate the starting date
     * @param endDate   the end date
     * @return list of all the costs in between the starting date and the end date
     */
    ArrayList<Cost> getCostDateRange(String startDate, String endDate) throws CostManagerException;
}
