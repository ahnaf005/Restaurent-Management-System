package sample;

import DB.DBJobMaxSalary;
import DB.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MaxSalaryController {
    private Main main;
    @FXML
    private TableView tableView;

    ObservableList<SubQueryDemo> data;

    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<SubQueryDemo, String> job_titleCol = new TableColumn<>("job_title");
        job_titleCol.setMinWidth(100);
        job_titleCol.setCellValueFactory(new PropertyValueFactory<SubQueryDemo,String>("job_title"));

        TableColumn<SubQueryDemo, String> employee_id = new TableColumn<>("employee_id");
        employee_id.setMinWidth(100);
        employee_id.setCellValueFactory(new PropertyValueFactory<SubQueryDemo,String>("employee_id"));

        TableColumn<SubQueryDemo, String> employee_name = new TableColumn<>("employee_name");
        employee_name.setMinWidth(200);
        employee_name.setCellValueFactory(new PropertyValueFactory<SubQueryDemo, String >("employee_name"));

        tableView.getColumns().addAll(job_titleCol, employee_id, employee_name);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> queryList = new DBJobMaxSalary().getMaxSalary();
        for (List<String> row : queryList)
        {
            SubQueryDemo u = new SubQueryDemo(row.get(0), row.get(1), row.get(2));
            //data.add(new User(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4)));
            data.add(u);
            //System.out.println(u.toString());
            System.out.println(data);
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

    public void setMain(Main main)
    {
        this.main = main;
    }

}
