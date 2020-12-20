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
public class AddCostModelIT {

    public AddCostModelIT() {
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
     * Test of getCategory method, of class AddCostModel.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        AddCostModel instance = new AddCostModel("Grocery", "01-Dec-2020", "Grocery Item's", 1);
        String expResult = "Grocery";
        String result = instance.getCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCategory method, of class AddCostModel.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "Grocery";
        AddCostModel instance = new AddCostModel("Grocery", "01-Dec-2020", "Grocery Item's", 1);
        instance.setCategory(category);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getDate method, of class AddCostModel.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        AddCostModel instance = new AddCostModel("Grocery", "01-Dec-2020", "Grocery Item's", 1);
        String expResult = "01-Dec-2020";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setDate method, of class AddCostModel.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "01-Dec-2020";
        AddCostModel instance = new AddCostModel("Grocery", "01-Dec-2020", "Grocery Item's", 1);
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDesc method, of class AddCostModel.
     */
    @Test
    public void testGetDesc() {
        System.out.println("getDesc");
        AddCostModel instance = new AddCostModel("Grocery", "01-Dec-2020", "Grocery Item's", 1);
        String expResult = "Grocery Item's";
        String result = instance.getDesc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setDesc method, of class AddCostModel.
     */
    @Test
    public void testSetDesc() {
        System.out.println("setDesc");
        String desc = "";
        AddCostModel instance = new AddCostModel("Grocery", "01-Dec-2020", "Grocery Item's", 1);
        instance.setDesc(desc);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCost method, of class AddCostModel.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        AddCostModel instance = new AddCostModel("Grocery", "01-Dec-2020", "Grocery Item's", 100.0);
        double expResult = 100.0;
        double result = instance.getCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCost method, of class AddCostModel.
     */
    @Test
    public void testSetCost() {
        System.out.println("setCost");
        double cost = 0.0;
        AddCostModel instance = new AddCostModel("Grocery", "01-Dec-2020", "Grocery Item's", 1);
        instance.setCost(cost);
        // TODO review the generated test code and remove the default call to fail.

    }

}
