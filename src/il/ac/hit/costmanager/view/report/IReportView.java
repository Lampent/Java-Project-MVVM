package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.model.cost.Cost;

import java.util.ArrayList;

/**
 * The interface of the report view.
 * Includes the required methods that the view should implement.
 */
public interface IReportView {

    /**
     * Sets the view model
     * @param viewModel the report view ViewModel.
     */
    void setViewModel(IReportViewModel viewModel);

    void showCosts(ArrayList<Cost> costs);

    /**
     * Shows a message to the user, mainly used to show feedback to the user on the different actions available to the user.
     * @param text text to be show to the user.
     */
    void showMessage(String text);
}
