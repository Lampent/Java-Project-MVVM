/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
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

    /**
     * Shows all the categories with their cost of costs with a date between start date and end date.
     *
     * @param startDate the date from which the costs will be summed
     * @param endDate   the end date of the costs that will be summed.
     */
    void showCategoriesData(String startDate, String endDate);
}
