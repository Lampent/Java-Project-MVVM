package il.ac.hit.costmanager.view.chart;

import il.ac.hit.costmanager.view.builders.LabelBuilder;
import il.ac.hit.costmanager.view.builders.TitleLayoutBuilder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

/**
 * The view of the chart.
 * Displays all the categories of the application with their total cost of costs in a chart.
 * Allows comfort view of all the categories of the application with their total cost of costs.
 * <p>
 * The view implements the IChartView interface.
 */
public class ChartView extends javax.swing.JFrame implements IChartView {


    private ChartUi chartUi;

    /**
     * The constructor of the chart view.
     * Initializing the chart view ui.
     */
    public ChartView() {
        this.chartUi = new ChartUi();
    }

    /**
     * Shows categories with their total cost of costs in the user interface chart.
     * Calls the chartUI method to show the categories with their total cost of costs.
     *
     * @param categoryMap a map, key represent the category name and the value represents the total cost of its costs.
     */
    @Override
    public void showCategoriesData(HashMap<String, Double> categoryMap) {
        this.chartUi.createChart(categoryMap);
    }

    /**
     * Shows a message to the user, mainly used to show feedback of showing the chart data in the chart.
     * Calls the chartUI method to show the message.
     *
     * @param text text to be show to the user.
     */
    @Override
    public void showMessage(String text) {
        chartUi.showMessage(text);
    }

    /**
     * The user interface of the view.
     * Currently there are no actions to be preformed from the view, therefore it dose not communicate with a ViewModel.
     */
    public class ChartUi {
        private javax.swing.JPanel containerPanel;

        /**
         * The ui constructor.
         * Initializing the user interface.
         */
        public ChartUi() {
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
         * Makes use of different builders such as the LabelBuilder, TitleBuilder and TittleLayoutBuilder to save lines of code.
         */
        private void initComponents() {
            // sets the close operation to exit when closed
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


            // creating title panel and title label using label builder
            javax.swing.JPanel titlePanel = new javax.swing.JPanel();
            javax.swing.JLabel titleLabel = new LabelBuilder("Chart Menu").setHorizontalAlignment(javax.swing.SwingConstants.CENTER)
                    .setFontSize(24).build();
            titlePanel.setBackground(new java.awt.Color(102, 102, 255));

            // creating the title layout using the title layout builder
            new TitleLayoutBuilder(titleLabel, titlePanel).build();

            // creating the container panel for the chart
            containerPanel = new javax.swing.JPanel();
            javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
            containerPanel.setLayout(containerPanelLayout);
            containerPanelLayout.setHorizontalGroup(
                    containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 0, Short.MAX_VALUE)
            );
            containerPanelLayout.setVerticalGroup(
                    containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 281, Short.MAX_VALUE)
            );

            // creating the layou of the container panel and the title panel
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            pack();
        }

        /**
         * Creates the chart itself.
         * The method receives a map where each entry in it consists from key - category name and value - the total cost of the category costs.
         * The map made of all the categories exists in the model.
         * It then parse this data to be displayed in the chart, each category receives a random color.
         *
         * @param categoryMap a map where each entry in it consists from key - category name and value - the total cost of the category costs
         */
        private void createChart(HashMap<String, Double> categoryMap) {

            // initializing the chart dataset, a collection of all the categories with their total cost of costs
            final DefaultPieDataset chartDataset = new DefaultPieDataset();
            categoryMap.forEach(chartDataset::setValue);

            // creating new JFreeChart of the dataset
            final JFreeChart chart = ChartFactory.createPieChart(
                    "Cost Pie Chart",
                    chartDataset,
                    true,
                    true,
                    true
            );

            // setting noDataMessage in case there is no data available for display.
            final PiePlot chartPlot = (PiePlot) chart.getPlot();
            chartPlot.setNoDataMessage("No data available");

            // sets an explode visual effect on the first category in the map.
            chartPlot.setExplodePercent(categoryMap.keySet().stream().findFirst().get(), 0.20);

            // sets the pie chart font
            chartPlot.setLabelFont(new Font("Times New Roman", Font.PLAIN, 12));

            // providing each category in the chart a random color.
            categoryMap.keySet().forEach(categoryName -> {
                Random randomGenerator = new Random();
                Color randomColour = new Color(randomGenerator.nextInt(256), randomGenerator.nextInt(256), randomGenerator.nextInt(256));
                chartPlot.setSectionPaint(categoryName, randomColour);
            });

            // sets the chart plot background, outline and the method for displaying the lable.
            chartPlot.setBackgroundPaint(Color.WHITE);
            chartPlot.setOutlinePaint(Color.WHITE);
            chartPlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}" + " " + "{2}"));

            // sets charts parameters
            chart.setBorderVisible(true);
            chart.setBorderPaint(new Color(145, 141, 62));
            chart.setBackgroundPaint(Color.WHITE);
            chart.getTitle().setHeight(25);
            chart.getTitle().setPaint(new Color(255, 255, 255));
            chart.getTitle().setExpandToFitSpace(true);
            chart.getTitle().setBackgroundPaint(new Color(45, 181, 209));
            chart.getTitle().setFont(new Font("Times New Roman", Font.BOLD, 22));

            // creating new panel for the created chart
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(300, 220));

            // sets the new chart panel in the container panel
            containerPanel.setLayout(new BorderLayout());
            containerPanel.add(chartPanel, BorderLayout.CENTER);
            containerPanel.validate();
        }

    }
}
