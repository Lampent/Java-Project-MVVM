/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.model;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.model.category.CategoryDAO;
import il.ac.hit.costmanager.model.category.ICategoryDAO;
import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.model.cost.CostDAO;
import il.ac.hit.costmanager.model.cost.ICostDAO;

import java.util.ArrayList;


/**
 * The model of the application, exposing interface of the functionality available on each object stored in the database.
 * This Class acts like hides the direct access to each object DAO, by doing so we add an additional layer between the application and its objects DAOs.
 * This layer allow us to make changes in the objects DAOs without necessarily changing those that use it.
 * <p>
 * Another advantage is the single source of truth of the data that stored in the database, the application talks only with this class instead of X DAO classes.
 * Includes insert, get and delete functions of the cost object.
 */
public class DerbyDBModel implements IModel {
    private ICategoryDAO categoryDAO = new CategoryDAO();
    private ICostDAO costDAO = new CostDAO();

    /**
     * Call the category DAO insert method to insert a category.
     *
     * @param category the category to be inserted.
     * @throws CostManagerException exception of the category DAO insert method.
     */
    @Override
    public void insertCategory(Category category) throws CostManagerException {
        categoryDAO.insertCategory(category);
    }

    /**
     * Call the category DAO get method to get a list of all the categories.
     *
     * @return a list of all the categories.
     * @throws CostManagerException exception of the category DAO get method.
     */
    @Override
    public ArrayList<Category> getCategories() throws CostManagerException {
        return categoryDAO.getCategories();
    }

    /**
     * Call the category DAO delete method to delete a category by its id.
     *
     * @param id the category id.
     * @throws CostManagerException exception of the category DAO delete method.
     */
    @Override
    public void deleteCategory(int id) throws CostManagerException {
        categoryDAO.deleteCategory(id);
    }

    /**
     * Call the cost DAO insert method to insert a category.
     *
     * @param cost the cost to be inserted.
     * @throws CostManagerException exception of the cost DAO insert method.
     */
    @Override
    public void insertCost(Cost cost) throws CostManagerException {
        costDAO.insertCost(cost);
    }

    /**
     * Call the cost DAO getTotalCost method to get the total cost of all the cots with the inputted category name.
     *
     * @param categoryName a category name.
     * @return the total cost of all the cots with the inputted category name.
     * @throws CostManagerException exception of the cost DAO getTotalCost method.
     */
    @Override
    public double getTotalCost(String categoryName) throws CostManagerException {
        return costDAO.getTotalCost(categoryName);
    }

    /**
     * Call the cost DAO get method to get a list of all the costs.
     *
     * @return a list of all the costs.
     * @throws CostManagerException exception of the cost DAO get method.
     */
    @Override
    public ArrayList<Cost> getCosts() throws CostManagerException {
        return costDAO.getCosts();
    }

    /**
     * Call a cost DAO get method to get a list of all the costs created between the two inputted dates.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return a list of all the costs that created between the two inputted dates.
     * @throws CostManagerException exception of the cost DAO get method.
     */
    @Override
    public ArrayList<Cost> getCostDateRange(String startDate, String endDate) throws CostManagerException {
        return costDAO.getCostDateRange(startDate, endDate);
    }
}
