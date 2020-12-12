/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import DB.DBFoods;
import DB.DBInsertFood;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB.DBUpdateFood;
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
public class InsertFoodController implements Initializable {
    private Main main;
    @FXML
    private TextField food_id;
    @FXML
    private TextField name;
    @FXML
    private TextField type;
    @FXML
    private TextField cost;
    @FXML
    private TextField origin;
    @FXML
    private Button back;
    @FXML
    public Button getFoodDetails;
    @FXML
    public Button saveBtn;
    @FXML
    public Button done;

    @FXML
    Label nameLabel;
    @FXML
    Label typeLabel;
    @FXML
    Label costLabel;
    @FXML
    Label originLabel;

    /**
     * Initializes the controller class.
     */

    @FXML
    void backAction(ActionEvent Event)
    {
        try {
            main.showTable();
        } catch (IOException ex) {
            Logger.getLogger(InsertFoodController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void doneAction(ActionEvent Event)
    {
        if(food_id.getText()!=null && name.getText()!=null && type.getText()!=null && cost.getText()!=null && origin.getText()!=null)
        {
            List<String>Insertlist=new ArrayList<>();
            Insertlist.add(food_id.getText());
            Insertlist.add(name.getText());
            Insertlist.add(type.getText());
            Insertlist.add(cost.getText());
            Insertlist.add(origin.getText());
            boolean success=new DBInsertFood().validateInsert(Insertlist);
            if(success)
            {
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                 alert.setTitle("Inserton Successful");
                 alert.setHeaderText("Insertion Successful");
                 alert.setContentText("Press back to check the updated table");
                 alert.showAndWait();
                 food_id.setText(null);
                 name.setText(null);
                 type.setText(null);
                 cost.setText(null);
                 origin.setText(null);
            }
            else
            {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Incorrect Credentials");
                 alert.setHeaderText("Incorrect Credentials");
                 alert.setContentText("The Food_id you entered already exists");
                 alert.showAndWait();
            }
        }
    }

    @FXML
    void saveFood(ActionEvent event){
        List<String>Updatelist=new ArrayList<>();
        Updatelist.add(food_id.getText());
        Updatelist.add(name.getText());
        Updatelist.add(type.getText());
        Updatelist.add(cost.getText());
        Updatelist.add(origin.getText());
        boolean success = new DBUpdateFood().updateFood(Updatelist);
        if(success)
        {
            Alert alert = new Alert((Alert.AlertType.CONFIRMATION));
            alert.setTitle("Successful");
            alert.setHeaderText("Successful in update");
            alert.setContentText("Successfully updated the details");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert((Alert.AlertType.ERROR));
            alert.setTitle("ERROR");
            alert.setHeaderText("update was unsuccessful");
            alert.setContentText("Details weren't updated.");
            alert.showAndWait();
        }
        System.out.println(success);
    }
    void setMain(Main main)
    {
        this.main = main;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }



    @FXML
    void getFoodDetails(ActionEvent event)
    {
        if(food_id.getText().equals(""))
        {
            Alert alert = new Alert((Alert.AlertType.ERROR));
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("Please Enter a valid Food_ID");
            alert.showAndWait();
        }
        else
        {
            List<String> foodDetails = new DBFoods().getOneFoodDetails(food_id.getText().toString());

            getFoodDetails.setDisable(true);
            name.setText(foodDetails.get(1));
            type.setText(foodDetails.get(2));
            cost.setText(foodDetails.get(3));
            origin.setText(foodDetails.get(4));
            showOrHideAllFields(1);
        }
    }

    void showOrHideAllFields(int flag)
    {
        nameLabel.setOpacity(flag);
        typeLabel.setOpacity(flag);
        costLabel.setOpacity(flag);
        originLabel.setOpacity(flag);
        getFoodDetails.setOpacity((flag+1)%2);
        saveBtn.setOpacity(flag);

        name.setOpacity(flag);
        type.setOpacity(flag);
        cost.setOpacity(flag);
        origin.setOpacity(flag);
    }

    public void showFoodUpdateDetails()
    {
        getFoodDetails.setDisable(false);
        done.setOpacity(0);
        done.setDisable(true);
        showOrHideAllFields(0);
        //List<String> foodDetails = new DBFoods().
    }
    
}
