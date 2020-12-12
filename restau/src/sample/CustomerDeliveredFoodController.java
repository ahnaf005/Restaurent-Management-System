/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import DB.Customer;
import DB.DBDelivery;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Alavi
 */
public class CustomerDeliveredFoodController implements Initializable {
    String Service_Number;
    private Main main;
    @FXML
    private TableView tableView;

    ObservableList<CustomerDelivery> data;
    @FXML
    private Button back;
    @FXML
    private TextField total_cost;
    private boolean init = true;
    private void initializeColumns()
    {

        TableColumn<CustomerDelivery, String> foodIdCol = new TableColumn<>("Food ID");
        foodIdCol.setMinWidth(150);
        foodIdCol.setCellValueFactory(new PropertyValueFactory<CustomerDelivery,String>("food_id"));
        
         TableColumn<CustomerDelivery, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(150);
        nameCol.setCellValueFactory(new PropertyValueFactory<CustomerDelivery,String>("name"));
        
         TableColumn<CustomerDelivery, String> costCol = new TableColumn<>("Cost");
        costCol.setMinWidth(150);
        costCol.setCellValueFactory(new PropertyValueFactory<CustomerDelivery,String>("cost"));

        TableColumn<CustomerDelivery, String> amountCol = new TableColumn<>("Amount");
        amountCol.setMinWidth(200);
        amountCol.setCellValueFactory(new PropertyValueFactory<CustomerDelivery, String>("amount"));

        tableView.getColumns().addAll(foodIdCol,nameCol,costCol, amountCol);
    }

    public void load(String Service_Number)
    {
        this.Service_Number=Service_Number;
        if (init)
        {
            initializeColumns();
            init = false;
        }
        int sum=0;
        data = FXCollections.observableArrayList();
        List<List<String>> foodDataList = new Customer().getAllCustomerDelivery(Service_Number);
        for (List<String> row : foodDataList)
        {
            CustomerDelivery u = new CustomerDelivery(row.get(0), row.get(1), row.get(2), row.get(3));
            sum=sum+Integer.parseInt(row.get(2))*Integer.parseInt(row.get(3));
            data.add(u);
        }

        tableView.setEditable(true);
        tableView.setItems(data);
        total_cost.setText(String.valueOf(sum));
    }
    void setMain(Main main)
    {
        this.main=main;
    }
    @FXML
    void backAction(ActionEvent event)
    {
        try {
            main.showRatingWindow();
        } catch (IOException ex) {
            Logger.getLogger(CustomerDeliveredFoodController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
