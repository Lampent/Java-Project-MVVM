package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.ViewInitializer;

public interface IMainViewModel extends ViewInitializer {

    void setModel(IModel model);

    void setMainView(MainView mainView);

    void navigateChartMenu();

    void navigateCostMenu();

    void navigateCategoriesMenu();

    void navigateReportMenu();

}
