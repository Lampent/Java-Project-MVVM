/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.ViewInitializer;

/**
 * The interface of the report view model.
 * Includes the required methods that the view model should implement.
 * Extends ViewInitializer interface.
 */
public interface IReportViewModel extends ViewInitializer {

    /**
     * Sets the model.
     *
     * @param model the model implementing IModel.
     */
    void setModel(IModel model);

    /**
     * Sets the view.
     *
     * @param view the view implementing IReportView.
     */
    void setView(IReportView view);

    /**
     * Shows all the existing costs in the model.
     */
    void showCosts();

    /**
     * Shows all the existing costs that created between two dates.
     */
    void showCosts(String startDate, String endDate);
}
