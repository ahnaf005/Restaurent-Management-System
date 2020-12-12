package sample;

import DB.DBJobMaxSalary;
import DB.DBJoinTableQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class JoinTableController {

    private Main main;
    @FXML
    private TableView tableView;

    ObservableList<JoinQueryTableDemo> data;

    @FXML
    private Button button;
    @FXML
    private TextField employee_idField;
    @FXML
    private TextField customer_idField;
    @FXML
    private Button insert;
    private boolean init = true;

    String employee_id,customer_id;

    private void initializeColumns()
    {
        TableColumn<JoinQueryTableDemo, String> customer_nameCol = new TableColumn<>("customer_name");
        customer_nameCol.setMinWidth(200);
        customer_nameCol.setCellValueFactory(new PropertyValueFactory<JoinQueryTableDemo,String>("customer_name"));

        TableColumn<JoinQueryTableDemo, String> first_nameCol = new TableColumn<>("first_name");
        first_nameCol.setMinWidth(200);
        first_nameCol.setCellValueFactory(new PropertyValueFactory<JoinQueryTableDemo,String>("first_name"));

        TableColumn<JoinQueryTableDemo, String> table_numberCol = new TableColumn<>("table_number");
        table_numberCol.setMinWidth(200);
        table_numberCol.setCellValueFactory(new PropertyValueFactory<JoinQueryTableDemo, String >("table_number"));

        TableColumn<JoinQueryTableDemo, String> dateCol = new TableColumn<>("date");
        dateCol.setMinWidth(150);
        dateCol.setCellValueFactory(new PropertyValueFactory<JoinQueryTableDemo, String >("date"));
        TableColumn<JoinQueryTableDemo, String> timeCol = new TableColumn<>("time");
        timeCol.setMinWidth(100);
        timeCol.setCellValueFactory(new PropertyValueFactory<JoinQueryTableDemo, String >("time"));
        TableColumn<JoinQueryTableDemo, String> ratingCol = new TableColumn<>("rating");
        ratingCol.setMinWidth(100);
        ratingCol.setCellValueFactory(new PropertyValueFactory<JoinQueryTableDemo, String >("rating"));
        TableColumn<JoinQueryTableDemo, String> event_idCol = new TableColumn<>("event_id");
        event_idCol.setMinWidth(120);
        event_idCol.setCellValueFactory(new PropertyValueFactory<JoinQueryTableDemo, String >("event_id"));

        tableView.getColumns().addAll(customer_nameCol, first_nameCol, table_numberCol, dateCol, timeCol, ratingCol, event_idCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> queryList = new DBJoinTableQuery().joinQuery(employee_idField.getText().toString(),customer_idField.getText().toString());
        for (List<String> row : queryList)
        {
            JoinQueryTableDemo u = new JoinQueryTableDemo(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6));
            //data.add(new User(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4)));
            data.add(u);
            //System.out.println(u.toString());
            System.out.println(data);
            //System.out.println(row.get(0)+" "+ row.get(1)+ " "+ row.get(2)+ " "+ row.get(3)+ " "+ row.get(4));
        }

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
            //main.showUserWindow("hridoy");
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

    public void getServiceReport()
    {
        employee_id = employee_idField.getText();
        customer_id = customer_idField.getText();
        try {
            load();
            //main.joinShow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void getIDs()
    {

    }

    public void setMain(Main main)
    {
        this.main = main;
    }
}
