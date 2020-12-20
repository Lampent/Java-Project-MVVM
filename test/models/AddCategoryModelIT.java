/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
public class AddCategoryModelIT {

    public AddCategoryModelIT() {
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
    @Test
    public void testGetCategoryName() {
        System.out.println("getCategoryName");
        AddCategoryModel instance = new AddCategoryModel("Fee");
        String expResult = "Fee";
        String result = instance.getCategoryName();
        assertEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCategoryName method, of class AddCategoryModel.
     */
    @Test
    public void testSetCategoryName() {
        System.out.println("setCategoryName");
        String categoryName = "Fee";
        AddCategoryModel instance = new AddCategoryModel("Fee");
        instance.setCategoryName(categoryName);
        // TODO review the generated test code and remove the default call to fail.
    }

}
