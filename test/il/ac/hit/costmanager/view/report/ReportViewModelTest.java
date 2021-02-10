/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.report;

import org.junit.Test;

/**
 * Test for the ReportViewModelTest class.
 */
public class ReportViewModelTest {

    /**
     * Test of initializeView method.
     */
    @Test
    public void testInitializeView() {
        ReportViewModel viewModel = new ReportViewModel();
        viewModel.initializeView();
    }

    /**
     * Test of showCosts method.
     */
    @Test
    public void testShowCosts() {
        ReportViewModel viewModel = new ReportViewModel();
        viewModel.showCosts();
        viewModel.showCosts("1997-10-30", "1998-10-30");
    }
}