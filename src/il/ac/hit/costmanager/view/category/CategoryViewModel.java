package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The category view model.
 * Executing operations on a different thread for the view.
 * Act as a layer separating the access from the view and model (model).
 * Implements ICategoryViewModel interface.
 */
public class CategoryViewModel implements ICategoryViewModel {

    private IModel model;
    private ICategoryView view;
    private ExecutorService pool;

    /**
     * Constructor of the category view model.
     * Initializing a thread pool with a constant number of 10 threads.
     */
    public CategoryViewModel() {
        pool = Executors.newFixedThreadPool(10);
    }

    /**
     * Sets the model.
     *
     * @param model the model implementing IModel.
     */
    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    /**
     * Sets the view.
     *
     * @param view the view implementing ICategoryView.
     */
    @Override
    public void setView(ICategoryView view) {
        this.view = view;
    }

    /**
     * Initializing the view.
     */
    @Override
    public void initializeView() {
        showCategories();
    }

    /**
     * Shows all the existing categories in the model.
     * Gets the categories from the model, and send them to the view.
     * This operation preformed on a dedicated thread.
     * <p>
     * Shows feedback in case failed to fetch the data from the model.
     */
    @Override
    public void showCategories() {
        pool.submit(() -> {
            try {
                ArrayList<Category> categories = model.getCategories();
                view.showCategories(categories);
            } catch (CostManagerException e) {
                this.view.showMessage("Failed to get categories");
            }
        });
    }

    /**
     * Inserting a new category to the model.
     * Afterwords, Shows all the existing categories in the model.
     * This operation preformed on a dedicated thread.
     * Shows feedback in case failed to insert category to the model.
     *
     * @param category the category to be inserted to the model.
     */
    @Override
    public void insertCategory(Category category) {
        pool.submit(() -> {
            try {
                model.insertCategory(category);
                this.view.showMessage("Category crated Successfully");
                this.showCategories();
            } catch (CostManagerException ex) {
                this.view.showMessage("Failed to crate category");
            }
        });
    }

    /**
     * Deletes an existing category from the model.
     * Afterwords, Shows all the existing categories in the model.
     * This operation preformed on a dedicated thread.
     * Shows feedback in case failed to delete category from the model.
     *
     * @param id the id of the category to be deleted.
     */
    @Override
    public void deleteCategory(int id) {
        pool.submit(() -> {
            try {
                model.deleteCategory(id);
                this.view.showMessage("Category deleted Successfully");
                this.showCategories();
            } catch (CostManagerException ex) {
                this.view.showMessage("Failed to delete category");
            }
        });
    }
}
