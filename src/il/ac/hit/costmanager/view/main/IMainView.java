package il.ac.hit.costmanager.view.main;

import il.ac.hit.costmanager.model.IModel;
import il.ac.hit.costmanager.view.category.ICategoryViewModel;
import il.ac.hit.costmanager.view.cost.ICostViewModel;
import il.ac.hit.costmanager.view.chart.IChartViewModel;
import il.ac.hit.costmanager.view.report.IReportViewModel;

public interface IMainView {

    void setViewModel(IMainViewModel viewModel);

    void navigateChartMenu(IModel model, IChartViewModel viewModel);

    void navigateCostMenu(IModel model, ICostViewModel viewModel);

    void navigateCategoriesMenu(IModel model, ICategoryViewModel viewModel);

    void navigateReportMenu(IModel model, IReportViewModel viewModel);
}
