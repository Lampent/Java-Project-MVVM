package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;

public interface ICostView {

    void setViewModel(CostViewModel vm);

    void showCosts(ArrayList<Category> categories);
}
