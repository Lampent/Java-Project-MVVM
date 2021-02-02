package il.ac.hit.costmanager.view.piechart;

import java.util.HashMap;

public interface IPieChartView {

    public void setViewModel(IPieChartViewModel vm);

    public void showCategoriesData(HashMap<String, Double> categoryMap);
}
