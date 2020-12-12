/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import DB.DBInsertFood;
import DB.Insert;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
public class InsertEmployeeController implements Initializable {
    private Main main;
    @FXML
    private Button back;
    @FXML
    private Button done;
    @FXML
    private ComboBox job_id;
    @FXML
    private ComboBox gender;
    @FXML
    private TextField f_name;
    @FXML
    private TextField l_name;
    @FXML
    private DatePicker hire_date;
    @FXML
    private DatePicker birth_date;
    @FXML
    private TextField phone_num;
    @FXML
    private TextField email;
    @FXML
    private TextField salary;
    @FXML
    private TextField com_pct;
    void init()
    {
        ObservableList<String>genders=FXCollections.observableArrayList("Male","Female");
        ObservableList<String>jobids=FXCollections.observableArrayList(new Insert().getAllJobId());
        job_id.getItems().addAll(jobids);
        gender.getItems().addAll(genders);
    }
    @FXML
    void backAction(ActionEvent event)
    {
        try {
            main.showEmployee();
        } catch (IOException ex) {
            Logger.getLogger(InsertEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void doneAction(ActionEvent event)
    {
        if(job_id.getValue()!=null && f_name.getText()!=null && l_name.getText()!=null && phone_num.getText()!=null 
                && hire_date.getValue()!=null && birth_date.getValue()!=null && email.getText()!=null
                && salary.getText()!=null && com_pct.getText()!=null && gender.getValue()!=null)
        {
            List<String>Insertlist=new ArrayList<>();
            Insertlist.add(job_id.getValue().toString());
            Insertlist.add(f_name.getText());
            Insertlist.add(l_name.getText());
            Insertlist.add(phone_num.getText());
            Insertlist.add(hire_date.getEditor().getText());
            Insertlist.add(birth_date.getEditor().getText());
            Insertlist.add(email.getText());
            Insertlist.add(salary.getText());
            Insertlist.add(com_pct.getText());
            Insertlist.add(gender.getValue().toString());
            boolean success=true;
            try {
                new Insert().InsertEmployees(Insertlist,success);
            } catch (ParseException ex) {
                Logger.getLogger(InsertEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                success=false;
            }
            if(success)
            {
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                 alert.setTitle("Inserton Successful");
                 alert.setHeaderText("Insertion Successful");
                 alert.setContentText("Press back to check the updated table");
                 alert.showAndWait();
                 job_id.setValue(null);
                 f_name.setText(null);
                 l_name.setText(null);
                 phone_num.setText(null);
                 hire_date.setValue(null);
                 birth_date.setValue(null);
                 email.setText(null);
                 salary.setText(null);
                 com_pct.setText(null);
                 gender.setValue(null);
            }
            else
            {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Incorrect Credentials");
                 alert.setHeaderText("Incorrect Credentials");
                 alert.setContentText("The employee you entered already exists");
                 alert.showAndWait();
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
