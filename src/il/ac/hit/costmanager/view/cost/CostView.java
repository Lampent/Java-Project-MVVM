/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.view.builders.ButtonBuilder;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Birbal
 */
public class CostView extends javax.swing.JFrame implements ICostView {

    private CostViewModel viewModel;
    private CostUI costUI;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

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
        private javax.swing.JButton btnSubmit;
        private javax.swing.JComboBox<String> comCategories;
        private datechooser.beans.DateChooserCombo dateChooserCombo1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextField txtCost;
        private javax.swing.JTextArea txtDec;

        /**
         * Creates new form AddCost
         */
        public CostUI() {
            initComponents();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            comCategories = new javax.swing.JComboBox<>();
            jLabel3 = new javax.swing.JLabel();
            txtCost = new javax.swing.JTextField();
            jLabel4 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            txtDec = new javax.swing.JTextArea();

            btnSubmit = new ButtonBuilder("Submit").build();
            btnSubmit.addActionListener(this::btnSubmitActionPerformed);

            jLabel5 = new javax.swing.JLabel();
            dateChooserCombo1 = new datechooser.beans.DateChooserCombo();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanel1.setBackground(new java.awt.Color(102, 102, 255));

            jLabel1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 24)); // NOI18N
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Add Cost");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jLabel2.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12)); // NOI18N
            jLabel2.setText("Select Cost Categorie :");

            comCategories.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

            jLabel3.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12)); // NOI18N
            jLabel3.setText("Enter Cost :");

            jLabel4.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12)); // NOI18N
            jLabel4.setText("Enter Cost Describing :");

            txtDec.setColumns(20);
            txtDec.setRows(5);
            jScrollPane1.setViewportView(txtDec);


            jLabel5.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12)); // NOI18N
            jLabel5.setText("Select Date :");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnSubmit)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel2)
                                                            .addComponent(jLabel3)
                                                            .addComponent(jLabel4)
                                                            .addComponent(jLabel5))
                                                    .addGap(69, 69, 69)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(comCategories, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(txtCost)
                                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addContainerGap(76, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(comCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSubmit)
                                    .addContainerGap())
            );

            pack();
        }

        private void showCategories(ArrayList<Category> catModel) {
            dateChooserCombo1.setDateFormat(dateFormat);
            comCategories.removeAllItems();
            for (Category category : catModel) {
                comCategories.addItem(category.getCategoryName());
            }
        }

        private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
            if (txtCost.getText().trim().length() > 0 && txtDec.getText().trim().length() > 0) {
                viewModel.InsertCost(Double.parseDouble(txtCost.getText().trim()), dateFormat.format(dateChooserCombo1.getSelectedDate().getTime()) + "", txtDec.getText().trim(), comCategories.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all required filed's");
            }
        }
    }
}
