/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.cost.Cost;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The report view model.
 * Executing operations on a different thread for the view.
 * Act as a layer separating the access from the view and model (database).
 * Implements IReportViewModel interface.
 */
public class ReportViewModel implements IReportViewModel {

    private IModel model;
    private IReportView view;
    private ExecutorService pool;

    /**
     * Constructor of the report view model.
     * Initializing a thread pool with a constant number of 10 threads.
     */
    public ReportViewModel() {
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
     * @param view the view implementing IReportView.
     */
    @Override
    public void setView(IReportView view) {
        this.view = view;
    }

    /**
     * Initializing the view.
     */
    @Override
    public void initializeView() {
        this.showCosts();
    }

    /**
     * Shows all the existing costs in the model.
     * Gets the costs from the model, and send them to the view.
     * This operation preformed on a dedicated thread.
     * <p>
     * Shows feedback in case failed to fetch the data from the model.
     */
    @Override
    public void showCosts() {
        pool.submit(() -> {
            try {
                ArrayList<Cost> costs = model.getCosts();
                view.showCosts(costs);
            } catch (CostManagerException ex) {
                this.view.showMessage("Failed to get costs");
            }
        });
    }

    /**
     * Shows all the existing costs that created between two dates.
     * Gets the costs that created between two dates from the model, and send them to the view.
     * This operation preformed on a dedicated thread.
     * <p>
     * Shows feedback in case failed to fetch the data from the model.
     */
    @Override
    public void showCosts(String startDate, String endDate) {
        pool.submit(() -> {
            try {
                ArrayList<Cost> costs = model.getCostDateRange(startDate, endDate);
                view.showCosts(costs);
            } catch (CostManagerException ex) {
                this.view.showMessage("Failed to get costs");
            }
        });
    }
}
