package il.ac.hit.costmanager.model;

import il.ac.hit.costmanager.model.category.ICategoryDAO;
import il.ac.hit.costmanager.model.cost.ICostDAO;

/**
 * Interface of the application model.
 * Includes the functions of all the applications DAOs.
 */
public interface IModel extends ICostDAO, ICategoryDAO {
}