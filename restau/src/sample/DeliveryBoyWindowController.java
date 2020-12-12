package sample;

import DB.DBDelivery;
import DB.DBServiceReport;
import DB.DBUpdateServiceReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeliveryBoyWindowController {

    private Main main;
    @FXML
    private TableView<ServiceReport> tableView;
    @FXML
    private TableView<ServiceReport> pendingTableView;

    ObservableList<ServiceReport> data;
    ObservableList<ServiceReport> dataPending;

    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;
    private boolean init2 = true;

    private void initializeColumns()
    {
        TableColumn<ServiceReport, String> serviceNumberCol = new TableColumn<>("Service No");
        serviceNumberCol.setMinWidth(120);
        serviceNumberCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("service_number"));
//
//            TableColumn<ServiceReport, String> eventIdCol = new TableColumn<>("Event ID");
//            eventIdCol.setMinWidth(150);
//            eventIdCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("event_id"));

        TableColumn<ServiceReport, String> customerIdCol = new TableColumn<>("Customer ID");
        customerIdCol.setMinWidth(100);
        customerIdCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("customer_id"));

        TableColumn<ServiceReport, String> deliveryAddressCol = new TableColumn<>("Delivery Address");
        deliveryAddressCol.setMinWidth(200);
        deliveryAddressCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("delivery_address"));

//
//            TableColumn<ServiceReport, String> employeeIdCol = new TableColumn<>("Employee ID");
//            employeeIdCol.setMinWidth(130);
//            employeeIdCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("employee_id"));

//            TableColumn<ServiceReport, String> tableNoCol = new TableColumn<>("Table No.");
//            tableNoCol.setMinWidth(130);
//            tableNoCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("table_number"));

        TableColumn<ServiceReport, String> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(120);
        dateCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("date"));

        TableColumn<ServiceReport, String> timeCol = new TableColumn<>("Time");
        timeCol.setMinWidth(90);
        timeCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("time"));

//            TableColumn<ServiceReport, String> ratingCol = new TableColumn<>("Rating");
//            ratingCol.setMinWidth(150);
//            ratingCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("rating"));

//            TableColumn<ServiceReport, String> deliveryCol = new TableColumn<>("Delivery Status");
//            deliveryCol.setMinWidth(200);
//            deliveryCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("delivery_status"));

//            TableColumn<ServiceReport, String> paymentCol = new TableColumn<>("Payment Status");
//            paymentCol.setMinWidth(200);
//            paymentCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("payment_status"));


        tableView.getColumns().addAll(serviceNumberCol, customerIdCol, deliveryAddressCol, dateCol, timeCol);

    }

    public void load()
    {
        showInPendingWindow();
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new DBServiceReport().getAllServiceReports();

        for (List<String> row : userDataList)
        {
            if(row.get(8).equals("no"))
            {
                List<List<String>> deliveryDetails = new DBDelivery().getSpecificDelivery(row.get(0));
                ServiceReport u = new ServiceReport(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5)
                        , row.get(6), row.get(7), row.get(8), row.get(9), deliveryDetails.get(0).get(2));

//                u.setDelivery_address();
                data.add(u);
            }
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
            //if(Constants.userType.equals("delivery_boy"))
                main.showDeliveryBoyWindow();
//            else
//                main.showAdminWindow();
                //main.showAdminWindow(main.adminType);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void Reload(ActionEvent event){
        load();
    }
    @FXML
    void profileShow(ActionEvent event){
        try {
            main.showProfile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void HistoryAction(ActionEvent event)
    {
        try {
            main.showServiceHistory();
        } catch (Exception ex) {
            Logger.getLogger(WaiterWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void submitRequest(ActionEvent event)
    {
        try {
            List<String> editList = new ArrayList<>();
            editList.add(tableView.getSelectionModel().getSelectedItem().getService_number());
            //editList.add(tableView.getSelectionModel().getSelectedItem().getEvent_id());
            editList.add(tableView.getSelectionModel().getSelectedItem().getCustomer_id());
            editList.add(tableView.getSelectionModel().getSelectedItem().getEmployee_id());
            //editList.add(tableView.getSelectionModel().getSelectedItem().getTable_number());
            editList.add(tableView.getSelectionModel().getSelectedItem().getDate());
            editList.add(tableView.getSelectionModel().getSelectedItem().getTime());
            //editList.add(tableView.getSelectionModel().getSelectedItem().getRating());
            editList.add("pending");
            //editList.add(tableView.getSelectionModel().getSelectedItem().getPayment_status());
            boolean success = new DBUpdateServiceReport().updateSpecificReport(editList);
            AlertDialogShow(success);
            if (success) {
                load();
                //showInPendingWindow();
            }
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occurred");
            alert.setHeaderText("No Row Selected");
            alert.setContentText("Please Select a row and then press the button");
            alert.showAndWait();
        }

    }


    @FXML
    void deliveryComplete(ActionEvent event)
    {
        try {
            List<String> editList = new ArrayList<>();
            editList.add(pendingTableView.getSelectionModel().getSelectedItem().getService_number());
            //editList.add(pendingTableView.getSelectionModel().getSelectedItem().getEvent_id());
            editList.add(pendingTableView.getSelectionModel().getSelectedItem().getCustomer_id());
            editList.add(pendingTableView.getSelectionModel().getSelectedItem().getEmployee_id());
            //editList.add(pendingTableView.getSelectionModel().getSelectedItem().getTable_number());
            editList.add(pendingTableView.getSelectionModel().getSelectedItem().getDate());
            editList.add(pendingTableView.getSelectionModel().getSelectedItem().getTime());
            //editList.add(pendingTableView.getSelectionModel().getSelectedItem().getRating());
            editList.add("delivered");
            //editList.add(pendingTableView.getSelectionModel().getSelectedItem().getPayment_status());
            boolean success = new DBUpdateServiceReport().updateSpecificReport(editList);
            AlertDialogShow(success);
            if (success) {
                load();
                //showInPendingWindow();
            }
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occurred");
            alert.setHeaderText("No Row Selected");
            alert.setContentText("Please Select a row and then press the button");
            alert.showAndWait();
        }

    }


    public void setMain(Main main)
    {
        this.main = main;
    }

    void showInPendingWindow(){
        if (init2)
        {
            initializePendingColumns();
            init2 = false;
        }
        dataPending = FXCollections.observableArrayList();

        List<List<String>> userDataList = new DBServiceReport().getAllServiceReports();
        for (List<String> row : userDataList)
        {
            if(row.get(8).equals("pending") && row.get(3).equals(Constants.ID))
            {
                List<List<String>> deliveryDetails = new DBDelivery().getSpecificDelivery(row.get(0));
                ServiceReport u = new ServiceReport(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5)
                        , row.get(6), row.get(7), row.get(8), row.get(9), deliveryDetails.get(0).get(2));

                //u.setDelivery_address();
                dataPending.add(u);
            }
        }
        pendingTableView.setEditable(true);
        pendingTableView.setItems(dataPending);
    }


    private void initializePendingColumns()
    {
        TableColumn<ServiceReport, String> serviceNumberCol = new TableColumn<>("Service No");
        serviceNumberCol.setMinWidth(120);
        serviceNumberCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("service_number"));

//        TableColumn<ServiceReport, String> eventIdCol = new TableColumn<>("Event ID");
//        eventIdCol.setMinWidth(150);
//        eventIdCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("event_id"));

        TableColumn<ServiceReport, String> customerIdCol = new TableColumn<>("Customer ID");
        customerIdCol.setMinWidth(100);
        customerIdCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("customer_id"));

        TableColumn<ServiceReport, String> deliveryAddressCol = new TableColumn<>("Delivery Address");
        deliveryAddressCol.setMinWidth(200);
        deliveryAddressCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("delivery_address"));

//        TableColumn<ServiceReport, String> employeeIdCol = new TableColumn<>("Employee ID");
//        employeeIdCol.setMinWidth(130);
//        employeeIdCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("employee_id"));

//        TableColumn<ServiceReport, String> tableNoCol = new TableColumn<>("Table No.");
//        tableNoCol.setMinWidth(130);
//        tableNoCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("table_number"));

        TableColumn<ServiceReport, String> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(120);
        dateCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("date"));

        TableColumn<ServiceReport, String> timeCol = new TableColumn<>("Time");
        timeCol.setMinWidth(90);
        timeCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("time"));

//        TableColumn<ServiceReport, String> ratingCol = new TableColumn<>("Rating");
//        ratingCol.setMinWidth(150);
//        ratingCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("rating"));

//        TableColumn<ServiceReport, String> deliveryCol = new TableColumn<>("Delivery Status");
//        deliveryCol.setMinWidth(200);
//        deliveryCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("delivery_status"));

//        TableColumn<ServiceReport, String> paymentCol = new TableColumn<>("Payment Status");
//        paymentCol.setMinWidth(200);
//        paymentCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("payment_status"));


        pendingTableView.getColumns().addAll(serviceNumberCol, customerIdCol, deliveryAddressCol, dateCol, timeCol);
    }


    void AlertDialogShow(boolean success)
    {
        if(success)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText("Update Notice.");
            alert.setContentText("Request accepted");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Notice");
            alert.setHeaderText("Request Already taken by someone");
            alert.setContentText("Sorry The delivery request is already taken by someone else");
            alert.showAndWait();
        }
    }

    @FXML
    void showDeliveryDetails(ActionEvent event){
        try {
            //if(tableView!=null)
            main.showDeliveryDetails(tableView.getSelectionModel().getSelectedItem().getService_number());
            //else
            //System.out.println("servNo: "+ tableView.getSelectionModel().getSelectedItem().getService_number());
        } catch (Exception e) {
            //e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occurred");
            alert.setHeaderText("No Row Selected");
            alert.setContentText("Please Select a row and then press the button");
            alert.showAndWait();

        }
    }
    @FXML
    void showDeliveryCompleteDetails(ActionEvent event){
        try {
            main.showDeliveryDetails(pendingTableView.getSelectionModel().getSelectedItem().getService_number());
            //System.out.println("servNo: "+ tableView.getSelectionModel().getSelectedItem().getService_number());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occurred");
            alert.setHeaderText("No Row Selected");
            alert.setContentText("Please Select a row and then press the button");
            alert.showAndWait();
            //e.printStackTrace();
        }
    }
}


