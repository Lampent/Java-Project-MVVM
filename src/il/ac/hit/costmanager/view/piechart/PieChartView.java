/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.view.piechart;

import il.ac.hit.costmanager.view.builders.TitleLayoutBuilder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Birbal
 */
public class PieChartView extends javax.swing.JFrame implements IPieChartView {


    private IPieChartViewModel viewModel;
    private PieChartUi pieChartUi;

    public PieChartView() {
        this.pieChartUi = new PieChartUi();
    }

    @Override
    public void setViewModel(IPieChartViewModel vm) {
        this.viewModel = vm;
    }

    public void showCategoriesData(HashMap<String, Double> categoryMap) {
        this.pieChartUi.createChart(categoryMap);
    }

    public class PieChartUi {
        private javax.swing.JPanel containerPanel;

        public PieChartUi() {
            initComponents();
        }

        private void initComponents() {

            javax.swing.JPanel titlePanel = new javax.swing.JPanel();
            javax.swing.JLabel titleLabel = new javax.swing.JLabel();
            containerPanel = new javax.swing.JPanel();


            titlePanel.setBackground(new java.awt.Color(102, 102, 255));
            titleLabel.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 24));
            titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            titleLabel.setText("Chart Menu");
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            javax.swing.GroupLayout titleLayout = new TitleLayoutBuilder(titleLabel, titlePanel).build();

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

        private void createChart(HashMap<String, Double> categoryMap) {

            final DefaultPieDataset chartDataset = new DefaultPieDataset();
            categoryMap.forEach(chartDataset::setValue);

            final JFreeChart chart = ChartFactory.createPieChart(
                    "Cost Pie Chart",
                    chartDataset,
                    true,
                    true,
                    true
            );

            final PiePlot chartPlot = (PiePlot) chart.getPlot();
            chartPlot.setNoDataMessage("No data available");

            chartPlot.setExplodePercent(categoryMap.keySet().stream().findFirst().get(), 0.20);
            Font font = new Font("Times New Roman", Font.PLAIN, 12);
            chartPlot.setLabelFont(font);

            categoryMap.keySet().forEach(categoryName -> {
                Random randomGenerator = new Random();
                Color randomColour = new Color(randomGenerator.nextInt(256), randomGenerator.nextInt(256), randomGenerator.nextInt(256));
                chartPlot.setSectionPaint(categoryName, randomColour);
            });

            chartPlot.setBackgroundPaint(Color.WHITE);
            chartPlot.setOutlinePaint(Color.WHITE);
            chartPlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}" + " " + "{2}"));

            chart.setBorderVisible(true);
            chart.setBorderPaint(new Color(145, 141, 62));
            chart.setBackgroundPaint(Color.WHITE);
            chart.getTitle().setHeight(25);
            chart.getTitle().setPaint(new Color(255, 255, 255));
            chart.getTitle().setExpandToFitSpace(true);
            chart.getTitle().setBackgroundPaint(new Color(45, 181, 209));
            chart.getTitle().setFont(new Font("Times New Roman", Font.BOLD, 22));

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(300, 220));

            containerPanel.setLayout(new BorderLayout());
            containerPanel.add(chartPanel, BorderLayout.CENTER); //BorderLayout.CENTER
            containerPanel.validate();
        }

    }
}
