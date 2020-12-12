/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import DB.Insert;
import DB.DBInsertFood;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Alavi
 */
public class InsertJobsController implements Initializable {
    private Main main;
    @FXML
    private TextField job_id;
    @FXML
    private TextField job_title;
    @FXML
    private TextField min_salary;
    @FXML
    private TextField max_salary;
    @FXML
    private Button back;
    @FXML
    public Button done;
    @FXML
    Label idLabel;
    @FXML
    Label titleLabel;
    @FXML
    Label minsalaryLabel;
    @FXML
    Label maxsalaryLabel;

    /**
     * Initializes the controller class.
     */

    @FXML
    void backAction(ActionEvent Event)
    {
        try {
            main.showJobs();
        } catch (IOException ex) {
            Logger.getLogger(InsertFoodController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void doneAction(ActionEvent Event)
    {
        if(job_id.getText()!=null && job_title.getText()!=null && min_salary.getText()!=null && max_salary.getText()!=null)
        {
            List<String>Insertlist=new ArrayList<>();
            Insertlist.add(job_id.getText());
            Insertlist.add(job_title.getText());
            Insertlist.add(min_salary.getText());
            Insertlist.add(max_salary.getText());
            boolean success=new Insert().InsertJob(Insertlist);
            if(success)
            {
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                 alert.setTitle("Inserton Successful");
                 alert.setHeaderText("Insertion Successful");
                 alert.setContentText("Press back to check the updated table");
                 alert.showAndWait();
                 job_id.setText(null);
                 job_title.setText(null);
                 min_salary.setText(null);
                 max_salary.setText(null);
            }
            else
            {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Incorrect Credentials");
                 alert.setHeaderText("Incorrect Credentials");
                 alert.setContentText("The job_id you entered already exists");
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
