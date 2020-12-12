/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import DB.Customer;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
public class CustomerProfileController implements Initializable {
    private Main main;
    private boolean init=true;
    @FXML
    private Label showLabel;
    @FXML
    private Button AccountSettings;
    @FXML
    private Button HOME;
    @FXML
    private Button LogOut;
    @FXML
    private Label Customer_ID;
    @FXML
    private Label Name;
    @FXML
    private Label Age;
    @FXML
    private Label Phone_Number;
    @FXML
    private Label Email;
    @FXML
    private Label Address;
    @FXML
    private Label Customer_Type;
    @FXML
    private Label Total_Spent;
    void setMain(Main main)
    {
        this.main=main;
    }
    void Init()
    {
        if(init)
        {
            init=false;
            showLabel.setText("Welcome "+new Customer().getUserName(Constants.ID));
            List<String>profileLoad=new Customer().LoadProfile();
            Customer_ID.setText(profileLoad.get(0));
            Name.setText(profileLoad.get(1));
            Age.setText(profileLoad.get(2));
            Address.setText(profileLoad.get(3));
            Phone_Number.setText(profileLoad.get(4));
            Email.setText(profileLoad.get(5));
            Customer_Type.setText(profileLoad.get(6));
            Total_Spent.setText(profileLoad.get(7));
        }
    }
    @FXML
    void HOMEAction(ActionEvent event)
    {
        try {
            main.ShowCustomerWindow();
        } catch (IOException ex) {
            Logger.getLogger(CustomerProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
            main.showCustomerAccountSettings();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
