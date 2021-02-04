package il.ac.hit.costmanager.application;

import il.ac.hit.costmanager.model.DerbyDBModel;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.main.IMainViewModel;
import il.ac.hit.costmanager.view.main.MainView;
import il.ac.hit.costmanager.view.main.MainViewModel;

public class Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IModel model = new DerbyDBModel();
                MainView view = new MainView();
                IMainViewModel viewModel = new MainViewModel();

                view.setViewModel(viewModel);
                viewModel.setMainView(view);
                viewModel.setModel(model);
                viewModel.initializeView();
            }
        });
    }
}
