/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.model.category;

import il.ac.hit.costmanager.database.DBAdapter;
import il.ac.hit.costmanager.exeptions.CostManagerException;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author ron
 */
public class CategoryDAO implements ICategoryDAO {

    /**
     * @param category
     */
    @Override
    public void insertCategory(Category category) throws CostManagerException {
        try {
            int catId = 0;
            String query = "Select * from APP.Category";
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                catId = (res.getInt("catId"));
            }
            category.setCatId(catId + 1);
            String sql = "INSERT INTO APP.Category (catId,catName) "
                    + "VALUES (" + category.getCatId() + ",'" + category.getCategoryName() + "')";
            DBAdapter.executeUpdate(sql);

        } catch (Exception e) {
            throw new CostManagerException("Failed to insert category to DB");
        }
    }

    /**
     * @return ArrayList<CategoryItems>
     */
    @Override
    public ArrayList<Category> getCategories() throws CostManagerException {
        ArrayList<Category> catModel = new ArrayList<>();
        try {
            String query = "SELECT * FROM App.Category";
            ResultSet res = DBAdapter.executeQuery(query);
            while (res.next()) {
                Category ad = new Category(res.getString("catName"), res.getInt("catId"));
                catModel.add(ad);
            }
        } catch (Exception e) {
            throw new CostManagerException("Failed to get categories from DB");
        }
        return catModel;
    }

    /**
     * @param catId
     */
    @Override
    public void deleteCategory(int catId) throws CostManagerException {
        try {
            String query = "DELETE FROM APP.Category WHERE catId=" + catId + "";
            DBAdapter.executeUpdate(query);
        } catch (Exception e) {
            throw new CostManagerException("Failed to delete category from DB");
        }
    }
}
