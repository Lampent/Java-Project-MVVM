package il.ac.hit.costmanager.view.piechart;

import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.view.IView;

import java.util.ArrayList;

public interface IPieChartView extends IView {

    public void createChart(ArrayList<Category> catModel);

}
