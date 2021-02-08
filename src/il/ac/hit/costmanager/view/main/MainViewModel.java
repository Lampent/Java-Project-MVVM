/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.IModel;

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
        this.view.navigateChartMenu(model);
    }

    @Override
    public void navigateCostMenu() {
        this.view.navigateCostMenu(model);
    }

    @Override
    public void navigateCategoriesMenu() {
        this.view.navigateCategoriesMenu(model);
    }

    @Override
    public void navigateReportMenu() {
        this.view.navigateReportMenu(model);
    }
}
