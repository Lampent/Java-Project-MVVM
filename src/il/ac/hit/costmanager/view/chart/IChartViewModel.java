package il.ac.hit.costmanager.view.chart;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.ViewInitializer;

public interface IChartViewModel extends ViewInitializer {

    void setModel(IModel model);

    void setView(IChartView view);

    void showCategoriesData();
}
