/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.ViewInitializer;

/**
 * The interface of the main view model.
 * Includes the required methods that the view model should implement.
 * Extends ViewInitializer interface.
 */
public interface IMainViewModel extends ViewInitializer {

    /**
     * Sets the model.
     *
     * @param model the model implementing IModel.
     */
    void setModel(IModel model);

    /**
     * Sets the view.
     *
     * @param view the view implementing IMainView.
     */
    void setMainView(IMainView view);

    /**
     * Navigates the user interface to display the chart menu.
     */
    void navigateChartMenu();

    /**
     * Navigates the user interface to display the cost menu.
     */
    void navigateCostMenu();

    /**
     * Navigates the user interface to display the category menu.
     */
    void navigateCategoryMenu();

    /**
     * Navigates the user interface to display the report menu.
     */
    void navigateReportMenu();

}
