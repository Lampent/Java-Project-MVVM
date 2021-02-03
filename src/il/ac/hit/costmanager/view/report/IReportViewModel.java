package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.model.IModel;

public interface IReportViewModel {

    void setModel(IModel model);

    void setReportView(IReportView reportView);

    void initializeView();

    void showCosts();

    void showCosts(String startDate, String endDate);
}
