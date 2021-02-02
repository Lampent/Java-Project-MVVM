package il.ac.hit.costmanager.model;

import il.ac.hit.costmanager.exeptions.CostManagerException;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.model.category.CategoryDAO;
import il.ac.hit.costmanager.model.category.ICategoryDAO;
import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.model.cost.CostDAO;
import il.ac.hit.costmanager.model.cost.ICostDAO;

import java.util.ArrayList;

public class DerbyDBModel implements IModel {
    private ICategoryDAO categoryDAO = new CategoryDAO();
    private ICostDAO costDAO = new CostDAO();


    @Override
    public void InsertCategory(String catName) throws CostManagerException {
        categoryDAO.InsertCategory(catName);
    }

    @Override
    public ArrayList<Category> getCategories() throws CostManagerException {
        return categoryDAO.getCategories();
    }

    @Override
    public void deleteCategory(int catId) throws CostManagerException {
        categoryDAO.deleteCategory(catId);
    }

    @Override
    public void InsertCost(double cost, String date, String dec, String catName) throws CostManagerException {
        costDAO.InsertCost(cost, date, dec, catName);
    }

    @Override
    public double getTotalCost(String catName) throws CostManagerException {
        return costDAO.getTotalCost(catName);
    }

    @Override
    public ArrayList<Cost> getCosts() throws CostManagerException {
        return costDAO.getCosts();
    }

    @Override
    public ArrayList<Cost> getCostDateRange(String startDate, String endDate) throws CostManagerException {
        return costDAO.getCostDateRange(startDate, endDate);
    }
}
