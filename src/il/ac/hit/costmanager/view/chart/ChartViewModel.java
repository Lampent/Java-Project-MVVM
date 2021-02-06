package il.ac.hit.costmanager.view.chart;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The chart view model.
 * Executing operations on a different thread for the view.
 * Act as a layer separating the access from the view and model (database).
 * Implements IChartViewModel interface.
 */
public class ChartViewModel implements IChartViewModel {


    private IModel model;
    private IChartView view;
    private ExecutorService pool;

    /**
     * Constructor of the chart view model.
     * Initializing a thread pool with a constant number of 10 threads.
     */
    public ChartViewModel() {
        pool = Executors.newFixedThreadPool(10);
    }

    /**
     * Sets the model.
     *
     * @param model the model implementing IModel.
     */
    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    /**
     * Sets the view.
     *
     * @param view the view implementing IChartView.
     */
    @Override
    public void setView(IChartView view) {
        this.view = view;
    }

    /**
     * Initializing the view.
     */
    @Override
    public void initializeView() {
        this.showCategoriesData();
    }

    /**
     * Shows all the existing categories in the model.
     * Gets the categories from the model, and build suitable map to be sent to the view.
     * The map consists from key - category name and value - the total cost of the category costs
     * This operation preformed on a dedicated thread.
     * <p>
     * Shows feedback in case failed to fetch the data from the model.
     */
    public void showCategoriesData() {
        pool.submit(() -> {
            try {
                HashMap<String, Double> categoryMap = new HashMap<>();
                ArrayList<Category> categories = model.getCategories();
                for (Category category : categories) {
                    categoryMap.put(category.getCategoryName(), model.getTotalCost(category.getCategoryName()));
                }
                view.showCategoriesData(categoryMap);
            } catch (CostManagerException e) {
                this.view.showMessage("Failed to get Categories");
            }
        });
    }

}
