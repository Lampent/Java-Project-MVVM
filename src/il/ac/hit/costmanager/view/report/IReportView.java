package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.model.cost.Cost;

import java.util.ArrayList;

public interface IReportView {

    void setViewModel(IReportViewModel reportViewModel);

    void showCosts(ArrayList<Cost> costs);

    void showMessage(String text);
}
