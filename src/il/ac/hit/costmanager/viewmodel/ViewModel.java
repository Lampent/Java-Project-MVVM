/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.ac.hit.costmanager.viewmodel;

import java.util.ArrayList;

import il.ac.hit.costmanager.model.DerbyDBModel;
import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.model.category.Category;
import il.ac.hit.costmanager.model.cost.Cost;
import il.ac.hit.costmanager.exeptions.CostManagerException;

import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import il.ac.hit.costmanager.view.category.CategoryView;
import il.ac.hit.costmanager.view.cost.CostView;
import il.ac.hit.costmanager.view.main.MainView;
import il.ac.hit.costmanager.view.piechart.PieChartView;
import il.ac.hit.costmanager.view.reports.ReportsView;

/**
 *
 * @author ron
 */
public class ViewModel implements IViewModel {
    private IModel model;
    private CategoryView categoryView;
    private CostView costView;
    private MainView mainView;
    private PieChartView pieChartView;
    private ReportsView reportsView;
    private ExecutorService pool;

    public ViewModel() {
        this.model = new DerbyDBModel();
    }

    @Override
    public void setView(CategoryView view) {
        this.categoryView = view;
    }

    @Override
    public void setView(CostView view) {
        this.costView = view;
    }

    @Override
    public void setView(MainView view) {
        this.mainView = view;
    }

    @Override
    public void setView(PieChartView view) {
        this.pieChartView = view;
    }

    @Override
    public void setView(ReportsView view) {
        this.reportsView = view;
    }

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public ArrayList<Category> getCategories() {
        try {
            return this.model.getCategories();
        } catch (CostManagerException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    
    @Override
    public void insertCategory(String categoryName) {
        try {
            this.model.InsertCategory(categoryName);
        } catch (CostManagerException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void deleteCategory(int id) {
        try {
            this.model.deleteCategory(id);
        } catch (CostManagerException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void InsertCost(double cost, String date, String dec, String catName) {
        try {
            this.model.InsertCost(cost, date, dec, catName);
        } catch (CostManagerException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public double getTotalCost(String catName) {
        try {
            return this.model.getTotalCost(catName);
        } catch (CostManagerException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    @Override
    public ArrayList<Cost> getCosts() {
        try {
            return this.model.getCosts();
        } catch (CostManagerException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    
    @Override
    public ArrayList<Cost> getCostDateRange(String startDate, String endDate) {
        try {
            return this.model.getCostDateRange(startDate, endDate);
        } catch (CostManagerException ex) {
            Logger.getLogger(ViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
}
