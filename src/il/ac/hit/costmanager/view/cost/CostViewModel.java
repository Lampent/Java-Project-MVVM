package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.model.cost.Cost;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CostViewModel implements ICostViewModel {

    private IModel model;
    private CostView view;
    private ExecutorService pool;

    public CostViewModel() {
        pool = Executors.newFixedThreadPool(10);
    }

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void setView(CostView view) {
        this.view = view;
    }

    @Override
    public void initializeView() {
        showCategories();
    }

    @Override
    public ArrayList<Category> showCategories() {
        pool.submit(() -> {
            try {
                view.showCosts(model.getCategories());
            } catch (CostManagerException ex) {
                this.view.showMessage("Error occurred when trying to get costs");
            }
        });
        return new ArrayList<>();
    }

    @Override
    public void insertCost(Cost cost) {
        pool.submit(() -> {
            try {
                model.insertCost(cost);
                this.view.showMessage("Cost created successfully");
            } catch (CostManagerException ex) {
                this.view.showMessage("Failed to create cost");
            }
        });
    }
}
