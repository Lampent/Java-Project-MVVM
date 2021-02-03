package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.model.cost.Cost;

import java.util.ArrayList;

public interface ICostViewModel {

    void setModel(IModel model);

    void setCostView(CostView costView);

    void initializeView();

    void insertCost(Cost cost);

    ArrayList<Category> showCategories();

}
