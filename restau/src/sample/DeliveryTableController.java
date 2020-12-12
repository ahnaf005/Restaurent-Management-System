package sample;

import DB.DBDelivery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.management.ServiceNotFoundException;
import java.util.List;

public class DeliveryTableController {
    private Main main;
    @FXML
    private TableView tableView;

    ObservableList<DeliveryTable> data;

    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<DeliveryTable, String> serviceNoCol = new TableColumn<>("Serv. No");
        serviceNoCol.setMinWidth(200);
        serviceNoCol.setCellValueFactory(new PropertyValueFactory<DeliveryTable,String>("service_number"));

        TableColumn<DeliveryTable, String> foodIdCol = new TableColumn<>("Food ID");
        foodIdCol.setMinWidth(150);
        foodIdCol.setCellValueFactory(new PropertyValueFactory<DeliveryTable,String>("food_id"));

        TableColumn<DeliveryTable, String> deliveryAddressCol = new TableColumn<>("Deliv. Address");
        deliveryAddressCol.setMinWidth(200);
        deliveryAddressCol.setCellValueFactory(new PropertyValueFactory<DeliveryTable, String >("delivery_address"));

        TableColumn<DeliveryTable, String> amountCol = new TableColumn<>("Amount");
        amountCol.setMinWidth(200);
        amountCol.setCellValueFactory(new PropertyValueFactory<DeliveryTable, String>("amount"));

        tableView.getColumns().addAll(serviceNoCol, foodIdCol, deliveryAddressCol, amountCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();
        List<List<String>> foodDataList = new DBDelivery().getAllDelivery();
        for (List<String> row : foodDataList)
        {
            DeliveryTable u = new DeliveryTable(row.get(0), row.get(1), row.get(2), row.get(3));
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
    void InsertDelivery(ActionEvent event)
    {
        try
        {
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
