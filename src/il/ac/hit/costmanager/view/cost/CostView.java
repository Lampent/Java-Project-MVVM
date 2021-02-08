/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
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

/**
 * The view of the costs.
 * Allows comfort interface for the creation of a new cost.
 * The user can choose the category of the cost from a categories combobox and fill the needed details in text filed and text area.
 * The cost view will also provide feedback on the action of creating a new cost and fetching the required data for that;
 * for example, when opened if failed to get the categories from the model, it will inform the user.
 * <p>
 * The view implements the ICostView interface.
 */
public class CostView extends javax.swing.JFrame implements ICostView {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private ICostViewModel viewModel;
    private CostUI costUI;

    /**
     * The constructor of the cost view.
     * Initializing the cost view ui.
     */
    public CostView() {
        this.costUI = new CostUI();
    }

    /**
     * Sets the view model
     *
     * @param viewModel the cost view ViewModel.
     */
    @Override
    public void setViewModel(ICostViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Shows the categories names in the user interface.
     * Calls the costUI method to show the categories names.
     *
     * @param categories categories names to be shown.
     */
    @Override
    public void showCategories(ArrayList<Category> categories) {
        this.costUI.showCategories(categories);
    }

    /**
     * Shows a message to the user, mainly used to show feedback to the user on the different actions available to the user.
     * Calls the costUI method to show the message.
     *
     * @param text text to be show to the user.
     */
    @Override
    public void showMessage(String text) {
        this.costUI.showMessage(text);
    }

    /**
     * The user interface of the view.
     * Communicating with the ViewModel for executing different operations on a separated thread.
     */
    public class CostUI {
        private javax.swing.JComboBox<String> categoriesComboBox;
        private datechooser.beans.DateChooserCombo dateChooserCombo;
        private javax.swing.JTextField costTextField;
        private javax.swing.JTextArea costTextArea;

        /**
         * The ui constructor.
         * Initializing the user interface.
         */
        public CostUI() {
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

            // creating title panel and title label using label builder
            JPanel titlePanel = new JPanel();
            titlePanel.setBackground(new java.awt.Color(102, 102, 255));
            JLabel titleLabel = new LabelBuilder("Cost Menu").setHorizontalAlignment(javax.swing.SwingConstants.CENTER)
                    .setFontSize(24).build();

            // creating the title layout using the title layout builder
            new TitleLayoutBuilder(titleLabel, titlePanel).build();

            // initializing the category combobox and creating its label
            categoriesComboBox = new javax.swing.JComboBox<>();
            categoriesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
            JLabel comboBoxLabel = new LabelBuilder("Select Cost Categories :").build();

            // initializing the cost text field and creating its label
            costTextField = new javax.swing.JTextField();
            JLabel costTextFieldLabel = new LabelBuilder("Enter Cost :").build();

            // creating the submit button that creates a new entered cost
            JButton btnSubmit = new ButtonBuilder("Submit").build();
            btnSubmit.addActionListener(event -> submitCost());

            // initializing the date chooser combobox and creating its label
            JLabel selectDateLabel = new LabelBuilder("Select Date :").build();
            dateChooserCombo = new datechooser.beans.DateChooserCombo();

            // creating the cost text area label, and initializing it
            JLabel costTextAreaLabel = new LabelBuilder("Enter Cost Description :").build();
            JScrollPane costTextAreaScrollPane = new JScrollPane();
            costTextArea = new javax.swing.JTextArea();
            costTextArea.setColumns(20);
            costTextArea.setRows(5);
            costTextAreaScrollPane.setViewportView(costTextArea);


            // creating and setting the main layout of the view
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
                                                            .addComponent(dateChooserCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                                            .addComponent(dateChooserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        /**
         * Shows the categories names received in the category combobox.
         * When a user creates a cost he needs to select its category from the category combobox.
         *
         * @param categories categories names to be shown.
         */
        private void showCategories(ArrayList<Category> categories) {
            dateChooserCombo.setDateFormat(dateFormat);
            categoriesComboBox.removeAllItems();
            for (Category category : categories) {
                categoriesComboBox.addItem(category.getCategoryName());
            }
        }

        /**
         * Submits the new cost.
         * It gatherers the details needed for the creation of the new cost.
         * It takes the new cost category from the category combobox, the description from the cost text area,
         * and the cost from the cost text filed.
         * If one of the details are invalid it displays a feedback to the user.
         * <p>
         * After all of the details from the ui are check to be valid, it sent the cost to the viewModel.
         * Thus inserting the new cost to the model on a different thread.
         */
        private void submitCost() {
            String selectedCategory = categoriesComboBox.getSelectedItem() != null ? categoriesComboBox.getSelectedItem().toString() : "";
            if (costTextField.getText().trim().length() > 0) {
                try {
                    double cost = Double.parseDouble(costTextField.getText().trim());
                    Cost costItem = new Cost(selectedCategory, dateFormat.format(dateChooserCombo.getSelectedDate().getTime()) + "", costTextArea.getText().trim(), cost);
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
