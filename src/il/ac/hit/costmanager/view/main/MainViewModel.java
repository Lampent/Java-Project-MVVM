package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.category.CategoryViewModel;
import il.ac.hit.costmanager.view.cost.CostViewModel;
import il.ac.hit.costmanager.view.chart.ChartViewModel;
import il.ac.hit.costmanager.view.report.ReportViewModel;

/**
 * The main view view model.
 * Executing operations for the view, mainly navigating the view container panel to the different views.
 * Act as a layer separating the access from the view and model (database).
 * Implements IMainViewModel interface.
 */
public class MainViewModel implements IMainViewModel {

    private IModel model;
    private IMainView view;

    public MainViewModel() {
    }

    /**
     * Sets the mode.
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
     * @param view the view implementing IMainView.
     */
    @Override
    public void setMainView(IMainView view) {
        this.view = view;
    }

    /**
     * Initializing the view.
     */
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
