package il.ac.hit.costmanager.view.chart;

import java.util.HashMap;

public interface IChartView {

    void showCategoriesData(HashMap<String, Double> categoryMap);

    void showMessage(String text);
}
