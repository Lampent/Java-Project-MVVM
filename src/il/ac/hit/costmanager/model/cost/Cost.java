/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.model.cost;

import il.ac.hit.costmanager.exceptions.CostManagerException;

/**
 * Cost represents a real life cost
 * The cost has category, date, desc and a cost
 * <p>
 * Each Cost most have all off the properties mentioned above.
 * It has one constrictor requiring all the properties.
 */
public class Cost {

    private String category = "";
    private String date = "";
    private String desc = "";
    private double cost = 0;

    /**
     * Constructs the cost.
     *
     * @param category the category of the cost.
     * @param date     the date the cost was created.
     * @param desc     the description of the cost.
     * @param cost     the cost itself represented as a double.
     * @throws CostManagerException exception thrown when one of the provided properties is not valid.
     */
    public Cost(String category, String date, String desc, double cost) throws CostManagerException {
        this.setCategory(category);
        this.setCost(cost);
        this.setDesc(desc);
        this.setDate(date);
    }

    /**
     * @return the category of the cost.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the cost.
     * If the category is null or it is an empty string then its not valid.
     *
     * @param category the received category to be set.
     * @throws CostManagerException exception thrown when the category is not valid.
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
     * @return the cost date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the category date of creation.
     * If the date equals null it is not valid.
     *
     * @param date the category data to be set.
     * @throws CostManagerException exception thrown when the category is not valid.
     */
    public void setDate(String date) throws CostManagerException {
        if (date == null) {
            throw new CostManagerException("Date can not be null");
        }
        this.date = date;
    }

    /**
     * @return the category description
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the cost description.
     * If the description equals null or empty it is not valid.
     *
     * @param desc the description to be set.
     * @throws CostManagerException exception thrown when the description is not valid.
     */
    public void setDesc(String desc) throws CostManagerException {
        if (desc == null) {
            throw new CostManagerException("Description can not be null");
        } else if (desc.length() == 0) {
            throw new CostManagerException("Description can not be empty");
        }
        this.desc = desc;
    }

    /**
     * @return the cost of the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost of the cost.
     * If the cost is not a number  or lower then 0, it is not valid.
     *
     * @param cost the cost to be set.
     * @throws CostManagerException exception thrown when the cost is not valid.
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
