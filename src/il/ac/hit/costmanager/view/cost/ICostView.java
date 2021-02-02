package il.ac.hit.costmanager.view.cost;

import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.view.IView;

import java.util.ArrayList;

public interface ICostView extends IView {

    public void setCostData(ArrayList<Category> catModel);

}
