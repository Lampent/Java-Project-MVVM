package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;

public interface ICostViewModel {
    public ArrayList<Category> showCategories();

    public void InsertCost(double cost, String date, String dec, String catName);

    public void setModel(IModel model);

    public void setCostView(CostView costView);
}
