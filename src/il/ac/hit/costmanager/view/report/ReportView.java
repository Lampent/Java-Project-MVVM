/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.view.report;

import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.view.Initializable;
import il.ac.hit.costmanager.view.builders.ButtonBuilder;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Birbal
 */
public class ReportView extends javax.swing.JFrame implements IReportView {
    private IReportViewModel viewModel;
    private ReportUI reportUI;

    private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

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

    public class ReportUI {

        private javax.swing.JButton btnShow;
        private datechooser.beans.DateChooserCombo dateEnd;
        private datechooser.beans.DateChooserCombo dateStart;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JTable tabShowData;

        public ReportUI() {
            initComponents();
            dateStart.setDateFormat(dateFormat);
            dateEnd.setDateFormat(dateFormat);
        }

        public void showCosts(ArrayList<Cost> costs) {
            DefaultTableModel tabModel = (DefaultTableModel) tabShowData.getModel();
            tabModel.getDataVector().removeAllElements();
            Object[] data = new Object[4];
            for (Cost cost : costs) {
                data[0] = cost.getCost();
                data[1] = cost.getDate();
                data[2] = cost.getDesc();
                data[3] = cost.getCategory();
                tabModel.addRow(data);
            }
            tabShowData.setModel(tabModel);
        }

        private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            dateStart = new datechooser.beans.DateChooserCombo();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            dateEnd = new datechooser.beans.DateChooserCombo();

            btnShow = new ButtonBuilder("Show").build();
            btnShow.addActionListener(this::btnShowActionPerformed);

            jSeparator1 = new javax.swing.JSeparator();
            jScrollPane1 = new javax.swing.JScrollPane();
            tabShowData = new javax.swing.JTable();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanel1.setBackground(new java.awt.Color(102, 102, 255));

            jLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 24)); // NOI18N
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Show Report");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jLabel2.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12)); // NOI18N
            jLabel2.setText("From Data :");

            jLabel3.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12)); // NOI18N
            jLabel3.setText("To  Data :");


            tabShowData.setModel(new javax.swing.table.DefaultTableModel(
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
            jScrollPane1.setViewportView(tabShowData);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnShow)
                                    .addGap(30, 30, 30))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(dateStart, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(dateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(btnShow))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addContainerGap())
            );

            pack();
        }

        private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {
            viewModel.showCosts(dateFormat.format(dateStart.getSelectedDate().getTime()), dateFormat.format(dateEnd.getSelectedDate().getTime()));
        }

    }
}
