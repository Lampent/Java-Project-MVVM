package il.ac.hit.costmanager.view.category;

import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.view.IView;

import java.util.ArrayList;

public interface ICategoryView extends IView {

    public void setTableData(ArrayList<Category> catModel);

}
