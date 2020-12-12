/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB.VariousQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Alavi
 */
public class WaiterHistoryController implements Initializable {
    private Main main;
    @FXML
    private TableView tableView;
     ObservableList<ServiceHistory> data;

    @FXML
    private Button button;

    private boolean init = true;
    private void initializeColumns()
    {
        TableColumn<ServiceHistory, String> serviceNumberCol = new TableColumn<>("Serv. No");
        serviceNumberCol.setMinWidth(120);
        serviceNumberCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory,String>("service_number"));

        TableColumn<ServiceHistory, String> eventIdCol = new TableColumn<>("Event ID");
        eventIdCol.setMinWidth(150);
        eventIdCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory,String>("event_id"));

        TableColumn<ServiceHistory, String> customerIdCol = new TableColumn<>("Customer ID");
        customerIdCol.setMinWidth(100);
        customerIdCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory,String>("customer_id"));

        TableColumn<ServiceHistory, String> tableNoCol = new TableColumn<>("Table No.");
        tableNoCol.setMinWidth(130);
        tableNoCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory,String>("table_number"));

        TableColumn<ServiceHistory, String> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(120);
        dateCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory,String>("date"));

        TableColumn<ServiceHistory, String> timeCol = new TableColumn<>("Time");
        timeCol.setMinWidth(150);
        timeCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory,String>("time"));

        TableColumn<ServiceHistory, String> ratingCol = new TableColumn<>("Rating");
        ratingCol.setMinWidth(150);
        ratingCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory,String>("rating"));

        TableColumn<ServiceHistory, String> deliveryCol = new TableColumn<>("Delivery Status");
        deliveryCol.setMinWidth(200);
        deliveryCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory,String>("delivery_status"));

        TableColumn<ServiceHistory, String> paymentCol = new TableColumn<>("Payment Status");
        paymentCol.setMinWidth(200);
        paymentCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory,String>("payment_status"));


        tableView.getColumns().addAll(serviceNumberCol, eventIdCol, customerIdCol, tableNoCol, dateCol,
                timeCol, ratingCol, deliveryCol, paymentCol);


//        TableColumn<ServiceHistory, String> servicenumCol = new TableColumn<ServiceHistory, String>("Service_Number");
//        servicenumCol.setMinWidth(100);
//        servicenumCol.setCellValueFactory(new PropertyValueFactory< ServiceHistory, String>("service_number"));
//
//        TableColumn<ServiceHistory, String> eventidCol = new TableColumn<ServiceHistory, String>("Event_ID");
//        eventidCol.setMinWidth(100);
//        eventidCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory, String>("event_id"));
//
//        TableColumn<ServiceHistory, String> customeridCol = new TableColumn<ServiceHistory, String>("Customer_ID");
//        customeridCol.setMinWidth(200);
//        customeridCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory,String>("customer_id"));
//
//        TableColumn<ServiceHistory, String> tablenumCol = new TableColumn<ServiceHistory, String>("Table_Number");
//        tablenumCol.setMinWidth(100);
//        tablenumCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory, String>("table_number"));
//
//         TableColumn<ServiceHistory, String> dateCol = new TableColumn<ServiceHistory, String>("Date");
//        dateCol.setMinWidth(100);
//        dateCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory, String>("date"));
//
//         TableColumn<ServiceHistory, String> timeCol = new TableColumn<ServiceHistory, String>("Time");
//        timeCol.setMinWidth(100);
//        timeCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory, String>("time"));
//
//         TableColumn<ServiceHistory, String> ratingCol = new TableColumn<ServiceHistory, String>("Rating");
//        ratingCol.setMinWidth(100);
//        ratingCol.setCellValueFactory(new PropertyValueFactory<ServiceHistory, String>("rating"));
        //emailCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        /*emailCol.setOnEditCommit(
         (TableColumn.CellEditEvent<Person, String> t) ->
         t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue())
         );*/

        //tableView.getColumns().addAll(servicenumCol, eventidCol, customeridCol,tablenumCol,dateCol,timeCol,ratingCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new VariousQuery().getAllHistory(Constants.ID);
        System.out.println(userDataList.size());
        for (List<String> row : userDataList)
        {
            data.add(new ServiceHistory(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5)
                    , row.get(6), row.get(7), row.get(8)));
            //System.out.println(row.get(0)+" "+row.get(1)+" "+row.get(2)+" "+row.get(3)+" "+row.get(4)+" "+row.get(5)+" "+row.get(6));
        }
        tableView.setEditable(true);
        tableView.setItems(data);
        //data.get(0).setFirstName("Jacob2");

    }
    @FXML
    void ButtonAction(ActionEvent event)
    {
        if(Constants.userType.equals("waiter"))
        try {
            main.ShowWaiterWindow();
        } catch (IOException ex) {
            Logger.getLogger(WaiterHistoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if(Constants.userType.equals("marketer")) {
            try {
                main.ShowMarketerWindow();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Constants.userType.equals("delivery_boy")) {
            try {
                main.showDeliveryBoyWindow();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Constants.userType.equals("customer")) {
            try {
                main.showDeliveryBoyWindow();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Constants.userType.equals("manager")) {
            try {
                main.showManagerWindow();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
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
