/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.exceptions.CostManagerException;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.view.builders.ButtonBuilder;
import il.ac.hit.costmanager.view.builders.LabelBuilder;
import il.ac.hit.costmanager.view.builders.TitleLayoutBuilder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * The view of the categories.
 * Displays all the categories of the application in a table.
 * Allows comfort view of all the categories of the application.
 * Allows to delete and create categories.
 * <p>
 * The category view will also provide feedback on each it can preform;
 * for example, when a category will be deleted a message will be displayed to the user.
 * <p>
 * The view implements the ICategoryViw interface.
 */
public class CategoryView extends javax.swing.JFrame implements ICategoryView {

    private ICategoryViewModel viewModel;
    private CategoryUI categoryUI;

    /**
     * The constructor of the category view.
     * Initializing the category view ui.
     */
    public CategoryView() {
        this.categoryUI = new CategoryUI();
    }

    /**
     * Sets the view model
     *
     * @param viewModel the category view ViewModel.
     */
    @Override
    public void setViewModel(ICategoryViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Shows categories in the user interface.
     * Calls the categoryUI method to show the categories.
     *
     * @param categories categories to be shown.
     */
    @Override
    public void showCategories(ArrayList<Category> categories) {
        this.categoryUI.showCategories(categories);
    }

    /**
     * Shows a message to the user, mainly used to show feedback to the user on the different actions available to the user.
     * Calls the categoryUI method to show the message.
     *
     * @param text text to be show to the user.
     */
    @Override
    public void showMessage(String text) {
        this.categoryUI.showMessage(text);
    }

    /**
     * The user interface of the view.
     * Communicating with the ViewModel for executing different operations on a separated thread.
     */
    public class CategoryUI {
        private javax.swing.JTable categoriesTable;
        private javax.swing.JTextField addCategoryTextField;

        /**
         * The ui constructor.
         * Initializing the user interface.
         */
        public CategoryUI() {
            initComponents();
        }

        /**
         * Shows the received text message to the user.
         *
         * @param text the received message to be shown.
         */
        public void showMessage(String text) {
            JOptionPane.showMessageDialog(null, text);
        }

        /**
         * Initializing the user interface.
         * Makes use of different builders such as the LabelBuilder, TitleBuilder and TittleBuilder to save lines of code.
         */
        private void initComponents() {
            // sets the close operation to exit when closed
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            // Creating the title label using the labelBuilder and creates new tile layout
            JPanel titlePanel = new JPanel();
            JLabel titleLabel = new LabelBuilder("Category Menu").setHorizontalAlignment(javax.swing.SwingConstants.CENTER)
                    .setFontSize(24).build();
            titlePanel.setBackground(new java.awt.Color(102, 102, 255));
            new TitleLayoutBuilder(titleLabel, titlePanel).build();

            // creates the submit button and sets its action listener that creates new category.
            JButton submitButton = new ButtonBuilder("Submit").build();
            submitButton.addActionListener(event -> submitCategory());

            // creates the delete button and sets its action listener that deletes existing category.
            JButton deleteCategoryButton = new ButtonBuilder("Delete").setDefaultCapable(false).build();
            deleteCategoryButton.addActionListener(event -> deleteCategory());

            // initializing the add category text filed, and creates the add category text filed label.
            addCategoryTextField = new javax.swing.JTextField();
            JLabel addCategoryTextFieldLabel = new LabelBuilder("Add New Categorie :").build();

            // creates separator and scroll panel.
            JSeparator separator = new JSeparator();
            JScrollPane scrollPanel = new JScrollPane();

            // initializing the categories table with default value of four empty rows.
            categoriesTable = new javax.swing.JTable();
            categoriesTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                            {null, null},
                            {null, null},
                            {null, null},
                            {null, null}
                    },

                    // the columns headers
                    new String[]{
                            "Category Id", "Category Name"
                    }
            ) {
                // return the state of the given column index edit mode, always false (not editable).
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            });

            // attaches the scroll panel to the viewport
            scrollPanel.setViewportView(categoriesTable);

            // creating and setting the main layout of the view
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
                                    .addComponent(addCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        /**
         * Creates a new category if its name is valid.
         * After the creation, sets the add category text filed to empty string.
         * Shows a feedback to the user if created the category successfully or failed.
         */
        private void submitCategory() {
            try {
                viewModel.insertCategory(new Category(addCategoryTextField.getText().trim()));
                addCategoryTextField.setText("");
            } catch (CostManagerException exception) {
                showMessage(exception.getMessage());
            }
        }

        /**
         * Deletes an existing category.
         * Shows a feedback to the user if created the category successfully or failed.
         */
        private void deleteCategory() {
            int row = categoriesTable.getSelectedRow();
            // Check if user selected a category row
            if (row >= 0) {
                // extracting the row value and checks that its identifier is defined before deleting
                Object categoryIdentifier = categoriesTable.getModel().getValueAt(row, 0);
                if (categoryIdentifier != null) {
                    int categoryId = Integer.parseInt(categoryIdentifier.toString());
                    viewModel.deleteCategory(categoryId);
                } else {
                    showMessage("Can not delete empty row");
                }
            } else {
                showMessage("Please select category to delete");
            }
        }

        /**
         * Shows the recived categories in the view table.
         * Parse the category class to a object that can be displayed on the table.
         *
         * @param categories the categories to be displayed on the table.
         */
        public void showCategories(ArrayList<Category> categories) {
            Object[] data = new Object[2];
            DefaultTableModel tabModel = (DefaultTableModel) categoriesTable.getModel();
            // clears the table
            tabModel.getDataVector().removeAllElements();
            // parsing the categories to the accepted format of the table.
            for (Category category : categories) {
                data[0] = category.getId();
                data[1] = category.getCategoryName();
                tabModel.addRow(data);
            }

            // sets the parsed data to the table.
            categoriesTable.setModel(tabModel);
        }
    }
}
