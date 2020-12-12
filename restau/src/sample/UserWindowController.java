package sample;

import DB.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;

public class UserWindowController {



    private Main main;
    @FXML
    private TableView tableView;
    @FXML
    private TextField loginAs;

    ObservableList<User> data;

    @FXML
    private Button button;
    @FXML
    private Button food;
    @FXML
    private Button employees;

    //private boolean init = true;
    private boolean init = false;

    private void initializeColumns()
    {
        TableColumn<User, String> userNameCol = new TableColumn<User, String>("Username");
        userNameCol.setMinWidth(100);
        userNameCol.setCellValueFactory(new PropertyValueFactory< User, String>("userName"));
        TableColumn<User, String> passwordCol = new TableColumn<User, String>("Password");
        passwordCol.setMinWidth(100);
        passwordCol.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        TableColumn<User, String> fullNameCol = new TableColumn<User, String>("Full Name");
        fullNameCol.setMinWidth(200);
        fullNameCol.setCellValueFactory(new PropertyValueFactory<User,String>("fullName"));

        tableView.getColumns().addAll(userNameCol, passwordCol, fullNameCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new Users().getAllUsers();
        for (List<String> row : userDataList)
        {
            data.add(new User(row.get(0), row.get(1), row.get(2)));
        }

        tableView.setEditable(true);
        tableView.setItems(data);
        //data.get(0).setFirstName("Jacob2");

    }
    void setMain(Main main)
    {
        this.main = main;
    }


    void setText(String str)
    {
        if(str!=null)
            loginAs.setText(str);
    }

    @FXML
    void foodViewShow(ActionEvent event){
        try {
            main.showTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("foodView.fxml"));
//        Parent root = null;
//        try {
//            root = loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Loading the controller
//        FoodViewController controller = loader.getController();
//        //adminType = admin_type;
//        //controller.setText(admin_type);
//        //controller.load();
//        controller.setMain(this.main);
//
////        // Set the primary stage
//        main.stage.setTitle("User Window");
//        main.stage.setScene(new Scene(root));
//        main.stage.show();
    }
}
