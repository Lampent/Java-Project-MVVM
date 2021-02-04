package il.ac.hit.costmanager.view.piechart;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.ViewInitializer;

public interface IPieChartViewModel extends ViewInitializer {

    void setModel(IModel model);

    void setPieChartView(IPieChartView costView);

    void showCategoriesData();
}
