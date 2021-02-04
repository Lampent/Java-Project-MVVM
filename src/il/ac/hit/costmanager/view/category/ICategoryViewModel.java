package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.view.ViewInitializer;


public interface ICategoryViewModel extends ViewInitializer {
    void setModel(IModel model);

    void setView(CategoryView view);

    void insertCategory(Category category);

    void deleteCategory(int id);

    void showCategories();
}
