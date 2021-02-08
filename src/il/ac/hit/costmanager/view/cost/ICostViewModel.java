/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.view.ViewInitializer;

/**
 * The interface of the cost view model.
 * Includes the required methods that the view model should implement.
 * Extends ViewInitializer interface.
 */
public interface ICostViewModel extends ViewInitializer {

    /**
     * Sets the model.
     *
     * @param model the model implementing IModel.
     */
    void setModel(IModel model);

    /**
     * Sets the view.
     *
     * @param view the view implementing ICostView.
     */
    void setView(ICostView view);

    /**
     * Shows all the existing categories in the model.
     */
    void showCategories();

    /**
     * Inserting a new cost to the model.
     *
     * @param cost the cost to be inserted to the model.
     */
    void insertCost(Cost cost);
}
