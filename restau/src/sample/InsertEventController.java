package sample;

import DB.DBInsertEvent;
import DB.DBInsertFood;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertEventController {

    private Main main;
    @FXML
    private TextField event_id;
    @FXML
    private TextField name;
    @FXML
    private TextField venue;
    @FXML
    private DatePicker start_date;
    @FXML
    private DatePicker end_date;
    @FXML
    private TextField discount;
    @FXML
    private TextField event_type;
    @FXML
    private Button back;

    @FXML
    public Button done;

    @FXML
    void backAction(ActionEvent Event)
    {
        try {
            main.showEvent();
        } catch (IOException ex) {
            Logger.getLogger(InsertFoodController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void doneAction(ActionEvent Event)
    {
        if(name.getText()!=null && venue.getText()!=null && start_date.getEditor().getText()!=null &&
                end_date.getEditor().getText()!=null && discount.getText()!=null && event_type.getText()!=null)
        {
            List<String> Insertlist=new ArrayList<>();
            Insertlist.add(event_id.getText());
            Insertlist.add(name.getText());
            Insertlist.add(venue.getText());
            Insertlist.add(start_date.getEditor().getText());
            Insertlist.add(end_date.getEditor().getText());
            Insertlist.add(discount.getText());
            Insertlist.add(event_type.getText());
            boolean success= false;
            try {
                success = new DBInsertEvent().validateInsert(Insertlist);
            } catch (Exception e) {
                e.printStackTrace();
                //success = false;
            }
            if(success)
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Inserton Successful");
                alert.setHeaderText("Insertion Successful");
                alert.setContentText("Press back to check the updated table");
                alert.showAndWait();
                event_id.setText(null);
                name.setText(null);
                venue.setText(null);
                start_date.getEditor().setText(null);
                end_date.getEditor().setText(null);
                discount.setText(null);
                event_type.setText(null);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Credentials");
                alert.setHeaderText("Incorrect Credentials");
                alert.setContentText("The Event_Id you entered already exists");
                alert.showAndWait();
            }
        }
    }

    void setMain(Main main)
    {
        this.main = main;
    }


}
