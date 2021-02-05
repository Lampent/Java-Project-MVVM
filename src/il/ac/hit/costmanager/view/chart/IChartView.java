package il.ac.hit.costmanager.view.chart;

import java.util.HashMap;

/**
 * The interface of the chart view.
 * Includes the required methods that the view should implement.
 */
public interface IChartView {

    void showCategoriesData(HashMap<String, Double> categoryMap);

    /**
     * Shows a message to the user, mainly used to show feedback to the user on the different actions available to the user.
     * @param text text to be show to the user.
     */
    void showMessage(String text);
}
