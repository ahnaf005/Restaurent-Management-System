package sample;

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

public class AccountSettingsWindowController {
    private Main main;
    private boolean init=true;
    private int employee_id;

    @FXML
    TextField employeeIdField;
    @FXML
    TextField jobIdField;
    @FXML
    TextField fNameField;
    @FXML
    TextField lNameField;
    @FXML
    TextField jobTitleField;
    @FXML
    TextField phoneNoField;
    @FXML
    TextField hireDateField;
    @FXML
    TextField birthDateField;
    @FXML
    TextField emailField;
    @FXML
    TextField salaryField;
    @FXML
    TextField commissionField;
    @FXML
    TextField genderField;
    List<String> Profileload;

    public void setFields(String emp, String jobId, String fName, String lName, String phnNo, String hDate, String bDate,
                          String email, String salary, String comm, String gender, String jobTitle){
        this.employeeIdField.setText(emp);
        this.jobIdField.setText(jobId);
        this.fNameField.setText(fName);
        this.lNameField.setText(lName);
        this.phoneNoField.setText(phnNo);
        this.hireDateField.setText(hDate);
        this.birthDateField.setText(bDate);
        this.emailField.setText(email);
        this.salaryField.setText(salary);
        this.commissionField.setText(comm);
        this.genderField.setText(gender);
        this.jobTitleField.setText(jobTitle);

    }

    public void load()
    {
        //if(init)
        {
            employee_id=Integer.parseInt(Constants.ID);
            init=false;
            //showLabel.setText("Welcome "+new VariousQuery().getUsername(employee_id));
            Profileload=new VariousQuery().LoadProfile();
            setFields(Profileload.get(0), Profileload.get(1), Profileload.get(2), Profileload.get(3), Profileload.get(4), Profileload.get(5),
                    Profileload.get(6), Profileload.get(7), Profileload.get(8), Profileload.get(9), Profileload.get(10), Profileload.get(11));
        }
        if(Constants.userType.equals("admin"))
        {
            employeeIdField.setEditable(true);
            jobIdField.setEditable(true);
            jobTitleField.setEditable(true);
            salaryField.setEditable(true);
            commissionField.setEditable(true);
            hireDateField.setEditable(true);
            genderField.setEditable(true);
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
            else if(Constants.userType.equals("manager"))
            {
                main.showManagerWindow();
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
    void saveSettings(ActionEvent event)
    {
        //List<String> employeeDetails =
        Profileload.set(0,employeeIdField.getText());
        Profileload.set(1,jobIdField.getText());
        Profileload.set(2,fNameField.getText());
        Profileload.set(3,lNameField.getText());
        Profileload.set(4,phoneNoField.getText());
        Profileload.set(5,hireDateField.getText());
        Profileload.set(6,birthDateField.getText());
        Profileload.set(7,emailField.getText());
        Profileload.set(8,salaryField.getText());
        Profileload.set(9,commissionField.getText());
        Profileload.set(10,genderField.getText());
        Profileload.set(11,jobTitleField.getText());
        boolean success = new DBUpdateProfile().employeeProfileUpdate(Profileload);
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
