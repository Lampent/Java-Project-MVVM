package il.ac.hit.costmanager.view.piechart;

import java.util.HashMap;

public interface IPieChartView {

    void showCategoriesData(HashMap<String, Double> categoryMap);

    void showMessage(String text);
}
