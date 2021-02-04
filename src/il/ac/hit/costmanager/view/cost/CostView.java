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
import il.ac.hit.costmanager.view.builders.LabelBuilder;
import il.ac.hit.costmanager.view.builders.TitleLayoutBuilder;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CostView extends javax.swing.JFrame implements ICostView {

    private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private CostViewModel viewModel;
    private CostUI costUI;

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

    @Override
    public void showMessage(String text) {
        this.costUI.showMessage(text);
    }

    public class CostUI {
        private javax.swing.JComboBox<String> categoriesComboBox;
        private datechooser.beans.DateChooserCombo dateChooserCombo1;
        private javax.swing.JTextField costTextField;
        private javax.swing.JTextArea costTextArea;

        public CostUI() {
            initComponents();
        }

        public void showMessage(String text) {
            JOptionPane.showMessageDialog(null, text);
        }

        private void initComponents() {

            JPanel titlePanel = new JPanel();
            titlePanel.setBackground(new java.awt.Color(102, 102, 255));

            JLabel titleLabel = new LabelBuilder("Cost Menu").setHorizontalAlignment(javax.swing.SwingConstants.CENTER)
                    .setFontSize(24)
                    .build();

            categoriesComboBox = new javax.swing.JComboBox<>();
            JLabel comboBoxLabel = new LabelBuilder("Select Cost Categories :").build();

            costTextField = new javax.swing.JTextField();
            JLabel costTextFieldLabel = new LabelBuilder("Enter Cost :").build();

            JLabel costTextAreaLabel = new LabelBuilder("Enter Cost Description :").build();
            JScrollPane costTextAreaScrollPane = new JScrollPane();

            JButton btnSubmit = new ButtonBuilder("Submit").build();
            btnSubmit.addActionListener(event -> submitCost());

            JLabel selectDateLabel = new LabelBuilder("Select Date :").build();
            dateChooserCombo1 = new datechooser.beans.DateChooserCombo();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            new TitleLayoutBuilder(titleLabel, titlePanel).build();

            categoriesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

            costTextArea = new javax.swing.JTextArea();
            costTextArea.setColumns(20);
            costTextArea.setRows(5);
            costTextAreaScrollPane.setViewportView(costTextArea);


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
                                                            .addComponent(selectDateLabel))
                                                    .addGap(69, 69, 69)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(categoriesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(costTextField)
                                                            .addComponent(costTextAreaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addContainerGap(44, Short.MAX_VALUE))
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
                                            .addComponent(selectDateLabel)
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
            String selectedCategory = categoriesComboBox.getSelectedItem() != null ? categoriesComboBox.getSelectedItem().toString() : "";
            if (costTextField.getText().trim().length() > 0) {
                try {
                    double cost = Double.parseDouble(costTextField.getText().trim());
                    Cost costItem = new Cost(selectedCategory, dateFormat.format(dateChooserCombo1.getSelectedDate().getTime()) + "", costTextArea.getText().trim(), cost);
                    viewModel.insertCost(costItem);
                } catch (CostManagerException e) {
                    showMessage(e.getMessage());
                } catch (Exception e) {
                    showMessage("Cost entered is not valid, please enter a valid number");
                }
            } else {
                showMessage("Please enter cost");
            }
        }
    }
}
