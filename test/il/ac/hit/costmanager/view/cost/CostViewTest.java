/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.cost;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Test for the CostViewTest class.
 */
public class CostViewTest {

    /**
     * Test of showCategories method.
     */
    @Test
    public void testShowCategories() {
        CostView categoryView = new CostView();
        categoryView.showCategories(new ArrayList<>());
    }

}