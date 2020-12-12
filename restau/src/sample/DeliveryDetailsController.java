package sample;

import DB.DBDelivery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class DeliveryDetailsController {
    private Main main;
    private String servNo;
    @FXML
    private TableView<DeliveryTable> tableView;
    ObservableList<DeliveryTable> data;

    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<DeliveryTable, String> serviceNoCol = new TableColumn<>("Service No");
        serviceNoCol.setMinWidth(150);
        serviceNoCol.setCellValueFactory(new PropertyValueFactory<DeliveryTable,String>("service_number"));

        TableColumn<DeliveryTable, String> deliveryAddressCol = new TableColumn<>("Delivery Address");
        deliveryAddressCol.setMinWidth(180);
        deliveryAddressCol.setCellValueFactory(new PropertyValueFactory<DeliveryTable,String>("delivery_address"));

        TableColumn<DeliveryTable, String> foodIdCol = new TableColumn<>("Food ID");
        foodIdCol.setMinWidth(150);
        foodIdCol.setCellValueFactory(new PropertyValueFactory<DeliveryTable,String>("food_id"));

        TableColumn<DeliveryTable, String> amountCol = new TableColumn<>("Amount");
        amountCol.setMinWidth(200);
        amountCol.setCellValueFactory(new PropertyValueFactory<DeliveryTable, String>("amount"));

        tableView.getColumns().addAll(serviceNoCol, deliveryAddressCol, foodIdCol, amountCol);
    }


    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();
        List<List<String>> details = new DBDelivery().getSpecificDelivery(servNo);
        //System.out.println(details);
        for (List<String> row : details)
        {
            DeliveryTable u = new DeliveryTable(row.get(0), row.get(1), row.get(2), row.get(3));
            data.add(u);
        }

        tableView.setEditable(true);
        tableView.setItems(data);
    }


    @FXML
    void backButton(ActionEvent event){
        try {
            main.showDeliveryBoyWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main)
    {
        this.main = main;
    }
    public void setServNo(String servNo)
    {
        this.servNo = servNo;
    }

}
