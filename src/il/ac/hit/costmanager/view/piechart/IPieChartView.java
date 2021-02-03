package il.ac.hit.costmanager.view.piechart;

import java.util.HashMap;

public interface IPieChartView {

    void setViewModel(IPieChartViewModel vm);

    void showCategoriesData(HashMap<String, Double> categoryMap);
}
