/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.model.category;

import il.ac.hit.costmanager.model.DBAdapter;
import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.CostManagerDAO;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The category Data Access Object, wraps the access to the database for Categories as a separate layer.
 * Implementing and exposing the insert,get and delete functionality of category object.
 * Implements the ICategoryDAO interface
 * Extends CostManagerDAO
 */
public class CategoryDAO extends CostManagerDAO implements ICategoryDAO {

    /**
     * The category DAO constructor
     * Sets the tableName variable thorough CostManagerDAO constructor.
     * Calls the initializeTable method that creates the table with the provided schema in case not already exists.
     * The Category id is auto generated integer.
     */
    public CategoryDAO() {
        super("category");
        this.initializeTable("(CATID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)" +
                ", CATNAME VARCHAR(255), PRIMARY KEY (CATID))");
    }

    /**
     * Inserts category into the database.
     *
     * @param category the category to insert.
     * @throws CostManagerException exception if failed to insert category.
     */
    @Override
    public void insertCategory(Category category) throws CostManagerException {
        try {
            String sql = "INSERT INTO APP." + tableName + " (catName) "
                    + "VALUES ('" + category.getCategoryName() + "')";
            DBAdapter.executeUpdate(sql);

        } catch (Exception e) {
            throw new CostManagerException("Failed to insert category to DB");
        }
    }

    /**
     * Gets all the categories in the database
     *
     * @return returns a list of all the categories in the database
     * @throws CostManagerException exception if failed to get categories from database.
     */
    @Override
    public ArrayList<Category> getCategories() throws CostManagerException {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String query = "SELECT * FROM App." + tableName;
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                Category ad = new Category(res.getString("catName"), res.getInt("catId"));
                categories.add(ad);
            }
        } catch (Exception e) {
            throw new CostManagerException("Failed to get categories from DB");
        }
        return categories;
    }

    /**
     * Deletes a category from the database by its identifier.
     *
     * @param categoryId the id of the category to be deleted.
     * @throws CostManagerException exception if failed to delete the category.
     */
    @Override
    public void deleteCategory(int categoryId) throws CostManagerException {
        try {
            String query = "DELETE FROM APP." + tableName + " WHERE catId=" + categoryId + "";
            DBAdapter.executeUpdate(query);
        } catch (Exception e) {
            throw new CostManagerException("Failed to delete category from DB");
        }
    }
}
