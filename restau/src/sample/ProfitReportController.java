/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import DB.Reports;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Alavi
 */
public class ProfitReportController implements Initializable {
    boolean init=true;
    Main main;
    @FXML
    private Button Go1;
    @FXML
    private Button Go2;
    @FXML
    private Button Go3;
    @FXML
    private Button Go4;
    @FXML
    private TextField Year1;
    @FXML
    private TextField Year2;
    @FXML
    private TextField Year3;
    @FXML
    private TextField Year4;
    @FXML
    private TextField Result1;
    @FXML
    private TextField Result2;
    @FXML
    private TextField Result3;
    @FXML
    private TextField Result4;
    @FXML
    private ComboBox Month1;
    @FXML
    private ComboBox Month2;
    @FXML
    private ComboBox Month3;
    @FXML
    private Button Clear;
    @FXML
    private Button Back;
    void Init()
    {
        ObservableList<String>months=FXCollections.observableArrayList(
                "Jan","Feb","Mar","Apr","May",
                "Jun","Jul","Aug","Sep","Oct",
                "Nov","Dec");
        Month1.getItems().addAll(months);
        Month2.getItems().addAll(months);
        Month3.getItems().addAll(months);
    }
    void Load()
    {
        if(init)
        {
            Init();
            init=false;
        }
    }
    void setMain(Main main)
    {
        this.main=main;
    }
    @FXML
    void Go1Action(ActionEvent event)
    {
        if(Year1.getText()!=null && Month1.getValue()!=null )
        {
            System.out.println("Hello");
           Result1.setText(new Reports().getMonthlySell(Year1.getText(),Month1.getValue().toString()));
        }
    }
    @FXML
    void Go2Action(ActionEvent event)
    {
        if(Year2.getText()!=null && Month2.getValue()!=null )
        {
            //System.out.println("Hello");
           Result2.setText(new Reports().getMonthlyExpense(Year2.getText(),Month2.getValue().toString()));
        }
    }
    @FXML
    void Go3Action(ActionEvent event)
    {
        if(Year3.getText()!=null && Month3.getValue()!=null )
        {
            //System.out.println("Hello");
           Result3.setText(new Reports().getMonthlyProfit(Year3.getText(),Month3.getValue().toString()));
        }
    }
    @FXML
    void Go4Action(ActionEvent event)
    {
        if(Year4.getText()!=null)
        {
            //System.out.println("Hello");
           Result4.setText(new Reports().getYearlyProfit(Year4.getText()));
        }
    }
    @FXML
    void BackAction(ActionEvent event)
    {
        try {
            main.showReports();
        } catch (IOException ex) {
            Logger.getLogger(ProfitReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void ClearAction()
    {
        Year1.setText(null);
        Year2.setText(null);
        Year3.setText(null);
        Year4.setText(null);
        Result1.setText(null);
        Result2.setText(null);
        Result3.setText(null);
        Result4.setText(null);
                
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
