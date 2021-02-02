/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CategoryItemsTest {

    public CategoryItemsTest() {
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
     * Test of getCategoryName method, of class AddCategoryModel.
     */
    /**
     * Test of setCategoryName method, of class Category.
     * @throws exeptions.CostManagerExeption
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
