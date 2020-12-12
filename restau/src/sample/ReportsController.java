/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Alavi
 */
public class ReportsController implements Initializable {

    Main main;
    @FXML
    private Button Back;
    void setMain(Main main)
    {
        this.main=main;
    }
    @FXML
    void ProfitAction(ActionEvent event)
    {
        try {
            main.showProfitReport();
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void CustomerAction(ActionEvent event)
    {
        try {
            main.showCustomerReports();
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void FoodAction(ActionEvent event)
    {
        try {
            main.showFoodProfit();
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void BackAction(ActionEvent event)
    {
        try {
            main.showManagerWindow();
        } catch (Exception ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void EventAction(ActionEvent event)
    {
        try {
            main.showEventReports();
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void WaiterAction(ActionEvent event)
    {
        try {
            main.showWaiterReports();
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
