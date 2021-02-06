package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.builders.ButtonBuilder;
import il.ac.hit.costmanager.view.category.CategoryView;
import il.ac.hit.costmanager.view.category.CategoryViewModel;
import il.ac.hit.costmanager.view.category.ICategoryViewModel;
import il.ac.hit.costmanager.view.chart.ChartView;
import il.ac.hit.costmanager.view.chart.ChartViewModel;
import il.ac.hit.costmanager.view.chart.IChartViewModel;
import il.ac.hit.costmanager.view.cost.CostView;
import il.ac.hit.costmanager.view.cost.CostViewModel;
import il.ac.hit.costmanager.view.cost.ICostViewModel;
import il.ac.hit.costmanager.view.report.IReportViewModel;
import il.ac.hit.costmanager.view.report.ReportView;
import il.ac.hit.costmanager.view.report.ReportViewModel;


/**
 * The main view, display the navigation bar and a container panel for the navigated view.
 * <p>
 * The navigation bar consists from four buttons and each button represent a view, chart menu, cost menu, report menu, categories menu.
 * When clicked on a button its then presents its represented view in the container (navigates to it).
 * <p>
 * The container will be cleared and display the relevant view each time a button is pressed.
 * <p>
 * The implementation in this application is that each view (menu) has its own MVVM implementation.
 * However, they all share the same IModel has they have common behavior to the IModel.
 * The IModel instance is received from the MainViewModel, so when a navigation button clicked it calls a method in the MainViewModel and that will invoke the navigation.
 */
public class MainView extends javax.swing.JFrame implements IMainView {

    private IMainViewModel viewModel;
    private ApplicationUI ui;

    /**
     * The constructor of the main view.
     * Initializing the view ui.
     */
    public MainView() {
        this.ui = new ApplicationUI();
    }

    /**
     * Sets the view model
     *
     * @param viewModel the main view ViewModel.
     */
    @Override
    public void setViewModel(IMainViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Displays the chart menu in the container.
     *
     * @param model the IModel for the use of the chart viewModel
     */
    @Override
    public void navigateChartMenu(IModel model) {
        this.ui.navigateChartMenu(model);
    }

    /**
     * Displays the cost menu in the container.
     *
     * @param model the IModel for the use of the cost viewModel
     */
    @Override
    public void navigateCostMenu(IModel model) {
        this.ui.navigateCostMenu(model);
    }

    /**
     * Displays the categories menu in the container.
     *
     * @param model the IModel for the use of the categories viewModel
     */
    @Override
    public void navigateCategoriesMenu(IModel model) {
        this.ui.navigateCategoriesMenu(model);
    }

    /**
     * Displays the report menu in the container.
     *
     * @param model the IModel for the use of the report viewModel
     */
    @Override
    public void navigateReportMenu(IModel model) {
        this.ui.navigateReportMenu(model);
    }


    public class ApplicationUI {

        // the container panel, display the navigated view.
        private javax.swing.JPanel containerPanel;

        /**
         * The ui constructor.
         * Initializing the user interface.
         */
        public ApplicationUI() {
            initComponents();
        }

        /**
         * Initializing the user interface.
         * Makes use of different builders such as the buttonBuilder to save lines of code.
         */
        private void initComponents() {
            // sets the close operation to exit when closed
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            // creating the cost menu button and attaches method to navigate when clicked
            javax.swing.JButton costMenuButton = new ButtonBuilder("Cost Menu").build();
            costMenuButton.addActionListener(event -> viewModel.navigateCostMenu());

            // creating the categories menu button and attaches method to navigate when clicked
            javax.swing.JButton categoriesMenuButton = new ButtonBuilder("Categories Menu").build();
            categoriesMenuButton.addActionListener(event -> viewModel.navigateCategoriesMenu());

            // creating the reports menu button and attaches method to navigate when clicked
            javax.swing.JButton reportMenuButton = new ButtonBuilder("Reports Menu").build();
            reportMenuButton.addActionListener(event -> viewModel.navigateReportMenu());

            // creating the chart menu button and attaches method to navigate when clicked
            javax.swing.JButton chartMenuButton = new ButtonBuilder("Chart Menu").build();
            chartMenuButton.addActionListener(event -> viewModel.navigateChartMenu());

            // sets the title of the view
            setTitle("Cost Management");

            // creating the navigator panel, includes all the button created above for the navigation
            javax.swing.JPanel navigatorPanel = new javax.swing.JPanel();
            javax.swing.GroupLayout navigatorPanelLayout = new javax.swing.GroupLayout(navigatorPanel);
            navigatorPanel.setLayout(navigatorPanelLayout);
            navigatorPanelLayout.setHorizontalGroup(
                    navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(navigatorPanelLayout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(costMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(categoriesMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(reportMenuButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(chartMenuButton)
                                    .addContainerGap(113, Short.MAX_VALUE))
            );
            navigatorPanelLayout.setVerticalGroup(
                    navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(navigatorPanelLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(costMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(categoriesMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(reportMenuButton)
                                            .addComponent(chartMenuButton))
                                    .addContainerGap(27, Short.MAX_VALUE))
            );

            // creating the container panel layout
            javax.swing.GroupLayout ContainerPanelLayout = new javax.swing.GroupLayout(containerPanel);
            ContainerPanelLayout.setHorizontalGroup(
                    ContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 0, Short.MAX_VALUE)
            );
            ContainerPanelLayout.setVerticalGroup(
                    ContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 370, Short.MAX_VALUE)
            );

            // initializing the container panel and sets its layout
            containerPanel = new javax.swing.JPanel();
            containerPanel.setLayout(ContainerPanelLayout);

            // creating and setting the main layout of the view
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(navigatorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(navigatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        }

        /**
         * Navigates to the chart menu.
         * <p>
         * Clears the container panel from previous view.
         * Receives the IModel instance and initializing the Chart MVVM.
         * After initialized, sets the container panel with the chart view.
         *
         * @param model the IModel instance.
         */
        private void navigateChartMenu(IModel model) {
            clearContainerPanel();

            IChartViewModel viewModel = new ChartViewModel();
            ChartView view = new ChartView();

            viewModel.setModel(model);
            viewModel.setView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        /**
         * Navigates to the cost menu.
         * <p>
         * Clears the container panel from previous view.
         * Receives the IModel instance and initializing the Cost MVVM.
         * After initialized, sets the container panel with the cost view.
         *
         * @param model the IModel instance.
         */
        private void navigateCostMenu(IModel model) {
            clearContainerPanel();

            ICostViewModel viewModel = new CostViewModel();
            CostView view = new CostView();

            view.setViewModel(viewModel);
            viewModel.setModel(model);
            viewModel.setView(view);
            viewModel.initializeView();

            view.pack();
            this.containerPanel.add(view.getContentPane());
        }

        /**
         * Navigates to the categories menu.
         * <p>
         * Clears the container panel from previous view.
         * Receives the IModel instance and initializing the category MVVM.
         * After initialized, sets the container panel with the category view.
         *
         * @param model the IModel instance.
         */
        private void navigateCategoriesMenu(IModel model) {
            clearContainerPanel();

            ICategoryViewModel viewModel = new CategoryViewModel();
            CategoryView view = new CategoryView();

            view.setViewModel(viewModel);
            viewModel.setModel(model);
            viewModel.setView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        /**
         * Navigates to the report menu.
         * <p>
         * Clears the container panel from previous view.
         * Receives the IModel instance and initializing the Report MVVM.
         * After initialized, sets the container panel with the report view.
         *
         * @param model the IModel instance.
         */
        private void navigateReportMenu(IModel model) {
            clearContainerPanel();

            IReportViewModel viewModel = new ReportViewModel();
            ReportView view = new ReportView();

            view.setViewModel(viewModel);
            viewModel.setModel(model);
            viewModel.setView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        /**
         * Clears the container panel.
         * <p>
         * The main use for this method is to clear the container panel before setting a new view.
         */
        private void clearContainerPanel() {
            containerPanel.removeAll();
            containerPanel.setVisible(false);
            containerPanel.setVisible(true);
        }
    }
}
