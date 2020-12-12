package sample;

import DB.DBJobs;
import DB.DBUpdateFood;
import DB.Delete;
import DB.Update;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.TextFieldTableCell;

public class JobsTableController {


    private Main main;
    @FXML
    private TableView<JobsTable> tableView;

    ObservableList<JobsTable> data;
    @FXML
    private Button delete;
    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<JobsTable, String> jobIdCol = new TableColumn<>("Id");
        jobIdCol.setMinWidth(130);
        jobIdCol.setCellValueFactory(new PropertyValueFactory<JobsTable,String>("job_id"));

        TableColumn<JobsTable, String> titleCol = new TableColumn<>("Title");
        titleCol.setMinWidth(150);
        titleCol.setCellValueFactory(new PropertyValueFactory<JobsTable,String>("title"));
        

        TableColumn<JobsTable, String> minSalaryCol = new TableColumn<>("Min Salary");
        minSalaryCol.setMinWidth(150);
        minSalaryCol.setCellValueFactory(new PropertyValueFactory<JobsTable,String>("min_salary"));

        
        TableColumn<JobsTable, String> maxSalaryCol = new TableColumn<>("Max Salary");
        maxSalaryCol.setMinWidth(150);
        maxSalaryCol.setCellValueFactory(new PropertyValueFactory<JobsTable,String>("max_salary"));
        titleCol.setCellFactory(TextFieldTableCell.<JobsTable>forTableColumn());
        titleCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<JobsTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<JobsTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setTitle(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getTitle());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getJob_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getJob_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getTitle());
                boolean update = new Update().updateJobClmn(fID,"job_title",value);
                AlertDialogShow(update);
            }
        });
        minSalaryCol.setCellFactory(TextFieldTableCell.<JobsTable>forTableColumn());
        minSalaryCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<JobsTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<JobsTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setMin_salary(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getMin_salary());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getJob_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getJob_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getMin_salary());
                boolean update = new Update().updateJobClmn(fID,"min_salary",value);
                AlertDialogShow(update);
            }
        });
        maxSalaryCol.setCellFactory(TextFieldTableCell.<JobsTable>forTableColumn());
        maxSalaryCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<JobsTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<JobsTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setMax_salary(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getMax_salary());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getJob_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getJob_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getMax_salary());
                boolean update = new Update().updateJobClmn(fID,"max_salary",value);
                AlertDialogShow(update);
            }
        });
        tableView.getColumns().addAll(jobIdCol, titleCol, minSalaryCol, maxSalaryCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new DBJobs().getAllJobs();
        for (List<String> row : userDataList)
        {
            JobsTable u = new JobsTable(row.get(0), row.get(1), row.get(2), row.get(3));
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
    void InsertJobs(ActionEvent event)
    {
        try
        {
            //make customer insert or update window..
            main.InsertJobs();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    void AlertDialogShow(boolean success)
    {
        if(success)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText("Update Notice.");
            alert.setContentText("Job Details have been successfully updated");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Notice");
            alert.setHeaderText("Failed To Update");
            alert.setContentText("Job Details update Failed");
            alert.showAndWait();
        }
    }
    @FXML
    void deleteAction(ActionEvent event)
    {
        boolean update=false;
        if(tableView.getSelectionModel().getSelectedItems()!=null){
            update = new Delete().DeleteJobs(tableView.getSelectionModel().getSelectedItem().getJob_id());
            AlertDialogShow(update);
            if(update)
                tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
        }
    }
    public void setMain(Main main)
    {
        this.main = main;
    }
}
