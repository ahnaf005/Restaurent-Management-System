package sample;

import DB.DBMarketingReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MarketingReportTableController {
    private Main main;
    @FXML
    private TableView tableView;

    ObservableList<MarketingReport> data;

    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<MarketingReport, String> marketingNumberCol = new TableColumn<>("Marketing Number");
        marketingNumberCol.setMinWidth(200);
        marketingNumberCol.setCellValueFactory(new PropertyValueFactory<MarketingReport,String>("marketing_number"));

        TableColumn<MarketingReport, String> employeeIdCol = new TableColumn<>("Employee ID");
        employeeIdCol.setMinWidth(150);
        employeeIdCol.setCellValueFactory(new PropertyValueFactory<MarketingReport,String>("employee_id"));

        TableColumn<MarketingReport, String> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(120);
        dateCol.setCellValueFactory(new PropertyValueFactory<MarketingReport,String>("date"));

        TableColumn<MarketingReport, String> timeCol = new TableColumn<>("Time");
        timeCol.setMinWidth(150);
        timeCol.setCellValueFactory(new PropertyValueFactory<MarketingReport,String>("time"));

        tableView.getColumns().addAll(marketingNumberCol, employeeIdCol, dateCol, timeCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new DBMarketingReport().getAllMarketingReport();
        for (List<String> row : userDataList)
        {
            MarketingReport u = new MarketingReport(row.get(0), row.get(1), row.get(2), row.get(3));
            data.add(u);
        }
        tableView.setEditable(true);
        tableView.setItems(data);
    }

    @FXML
    void logoutFunc(ActionEvent event)
    {
        try
        {
            main.showLoginPage();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    @FXML
    void showHome(ActionEvent event)
    {
        try
        {
             if(Constants.userType.equals("manager"))
                main.showManagerWindow();
            else
                main.showAdminWindow();
                //main.showAdminWindow(main.adminType);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    @FXML
    void InsertMarketingReport(ActionEvent event)
    {
        try
        {
            //make customer insert or update window..
            //main.InsertFoodWindow();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setMain(Main main)
    {
        this.main = main;
    }
}
