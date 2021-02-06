
package il.ac.hit.costmanager.viewmodel;

import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.exeptions.CostManagerException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Birbal
 */
public class CategoryTest {

    public CategoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setCategoryName method, of class Category.
     */
    @Test
    public void testSetCategoryName() throws CostManagerException {
        System.out.println("setCategoryName");
        String categoryName = "Fee";
        Category instance = new Category("", 100);
        instance.setCategoryName(categoryName);
        assertEquals(categoryName, instance.getCategoryName());
    }

}
