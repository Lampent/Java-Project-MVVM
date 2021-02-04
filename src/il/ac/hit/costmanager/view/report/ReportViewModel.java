package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.cost.Cost;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReportViewModel implements IReportViewModel {

    private IModel model;
    private IReportView reportView;
    private ExecutorService pool;

    public ReportViewModel() {
        pool = Executors.newFixedThreadPool(10);
    }

    @Override
    public void initializeView() {
        this.showCosts();
    }

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void setReportView(IReportView reportView) {
        this.reportView = reportView;
    }

    @Override
    public void showCosts() {
        pool.submit(() -> {
            try {
                ArrayList<Cost> costs = model.getCosts();
                reportView.showCosts(costs);
            } catch (CostManagerException ex) {
                this.reportView.showMessage("Failed to get costs");
            }
        });
    }

    @Override
    public void showCosts(String startDate, String endDate) {
        pool.submit(() -> {
            try {
                ArrayList<Cost> costs = model.getCostDateRange(startDate, endDate);
                reportView.showCosts(costs);
            } catch (CostManagerException ex) {
                this.reportView.showMessage("Failed to get costs");
            }
        });
    }
}
