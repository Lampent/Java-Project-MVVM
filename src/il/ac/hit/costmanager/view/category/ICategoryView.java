package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;

public interface ICategoryView {

    public void setViewModel(ICategoryViewModel categoryViewModel);

    public void showCategories(ArrayList<Category> catModel);

}
