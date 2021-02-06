package il.ac.hit.costmanager.model.category;

import il.ac.hit.costmanager.database.DBAdapter;
import il.ac.hit.costmanager.exeptions.CostManagerException;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The category Data Access Object, wraps the access to the database for Categories as a separate layer.
 * Implementing and exposing the insert,get and delete functionality of category object.
 * Implements the ICategoryDAO interface
 */
public class CategoryDAO implements ICategoryDAO {

    /**
     * The category DAO constructor
     */
    public CategoryDAO() {
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
            int catId = 0;
            String query = "Select * from APP.Category";
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                catId = (res.getInt("catId"));
            }
            category.setId(catId + 1);
            String sql = "INSERT INTO APP.Category (catId,catName) "
                    + "VALUES (" + category.getId() + ",'" + category.getCategoryName() + "')";
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
            String query = "SELECT * FROM App.Category";
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
            String query = "DELETE FROM APP.Category WHERE catId=" + categoryId + "";
            DBAdapter.executeUpdate(query);
        } catch (Exception e) {
            throw new CostManagerException("Failed to delete category from DB");
        }
    }
}
