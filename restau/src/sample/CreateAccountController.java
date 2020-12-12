package sample;

import DB.DBGetCustomer;
import DB.DBInsertCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountController {

    private Main main;
    @FXML
    private Button backBtn;
    @FXML
    private Button createBtn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneNoField;
    @FXML
    private TextField passwordField;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void backButtonAction(ActionEvent event)
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
    void createAccount(ActionEvent event)
    {
        String name = nameField.getText();
        String age = ageField.getText();
        String address = addressField.getText();
        String phoneNo = phoneNoField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();



        if(name.equals("") || age.equals("") || address.equals("") || phoneNo.equals("") || email.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Field Empty");
            alert.setHeaderText("Field can't be empty.");
            alert.setContentText("You must Fill up every field.");
            alert.showAndWait();
        }
        else
        {
            List<String > customerList = new ArrayList<>();
            customerList.add(name);
            customerList.add(age);
            customerList.add(address);
            customerList.add(phoneNo);
            customerList.add(email);
            customerList.add(password);
            boolean success=new DBInsertCustomer().validateInsert(customerList);
            if(success)
            {
                new DBGetCustomer().showCustomerID(phoneNo,email,password);
                nameField.setText(null);
                ageField.setText(null);
                phoneNoField.setText(null);
                emailField.setText(null);
                addressField.setText(null);
                passwordField.setText(null);
            }
        }


    }

}
