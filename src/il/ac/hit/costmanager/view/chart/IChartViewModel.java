package il.ac.hit.costmanager.view.chart;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.ViewInitializer;

/**
 * The interface of the chart view model.
 * Includes the required methods that the view model should implement.
 * Extends ViewInitializer interface.
 */
public interface IChartViewModel extends ViewInitializer {

    void setModel(IModel model);

    void setView(IChartView view);

    void showCategoriesData();
}
