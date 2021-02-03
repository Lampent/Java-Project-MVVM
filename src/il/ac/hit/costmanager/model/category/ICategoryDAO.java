/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.model.category;

import il.ac.hit.costmanager.exeptions.CostManagerException;

import java.util.ArrayList;

/**
 * @author ron
 */
public interface ICategoryDAO {

    /**
     */
    void insertCategory(Category category) throws CostManagerException;

    /**
     * @return
     */
    ArrayList<Category> getCategories() throws CostManagerException;

    /**
     * @param catId
     */
    void deleteCategory(int catId) throws CostManagerException;
}
