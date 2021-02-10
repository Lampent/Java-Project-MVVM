/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.main;

import org.junit.Test;

/**
 * Test for the MainViewTest class.
 */
public class MainViewTest {

    /**
     * Test of navigateChartMenu method.
     */
    @Test
    public void testNavigateChartMenu() {
        MainView mainView = new MainView();
        mainView.navigateChartMenu(null);
    }

    /**
     * Test of navigateCostMenu method.
     */
    @Test
    public void testNavigateCostMenu() {
        MainView mainView = new MainView();
        mainView.navigateCostMenu(null);
    }

    /**
     * Test of navigateCategoriesMenu method.
     */
    @Test
    public void testNavigateCategoriesMenu() {
        MainView mainView = new MainView();
        mainView.navigateCategoriesMenu(null);
    }

    /**
     * Test of navigateReportMenu method.
     */
    @Test
    public void testNavigateReportMenu() {
        MainView mainView = new MainView();
        mainView.navigateReportMenu(null);
    }
}