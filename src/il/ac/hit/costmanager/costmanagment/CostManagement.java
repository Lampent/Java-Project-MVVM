package il.ac.hit.costmanager.costmanagment;

import il.ac.hit.costmanager.model.DerbyDBModel;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.main.IMainView;
import il.ac.hit.costmanager.view.main.IMainViewModel;
import il.ac.hit.costmanager.view.main.MainView;
import il.ac.hit.costmanager.view.main.MainViewModel;

/**
 * The CostManagement program implements an application that manage costs
 * It will offer four different views.
 * Cost - For adding a new cost
 * Category - For adding and deleting categories.
 * Report -  For displaying all the costs or some of them by date.
 * Chart - Visualising all the categories in a chart according to the total sum of their costs.
 */
public class CostManagement {

    /**
     * @param args
     * The main method
     * Creates the model class and the MainView and the MainViewModel, and starting the application.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // initializing IModel, MainView and IMainViewModel
                IModel model = new DerbyDBModel();
                IMainView view = new MainView();
                IMainViewModel viewModel = new MainViewModel();

                // setting the required dependencies
                view.setViewModel(viewModel);
                viewModel.setMainView(view);
                viewModel.setModel(model);

                // initializing the view after all dependencies were solved
                viewModel.initializeView();
            }
        });
    }
}
