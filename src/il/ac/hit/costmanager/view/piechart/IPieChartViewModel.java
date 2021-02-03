package il.ac.hit.costmanager.view.piechart;

import il.ac.hit.costmanager.model.IModel;

public interface IPieChartViewModel {

    void setModel(IModel model);

    void setPieChartView(IPieChartView costView);

    void initializeView();

    void showCategoriesData();
}
