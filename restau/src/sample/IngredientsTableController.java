package sample;

import DB.DBIngredients;
import DB.DBUpdateFood;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.List;

public class IngredientsTableController {

    private Main main;
    @FXML
    private TableView tableView;

    ObservableList<IngredientsTable> data;

    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<IngredientsTable, String> ingredientNameCol = new TableColumn<>("Ingredient Name");
        ingredientNameCol.setMinWidth(200);
        ingredientNameCol.setCellValueFactory(new PropertyValueFactory<IngredientsTable,String>("ingredient_name"));

        TableColumn<IngredientsTable, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(150);
        typeCol.setCellValueFactory(new PropertyValueFactory<IngredientsTable,String>("type"));

        TableColumn<IngredientsTable, String> costCol = new TableColumn<>("Cost");
        costCol.setMinWidth(150);
        costCol.setCellValueFactory(new PropertyValueFactory<IngredientsTable,String>("cost"));


        tableView.getColumns().addAll(ingredientNameCol, typeCol, costCol);


        typeCol.setCellFactory(TextFieldTableCell.<IngredientsTable>forTableColumn());
        typeCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<IngredientsTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<IngredientsTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setType(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getIngredient_name());
                String IngName = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getIngredient_name());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getType());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getType());
                boolean update = new DBIngredients().updateIngredientsClmn(IngName,"type",value);
                AlertDialogShow(update);
            }
        });

        costCol.setCellFactory(TextFieldTableCell.<IngredientsTable>forTableColumn());
        costCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<IngredientsTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<IngredientsTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCost(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getIngredient_name());
                String IngName = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getIngredient_name());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getCost());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getCost());
                boolean update = new DBIngredients().updateIngredientsClmn(IngName,"cost",value);
                AlertDialogShow(update);
            }
        });

    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new DBIngredients().getAllIngredients();
        for (List<String> row : userDataList)
        {
            IngredientsTable u = new IngredientsTable(row.get(0), row.get(1), row.get(2));
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
    void InsertIngredients(ActionEvent event)
    {
        try
        {
            //make customer insert or update window..
            main.InsertIngredients();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setMain(Main main)
    {
        this.main = main;
    }


    void AlertDialogShow(boolean success)
    {
        if(success)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText("Update Notice.");
            alert.setContentText("Ingredients Details have been successfully updated");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Notice");
            alert.setHeaderText("Failed To Update");
            alert.setContentText("Ingredients Details update Failed");
            alert.showAndWait();
        }
    }
}
