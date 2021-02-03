/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.DerbyDBModel;
import il.ac.hit.costmanager.view.builders.ButtonBuilder;
import il.ac.hit.costmanager.view.category.CategoryView;
import il.ac.hit.costmanager.view.category.CategoryViewModel;
import il.ac.hit.costmanager.view.category.ICategoryViewModel;
import il.ac.hit.costmanager.view.cost.CostView;
import il.ac.hit.costmanager.view.cost.CostViewModel;
import il.ac.hit.costmanager.view.piechart.IPieChartViewModel;
import il.ac.hit.costmanager.view.piechart.PieChartView;
import il.ac.hit.costmanager.view.piechart.PieChartViewModel;
import il.ac.hit.costmanager.view.report.IReportViewModel;
import il.ac.hit.costmanager.view.report.ReportView;
import il.ac.hit.costmanager.view.report.ReportViewModel;


/**
 * @author Birbal
 */
public class MainView extends javax.swing.JFrame {

    private ApplicationUI ui;

    public MainView() {
        this.ui = new ApplicationUI();
        this.ui.navigateCostMenu();
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
            costMenuButton.addActionListener(event -> navigateCostMenu());

            javax.swing.JButton categoriesMenuButton = new ButtonBuilder("Categories Menu").build();
            categoriesMenuButton.addActionListener(event -> navigateCategoriesMenu());

            javax.swing.JButton reportMenuButton = new ButtonBuilder("Reports Menu").build();
            reportMenuButton.addActionListener(event -> navigateReportMenu());

            javax.swing.JButton chartMenuButton = new ButtonBuilder("Chart Menu").build();
            chartMenuButton.addActionListener(event -> navigateChartMenu());


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
                                    .addContainerGap(130, Short.MAX_VALUE))
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
                            .addGap(0, 407, Short.MAX_VALUE)
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
        }

        private void navigateChartMenu() {
            this.clearContainerPanel();

            IPieChartViewModel viewModel = new PieChartViewModel();
            PieChartView view = new PieChartView();

            view.setViewModel(viewModel);
            viewModel.setModel(new DerbyDBModel());
            viewModel.setPieChartView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        // this button click add Cost view add in container panel
        private void navigateCostMenu() {
            this.clearContainerPanel();

            CostViewModel viewModel = new CostViewModel();
            CostView view = new CostView();

            view.setViewModel(viewModel);
            viewModel.setModel(new DerbyDBModel());
            viewModel.setCostView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        // this button click add Category view add in container panel
        private void navigateCategoriesMenu() {
            this.clearContainerPanel();

            ICategoryViewModel viewModel = new CategoryViewModel();
            CategoryView view = new CategoryView();

            view.setViewModel(viewModel);
            viewModel.setModel(new DerbyDBModel());
            viewModel.setCategoryView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        // this button click Report view add in container panel
        private void navigateReportMenu() {
            this.clearContainerPanel();

            IReportViewModel viewModel = new ReportViewModel();
            ReportView view = new ReportView();

            view.setViewModel(viewModel);
            viewModel.setModel(new DerbyDBModel());
            viewModel.setReportView(view);
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
