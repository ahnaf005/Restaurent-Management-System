package sample;
import DB.Customer;
import DB.DBFoods;
import DB.DBUpdateFood;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author Alavi
 */
public class CustomerWindowController implements Initializable {
    Main main;
    Customer query;
    private boolean value=true;
    private String Address;
    @FXML
    private TableView tableView;
    @FXML
    private Button profile;
    @FXML
    private Button addorder;
    @FXML
    private Button payment;
    @FXML
    private Button logout;
    @FXML
    private Button done;
    @FXML
    private Button AddMore;
    @FXML
    private Button InsertComplete;
    @FXML
    private TextField address;
    @FXML
    private TextField FoodId;
    @FXML
    private TextField Ammount;
    @FXML
    private Label showLabel;
    ObservableList<Food>data;
    private boolean init=true;
    private void initializeColumns()
    {
        query=new Customer();
        showLabel.setText(new Customer().getUserName(Constants.ID));
        TableColumn<Food, String> food_idCol = new TableColumn<>("F_id");
        food_idCol.setMinWidth(100);
        food_idCol.setCellValueFactory(new PropertyValueFactory<Food,String>("food_id"));

        TableColumn<Food, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(150);
        nameCol.setCellValueFactory(new PropertyValueFactory<Food,String>("name"));


        TableColumn<Food, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(100);
        typeCol.setCellValueFactory(new PropertyValueFactory<Food, String >("type"));

        TableColumn<Food, String> costCol = new TableColumn<>("Cost");
        costCol.setMinWidth(100);
        costCol.setCellValueFactory(new PropertyValueFactory<Food, String>("cost"));

        TableColumn<Food, String> originCol = new TableColumn<>("Origin");
        originCol.setMinWidth(100);
        originCol.setCellValueFactory(new PropertyValueFactory<Food, String>("origin"));


        tableView.getColumns().addAll(food_idCol, nameCol, typeCol, costCol, originCol);

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
    void viewProfile(ActionEvent event)
    {
        try {
            main.ShowCustomerProfile();
        } catch (IOException ex) {
            Logger.getLogger(CustomerWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void DoneAction(ActionEvent event)
    {
        if(address.getText()!=null)
        {
            Address=address.getText();
            address.setEditable(false);
            FoodId.setEditable(true);
            Ammount.setEditable(true);
            done.setDisable(true);
            AddMore.setDisable(false);
            //InsertComplete.setDisable(false);
        }
    }
    @FXML
    void AddMoreAction(ActionEvent event)
    {
        if(FoodId.getText()!=null && Ammount.getText()!=null)
        {
            List<String>InfoList=new ArrayList<>();
            InfoList.add(Address);
            InfoList.add(FoodId.getText());
            InfoList.add(Ammount.getText());
            try {
                query.InsertFromCustomerWindow(InfoList,value);
            } catch (Exception ex) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The food doesnot Exist");
                alert.showAndWait();
                FoodId.setText(null);
                Ammount.setText(null);
                Logger.getLogger(WaiterWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
            InsertComplete.setDisable(false);
            value=false;
            FoodId.setText(null);
            Ammount.setText(null);
        }
    }
    @FXML
    void InsertCompleteAction(ActionEvent event)
    {
        address.setText(null);
        FoodId.setEditable(false);
        Ammount.setEditable(false);
        AddMore.setDisable(true);
        InsertComplete.setDisable(true);
        value=true;
    }
    @FXML
    void AddOrderAction(ActionEvent event)
    {
        address.setText(null);
        done.setDisable(false);
        address.setEditable(true);
    }
    @FXML
    void logOut(ActionEvent event)
    {
        try {
            main.showLoginPage();
        } catch (Exception ex) {
            Logger.getLogger(CustomerWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void AddratingAction(ActionEvent event)
    {
        try {
            main.showRatingWindow();
        } catch (IOException ex) {
            Logger.getLogger(CustomerWindowController.class.getName()).log(Level.SEVERE, null, ex);
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
