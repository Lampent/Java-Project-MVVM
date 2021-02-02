/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.viewmodel;

import il.ac.hit.costmanager.model.cost.Cost;
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
public class CostItemsTest {

    public CostItemsTest() {
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
     * Test of getCategory method, of class Cost.
     */
    @Test
    public void testGetCategory() throws CostManagerException {
        System.out.println("getCategory");
        Cost instance = new Cost("Grocery", "", "", 0);
        String result = instance.getCategory();
        assertEquals(result, "Grocery");
    }

    /**
     * Test of setCategory method, of class Cost.
     * @throws exeptions.CostManagerExeption
     */
    @Test
    public void testSetCategory() throws CostManagerException {
        System.out.println("setCategory");
        String category = "Grocery";
        Cost instance = new Cost("", "", "", 0);
        instance.setCategory(category);
        assertEquals(category, instance.getCategory());
    }

    /**
     * Test of getDate method, of class Cost.
     */
    @Test
    public void testGetDate() throws CostManagerException {
        System.out.println("getDate");
        Cost instance = new Cost("", "01-Dec-2020", "", 0);
        String result = instance.getDate();
        assertEquals(result, "01-Dec-2020");
    }

    /**
     * Test of setDate method, of class Cost.
     * @throws exeptions.CostManagerExeption
     */
    @Test
    public void testSetDate() throws CostManagerException {
        System.out.println("setDate");
        Cost instance = new Cost("", "", "", 0);
        instance.setDate("01-Dec-2020");
        assertEquals(instance.getDate(), "01-Dec-2020");
    }

    /**
     * Test of getDesc method, of class Cost.
     */
    @Test
    public void testGetDesc() throws CostManagerException {
        System.out.println("getDescription");
        Cost instance = new Cost("", "", "Description test", 0);
        assertEquals(instance.getDesc(), "Description test");
    }

    /**
     * Test of setDesc method, of class Cost.
     * @throws exeptions.CostManagerExeption
     */
    @Test
    public void testSetDesc() throws CostManagerException {
        System.out.println("setDescription");
        Cost instance = new Cost("", "", "", 0);
        instance.setDesc("Description test");
        assertEquals(instance.getDesc(), "Description test");

    }

    /**
     * Test of getCost method, of class Cost.
     */
    @Test
    public void testGetCost() throws CostManagerException {
        System.out.println("getCost");
        Cost instance = new Cost("", "", "", 100);
        assertEquals(100.0, instance.getCost(), 0);
    }

    /**
     * Test of setCost method, of class Cost.
     * @throws exeptions.CostManagerExeption
     */
    @Test
    public void testSetCost() throws CostManagerException {
        System.out.println("setCost");
        Cost instance = new Cost("", "", "", 0);
        instance.setCost(100);
        assertEquals(100.0, instance.getCost(), 0);
    }

}
