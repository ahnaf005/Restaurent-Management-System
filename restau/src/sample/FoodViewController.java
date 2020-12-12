package sample;

import DB.DBFoods;
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

public class FoodViewController {


    private Main main;
    @FXML
    private TableView tableView;

    ObservableList<Food> data;

    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<Food, String> food_idCol = new TableColumn<>("Food_id");
        food_idCol.setMinWidth(100);
        food_idCol.setCellValueFactory(new PropertyValueFactory<Food,String>("food_id"));

        TableColumn<Food, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<Food,String>("name"));

        nameCol.setEditable(true);
        nameCol.setOnEditCommit((TableColumn.CellEditEvent<Food, String> t )->
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue()));

        TableColumn<Food, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(200);
        typeCol.setCellValueFactory(new PropertyValueFactory<Food, String >("type"));

        TableColumn<Food, String> costCol = new TableColumn<>("Cost");
        costCol.setMinWidth(200);
        costCol.setCellValueFactory(new PropertyValueFactory<Food, String>("cost"));

        TableColumn<Food, String> originCol = new TableColumn<>("Origin");
        originCol.setMinWidth(200);
        originCol.setCellValueFactory(new PropertyValueFactory<Food, String>("origin"));


        tableView.getColumns().addAll(food_idCol, nameCol, typeCol, costCol, originCol);


        nameCol.setCellFactory(TextFieldTableCell.<Food>forTableColumn());
        nameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Food, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Food, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getFood_id());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getFood_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getName());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getName());
                boolean update = new DBUpdateFood().updateFoodClmn(fID,"name",value);
                AlertDialogShow(update);
            }
        });

        typeCol.setCellFactory(TextFieldTableCell.<Food>forTableColumn());
        typeCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Food, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Food, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setType(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getFood_id());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getFood_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getType());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getType());
                boolean update = new DBUpdateFood().updateFoodClmn(fID,"type",value);
                AlertDialogShow(update);
            }
        });

        costCol.setCellFactory(TextFieldTableCell.<Food>forTableColumn());
        costCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Food, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Food, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCost(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getFood_id());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getFood_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getCost());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getCost());
                boolean update = new DBUpdateFood().updateFoodClmn(fID,"cost",value);
                AlertDialogShow(update);
            }
        });

        originCol.setCellFactory(TextFieldTableCell.<Food>forTableColumn());
        originCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Food, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Food, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setOrigin(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getFood_id());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getFood_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getOrigin());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getOrigin());
                boolean update = new DBUpdateFood().updateFoodClmn(fID,"origin",value);
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

        //List<List<String>> userDataList = new Users().getAllUsers();
        List<List<String>> foodDataList = new DBFoods().getAllFoods();
        for (List<String> row : foodDataList)
        {
            Food u = new Food(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4));
            //data.add(new User(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4)));
            data.add(u);
            //System.out.println(u.toString());
            //System.out.println(data);
            //System.out.println(row.get(0)+" "+ row.get(1)+ " "+ row.get(2)+ " "+ row.get(3)+ " "+ row.get(4));
        }

//        data = FXCollections.observableArrayList(
//                new User("Jacob", "2312", "Jacob Smith"),
//                new User("Isabella", "546t5", "Isabella Johnson"),
//                new User("Ethan", "fg565", "Ethan Williams"),
//                new User("Emma", "56564", "Emma Jones"),
//                new User("Michael", "gh5456", "Michael Brown")
//        );
        tableView.setEditable(true);
        tableView.setItems(data);
        //data.get(0).setFirstName("Jacob2");

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
    void InsertFood(ActionEvent event)
    {
        try
        {
            main.InsertFoodWindow();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void UpdateFood(ActionEvent event)
    {
        try
        {
            main.UpdateFoodWindow();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setMain(Main main)
    {
        this.main = main;
    }

    @FXML
    void showTest(ActionEvent ev){
        System.out.println(tableView.getSelectionModel().getSelectedItems().toString());
    }

    void AlertDialogShow(boolean success)
    {
        if(success)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText("Update Notice.");
            alert.setContentText("Food Details have been successfully updated");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Notice");
            alert.setHeaderText("Failed To Update");
            alert.setContentText("Food Details update Failed");
            alert.showAndWait();
        }
    }

}
