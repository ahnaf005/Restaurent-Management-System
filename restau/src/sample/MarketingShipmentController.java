package sample;

import DB.DBMarketingShipment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.omg.CORBA.MARSHAL;

import java.util.List;

public class MarketingShipmentController {
    private Main main;
    @FXML
    private TableView tableView;

    ObservableList<MarketingShipment> data;

    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<MarketingShipment, String> marketingNumberCol = new TableColumn<>("Marketing Number");
        marketingNumberCol.setMinWidth(200);
        marketingNumberCol.setCellValueFactory(new PropertyValueFactory<MarketingShipment,String>("marketing_number"));

        TableColumn<MarketingShipment, String> ingredientCol = new TableColumn<>("Ingredient");
        ingredientCol.setMinWidth(150);
        ingredientCol.setCellValueFactory(new PropertyValueFactory<MarketingShipment,String>("ingredient_name"));

        TableColumn<MarketingShipment, String> amountCol = new TableColumn<>("Amount");
        amountCol.setMinWidth(120);
        amountCol.setCellValueFactory(new PropertyValueFactory<MarketingShipment,String>("amount"));


        tableView.getColumns().addAll(marketingNumberCol, ingredientCol, amountCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new DBMarketingShipment().getAllMarketingShipments();
        for (List<String> row : userDataList)
        {
            MarketingShipment u = new MarketingShipment(row.get(0), row.get(1), row.get(2));
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
    void InsertMarketingShipment(ActionEvent event)
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
