/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.chart;

import org.junit.Test;

import java.util.HashMap;


/**
 * Test for the ChartViewTest class.
 */
public class ChartViewTest {

    /**
     * Test of showCategoriesData method.
     */
    @Test
    public void testShowCategoriesData() {
        ChartView chartView = new ChartView();
        chartView.showCategoriesData(new HashMap<>());
    }

}