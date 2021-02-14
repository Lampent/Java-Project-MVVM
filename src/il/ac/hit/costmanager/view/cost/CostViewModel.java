/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.exceptions.CostManagerException;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.cost.Cost;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The cost view model.
 * Executing operations on a different thread for the view.
 * Act as a layer separating the access from the view and model (database).
 * Implements ICostViewModel interface.
 */
public class CostViewModel implements ICostViewModel {

    private IModel model;
    private ICostView view;
    private ExecutorService pool;

    /**
     * Constructor of the cost view model.
     * Initializing a thread pool with a constant number of 10 threads.
     */
    public CostViewModel() {
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
     * @param view the view implementing ICostView.
     */
    @Override
    public void setView(ICostView view) {
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
                view.showCategories(model.getCategories());
            } catch (CostManagerException ex) {
                this.view.showMessage("Error occurred when trying to get costs");
            }
        });
    }

    /**
     * Inserting a new cost to the model.
     * This operation preformed on a dedicated thread.
     * Shows feedback in case failed to insert cost to the model.
     *
     * @param cost the cost to be inserted to the model.
     */
    @Override
    public void insertCost(Cost cost) {
        pool.submit(() -> {
            try {
                model.insertCost(cost);
                this.view.showMessage("Cost created successfully");
            } catch (CostManagerException ex) {
                this.view.showMessage("Failed to create cost");
            }
        });
    }
}
