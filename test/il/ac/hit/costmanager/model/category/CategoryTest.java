/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.model.category;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test for the category class.
 */
public class CategoryTest {

    public CategoryTest() {
    }

    /**
     * Test invalid category creation.
     */
    @Test
    public void testInvalidCategoryCreation() {
        Category category = null;

        // tests that cannot create category with empty name
        try {
            category = new Category("", 100);
        } catch (CostManagerException e) {

        }
        assertNull(category);

        // tests that cannot create category with negative id
        try {
            category = new Category("", -200);
        } catch (CostManagerException e) {

        }
        assertNull(category);
    }

    /**
     * Test valid category creation.
     */
    @Test
    public void testValidCategoryCreation() throws CostManagerException {
        String categoryName = "Fee";
        int categoryId = 100;

        // tests first constructor
        Category firstCategory = new Category(categoryName);
        firstCategory.setCategoryName(categoryName);
        assertEquals(categoryName, firstCategory.getCategoryName());

        // tests second constructor
        Category secondCategory = new Category(categoryName, categoryId);
        secondCategory.setCategoryName(categoryName);
        secondCategory.setId(categoryId);
        assertEquals(categoryName, secondCategory.getCategoryName());
        assertEquals(categoryId, secondCategory.getId());
    }

    /**
     * Test of category name.
     */
    @Test
    public void testCategoryName() throws CostManagerException {
        String startCategoryName = "Start name";
        String categoryName = "End name";

        // checks the set of the category name in constructor
        Category category = new Category(startCategoryName);
        assertEquals(startCategoryName, category.getCategoryName());

        // checks the set of the category name over setter
        category.setCategoryName(categoryName);
        assertEquals(categoryName, category.getCategoryName());
    }

    /**
     * Test of category id.
     */
    @Test
    public void testCategoryId() throws CostManagerException {
        int startId = 100;
        int endId = 200;

        // checks the set of the category id in constructor
        Category category = new Category("test", startId);
        assertEquals(startId, category.getId());

        // checks the set of the category id over setter
        category.setId(endId);
        assertEquals(endId, category.getId());
    }
}
