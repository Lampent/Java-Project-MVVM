/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.model.category;

import il.ac.hit.costmanager.exceptions.CostManagerException;

import java.util.ArrayList;

/**
 * Interface of a category data access object.
 * Includes insert, get and delete functions of the category object.
 */
public interface ICategoryDAO {

    /**
     * @param category the category to be inserted.
     * @throws CostManagerException exception if failed to insert the category.
     */
    void insertCategory(Category category) throws CostManagerException;

    /**
     * @return list of all categories
     * @throws CostManagerException exception if failed to get all the categories.
     */
    ArrayList<Category> getCategories() throws CostManagerException;

    /**
     * @param categoryId the id of the category to be deleted.
     * @throws CostManagerException exception if failed to delete the category.
     */
    void deleteCategory(int categoryId) throws CostManagerException;
}
