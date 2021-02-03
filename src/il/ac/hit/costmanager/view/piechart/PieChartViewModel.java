package il.ac.hit.costmanager.view.piechart;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PieChartViewModel implements IPieChartViewModel {


    private IModel model;
    private IPieChartView pieChartView;
    private ExecutorService pool;

    public PieChartViewModel() {
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
    public void setPieChartView(IPieChartView pieChartView) {
        this.pieChartView = pieChartView;
    }


    public void showCategoriesData() {
        pool.submit(() -> {
            try {
                HashMap<String, Double> categoryMap = new HashMap<>();
                ArrayList<Category> catModel = model.getCategories();
                for (Category category : catModel) {
                    categoryMap.put(category.getCategoryName(), model.getTotalCost(category.getCategoryName()));
                }
                pieChartView.showCategoriesData(categoryMap);
            } catch (CostManagerException e) {
                Logger.getLogger(PieChartViewModel.class.getName()).log(Level.SEVERE, null, e);
            }
        });
    }

}
