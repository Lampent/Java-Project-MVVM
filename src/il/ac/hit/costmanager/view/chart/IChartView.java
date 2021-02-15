/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.chart;

import java.util.HashMap;

/**
 * The interface of the chart view.
 * Includes the required methods that the view should implement.
 */
public interface IChartView {

    /**
     * Sets the view model
     *
     * @param viewModel the chart view ViewModel.
     */
    void setViewModel(IChartViewModel viewModel);

    /**
     * Shows categories with their total cost of costs in the user interface chart.
     *
     * @param categoryMap a map, key represent the category name and the value represents the total cost of its costs.
     */
    void showCategoriesData(HashMap<String, Double> categoryMap);

    /**
     * Shows a message to the user, mainly used to show feedback to the user on the different actions available to the user.
     *
     * @param text text to be show to the user.
     */
    void showMessage(String text);
}
