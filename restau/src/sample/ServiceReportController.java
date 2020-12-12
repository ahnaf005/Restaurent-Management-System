package sample;

import DB.DBServiceReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ServiceReportController {
    private Main main;
    @FXML
    private TableView tableView;

    ObservableList<ServiceReport> data;

    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<ServiceReport, String> serviceNumberCol = new TableColumn<>("Serv. No");
        serviceNumberCol.setMinWidth(120);
        serviceNumberCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("service_number"));

        TableColumn<ServiceReport, String> eventIdCol = new TableColumn<>("Event ID");
        eventIdCol.setMinWidth(150);
        eventIdCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("event_id"));

        TableColumn<ServiceReport, String> customerIdCol = new TableColumn<>("Customer ID");
        customerIdCol.setMinWidth(100);
        customerIdCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("customer_id"));

        TableColumn<ServiceReport, String> employeeIdCol = new TableColumn<>("Employee ID");
        employeeIdCol.setMinWidth(130);
        employeeIdCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("employee_id"));

        TableColumn<ServiceReport, String> tableNoCol = new TableColumn<>("Table No.");
        tableNoCol.setMinWidth(130);
        tableNoCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("table_number"));

        TableColumn<ServiceReport, String> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(120);
        dateCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("date"));

        TableColumn<ServiceReport, String> timeCol = new TableColumn<>("Time");
        timeCol.setMinWidth(150);
        timeCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("time"));

        TableColumn<ServiceReport, String> ratingCol = new TableColumn<>("Rating");
        ratingCol.setMinWidth(150);
        ratingCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("rating"));

        TableColumn<ServiceReport, String> deliveryCol = new TableColumn<>("Delivery Status");
        deliveryCol.setMinWidth(200);
        deliveryCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("delivery_status"));

        TableColumn<ServiceReport, String> paymentCol = new TableColumn<>("Payment Status");
        paymentCol.setMinWidth(200);
        paymentCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("payment_status"));


        tableView.getColumns().addAll(serviceNumberCol, eventIdCol, customerIdCol, employeeIdCol, tableNoCol, dateCol,
                timeCol, ratingCol, deliveryCol, paymentCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new DBServiceReport().getAllServiceReports();
        for (List<String> row : userDataList)
        {
            ServiceReport u = new ServiceReport(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5)
                    , row.get(6), row.get(7), row.get(8), row.get(9),null);
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
    void InsertServiceReport(ActionEvent event)
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
