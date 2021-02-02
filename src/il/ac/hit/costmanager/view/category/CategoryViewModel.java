package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryViewModel implements ICategoryViewModel {

    private IModel model;
    private CategoryView categoryView;
    private ExecutorService pool;

    public CategoryViewModel() {
        pool = Executors.newFixedThreadPool(10);
    }

    @Override
    public void showCategories() {
        pool.submit(() -> {
            try {
                ArrayList<Category> categories = model.getCategories();
                categoryView.showCategories(categories);
            } catch (CostManagerException e) {
                Logger.getLogger(CategoryViewModel.class.getName()).log(Level.SEVERE, null, e);
            }
        });
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
    public void insertCategory(String categoryName) {
        pool.submit(() -> {
            try {
                model.InsertCategory(categoryName);
                categoryView.showCategories(model.getCategories());
            } catch (CostManagerException ex) {
                Logger.getLogger(CategoryViewModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @Override
    public void deleteCategory(int id) {
        pool.submit(() -> {
            try {
                model.deleteCategory(id);
                categoryView.showCategories(model.getCategories());
            } catch (CostManagerException ex) {
                Logger.getLogger(CategoryViewModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
