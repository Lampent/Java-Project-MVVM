package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.view.ViewInitializer;

import java.util.ArrayList;

public interface ICostViewModel extends ViewInitializer {

    void setModel(IModel model);

    void setView(CostView view);

    void insertCost(Cost cost);

    ArrayList<Category> showCategories();

}
