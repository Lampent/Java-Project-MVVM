/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.view.builders.ButtonBuilder;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CostView extends javax.swing.JFrame implements ICostView {

    private CostViewModel viewModel;
    private CostUI costUI;
    private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public CostView() {
        this.costUI = new CostUI();
    }

    @Override
    public void setViewModel(CostViewModel vm) {
        this.viewModel = vm;
    }

    @Override
    public void showCosts(ArrayList<Category> categories) {
        this.costUI.showCategories(categories);
    }

    public class CostUI {
        private javax.swing.JComboBox<String> categoriesComboBox;
        private datechooser.beans.DateChooserCombo dateChooserCombo1;
        private javax.swing.JTextField costTextField;
        private javax.swing.JTextArea costTextArea;

        public CostUI() {
            initComponents();
        }

        private void initComponents() {

            JPanel titlePanel = new JPanel();
            JLabel titleLabel = new JLabel();

            categoriesComboBox = new javax.swing.JComboBox<>();
            JLabel comboBoxLabel = new JLabel();

            costTextField = new javax.swing.JTextField();
            JLabel costTextFieldLabel = new JLabel();

            costTextArea = new javax.swing.JTextArea();
            JLabel costTextAreaLabel = new JLabel();
            JScrollPane costTextAreaScrollPane = new JScrollPane();

            JButton btnSubmit = new ButtonBuilder("Submit").build();
            btnSubmit.addActionListener(event -> submitCost());

            JLabel jLabel5 = new JLabel();
            dateChooserCombo1 = new datechooser.beans.DateChooserCombo();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            titlePanel.setBackground(new java.awt.Color(102, 102, 255));
            titleLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 24));
            titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            titleLabel.setText("Cost Menu");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(titlePanel);
            titlePanel.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            comboBoxLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12));
            comboBoxLabel.setText("Select Cost Categorie :");

            categoriesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

            costTextFieldLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12));
            costTextFieldLabel.setText("Enter Cost :");

            costTextAreaLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12));
            costTextAreaLabel.setText("Enter Cost Describing :");

            costTextArea.setColumns(20);
            costTextArea.setRows(5);
            costTextAreaScrollPane.setViewportView(costTextArea);


            jLabel5.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12));
            jLabel5.setText("Select Date :");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnSubmit)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(comboBoxLabel)
                                                            .addComponent(costTextFieldLabel)
                                                            .addComponent(costTextAreaLabel)
                                                            .addComponent(jLabel5))
                                                    .addGap(69, 69, 69)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(categoriesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(costTextField)
                                                            .addComponent(costTextAreaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addContainerGap(76, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(comboBoxLabel)
                                            .addComponent(categoriesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(costTextFieldLabel)
                                            .addComponent(costTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(costTextAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(costTextAreaLabel))
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSubmit)
                                    .addContainerGap())
            );

            pack();
        }

        private void showCategories(ArrayList<Category> catModel) {
            dateChooserCombo1.setDateFormat(dateFormat);
            categoriesComboBox.removeAllItems();
            for (Category category : catModel) {
                categoriesComboBox.addItem(category.getCategoryName());
            }
        }

        private void submitCost() {
            try {
                String selectedCategory = categoriesComboBox.getSelectedItem() != null ? categoriesComboBox.getSelectedItem().toString() : "";
                double cost =  costTextField.getText().trim().length() > 0 ? Double.parseDouble(costTextField.getText().trim()) : 0;
                Cost costItem = new Cost(selectedCategory, dateFormat.format(dateChooserCombo1.getSelectedDate().getTime()) + "", costTextArea.getText().trim(), cost);
                viewModel.insertCost(costItem);
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
            } catch (CostManagerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
