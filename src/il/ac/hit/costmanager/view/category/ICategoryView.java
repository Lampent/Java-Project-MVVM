package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;

public interface ICategoryView {

    void setViewModel(ICategoryViewModel categoryViewModel);

    void showCategories(ArrayList<Category> catModel);

    void showMessage(String text);
}
