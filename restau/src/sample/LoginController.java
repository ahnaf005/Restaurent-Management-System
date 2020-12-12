package sample;

import DB.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

import java.io.IOException;

public class LoginController
{

    private Main main;

    @FXML
    private TextField userText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button resetButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button createAccount;

    @FXML
    void loginAction(ActionEvent event)
    {
        //String validUserName = "admin";
        //String validPassword = "123";
        String userID = userText.getText();
        Constants.setID(userID);

        //userID = "0";
        String password = passwordText.getText();
        //password = "hridoy";
        Users users = new Users();
        //boolean success = new Users().validateLogin(userName, password);
        boolean success = users.validateLogin(userID, password);
        String userType = users.userType;
        if (success)
        {
            // successful login
            try
            {

                //main.showTable();
                if(userType!=null) {
                    //main.showUserWindow(userType);
                    main.processUserType(userType);
                    Constants.setUserType(userType);
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        } else
        {
            // failed login
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }

    }


@FXML
    void resetAction(ActionEvent event) {
        userText.setText(null);
        passwordText.setText(null);
    }

    void setMain(Main main) {
        this.main = main;
    }


    @FXML
    void createNewAccount(ActionEvent event){
        try {
            main.createAccountWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
