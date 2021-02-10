/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */

package il.ac.hit.costmanager.view.category;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Test for the CategoryViewTest class.
 */
public class CategoryViewTest {


    /**
     * Test of showCategories method.
     */
    @Test
    public void showCategories() {
        CategoryView categoryView = new CategoryView();
        categoryView.showCategories(new ArrayList<>());
    }
}