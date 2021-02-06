package il.ac.hit.costmanager.view.chart;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.ViewInitializer;

/**
 * The interface of the chart view model.
 * Includes the required methods that the view model should implement.
 * Extends ViewInitializer interface.
 */
public interface IChartViewModel extends ViewInitializer {

    /**
     * Sets the model.
     *
     * @param model the model implementing IModel.
     */
    void setModel(IModel model);

    /**
     * Sets the view.
     *
     * @param view the view implementing IChartView.
     */
    void setView(IChartView view);

    /**
     * Shows all the existing categories in the model in the view.
     */
    void showCategoriesData();
}
