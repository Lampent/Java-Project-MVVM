/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.model.category;

import il.ac.hit.costmanager.exeptions.CostManagerException;


/**
 * @author Birbal
 */
public class Category {

    private String categoryName = "";
    private int catId = -1;


    public Category(String categoryName) throws CostManagerException {
        this.setCategoryName(categoryName);
    }

    public Category(String categoryName, int catId) throws CostManagerException {
        this.setCategoryName(categoryName);
        this.setCatId(catId);
    }

    /**
     * @return
     */
    public int getCatId() {
        return catId;
    }

    /**
     * @param catId
     */
    public void setCatId(int catId) throws CostManagerException {
        if (catId < 0) {
            throw new CostManagerException("Category id can not less then 0");
        }
        this.catId = catId;
    }

    /**
     * @return
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName
     */
    public void setCategoryName(String categoryName) throws CostManagerException {
        if (categoryName == null) {
            throw new CostManagerException("Category name can not be null");
        } else if (categoryName.length() == 0) {
            throw new CostManagerException("Category name can not be empty");
        }
        this.categoryName = categoryName;
    }

}
