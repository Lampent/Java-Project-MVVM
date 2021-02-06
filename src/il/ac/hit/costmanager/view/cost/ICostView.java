package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;

/**
 * The interface of the cost view.
 * Includes the required methods that the view should implement.
 */
public interface ICostView {

    /**
     * Sets the view model
     *
     * @param viewModel the cost view ViewModel.
     */
    void setViewModel(ICostViewModel viewModel);

    /**
     * Shows the categories names in the user interface.
     *
     * @param categories categories names to be shown.
     */
    void showCategories(ArrayList<Category> categories);

    /**
     * Shows a message to the user, mainly used to show feedback to the user on the different actions available to the user.
     *
     * @param text text to be show to the user.
     */
    void showMessage(String text);
}
