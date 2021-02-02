package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;

public interface ICostView {

    public void setViewModel(CostViewModel vm);

    public void showCosts(ArrayList<Category> categories);
}
