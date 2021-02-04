package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.category.CategoryViewModel;
import il.ac.hit.costmanager.view.cost.CostViewModel;
import il.ac.hit.costmanager.view.chart.ChartViewModel;
import il.ac.hit.costmanager.view.report.ReportViewModel;

public class MainViewModel implements IMainViewModel {

    private IModel model;
    private MainView view;

    public MainViewModel() {
    }

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void setMainView(MainView mainView) {
        this.view = mainView;
    }

    @Override
    public void initializeView() {
        this.navigateCostMenu();
    }

    @Override
    public void navigateChartMenu() {
        this.view.navigateChartMenu(model, new ChartViewModel());
    }

    @Override
    public void navigateCostMenu() {
        this.view.navigateCostMenu(model, new CostViewModel());
    }

    @Override
    public void navigateCategoriesMenu() {
        this.view.navigateCategoriesMenu(model, new CategoryViewModel());
    }

    @Override
    public void navigateReportMenu() {
        this.view.navigateReportMenu(model, new ReportViewModel());
    }
}
