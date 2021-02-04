package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.ViewInitializer;

public interface IReportViewModel extends ViewInitializer {

    void setModel(IModel model);

    void setReportView(IReportView reportView);

    void showCosts();

    void showCosts(String startDate, String endDate);
}
