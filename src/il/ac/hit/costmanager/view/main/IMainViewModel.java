package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.ViewInitializer;

/**
 * The interface of the main view model.
 * Includes the required methods that the view model should implement.
 * Extends ViewInitializer interface.
 */
public interface IMainViewModel extends ViewInitializer {

    void setModel(IModel model);

    void setMainView(IMainView mainView);

    void navigateChartMenu();

    void navigateCostMenu();

    void navigateCategoriesMenu();

    void navigateReportMenu();

}
