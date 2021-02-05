package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.view.ViewInitializer;

import java.util.ArrayList;

/**
 * The interface of the cost view model.
 * Includes the required methods that the view model should implement.
 * Extends ViewInitializer interface.
 */
public interface ICostViewModel extends ViewInitializer {

    void setModel(IModel model);

    void setView(ICostView view);

    void insertCost(Cost cost);

    ArrayList<Category> showCategories();

}
