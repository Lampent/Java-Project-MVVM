package il.ac.hit.costmanager.view.chart;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChartViewModel implements IChartViewModel {


    private IModel model;
    private IChartView view;
    private ExecutorService pool;

    public ChartViewModel() {
        pool = Executors.newFixedThreadPool(10);
    }

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void initializeView() {
        this.showCategoriesData();
    }

    @Override
    public void setView(IChartView view) {
        this.view = view;
    }


    public void showCategoriesData() {
        pool.submit(() -> {
            try {
                HashMap<String, Double> categoryMap = new HashMap<>();
                ArrayList<Category> catModel = model.getCategories();
                for (Category category : catModel) {
                    categoryMap.put(category.getCategoryName(), model.getTotalCost(category.getCategoryName()));
                }
                view.showCategoriesData(categoryMap);
            } catch (CostManagerException e) {
                this.view.showMessage("Failed to get Categories");
            }
        });
    }

}
