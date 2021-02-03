package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.model.IModel;

public interface IReportViewModel {

    public void setModel(IModel model);

    public void setReportView(IReportView reportView);

    public void initializeView();

    public void showCosts();

    public void showCosts(String startDate, String endDate);
}
