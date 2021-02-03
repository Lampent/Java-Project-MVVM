package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;


public interface ICategoryViewModel {
    void setModel(IModel model);

    void setCategoryView(CategoryView categoryView);

    void initializeView();

    void insertCategory(Category category);

    void deleteCategory(int id);

    void showCategories();
}
