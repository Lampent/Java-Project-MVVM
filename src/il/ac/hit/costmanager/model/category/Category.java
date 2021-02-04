package il.ac.hit.costmanager.model.category;
import il.ac.hit.costmanager.exeptions.CostManagerException;

/**
 * Category represents a real life category of costs.
 * The category has id of type int, and a name of type string.
 * Each cost is classified by a category.
 *
 * Category can be created in two ways, in both of them a name is required.
 * It can be created with id, for example a category from the database that already posses id.
 * It can be created without id, for example when creating a new category, before inserting into the database
 */
public class Category {

    private String categoryName = "";
    private int id = -1;

    /**
     * Construct the category by name.
     * The constructor sets the name of the category through setter function, throwing exception if inputted name is invalid.
     * This constructor dose not require an identifier, its serves the implementation of setting identifier after the creation.
     * @param categoryName the category name.
     * @throws CostManagerException exception when category name is not valid.
     */
    public Category(String categoryName) throws CostManagerException {
        this.setCategoryName(categoryName);
    }

    /**
     * Construct the category by name and id.
     * The constructor sets the name and the id of the category through setter function, throwing exception if the parameters are invalid.
     * @param categoryName the category name.
     * @param id the category identifier.
     * @throws CostManagerException exception when category name or id is not valid.
     */
    public Category(String categoryName, int id) throws CostManagerException {
        this.setCategoryName(categoryName);
        this.setId(id);
    }

    /**
     * @return category identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the category identifier, if id is invalid, lower then 0, throws error.
     * @param id the identifier of the category.
     * @throws CostManagerException exception when id is invalid, meaning id lower then 0.
     */
    public void setId(int id) throws CostManagerException {
        if (id < 0) {
            throw new CostManagerException("Category id can not less then 0");
        }
        this.id = id;
    }

    /**
     * @return category name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the category name, if its null or empty throws error.
     * @param categoryName the category name.
     * @throws CostManagerException exception when category name is null or empty (length lower then 0).
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
