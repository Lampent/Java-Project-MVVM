package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CategoryViewModel implements ICategoryViewModel {

    private IModel model;
    private CategoryView categoryView;
    private ExecutorService pool;

    public CategoryViewModel() {
        pool = Executors.newFixedThreadPool(10);
    }

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void setCategoryView(CategoryView categoryView) {
        this.categoryView = categoryView;
    }

    @Override
    public void initializeView() {
        showCategories();
    }

    @Override
    public void showCategories() {
        pool.submit(() -> {
            try {
                ArrayList<Category> categories = model.getCategories();
                categoryView.showCategories(categories);
            } catch (CostManagerException e) {
                this.categoryView.showMessage("Failed to get categories");
            }
        });
    }

    @Override
    public void insertCategory(Category category) {
        pool.submit(() -> {
            try {
                model.insertCategory(category);
                this.categoryView.showMessage("Category crated Successfully");
                this.showCategories();
            } catch (CostManagerException ex) {
                this.categoryView.showMessage("Failed to crate category");
            }
        });
    }

    @Override
    public void deleteCategory(int id) {
        pool.submit(() -> {
            try {
                model.deleteCategory(id);
                this.categoryView.showMessage("Category deleted Successfully");
                this.showCategories();
            } catch (CostManagerException ex) {
                this.categoryView.showMessage("Failed to delete category");
            }
        });
    }
}