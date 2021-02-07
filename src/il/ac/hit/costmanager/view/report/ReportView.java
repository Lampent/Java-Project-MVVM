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
 * The report view, display all the costs exists.
 * Displays all the costs of the application in a dedicated table.
 * Allows comfort view of all the costs of the application.
 * Allows to show all the costs created between two selected dates.
 * <p>
 * The view implements the IReportView interface.
 */
public class ReportView extends javax.swing.JFrame implements IReportView {
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private IReportViewModel viewModel;
    private ReportUI reportUI;

    /**
     * The constructor of the report view.
     * Initializing the report view ui.
     */
    public ReportView() {
        this.reportUI = new ReportUI();
    }

    /**
     * Sets the view model
     *
     * @param viewModel the report view ViewModel.
     */
    @Override
    public void setViewModel(IReportViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Shows costs in the user interface.
     * Calls the reportUI method to show the costs.
     * The main use cases of this method is to show all the costs of the application and show specific costs.
     *
     * @param costs costs to be shown.
     */
    @Override
    public void showCosts(ArrayList<Cost> costs) {
        this.reportUI.showCosts(costs);
    }

    /**
     * Shows a message to the user, mainly used to show feedback to the user on the different actions available to the user.
     * Calls the reportUI method to show the message.
     *
     * @param text text to be show to the user.
     */
    @Override
    public void showMessage(String text) {
        this.reportUI.showMessage(text);
    }

    /**
     * The user interface of the view.
     * Communicating with the ViewModel for executing different operations on a separated thread.
     */
    public class ReportUI {

        private datechooser.beans.DateChooserCombo dateStart;
        private datechooser.beans.DateChooserCombo dateEnd;
        private javax.swing.JTable costsTable;

        /**
         * The ui constructor.
         * Initializing the user interface.
         */
        public ReportUI() {
            initComponents();

            // sets the comboboxes date format
            dateStart.setDateFormat(dateFormat);
            dateEnd.setDateFormat(dateFormat);
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
         * Shows the received costs in the cost table.
         * The method first clears the costs table.
         * Afterwords, it parses the costs objects in to a format to be displayed in the costs table.
         *
         * @param costs costs to be shown.
         */
        public void showCosts(ArrayList<Cost> costs) {
            // gets the table model reference and clean the table from previous data
            DefaultTableModel tabModel = (DefaultTableModel) costsTable.getModel();
            tabModel.getDataVector().removeAllElements();

            // parsing the costs objects to the required format and add a new row to the table, one by one
            Object[] data = new Object[4];
            for (Cost cost : costs) {
                data[0] = cost.getCost();
                data[1] = cost.getDate();
                data[2] = cost.getDesc();
                data[3] = cost.getCategory();
                tabModel.addRow(data);
            }

            // sets the model again to the table
            costsTable.setModel(tabModel);
        }

        /**
         * Initializing the user interface.
         * Makes use of different builders such as the LabelBuilder, TitleBuilder and TittleBuilder to save lines of code.
         */
        private void initComponents() {
            // sets the close operation to exit when closed
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            // Creating the title label using the labelBuilder and creates new tile layout
            javax.swing.JPanel titlePanel = new javax.swing.JPanel();
            javax.swing.JLabel titleLabel = new LabelBuilder("Report Menu").setFontSize(24)
                    .setHorizontalAlignment(javax.swing.SwingConstants.CENTER).build();
            titlePanel.setBackground(new java.awt.Color(102, 102, 255));
            new TitleLayoutBuilder(titleLabel, titlePanel).build();

            // initializing the start date data chooser and creating its label
            dateStart = new datechooser.beans.DateChooserCombo();
            javax.swing.JLabel dateStartLabel = new LabelBuilder("From Data :").build();

            // initializing the end date data chooser and creating its label
            dateEnd = new datechooser.beans.DateChooserCombo();
            javax.swing.JLabel dateEndLabel = new LabelBuilder("To Data :").build();

            // creating the show button, that will show all the costs between the start date and the end date.
            javax.swing.JButton showButton = new ButtonBuilder("Show").build();
            showButton.addActionListener(event -> viewModel.showCosts(dateFormat.format(dateStart.getSelectedDate().getTime()),
                    dateFormat.format(dateEnd.getSelectedDate().getTime())));

            // initializing the cost table with default value of four empty rows.
            costsTable = new javax.swing.JTable();
            costsTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null}
                    },

                    // the columns headers
                    new String[]{
                            "Cost", "Date", "Description", "Category Name"
                    }
            ) {
                // return the state of the given column index edit mode, always false (not editable).
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            });

            // creating scroll panel and attaches it to the viewport
            javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane();
            scrollPane.setViewportView(costsTable);

            // creating separator for the view
            javax.swing.JSeparator separator = new javax.swing.JSeparator();

            // creating and setting the main layout of the view
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
