package sample;

import DB.DBInsertIngredients;
import DB.DBUpdateFood;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertIngredientsController {
    private Main main;
    @FXML
    private TextField name;
    @FXML
    private TextField type;
    @FXML
    private TextField cost;


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
    void backAction(ActionEvent Event)
    {
        try {
            main.showIngredients();
        } catch (IOException ex) {
            Logger.getLogger(InsertFoodController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void doneAction(ActionEvent Event)
    {
        if(name.getText()!=null && type.getText()!=null && cost.getText()!=null)
        {
            List<String> Insertlist=new ArrayList<>();
            //Insertlist.add(food_id.getText());
            Insertlist.add(name.getText());
            Insertlist.add(type.getText());
            Insertlist.add(cost.getText());
            //Insertlist.add(origin.getText());
            boolean success=new DBInsertIngredients().validateInsert(Insertlist);
            if(success)
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Insertion Successful");
                alert.setHeaderText("Insertion Successful");
                alert.setContentText("Press back to check the updated table");
                alert.showAndWait();
                //food_id.setText(null);
                name.setText(null);
                type.setText(null);
                cost.setText(null);
                //origin.setText(null);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Credentials");
                alert.setHeaderText("Incorrect Credentials");
                alert.setContentText("The Ingredient_name you entered already exists");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void saveFood(ActionEvent event){
        List<String>Updatelist=new ArrayList<>();
        //Updatelist.add(food_id.getText());
        Updatelist.add(name.getText());
        Updatelist.add(type.getText());
        Updatelist.add(cost.getText());
        //Updatelist.add(origin.getText());
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


}
