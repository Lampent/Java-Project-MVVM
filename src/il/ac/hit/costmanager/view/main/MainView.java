
package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.builders.ButtonBuilder;
import il.ac.hit.costmanager.view.category.CategoryView;
import il.ac.hit.costmanager.view.category.ICategoryViewModel;
import il.ac.hit.costmanager.view.cost.CostView;
import il.ac.hit.costmanager.view.cost.ICostViewModel;
import il.ac.hit.costmanager.view.chart.IChartViewModel;
import il.ac.hit.costmanager.view.chart.ChartView;
import il.ac.hit.costmanager.view.report.IReportViewModel;
import il.ac.hit.costmanager.view.report.ReportView;


/**
 * The main view view, display the navigation bar and a container panel for the selected view view.
 * <p>
 * The navigation bar consists from four button, chart menu, cost menu, report menu , categories menu.
 * When clicked on a button its then presents its represented view in the container.
 * <p>
 * The container will show the selected view, and will be cleared when navigated to a different view.
 * <p>
 * When navigated to a certain view, a call to the main view view model is made to initialize the navigation.
 * The main view view model posses the IModel which required for each view model, thus the navigation will occur from the
 * main view view model.
 * <p>
 * Moreover, each view has its own view and viewModel implementing the MVVM methodology.
 * The view implements the IMainView interface.
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
     * Displays the chart view in the container.
     *
     * @param model IModel ;,
     * @param viewModel
     */
    @Override
    public void navigateChartMenu(IModel model, IChartViewModel viewModel) {
        this.ui.navigateChartMenu(model, viewModel);
    }

    @Override
    public void navigateCostMenu(IModel model, ICostViewModel viewModel) {
        this.ui.navigateCostMenu(model, viewModel);
    }

    @Override
    public void navigateCategoriesMenu(IModel model, ICategoryViewModel viewModel) {
        this.ui.navigateCategoriesMenu(model, viewModel);
    }

    @Override
    public void navigateReportMenu(IModel model, IReportViewModel viewModel) {
        this.ui.navigateReportMenu(model, viewModel);
    }


    public class ApplicationUI {

        private javax.swing.JPanel containerPanel;

        public ApplicationUI() {
            initComponents();
        }

        private void initComponents() {
            javax.swing.JPanel navigatorPanel = new javax.swing.JPanel();
            containerPanel = new javax.swing.JPanel();

            javax.swing.JButton costMenuButton = new ButtonBuilder("Cost Menu").build();
            costMenuButton.addActionListener(event -> viewModel.navigateCostMenu());

            javax.swing.JButton categoriesMenuButton = new ButtonBuilder("Categories Menu").build();
            categoriesMenuButton.addActionListener(event -> viewModel.navigateCategoriesMenu());

            javax.swing.JButton reportMenuButton = new ButtonBuilder("Reports Menu").build();
            reportMenuButton.addActionListener(event -> viewModel.navigateReportMenu());

            javax.swing.JButton chartMenuButton = new ButtonBuilder("Chart Menu").build();
            chartMenuButton.addActionListener(event -> viewModel.navigateChartMenu());


            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Cost Managment");


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

            javax.swing.GroupLayout ContainerPanelLayout = new javax.swing.GroupLayout(containerPanel);
            containerPanel.setLayout(ContainerPanelLayout);
            ContainerPanelLayout.setHorizontalGroup(
                    ContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 0, Short.MAX_VALUE)
            );
            ContainerPanelLayout.setVerticalGroup(
                    ContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 370, Short.MAX_VALUE)
            );

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

        private void navigateChartMenu(IModel model, IChartViewModel viewModel) {
            clearContainerPanel();

            ChartView view = new ChartView();

            viewModel.setModel(model);
            viewModel.setView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        // this button click add Cost view add in container panel
        private void navigateCostMenu(IModel model, ICostViewModel viewModel) {
            clearContainerPanel();

            CostView view = new CostView();

            view.setViewModel(viewModel);
            viewModel.setModel(model);
            viewModel.setView(view);
            viewModel.initializeView();

            view.pack();
            this.containerPanel.add(view.getContentPane());
        }

        // this button click add Category view add in container panel
        private void navigateCategoriesMenu(IModel model, ICategoryViewModel viewModel) {
            clearContainerPanel();

            CategoryView view = new CategoryView();

            view.setViewModel(viewModel);
            viewModel.setModel(model);
            viewModel.setView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        // this button click Report view add in container panel
        private void navigateReportMenu(IModel model, IReportViewModel viewModel) {
            clearContainerPanel();

            ReportView view = new ReportView();
            view.setViewModel(viewModel);
            viewModel.setModel(model);
            viewModel.setView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        private void clearContainerPanel() {
            containerPanel.removeAll();
            containerPanel.setVisible(false);
            containerPanel.setVisible(true);
        }
    }
}
