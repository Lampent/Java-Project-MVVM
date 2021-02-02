package il.ac.hit.costmanager.model;

import il.ac.hit.costmanager.model.category.ICategoryDAO;
import il.ac.hit.costmanager.model.cost.ICostDAO;


// A simple form of Encapsulation for the DerbyDbModel
public interface IModel extends ICostDAO, ICategoryDAO {
}