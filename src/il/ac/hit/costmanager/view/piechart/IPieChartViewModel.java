package il.ac.hit.costmanager.view.piechart;

import il.ac.hit.costmanager.model.IModel;

public interface IPieChartViewModel {

    public void setModel(IModel model);

    public void setPieChartView(IPieChartView costView);

    public void initializeView();

    public void showCategoriesData();
}
