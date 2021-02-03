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
    public void insertCategory(Category category) throws CostManagerException {
        categoryDAO.insertCategory(category);
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
    public void insertCost(Cost cost) throws CostManagerException {
        costDAO.insertCost(cost);
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
