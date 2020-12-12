package sample;

import DB.Customer;
import DB.DBUpdateProfile;
import DB.VariousQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerAccountSettingsController {

    private Main main;
    private boolean init=true;
    private int customer_id;

    @FXML
    TextField nameField;
    @FXML
    TextField ageField;
    @FXML
    TextField addressField;
    @FXML
    TextField phoneNoField;
    @FXML
    TextField emailField;
    @FXML
    TextField genderField;

    List<String> Profileload;

    public void setFields(String name, String age, String address, String phnNo,
                          String email, String gender){
        this.nameField.setText(name);
        this.ageField.setText(age);
        this.addressField.setText(address);
        this.phoneNoField.setText(phnNo);
        this.emailField.setText(email);
        this.genderField.setText(gender);
    }

    public void load()
    {
        //if(init)
        {
            customer_id=Integer.parseInt(Constants.ID);
            init=false;
            //showLabel.setText("Welcome "+new VariousQuery().getUsername(employee_id));
            Profileload=new Customer().LoadProfile();
            setFields(Profileload.get(1), Profileload.get(2), Profileload.get(3), Profileload.get(4), Profileload.get(5), "male");
        }

    }
    @FXML
    void HOMEAction(ActionEvent event)
    {
        try {
            if(Constants.userType.equals("waiter"))
                main.ShowWaiterWindow();
            else if(Constants.userType.equals("marketer"))
                main.ShowMarketerWindow();
            else if(Constants.userType.equals("admin")) {
                try {
                    main.showAdminWindow();
                    //main.showAdminWindow("admin");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else if(Constants.userType.equals("delivery_boy"))
            {
                main.showDeliveryBoyWindow();
            }
            else if(Constants.userType.equals("customer"))
            {
                main.ShowCustomerWindow();
            }
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
    void saveSettings(ActionEvent event)
    {
        //List<String> employeeDetails =
        Profileload.set(0,Constants.ID);
        Profileload.set(1,nameField.getText());
        Profileload.set(2,ageField.getText());
        Profileload.set(3,addressField.getText());
        Profileload.set(4,phoneNoField.getText());
        Profileload.set(5,emailField.getText());
        Profileload.set(6,genderField.getText());
        boolean success = new DBUpdateProfile().customerProfileUpdate(Profileload);
        if(success)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText("Update Notice.");
            alert.setContentText("Your Details have been successfully updated");
            alert.showAndWait();
            //HOMEAction(event);

        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Unsuccessful");
            alert.setHeaderText("Update Notice.");
            alert.setContentText("Your Details haven't been updated");
            alert.showAndWait();
        }
    }

    void setMain(Main main)
    {
        this.main=main;
    }


}
