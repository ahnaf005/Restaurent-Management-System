/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB.VariousQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Alavi
 */
public class ProfileController implements Initializable {
    private Main main;
    private boolean init=true;
    private int employee_id;
    @FXML
    private Label showLabel;
    @FXML
    private Button AccountSettings;
    @FXML
    private Button HOME;
    @FXML
    private Button LogOut;
    @FXML
    private Label Employee_ID;
    @FXML
    private Label Job_ID;
    @FXML
    private Label First_Name;
    @FXML
    private Label Last_Name;
    @FXML
    private Label Job_Title;
    @FXML
    private Label Phone_Number;
    @FXML
    private Label Hire_Date;
    @FXML
    private Label Birthdate;
    @FXML
    private Label Email;
    @FXML
    private Label Salary;
    @FXML
    private Label Commission_PCT;
    @FXML
    private Label Gender;
    void Initialize()
    {
        if(init)
        {
            employee_id=Integer.parseInt(Constants.ID);
            init=false;
            showLabel.setText("Welcome "+new VariousQuery().getUsername(employee_id));
            List<String>Profileload=new VariousQuery().LoadProfile();
            Employee_ID.setText(Profileload.get(0));
            Job_ID.setText(Profileload.get(1));
            First_Name.setText(Profileload.get(2));
            Last_Name.setText(Profileload.get(3));
            Phone_Number.setText(Profileload.get(4));
            Hire_Date.setText(Profileload.get(5).toString());
            Birthdate.setText(Profileload.get(6).toString());
            Email.setText(Profileload.get(7));
            Salary.setText(Profileload.get(8));
            Commission_PCT.setText(Profileload.get(9));
            Gender.setText(Profileload.get(10));
            Job_Title.setText(Profileload.get(11));
        }
    }
//    void HOMEAction(ActionEvent event)
//    {
//        try {
//            if(Constants.userType.equals("waiter"))
//                main.ShowWaiterWindow();
//            else if(Constants.userType.equals("marketer"))
//                main.ShowMarketerWindow();
//            else if(Constants.userType.equals("admin"))
//                try {
//                    main.showAdminWindow("admin");
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    @FXML
    void HOMEAction(ActionEvent event)
    {
        try {
            if(Constants.userType.equals("waiter"))
                main.ShowWaiterWindow();
            else if(Constants.userType.equals("admin"))
                main.showAdminWindow();
            else if(Constants.userType.equals("marketer"))
                main.ShowMarketerWindow();
            else if(Constants.userType.equals("manager")) {
                try {
                    main.showManagerWindow();
                } catch (Exception ex) {
                    Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(Constants.userType.equals("delivery_boy")){
                main.showDeliveryBoyWindow();
            }
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void LogOutAction(ActionEvent event)
    {
        try {
            main.showLoginPage();
        } catch (Exception ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void showAccountSettings(ActionEvent ev){
        try {
            main.showAccountSettings();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setMain(Main main)
    {
        this.main=main;
    }
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
