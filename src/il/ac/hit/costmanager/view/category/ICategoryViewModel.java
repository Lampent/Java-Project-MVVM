/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.view.ViewInitializer;

/**
 * The interface of the category view model.
 * Includes the required methods that the view model should implement.
 * Extends ViewInitializer interface.
 */
public interface ICategoryViewModel extends ViewInitializer {

    /**
     * Sets the model.
     *
     * @param model the model implementing IModel.
     */
    void setModel(IModel model);

    /**
     * Sets the view.
     *
     * @param view the view implementing ICategoryView.
     */
    void setView(ICategoryView view);

    /**
     * Inserting a new category to the model.
     *
     * @param category the new category to be inserted.
     */
    void insertCategory(Category category);

    /**
     * Deletes an existing category from the model.
     *
     * @param id the id of the category to be deleted.
     */
    void deleteCategory(int id);

    /**
     * Shows all the existing categories in the model.
     */
    void showCategories();
}
