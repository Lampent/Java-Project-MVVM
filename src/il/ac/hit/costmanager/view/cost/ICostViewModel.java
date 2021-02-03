package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;

public interface ICostViewModel {

    void setModel(IModel model);

    void setCostView(CostView costView);

    void initializeView();

    void InsertCost(double cost, String date, String dec, String catName);

    ArrayList<Category> showCategories();

}
