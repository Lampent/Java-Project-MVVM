package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.model.IModel;


public interface ICategoryViewModel {
    void setModel(IModel model);

    void setCategoryView(CategoryView costView);

    void initializeView();

    void insertCategory(String categoryName);

    void deleteCategory(int id);

    void showCategories();
}
