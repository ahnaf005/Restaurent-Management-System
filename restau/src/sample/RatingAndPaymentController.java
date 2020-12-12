/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import DB.Customer;
import DB.DBServiceReport;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
public class RatingAndPaymentController implements Initializable {
    private Main main;
    @FXML
    private TableView<ServiceReport>tableView;

    ObservableList<ServiceReport> data;

    @FXML
    private Button details;
    @FXML
    private Button rate;
    @FXML
    private Button payment;
    @FXML
    private Button done;
    @FXML
    private TextField ratingfield;
    private boolean init = true;

    private void initializeColumns()
    {
        ratingfield.setVisible(false);
        done.setVisible(false);
        TableColumn<ServiceReport, String> serviceNumberCol = new TableColumn<>("Serv. No");
        serviceNumberCol.setMinWidth(120);
        serviceNumberCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("service_number"));

        TableColumn<ServiceReport, String> eventIdCol = new TableColumn<>("Event ID");
        eventIdCol.setMinWidth(150);
        eventIdCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("event_id"));

//        TableColumn<ServiceReport, String> customerIdCol = new TableColumn<>("Customer ID");
//        customerIdCol.setMinWidth(100);
//        customerIdCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("customer_id"));

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

         TableColumn<ServiceReport, String> deliveraddressCol = new TableColumn<>("Delivery Address");
        deliveraddressCol.setMinWidth(200);
        deliveraddressCol.setCellValueFactory(new PropertyValueFactory<ServiceReport,String>("delivery_address"));
        tableView.getColumns().addAll(serviceNumberCol, eventIdCol,employeeIdCol, tableNoCol, dateCol,
                timeCol, ratingCol, deliveryCol, paymentCol,deliveraddressCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new Customer().getAllCustomerServiceReports(Constants.ID);
        for (List<String> row : userDataList)
        {
            ServiceReport u = new ServiceReport(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5)
                    , row.get(6), row.get(7), row.get(8), row.get(9),row.get(10));
            data.add(u);
        }
        tableView.setEditable(true);
        System.out.println(data);
        tableView.setItems(data);
    }
    @FXML
    void RateAction(ActionEvent event)
    {
        if(tableView.getSelectionModel().getSelectedItem()!=null){
            if(tableView.getSelectionModel().getSelectedItem().getRating()==null || tableView.getSelectionModel().getSelectedItem().getRating().equals("-1")){
                done.setVisible(true);
                ratingfield.setVisible(true);
            }
            else
            {
                ShowAlert("You have Already rated it");
            }
        }
        else
        {
            ShowAlert("Please select a row First");
        }
    }
    @FXML
    void doneAction(ActionEvent event)
    {
        if(ratingfield.getText()!=null){
            new Customer().updateServiceReport(tableView.getSelectionModel().getSelectedItem().getService_number(),
                    "rating", ratingfield.getText());
            tableView.getSelectionModel().getSelectedItem().setRating(ratingfield.getText());
            done.setVisible(false);
            ratingfield.setVisible(false);
        }
    }
    @FXML
    void PaymentAction(ActionEvent event)
    {
        if(tableView.getSelectionModel().getSelectedItem()!=null){
            if(tableView.getSelectionModel().getSelectedItem().getPayment_status().equals("pending")){
                new Customer().updateServiceReport(tableView.getSelectionModel().getSelectedItem().getService_number(),
                    "payment_status","cleared");
            tableView.getSelectionModel().getSelectedItem().setPayment_status("cleared");
            }
            else
            {
                ShowAlert("You have Already done it");
            }
        }
        else
        {
            ShowAlert("Please select a row First");
        }
    }
    @FXML
    void detailsAction(ActionEvent event)
    {
        if(tableView.getSelectionModel().getSelectedItem()!=null){
            try {
                main.showCustomerDeliveredFood(tableView.getSelectionModel().getSelectedItem().getService_number());
            } catch (IOException ex) {
                Logger.getLogger(RatingAndPaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            ShowAlert("Please select a row First");
        }
    }
    void setMain(Main main)
    {
        this.main=main;
    }
    void ShowAlert(String text)
    {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setContentText(text);
        alert.showAndWait();
    }


    @FXML
    void backButton(ActionEvent event)
    {
        try {
            main.ShowCustomerWindow();
        } catch (IOException ex) {
            Logger.getLogger(WaiterHistoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
