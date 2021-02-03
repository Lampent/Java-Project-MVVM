package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.model.IModel;


public interface ICategoryViewModel {
    public void setModel(IModel model);

    public void setCategoryView(CategoryView costView);

    public void initializeView();

    public void insertCategory(String categoryName);

    public void deleteCategory(int id);

    public void showCategories();
}
