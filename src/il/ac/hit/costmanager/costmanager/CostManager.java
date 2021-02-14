/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.costmanager;

import il.ac.hit.costmanager.model.DerbyDBModel;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.main.IMainView;
import il.ac.hit.costmanager.view.main.IMainViewModel;
import il.ac.hit.costmanager.view.main.MainView;
import il.ac.hit.costmanager.view.main.MainViewModel;

import javax.swing.*;

/**
 * The CostManager program implements an application that manage costs.
 * It will offer four different views.
 * Cost - For adding a new cost.
 * Category - For adding and deleting categories.
 * Report -  For displaying all the costs or some of them by date.
 * Chart - Visualising all the categories in a chart according to the total sum of their costs.
 * <p>
 * The CostManager program is based on MVVM architectural pattern.
 * In its current implementation its posses a main view that can display in it a selected view from the four mentioned above.
 * Each view mentioned above has its own view and viewModel has MVVM architectural pattern implementation.
 */
public class CostManager {

    /**
     * The main method
     * Creates the model class and the MainView and the MainViewModel, and starting the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        // initializing IModel, MainView and IMainViewModel
        IModel model = new DerbyDBModel();

        IMainViewModel viewModel = new MainViewModel();
        viewModel.setModel(model);

        SwingUtilities.invokeLater(() -> {
            IMainView view = new MainView();

            // setting the required dependencies
            view.setViewModel(viewModel);
            viewModel.setMainView(view);

            // initializing the view
            viewModel.initializeView();
        });
    }
}
