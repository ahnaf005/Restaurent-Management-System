/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import DB.VariousQuery;
//import com.sun.org.apache.bcel.internal.Constants;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Alavi
 */
public class WaiterWindowController implements Initializable {
    private int employee_id;
    private boolean value;
    VariousQuery query;
    private Main main;
    @FXML
    private Button ViewProfile;
    @FXML
    private Button AddService;
    @FXML
    private Button History;
    @FXML
    private Button LogOut;
    @FXML
    private Button Done;
    @FXML
    private Button AddMore;
    @FXML
    private Button InsertComplete;
    @FXML
    private Label showLabel;
    @FXML
    private TextField FoodId;
    @FXML
    private TextField Ammount;
    @FXML
    private TextField Customer_Id;
    @FXML
    private TextField Event_Id;
    @FXML
    private TextField Table_No;
    @FXML
    private TextField Time;
    @FXML
    private DatePicker date;
    private boolean init=true;
    private String sendCustomer_Id;
    private String sendEvent_Id;
    private String sendTable_No;
    private String sendTime;
    private String sendDate;
    /**
     * Initializes the controller class.
     */
    public void Initialize()
    {
        if(init){
            value=true;
            //employee_id=2;
            employee_id=Integer.parseInt(Constants.ID);
            showLabel.setText("Welcome "+new VariousQuery().getUsername(employee_id));
            init=false;
            Done.setDisable(true);
            AddMore.setDisable(true);
            InsertComplete.setDisable(true);
            query=new VariousQuery();
        }
    }
    @FXML
    void DoneAction(ActionEvent event)
    {
        if(Customer_Id.getText()!=null && Table_No.getText()!=null 
                && Time.getText()!=null && date.getEditor().getText()!=null)
        {
            sendCustomer_Id=Customer_Id.getText();
            sendEvent_Id=Event_Id.getText();
            sendTable_No=Table_No.getText();
            sendTime=Time.getText();
            sendDate=date.getEditor().getText();
            Customer_Id.setEditable(false);
            Event_Id.setEditable(false);
            Table_No.setEditable(false);
            Time.setEditable(false);
            date.setEditable(false);
            FoodId.setEditable(true);
            Ammount.setEditable(true);
            Done.setDisable(true);
            AddMore.setDisable(false);
            InsertComplete.setDisable(false);
        }
    }
    @FXML
    void AddMoreAction(ActionEvent event)
    {
        if(FoodId.getText()!=null && Ammount.getText()!=null)
        {
            List<String>InfoList=new ArrayList<>();
            InfoList.add(sendCustomer_Id);
            InfoList.add(sendEvent_Id);
            InfoList.add(sendTable_No);
            InfoList.add(sendTime);
            InfoList.add(sendDate);
            InfoList.add(FoodId.getText());
            InfoList.add(Ammount.getText());
            try {
                query.InsertFromWaiterWindow(InfoList,value);
            } catch (ParseException ex) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Enter Time at HH:mm Format");
                alert.showAndWait();
                Logger.getLogger(WaiterWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
            value=false;
            FoodId.setText(null);
            Ammount.setText(null);
        }
    }
    @FXML
    void InsertCompleteAction(ActionEvent event)
    {
        Customer_Id.setText(null);
        Event_Id.setText(null);
        Time.setText(null);
        date.getEditor().setText(null);
        Table_No.setText(null);
        Done.setDisable(true);
        FoodId.setEditable(false);
        Ammount.setEditable(false);
        AddMore.setDisable(true);
        InsertComplete.setDisable(true);
        value=true;
    }
    @FXML
    void ViewProfileAction(ActionEvent event)
    {
        try {
            main.showProfile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void LogOutAction(ActionEvent event)
    {
        try {
            main.showLoginPage();
        } catch (Exception ex) {
            Logger.getLogger(WaiterWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void AddServicesAction(ActionEvent event)
    {
        Customer_Id.setText(null);
        Event_Id.setText(null);
        Time.setText(null);
        date.getEditor().setText(null);
        Table_No.setText(null);
        Done.setDisable(false);
        Customer_Id.setEditable(true);
        Event_Id.setEditable(true);
        Time.setEditable(true);
        date.setEditable(true);
        Table_No.setEditable(true);
    }
    @FXML
    void HistoryAction(ActionEvent event)
    {
        try {
            main.showServiceHistory();
        } catch (Exception ex) {
            Logger.getLogger(WaiterWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void setMain(Main main)
    {
        this.main = main;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
