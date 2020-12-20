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
public class ReportGenrateModelIT {

    public ReportGenrateModelIT() {
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
     * Test of getId method, of class ReportGenrateModel.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ReportGenrateModel instance = new ReportGenrateModel(1, "Grocery");
        int expResult = 0;
        instance.setId(expResult);
        int result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setId method, of class ReportGenrateModel.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        ReportGenrateModel instance = new ReportGenrateModel(1, "Grocery");
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCatName method, of class ReportGenrateModel.
     */
    @Test
    public void testGetCatName() {
        System.out.println("getCatName");
        ReportGenrateModel instance = new ReportGenrateModel(1, "Grocery");
        String expResult = "Grocery";
        String result = instance.getCatName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCatName method, of class ReportGenrateModel.
     */
    @Test
    public void testSetCatName() {
        System.out.println("setCatName");
        String catName = "";
        ReportGenrateModel instance = new ReportGenrateModel(1, "Grocery");
        instance.setCatName(catName);
        // TODO review the generated test code and remove the default call to fail.

    }

}
