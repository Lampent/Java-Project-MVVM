/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.IModel;

/**
 * The interface of the main view.
 * Includes the required methods that the main view should implement.
 */
public interface IMainView {

    /**
     * Sets the view model
     *
     * @param viewModel the main view ViewModel.
     */
    void setViewModel(IMainViewModel viewModel);

    /**
     * Displays the chart menu in the container.
     *
     * @param model the IModel for the use of the chart viewModel
     */
    void navigateChartMenu(IModel model);

    /**
     * Displays the cost menu in the container.
     *
     * @param model the IModel for the use of the cost viewModel
     */
    void navigateCostMenu(IModel model);

    /**
     * Displays the categories menu in the container.
     *
     * @param model the IModel for the use of the categories viewModel
     */
    void navigateCategoriesMenu(IModel model);

    /**
     * Displays the report menu in the container.
     *
     * @param model the IModel for the use of the report viewModel
     */
    void navigateReportMenu(IModel model);
}
