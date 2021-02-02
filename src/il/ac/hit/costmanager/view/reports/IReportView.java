package il.ac.hit.costmanager.view.reports;

import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.view.IView;

import java.util.ArrayList;

public interface IReportView extends IView {

    public void setTableData(ArrayList<Cost> costs);

}
