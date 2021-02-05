package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.ViewInitializer;

/**
 * The interface of the report view model.
 * Includes the required methods that the view model should implement.
 * Extends ViewInitializer interface.
 */
public interface IReportViewModel extends ViewInitializer {

    void setModel(IModel model);

    void setView(IReportView view);

    void showCosts();

    void showCosts(String startDate, String endDate);
}
