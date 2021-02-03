/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.IModel;
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
public class MainView extends javax.swing.JFrame implements IMainView {

    ApplicationUI ui;
    IModel model;

    public MainView() {
        this.ui = new ApplicationUI();
    }

    public void setModel(IModel model) {
        this.model = model;
    }

    public class ApplicationUI {

        private javax.swing.JPanel containerPanel;


        public ApplicationUI() {
            initComponents();
        }

        private void initComponents() {
            javax.swing.JPanel navigatorPanel = new javax.swing.JPanel();
            containerPanel = new javax.swing.JPanel();

            javax.swing.JButton addCostButton = new ButtonBuilder("Add Cost").build();
            addCostButton.addActionListener(this::navigateCostMenu);

            javax.swing.JButton addCategoriesButton = new ButtonBuilder("Add Categories").build();
            addCategoriesButton.addActionListener(this::navigateCategoriesMenu);

            javax.swing.JButton reportCategoryButton = new ButtonBuilder("Report Generate").build();
            reportCategoryButton.addActionListener(this::navigateReportGenerator);

            javax.swing.JButton pieChartButton = new ButtonBuilder("Pie Chart").build();
            pieChartButton.addActionListener(this::navigatePieChart);


            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Cost Manahement");


            javax.swing.GroupLayout navigatorPanelLayout = new javax.swing.GroupLayout(navigatorPanel);
            navigatorPanel.setLayout(navigatorPanelLayout);
            navigatorPanelLayout.setHorizontalGroup(
                    navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(navigatorPanelLayout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(addCostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(addCategoriesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(reportCategoryButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(pieChartButton)
                                    .addContainerGap(130, Short.MAX_VALUE))
            );
            navigatorPanelLayout.setVerticalGroup(
                    navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(navigatorPanelLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(addCostButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addCategoriesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(reportCategoryButton)
                                            .addComponent(pieChartButton))
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

        private void navigatePieChart(java.awt.event.ActionEvent evt) {
            this.clearContainerPanel();

            IPieChartViewModel viewModel = new PieChartViewModel();
            PieChartView view = new PieChartView();

            view.setViewModel(viewModel);
            viewModel.setModel(model);
            viewModel.setPieChartView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        // this button click add Cost view add in container panel
        private void navigateCostMenu(java.awt.event.ActionEvent evt) {
            this.clearContainerPanel();

            CostViewModel viewModel = new CostViewModel();
            CostView view = new CostView();

            view.setViewModel(viewModel);
            viewModel.setModel(model);
            viewModel.setCostView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        // this button click add Category view add in container panel
        private void navigateCategoriesMenu(java.awt.event.ActionEvent evt) {
            this.clearContainerPanel();

            ICategoryViewModel viewModel = new CategoryViewModel();
            CategoryView view = new CategoryView();

            view.setViewModel(viewModel);
            viewModel.setModel(model);
            viewModel.setCategoryView(view);
            viewModel.initializeView();

            view.pack();
            containerPanel.add(view.getContentPane());
        }

        // this button click Report view add in container panel
        private void navigateReportGenerator(java.awt.event.ActionEvent evt) {
            this.clearContainerPanel();

            IReportViewModel viewModel = new ReportViewModel();
            ReportView view = new ReportView();

            view.setViewModel(viewModel);
            viewModel.setModel(model);
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
