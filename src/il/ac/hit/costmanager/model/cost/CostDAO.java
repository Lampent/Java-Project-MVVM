package il.ac.hit.costmanager.model.cost;

import il.ac.hit.costmanager.database.DBAdapter;
import il.ac.hit.costmanager.exeptions.CostManagerException;

import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author ron
 */
public class CostDAO implements ICostDAO {


    /**
     * @param cost
     * @param date
     * @param dec
     * @param catName
     */
    @Override
    public void InsertCost(double cost, String date, String dec, String catName) throws CostManagerException {
        try {
            int costId = 0;
            String query = "Select * from APP.Cost";
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                costId = (res.getInt("costId"));
            }
            costId = costId + 1;
            String sql = "INSERT INTO APP.Cost (costId,catName,cost,date,description) "
                    + "VALUES (" + costId + ",'" + catName + "'," + cost + ",'" + date + "','" + dec + "')";
            DBAdapter.executeUpdate(sql);
        } catch (Exception e) {
            throw new CostManagerException("Failed to insert cost to DB");
        }
    }


    /**
     * @param catName
     * @return catTotal
     */
    @Override
    public double getTotalCost(String catName) throws CostManagerException {
        double catTotal = 0;
        try {
            String query = "SELECT * FROM App.Cost WHERE catName='" + catName + "'";
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                catTotal = catTotal + (res.getDouble("cost"));
            }
        } catch (Exception e) {
            throw new CostManagerException("Failed to get the total cost of category from DB");
        }
        return catTotal;
    }


    /**
     * @return ArrayList<CostItems>
     * @throws il.ac.hit.costmanager.exeptions.CostManagerException
     */
    @Override
    public ArrayList<Cost> getCosts() throws CostManagerException {
        ArrayList<Cost> costs = new ArrayList<>();
        try {
            String query = "SELECT * FROM App.Cost";
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                Cost ad = new Cost(res.getString("catName"), res.getString("date"), res.getString("description"), res.getDouble("cost"));
                costs.add(ad);
            }
        } catch (Exception ex) {
            throw new CostManagerException("Failed to get costs from DB");
        }
        return costs;
    }

    /**
     * @param startDate
     * @param endDate
     * @return ArrayList<CostItems>
     */
    @Override
    public ArrayList<Cost> getCostDateRange(String startDate, String endDate) throws CostManagerException {
        ArrayList<Cost> costs = new ArrayList<>();
        try {
            String query = "SELECT * FROM App.Cost WHERE date BETWEEN '" + startDate + "' and '" + endDate + "'";
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                Cost ad = new Cost(res.getString("catName"), res.getString("date"), res.getString("description"), res.getDouble("cost"));
                costs.add(ad);
            }
        } catch (Exception e) {
            throw new CostManagerException("Failed to get costs by date range from DB");
        }
        return costs;
    }
}
