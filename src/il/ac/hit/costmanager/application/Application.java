package il.ac.hit.costmanager.application;

import il.ac.hit.costmanager.view.main.MainView;

public class Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Create and display the application */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainView mainView = new MainView();
                mainView.setVisible(true);
            }
        });
    }
}
