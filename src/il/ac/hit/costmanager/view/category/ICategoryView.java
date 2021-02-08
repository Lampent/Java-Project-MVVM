/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.model.category.Category;

import java.util.ArrayList;

/**
 * The interface of the category view.
 * Includes the required methods that the view should implement.
 */
public interface ICategoryView {

    /**
     * Sets the view model
     *
     * @param viewModel the category view ViewModel.
     */
    void setViewModel(ICategoryViewModel viewModel);

    /**
     * Shows categories in the user interface.
     *
     * @param categories categories to be shown.
     */
    void showCategories(ArrayList<Category> categories);

    /**
     * Shows a message to the user, mainly used to show feedback to the user on the different actions available to the user.
     *
     * @param text text to be show to the user.
     */
    void showMessage(String text);
}
