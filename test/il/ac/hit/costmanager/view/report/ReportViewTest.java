/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.report;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Test for the ReportViewTest class.
 */
public class ReportViewTest {

    /**
     * Test of showCosts method.
     */
    @Test
    public void testShowCosts() {
        ReportView reportView = new ReportView();
        reportView.showCosts(new ArrayList<>());
    }

}