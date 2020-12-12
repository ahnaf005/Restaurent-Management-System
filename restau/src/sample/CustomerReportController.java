/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import DB.CustomerReports;
import DB.DBCustomers;
import DB.Update;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
public class CustomerReportController implements Initializable {
    private Main main;
    @FXML
    private TableView<CustomerTable> tableView;

    ObservableList<CustomerTable> data;
    @FXML
    private Button back;
    @FXML
    private Button done;
    @FXML
    private Button confirm;
    @FXML
    private Button go;
    @FXML
    private TextField threshold;
    @FXML
    private TextField customerid1;
    @FXML
    private TextField customerid2;
    @FXML
    private Label name;
    @FXML
    private Label showname;
    @FXML
    private Label spentmoney;
    @FXML
    private Label showspentmoney;
    @FXML
    private ComboBox customertype;
    private boolean init = true;

    private void initializeColumns()
    {
        name.visibleProperty().set(false);
        showname.visibleProperty().set(false);
        spentmoney.visibleProperty().set(false);
        showspentmoney.visibleProperty().set(false);
        ObservableList<String>customer_type=FXCollections.observableArrayList("regular","premium");
        customertype.getItems().addAll(customer_type);
        TableColumn<CustomerTable, String> customerIdCol = new TableColumn<>("Id");
        customerIdCol.setMinWidth(50);
        customerIdCol.setCellValueFactory(new PropertyValueFactory<CustomerTable,String>("customer_id"));

        TableColumn<CustomerTable, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<CustomerTable,String>("name"));

        TableColumn<CustomerTable, String> phoneNumberCol = new TableColumn<>("Phone No");
        phoneNumberCol.setMinWidth(150);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<CustomerTable, String>("phone_number"));


        TableColumn<CustomerTable, String> customerTypeCol = new TableColumn<>("Type");
        customerTypeCol.setMinWidth(150);
        customerTypeCol.setCellValueFactory(new PropertyValueFactory<CustomerTable, String>("customer_type"));
        
        TableColumn<CustomerTable, String> totalspentCol = new TableColumn<>("Total_Spent");
        totalspentCol.setMinWidth(150);
        totalspentCol.setCellValueFactory(new PropertyValueFactory<CustomerTable, String>("spent_money"));
        tableView.getColumns().addAll(customerIdCol, nameCol, phoneNumberCol,customerTypeCol,totalspentCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new CustomerReports().getAllCustomers();
        for (List<String> row : userDataList)
        {
            CustomerTable u = new CustomerTable(row.get(0),row.get(1),null,null,row.get(2),null,row.get(3));
            //data.add(new User(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4)));
            u.setSpent_money(row.get(4));
            data.add(u);
            //System.out.println(u.toString());
            //System.out.println(data);
            //System.out.println(row.get(0)+" "+ row.get(1)+ " "+ row.get(2)+ " "+ row.get(3)+ " "+ row.get(4));
        }
        tableView.setEditable(true);
        tableView.setItems(data);
        //data.get(0).setFirstName("Jacob2");

    }
    @FXML
    void backAction(ActionEvent event)
    {
        try {
            main.showReports();
        } catch (IOException ex) {
            Logger.getLogger(CustomerReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void doneAction(ActionEvent event)
    {
        if(threshold.getText()!=null)
        {
            try {
                new CustomerReports().UpdateAllCustomerTypes(threshold.getText());
                main.showCustomerReports();
            } catch (IOException ex) {
                Logger.getLogger(CustomerReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void confirmAction(ActionEvent event)
    {
        if(customerid2.getText()!=null && customertype.getValue()!=null)
        {
            try {
                new CustomerReports().UpdateCustomerType(customerid2.getText(),customertype.getValue().toString());
                customerid2.setText(null);
                main.showCustomerReports();
            } catch (IOException ex) {
                Logger.getLogger(CustomerReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void GoAction(ActionEvent event)
    {
        if(customerid1.getText()!=null)
        {
            List<String>result=new CustomerReports().getStats(customerid1.getText());
            if(result.size()==0)
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("This Customer Doesnot exist");
                alert.showAndWait();
                customerid1.setText(null);
            }
            else
            {
                name.visibleProperty().set(true);
                showname.visibleProperty().set(true);
                spentmoney.visibleProperty().set(true);
                showspentmoney.visibleProperty().set(true);
                showname.setText(result.get(0));
                showspentmoney.setText(result.get(1));
            }
        }
    }
    void setMain(Main main)
    {
        this.main=main;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
