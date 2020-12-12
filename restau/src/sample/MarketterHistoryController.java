/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB.VariousQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Alavi
 */
public class MarketterHistoryController implements Initializable {
    private Main main;
    @FXML
    private TableView tableView;
     ObservableList<MarkettingHistory> data;

    @FXML
    private Button button;

    private boolean init = true;
    private void initializeColumns()
    {
        TableColumn<MarkettingHistory, String> markettingnumCol = new TableColumn<MarkettingHistory, String>("Marketting_Number");
        markettingnumCol.setMinWidth(100);
        markettingnumCol.setCellValueFactory(new PropertyValueFactory< MarkettingHistory, String>("marketting_number"));

        
         TableColumn<MarkettingHistory, String> dateCol = new TableColumn<MarkettingHistory, String>("Date");
        dateCol.setMinWidth(100);
        dateCol.setCellValueFactory(new PropertyValueFactory<MarkettingHistory, String>("date"));
        
         TableColumn<MarkettingHistory, String> timeCol = new TableColumn<MarkettingHistory, String>("Time");
        timeCol.setMinWidth(100);
        timeCol.setCellValueFactory(new PropertyValueFactory<MarkettingHistory, String>("time"));
        
        //emailCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        /*emailCol.setOnEditCommit(
         (TableColumn.CellEditEvent<Person, String> t) ->
         t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue())
         );*/

        tableView.getColumns().addAll(markettingnumCol,dateCol,timeCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new VariousQuery().getAllMarkettingHistory(Constants.ID);
        System.out.println(userDataList.size());
        for (List<String> row : userDataList)
        {
            data.add(new MarkettingHistory(row.get(0), row.get(1), row.get(2)));
            System.out.println(row.get(0)+" "+row.get(1)+" "+row.get(2));
        }
        tableView.setEditable(true);
        tableView.setItems(data);
        //data.get(0).setFirstName("Jacob2");

    }
    @FXML
    void ButtonAction(ActionEvent event)
    {
        try {
            main.ShowMarketerWindow();
        } catch (IOException ex) {
            Logger.getLogger(WaiterHistoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void setMain(Main main)
    {
        this.main=main;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
