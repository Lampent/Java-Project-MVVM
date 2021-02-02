/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.viewmodel;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.view.IView;
import il.ac.hit.costmanager.view.category.CategoryView;
import il.ac.hit.costmanager.view.cost.CostView;
import il.ac.hit.costmanager.view.main.MainView;
import il.ac.hit.costmanager.view.piechart.PieChartView;
import il.ac.hit.costmanager.view.reports.ReportsView;

import java.util.ArrayList;

/**
 *
 * @author ron
 */
public interface IViewModel {

    public void setView(CategoryView view);

    public void setView(CostView view);

    public void setView(MainView view);

    public void setView(PieChartView view);

    public void setView(ReportsView view);

    public void setModel(IModel model);

    public ArrayList<Category> getCategories();
    
    public void insertCategory(String categoryName);
    
    public void deleteCategory(int id);
    
    public void InsertCost(double cost, String date, String dec, String catName);
    
    public double getTotalCost(String catName);
    
    public ArrayList<Cost> getCosts();
    
    public ArrayList<Cost> getCostDateRange(String startDate, String endDate);
}
