package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.model.cost.Cost;

import java.util.ArrayList;

public interface IReportView  {

    public void setViewModel(IReportViewModel reportViewModel);

    public void showCosts(ArrayList<Cost> costs);

}
