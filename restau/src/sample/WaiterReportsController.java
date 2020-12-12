/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import DB.WaiterReports;
import DB.CustomerReports;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
public class WaiterReportsController implements Initializable {
    private Main main;
    @FXML
    private TableView tableView;

    ObservableList<EmployeeTable> data;
    @FXML
    private Button back;
    @FXML
    private Button done;
    @FXML
    private Button confirm;
    @FXML
    private Button go;
    @FXML
    private TextField threshold;
    @FXML
    private TextField employeeid1;
    @FXML
    private TextField employeeid2;
    @FXML
    private Label name;
    @FXML
    private Label showname;
    @FXML
    private Label gotmoney;
    @FXML
    private Label showgotmoney;
    @FXML
    private TextField updatedsalary;
    @FXML
    private Label avgrating;
    @FXML
    private Label showavgrating;
    private boolean init = true;

    private void initializeColumns()
    {
        name.visibleProperty().set(false);
        showname.visibleProperty().set(false);
        gotmoney.visibleProperty().set(false);
        showgotmoney.visibleProperty().set(false);
        avgrating.visibleProperty().set(false);
        showavgrating.visibleProperty().set(false);
        TableColumn<EmployeeTable, String> employeeIdCol = new TableColumn<>("Id");
        employeeIdCol.setMinWidth(100);
        employeeIdCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable,String>("employee_id"));

        TableColumn<EmployeeTable, String> jobIdCol = new TableColumn<>("Job Id");
        jobIdCol.setMinWidth(100);
        jobIdCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable,String>("job_id"));

        TableColumn<EmployeeTable, String> lNameCol = new TableColumn<>("L.Name");
        lNameCol.setMinWidth(150);
        lNameCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable,String>("lname"));

        TableColumn<EmployeeTable, String> salaryCol = new TableColumn<>("Salary");
        salaryCol.setMinWidth(100);
        salaryCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable, String>("salary"));

        TableColumn<EmployeeTable, String> commissionPctCol = new TableColumn<>("C.Pct.");
        commissionPctCol.setMinWidth(100);
        commissionPctCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable, String>("commission_pct"));

        TableColumn<EmployeeTable, String> serveCol = new TableColumn<>("Total_Served");
        serveCol.setMinWidth(100);
        serveCol.setCellValueFactory(new PropertyValueFactory<EmployeeTable, String>("total_services"));
        tableView.getColumns().addAll(employeeIdCol,jobIdCol,lNameCol,salaryCol,commissionPctCol,serveCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new WaiterReports().getAllWaiters();
        for (List<String> row : userDataList)
        {
            EmployeeTable u = new EmployeeTable(row.get(0),row.get(1),null,row.get(2),null,null,null,null,row.get(3),row.get(4),null);
            //data.add(new User(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4)));
            u.setTotal_services(row.get(5));
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
    void backAction(ActionEvent event)
    {
        try {
            main.showReports();
        } catch (IOException ex) {
            Logger.getLogger(WaiterReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void doneAction(ActionEvent event)
    {
        if(threshold.getText()!=null)
        {
            new WaiterReports().UpdateAllWaiterSalary(threshold.getText());
            try {
                main.showWaiterReports();
            } catch (IOException ex) {
                Logger.getLogger(WaiterReportsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void GoAction(ActionEvent event)
    {
        if(employeeid1.getText()!=null)
        {
            List<String>result=new WaiterReports().getStats(employeeid1.getText());
            if(result.size()==0)
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("This Customer Doesnot exist");
                alert.showAndWait();
                employeeid1.setText(null);
            }
            else
            {
                name.visibleProperty().set(true);
                showname.visibleProperty().set(true);
                gotmoney.visibleProperty().set(true);
                showgotmoney.visibleProperty().set(true);
                avgrating.visibleProperty().set(true);
                showavgrating.visibleProperty().set(true);
                showname.setText(result.get(0)+" "+result.get(1));
                showgotmoney.setText(result.get(2));
                showavgrating.setText(result.get(3));
            }
        }
    }
    @FXML
    void confirmAction(ActionEvent event)
    {
        if(employeeid2.getText()!=null && updatedsalary.getText()!=null)
        {
            new WaiterReports().UpdateWaiterSalary(employeeid2.getText(),updatedsalary.getText());
            employeeid2.setText(null);
            updatedsalary.setText(null);
            try {
                main.showWaiterReports();
            } catch (IOException ex) {
                Logger.getLogger(WaiterReportsController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
