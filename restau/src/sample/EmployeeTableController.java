package sample;

import DB.DBCustomers;
import DB.DBEmployee;
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

public class EmployeeTableController {
    private Main main;
    @FXML
    private TableView<EmployeeTable> tableView;

    ObservableList<EmployeeTable> data;
    @FXML
    private Button delete;
    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<EmployeeTable, String> employeeIdCol = new TableColumn<>("Id");
        employeeIdCol.setMinWidth(100);
        employeeIdCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable,String>("employee_id"));

        TableColumn<EmployeeTable, String> jobIdCol = new TableColumn<>("Job Id");
        jobIdCol.setMinWidth(100);
        jobIdCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable,String>("job_id"));

        TableColumn<EmployeeTable, String> fNameCol = new TableColumn<>("F.Name");
        fNameCol.setMinWidth(150);
        fNameCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable,String>("fname"));
        TableColumn<EmployeeTable, String> lNameCol = new TableColumn<>("L.Name");
        lNameCol.setMinWidth(150);
        lNameCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable,String>("lname"));

        TableColumn<EmployeeTable, String> phoneNumberCol = new TableColumn<>("Phone No");
        phoneNumberCol.setMinWidth(150);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable, String>("phone_number"));

        TableColumn<EmployeeTable, String> hireDateCol = new TableColumn<>("Hire Date");
        hireDateCol.setMinWidth(120);
        hireDateCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable, String >("hire_date"));

        TableColumn<EmployeeTable, String> birthDateCol = new TableColumn<>("Birth Date");
        birthDateCol.setMinWidth(130);
        birthDateCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable, String>("birth_date"));

        TableColumn<EmployeeTable, String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(150);
        emailCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable, String>("email"));

        TableColumn<EmployeeTable, String> salaryCol = new TableColumn<>("Salary");
        salaryCol.setMinWidth(100);
        salaryCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable, String>("salary"));

        TableColumn<EmployeeTable, String> commissionPctCol = new TableColumn<>("C.Pct.");
        commissionPctCol.setMinWidth(100);
        commissionPctCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable, String>("commission_pct"));

        TableColumn<EmployeeTable, String> genderCol = new TableColumn<>("Gender");
        genderCol.setMinWidth(100);
        genderCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable, String>("gender"));
        
        jobIdCol.setCellFactory(TextFieldTableCell.<EmployeeTable>forTableColumn());
        jobIdCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EmployeeTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EmployeeTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setJob_id(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getJob_id());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getJob_id());
                boolean update = new Update().updateEmployeeClmn(fID,"job_id",value);
                AlertDialogShow(update);
            }
        });
        fNameCol.setCellFactory(TextFieldTableCell.<EmployeeTable>forTableColumn());
        fNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EmployeeTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EmployeeTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setFname(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getFname());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getFname());
                boolean update = new Update().updateEmployeeClmn(fID,"first_name",value);
                AlertDialogShow(update);
            }
        });
        lNameCol.setCellFactory(TextFieldTableCell.<EmployeeTable>forTableColumn());
        lNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EmployeeTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EmployeeTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLname(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getLname());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getLname());
                boolean update = new Update().updateEmployeeClmn(fID,"last_name",value);
                AlertDialogShow(update);
            }
        });
        
        phoneNumberCol.setCellFactory(TextFieldTableCell.<EmployeeTable>forTableColumn());
        phoneNumberCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EmployeeTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EmployeeTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPhone_number(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getPhone_number());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getPhone_number());
                boolean update = new Update().updateEmployeeClmn(fID,"phone_number",value);
                AlertDialogShow(update);
            }
        });
        birthDateCol.setCellFactory(TextFieldTableCell.<EmployeeTable>forTableColumn());
        birthDateCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EmployeeTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EmployeeTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setBirth_date(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getBirth_date());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getBirth_date());
                boolean update = new Update().updateEmployeeClmn(fID,"birth_date",value);
                AlertDialogShow(update);
            }
        });
        emailCol.setCellFactory(TextFieldTableCell.<EmployeeTable>forTableColumn());
        emailCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EmployeeTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EmployeeTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmail());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmail());
                boolean update = new Update().updateEmployeeClmn(fID,"email",value);
                AlertDialogShow(update);
            }
        });
        
        salaryCol.setCellFactory(TextFieldTableCell.<EmployeeTable>forTableColumn());
        salaryCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EmployeeTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EmployeeTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSalary(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getSalary());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getSalary());
                boolean update = new Update().updateEmployeeClmn(fID,"salary",value);
                AlertDialogShow(update);
            }
        });
        
        commissionPctCol.setCellFactory(TextFieldTableCell.<EmployeeTable>forTableColumn());
        commissionPctCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EmployeeTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EmployeeTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCommission_pct(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getCommission_pct());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmployee_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getCommission_pct());
                boolean update = new Update().updateEmployeeClmn(fID,"commission_pct",value);
                AlertDialogShow(update);
            }
        });

        tableView.getColumns().addAll(employeeIdCol, jobIdCol, fNameCol, lNameCol, phoneNumberCol, hireDateCol, birthDateCol, emailCol, salaryCol, commissionPctCol, genderCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new DBEmployee().getAllEmployee();
        for (List<String> row : userDataList)
        {
            EmployeeTable u = new EmployeeTable(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6),
                                                row.get(7), row.get(8), row.get(9), row.get(10));
            //data.add(new User(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4)));
            data.add(u);
            //System.out.println(u.toString());
            //System.out.println(data);
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
    void InsertEmployee(ActionEvent event)
    {
        try
        {
            main.InsertEmployee();
            //make customer insert or update window..
            //main.InsertFoodWindow();
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
    @FXML
    void deleteAction(ActionEvent event)
    {
        boolean update=false;
        if(tableView.getSelectionModel().getSelectedItems()!=null){
            update = new Delete().DeleteEmployees(tableView.getSelectionModel().getSelectedItem().getEmployee_id());
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
