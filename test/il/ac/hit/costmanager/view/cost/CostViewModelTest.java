/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.exceptions.CostManagerException;
import il.ac.hit.costmanager.model.cost.Cost;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Test for the CostViewModelTest class.
 */
public class CostViewModelTest {

    /**
     * Test of initializeView method.
     */
    @Test
    public void testInitializeView() {
        CostViewModel viewModel = new CostViewModel();
        viewModel.initializeView();
    }

    /**
     * Test of showCategories method.
     */
    @Test
    public void testShowCategories() {
        CostViewModel categoryView = new CostViewModel();
        categoryView.showCategories();
    }

    /**
     * Test of insertCost method.
     */
    @Test
    public void testInsertCost() {
        try {
            CostViewModel viewModel = new CostViewModel();
            Cost cost = new Cost("test", "1997-10-30", "Test description", 100);
            viewModel.insertCost(cost);
        } catch (CostManagerException ex) {
            fail(ex.getMessage());
        }
    }
}