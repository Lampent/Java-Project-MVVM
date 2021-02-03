/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.model.cost;

import il.ac.hit.costmanager.exeptions.CostManagerException;

import java.util.ArrayList;

/**
 * @author ron
 */
public interface ICostDAO {

    void insertCost(Cost cost) throws CostManagerException;

    /**
     * @param catName
     * @return
     */
    double getTotalCost(String catName) throws CostManagerException;

    /**
     * @return
     */
    ArrayList<Cost> getCosts() throws CostManagerException;

    /**
     * @param startDate
     * @param endDate
     * @return
     */
    ArrayList<Cost> getCostDateRange(String startDate, String endDate) throws CostManagerException;
}
