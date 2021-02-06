package il.ac.hit.costmanager.view.chart;

import java.util.HashMap;

/**
 * The interface of the chart view.
 * Includes the required methods that the view should implement.
 */
public interface IChartView {

    /**
     * Shows categories with their total cost of costs in the user interface chart.
     *
     * @param categoryMap a map, key represent the category name and the value represents the total cost of its costs.
     */
    void showCategoriesData(HashMap<String, Double> categoryMap);

    /**
     * Shows a message to the user, mainly used to show feedback to the user on the different actions available to the user.
     * @param text text to be show to the user.
     */
    void showMessage(String text);
}
