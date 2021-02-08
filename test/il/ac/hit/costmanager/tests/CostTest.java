/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.tests;

import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.exeptions.CostManagerException;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for the cost class.
 */
public class CostTest {

    public CostTest() {
    }

    /**
     * Test of getCategory method, of class Cost.
     */
    @Test
    public void testGetCategory() throws CostManagerException {
        String category = "Grocery";
        Cost cost = new Cost(category, "1997-10-30", "test description", 1);
        assertEquals(cost.getCategory(), category);
    }

    /**
     * Test of setCategory method, of class Cost.
     */
    @Test
    public void testSetCategory() throws CostManagerException {
        String category = "Grocery";
        Cost cost = new Cost("test category", "1997-10-30", "test description", 1);
        cost.setCategory(category);
        assertEquals(category, cost.getCategory());
    }

    /**
     * Test of getDate method, of class Cost.
     */
    @Test
    public void testGetDate() throws CostManagerException {
        String date = "30-10-2000";
        Cost cost = new Cost("test category", date, "test description", 1);
        assertEquals(cost.getDate(), date);
    }

    /**
     * Test of setDate method, of class Cost.
     */
    @Test
    public void testSetDate() throws CostManagerException {
        String date = "30-10-2000";
        Cost cost = new Cost("test category", "1997-10-30", "test description", 1);
        cost.setDate(date);
        assertEquals(cost.getDate(), date);
    }

    /**
     * Test of getDesc method, of class Cost.
     */
    @Test
    public void testGetDesc() throws CostManagerException {
        String description = "Description test";
        Cost cost = new Cost("test category", "1997-10-30", description,1);
        assertEquals(cost.getDesc(), description);
    }

    /**
     * Test of setDesc method, of class Cost.
     */
    @Test
    public void testSetDesc() throws CostManagerException {
        String description = "Description test";
        Cost cost = new Cost("test category", "1997-10-30", "test description", 1);
        cost.setDesc(description);
        assertEquals(cost.getDesc(), description);
    }

    /**
     * Test of getCost method, of class Cost.
     */
    @Test
    public void testGetCost() throws CostManagerException {
        double costTest = 100;
        Cost cost = new Cost("test category", "1997-10-30", "test description", costTest);
        assertEquals(costTest, cost.getCost(), 0);
    }

    /**
     * Test of setCost method, of class Cost.
     */
    @Test
    public void testSetCost() throws CostManagerException {
        double costTest = 100;
        Cost cost = new Cost("test category", "1997-10-30", "test description", 1);
        cost.setCost(costTest);
        assertEquals(costTest, cost.getCost(), 0);
    }

}
