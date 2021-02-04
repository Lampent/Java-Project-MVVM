/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.view.builders.ButtonBuilder;
import il.ac.hit.costmanager.view.builders.LabelBuilder;
import il.ac.hit.costmanager.view.builders.TitleLayoutBuilder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Birbal
 */
public class ReportView extends javax.swing.JFrame implements IReportView {
    private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private IReportViewModel viewModel;
    private ReportUI reportUI;

    /**
     * Creates new form ReportGenerate
     */
    public ReportView() {
        this.reportUI = new ReportUI();
    }

    @Override
    public void setViewModel(IReportViewModel reportViewModel) {
        this.viewModel = reportViewModel;
    }

    @Override
    public void showCosts(ArrayList<Cost> costs) {
        this.reportUI.showCosts(costs);
    }

    @Override
    public void showMessage(String text) {
        this.reportUI.showMessage(text);
    }

    public class ReportUI {

        private datechooser.beans.DateChooserCombo dateStart;
        private datechooser.beans.DateChooserCombo dateEnd;
        private javax.swing.JTable costsTable;

        public ReportUI() {
            initComponents();
            dateStart.setDateFormat(dateFormat);
            dateEnd.setDateFormat(dateFormat);
        }

        public void showMessage(String text) {
            JOptionPane.showMessageDialog(null, text);
        }

        public void showCosts(ArrayList<Cost> costs) {
            DefaultTableModel tabModel = (DefaultTableModel) costsTable.getModel();
            tabModel.getDataVector().removeAllElements();
            Object[] data = new Object[4];
            for (Cost cost : costs) {
                data[0] = cost.getCost();
                data[1] = cost.getDate();
                data[2] = cost.getDesc();
                data[3] = cost.getCategory();
                tabModel.addRow(data);
            }
            costsTable.setModel(tabModel);
        }

        private void initComponents() {

            javax.swing.JPanel titlePanel = new javax.swing.JPanel();
            javax.swing.JLabel titleLabel = new LabelBuilder("Report Menu").setFontSize(24)
                    .setHorizontalAlignment(javax.swing.SwingConstants.CENTER).build();

            dateStart = new datechooser.beans.DateChooserCombo();
            javax.swing.JLabel dateStartLabel = new LabelBuilder("From Data :").build();

            dateEnd = new datechooser.beans.DateChooserCombo();
            javax.swing.JLabel dateEndLabel =  new LabelBuilder("To Data :").build();

            javax.swing.JButton showButton = new ButtonBuilder("Show").build();
            showButton.addActionListener(event -> viewModel.showCosts(dateFormat.format(dateStart.getSelectedDate().getTime()),
                    dateFormat.format(dateEnd.getSelectedDate().getTime())));

            javax.swing.JSeparator separator = new javax.swing.JSeparator();
            javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane();
            costsTable = new javax.swing.JTable();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            titlePanel.setBackground(new java.awt.Color(102, 102, 255));

            new TitleLayoutBuilder(titleLabel, titlePanel).build();

            costsTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null}
                    },
                    new String[]{
                            "Cost", "Date", "Description", "Category Name"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, true, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            scrollPane.setViewportView(costsTable);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(dateStartLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateEndLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(showButton)
                                    .addGap(30, 30, 30))
                            .addComponent(separator, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(dateStart, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                                            .addComponent(dateStartLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(dateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(dateEndLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(showButton))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addContainerGap())
            );

            pack();
        }
    }
}