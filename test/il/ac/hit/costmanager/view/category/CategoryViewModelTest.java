/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 *
 */
package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.category.Category;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Test for the CategoryViewModelTest class.
 */
public class CategoryViewModelTest {

    /**
     * Test of initializeView method.
     */
    @Test
    public void testInitializeView() {
        CategoryViewModel viewModel = new CategoryViewModel();
        viewModel.initializeView();
    }


    /**
     * Test of showCategories method.
     */
    @Test
    public void testShowCategories() {
        CategoryViewModel viewModel = new CategoryViewModel();
        viewModel.showCategories();
    }

    /**
     * Test of insertCategory method.
     */
    @Test
    public void testAddCategory() {
        try {
            CategoryViewModel viewModel = new CategoryViewModel();
            Category testCategory = new Category("test", 100);
            viewModel.insertCategory(testCategory);
        } catch (CostManagerException ex) {
            fail(ex.getMessage());
        }
    }
}