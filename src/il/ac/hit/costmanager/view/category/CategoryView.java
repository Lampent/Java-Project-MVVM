/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.view.builders.ButtonBuilder;
import il.ac.hit.costmanager.view.builders.TitleLayoutBuilder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Birbal
 */
public class CategoryView extends javax.swing.JFrame implements ICategoryView {

    private ICategoryViewModel viewModel;
    private CategoryUI categoryUI;

    public CategoryView() {
        this.categoryUI = new CategoryUI();
    }

    @Override
    public void setViewModel(ICategoryViewModel vm) {
        this.viewModel = vm;
    }

    @Override
    public void showCategories(ArrayList<Category> catModel) {
        this.categoryUI.showCategories(catModel);
    }

    public class CategoryUI {
        private javax.swing.JTable categoriesTable;
        private javax.swing.JTextField addCategoryTextField;


        public CategoryUI() {
            initComponents();
        }

        private void initComponents() {

            JPanel titlePanel = new JPanel();
            JLabel titleLabel = new JLabel();
            JLabel addCategoryTextFieldLabel = new JLabel();
            addCategoryTextField = new javax.swing.JTextField();

            JButton submitButton = new ButtonBuilder("Submit").build();
            submitButton.addActionListener(event -> submitCategory());

            JSeparator separator = new JSeparator();
            JScrollPane scrollPanel = new JScrollPane();
            categoriesTable = new javax.swing.JTable();

            JButton deleteCategoryButton = new ButtonBuilder("Delete").setDefaultCapable(false).build();
            deleteCategoryButton.addActionListener(event -> deleteCategory());


            titlePanel.setBackground(new java.awt.Color(102, 102, 255));

            titleLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 24));
            titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            titleLabel.setText("Categories Menu");
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            javax.swing.GroupLayout titleLayout = new TitleLayoutBuilder(titleLabel, titlePanel).build();

            addCategoryTextFieldLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12));
            addCategoryTextFieldLabel.setText("Add New Categorie :");


            categoriesTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                            {null, null},
                            {null, null},
                            {null, null},
                            {null, null}
                    },
                    new String[]{
                            "Category Id", "Category Name"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            scrollPanel.setViewportView(categoriesTable);



            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separator)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(addCategoryTextFieldLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(addCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(submitButton)
                                    .addContainerGap(54, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteCategoryButton)
                                    .addGap(55, 55, 55))
                            .addComponent(scrollPanel)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(addCategoryTextFieldLabel)
                                            .addComponent(addCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(submitButton))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(deleteCategoryButton)
                                    .addContainerGap())
            );

            pack();
        }

        private void submitCategory() {
            try {
                viewModel.insertCategory(new Category(addCategoryTextField.getText().trim()));
                addCategoryTextField.setText("");
                JOptionPane.showMessageDialog(null, "Category Inserted Successfully");
            } catch (CostManagerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        private void deleteCategory() {
            int row = categoriesTable.getSelectedRow();
            if (row >= 0) {
                int categoryId = Integer.parseInt(categoriesTable.getModel().getValueAt(row, 0).toString());
                viewModel.deleteCategory(categoryId);
            } else {
                JOptionPane.showMessageDialog(null, "Please select category to delete");
            }
        }

        public void showCategories(ArrayList<Category> catModel) {
            Object[] data = new Object[2];
            DefaultTableModel tabModel = (DefaultTableModel) categoriesTable.getModel();
            tabModel.getDataVector().removeAllElements();
            for (Category category : catModel) {
                data[0] = category.getCatId();
                data[1] = category.getCategoryName();
                tabModel.addRow(data);
            }
            categoriesTable.setModel(tabModel);
        }
    }
}
