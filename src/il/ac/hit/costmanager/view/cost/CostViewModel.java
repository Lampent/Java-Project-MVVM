package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.model.cost.Cost;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CostViewModel implements ICostViewModel {

    private IModel model;
    private CostView costView;
    private ExecutorService pool;

    public CostViewModel() {
        pool = Executors.newFixedThreadPool(10);
    }

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void setCostView(CostView costView) {
        this.costView = costView;
    }

    @Override
    public void initializeView() {
        showCategories();
    }

    @Override
    public ArrayList<Category> showCategories() {
        pool.submit(() -> {
            try {
                costView.showCosts(model.getCategories());
            } catch (CostManagerException ex) {
                Logger.getLogger(CostViewModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return new ArrayList<>();
    }

    @Override
    public void insertCost(Cost cost) {
        pool.submit(() -> {
            try {
                model.insertCost(cost);
            } catch (CostManagerException ex) {
                Logger.getLogger(CostViewModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
