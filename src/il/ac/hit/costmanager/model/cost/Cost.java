/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.model.cost;

import il.ac.hit.costmanager.exeptions.CostManagerException;


/**
 * @author Birbal
 */
public class Cost {

    private String category = "";
    private String date = "";
    private String desc = "";
    private double cost = 0;

    public Cost(String category, String date, String desc, double cost) throws CostManagerException {
        this.setCategory(category);
        this.setCost(cost);
        this.setDesc(desc);
        this.setDate(date);
    }

    /**
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     * @throws exeptions.CostManagerExeption
     */
    public void setCategory(String category) throws CostManagerException {
        if (category == null) {
            throw new CostManagerException("Category can not be null");
        } else if (category.length() == 0) {
            throw new CostManagerException("Category can not be empty");
        }
        this.category = category;
    }

    /**
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     * @throws exeptions.CostManagerExeption
     */
    public void setDate(String date) throws CostManagerException {
        if (date == null) {
            throw new CostManagerException("Date can not be null");
        }
        this.date = date;
    }

    /**
     * @return
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc
     * @throws exeptions.CostManagerExeption
     */
    public void setDesc(String desc) throws CostManagerException {
        if (desc == null) {
            throw new CostManagerException("Description can not be null");
        } else if (desc.length() == 0) {
            throw new CostManagerException("Description can not empty");
        }
        this.desc = desc;
    }

    /**
     * @return
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost
     * @throws exeptions.CostManagerExeption
     */
    public void setCost(double cost) throws CostManagerException {
        if (Double.isNaN(cost)) {
            throw new CostManagerException("Cost must be a number");
        } else if (cost <= 0) {
            throw new CostManagerException("Cost must be greater then 0");
        }
        this.cost = cost;
    }

}
