package sample;

import DB.DBCustomers;
import DB.Delete;
import DB.Update;
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
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.TextFieldTableCell;

public class CustomerTableController {
    private Main main;
    @FXML
    private TableView<CustomerTable> tableView;

    ObservableList<CustomerTable> data;
    @FXML
    private Button delete;
    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<CustomerTable, String> customerIdCol = new TableColumn<>("Id");
        customerIdCol.setMinWidth(60);
        customerIdCol.setCellValueFactory(new PropertyValueFactory<CustomerTable,String>("customer_id"));

        TableColumn<CustomerTable, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(150);
        nameCol.setCellValueFactory(new PropertyValueFactory<CustomerTable,String>("name"));

        TableColumn<CustomerTable, String> ageCol = new TableColumn<>("Age");
        ageCol.setMinWidth(70);
        ageCol.setCellValueFactory(new PropertyValueFactory<CustomerTable, String >("age"));

        TableColumn<CustomerTable, String> addressCol = new TableColumn<>("Address");
        addressCol.setMinWidth(150);
        addressCol.setCellValueFactory(new PropertyValueFactory<CustomerTable, String>("address"));

        TableColumn<CustomerTable, String> phoneNumberCol = new TableColumn<>("Phone No");
        phoneNumberCol.setMinWidth(150);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<CustomerTable, String>("phone_number"));

        TableColumn<CustomerTable, String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(new PropertyValueFactory<CustomerTable, String>("email"));

        TableColumn<CustomerTable, String> customerTypeCol = new TableColumn<>("Type");
        customerTypeCol.setMinWidth(150);
        customerTypeCol.setCellValueFactory(new PropertyValueFactory<CustomerTable, String>("customer_type"));
        
        nameCol.setCellFactory(TextFieldTableCell.<CustomerTable>forTableColumn());
        nameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CustomerTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<CustomerTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getName());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getCustomer_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getCustomer_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getName());
                boolean update = new Update().updateCustomerClmn(fID,"name",value);
                AlertDialogShow(update);
            }
        });
        ageCol.setCellFactory(TextFieldTableCell.<CustomerTable>forTableColumn());
        ageCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CustomerTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<CustomerTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAge(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getAge());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getCustomer_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getCustomer_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getAge());
                boolean update = new Update().updateCustomerClmn(fID,"age",value);
                AlertDialogShow(update);
            }
        });
        addressCol.setCellFactory(TextFieldTableCell.<CustomerTable>forTableColumn());
        addressCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CustomerTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<CustomerTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAddress(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getAddress());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getCustomer_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getCustomer_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getAddress());
                boolean update = new Update().updateCustomerClmn(fID,"address",value);
                AlertDialogShow(update);
            }
        });
        
        phoneNumberCol.setCellFactory(TextFieldTableCell.<CustomerTable>forTableColumn());
        phoneNumberCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CustomerTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<CustomerTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPhone_number(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getPhone_number());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getCustomer_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getCustomer_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getPhone_number());
                boolean update = new Update().updateCustomerClmn(fID,"phone_number",value);
                AlertDialogShow(update);
            }
        });
        
        emailCol.setCellFactory(TextFieldTableCell.<CustomerTable>forTableColumn());
        emailCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CustomerTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<CustomerTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmail());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getCustomer_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getCustomer_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEmail());
                boolean update = new Update().updateCustomerClmn(fID,"email",value);
                AlertDialogShow(update);
            }
        });
        tableView.getColumns().addAll(customerIdCol, nameCol, ageCol, addressCol, phoneNumberCol, emailCol, customerTypeCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new DBCustomers().getAllCustomers();
        for (List<String> row : userDataList)
        {
            CustomerTable u = new CustomerTable(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6));
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
    void InsertCustomer(ActionEvent event)
    {
        try
        {
            //make customer insert or update window..
            main.InsertCustomer();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void deleteAction(ActionEvent event)
    {
        boolean update=false;
        if(tableView.getSelectionModel().getSelectedItems()!=null){
            update = new Delete().DeleteCustomers(tableView.getSelectionModel().getSelectedItem().getCustomer_id());
            AlertDialogShow(update);
            if(update)
                tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
        }
    }
    void AlertDialogShow(boolean success)
    {
        if(success)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText("Update Notice.");
            alert.setContentText("Customer Details have been successfully updated");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Notice");
            alert.setHeaderText("Failed To Update");
            alert.setContentText("Customer Details update Failed");
            alert.showAndWait();
        }
    }
    public void setMain(Main main)
    {
        this.main = main;
    }
}
