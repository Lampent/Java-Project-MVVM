/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.chart;

import org.junit.Test;

/**
 * Test for the ChartViewModelTest class.
 */
public class ChartViewModelTest {
    /**
     * Test of initializeView method.
     */
    @Test
    public void testInitializeView() {
        ChartViewModel viewModel = new ChartViewModel();
        viewModel.initializeView();
    }

    /**
     * Test of showCategoriesData method.
     */
    @Test
    public void testShowCategoriesData() {
        ChartViewModel viewModel = new ChartViewModel();
        viewModel.showCategoriesData();
    }

}