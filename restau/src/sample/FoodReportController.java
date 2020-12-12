/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import DB.Reports;
import DB.DBFoods;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Alavi
 */
public class FoodReportController implements Initializable {
    ObservableList<FoodReportClass>data;
    Main main;
    @FXML
    private ComboBox Time1;
    @FXML
    private ComboBox Time2;
    @FXML
    private Button GetResults1;
    @FXML
    private Button GetResults2;
    @FXML
    private Button Clear;
    @FXML
    private Button Back;
    @FXML
    private TableView  table;
    @FXML
    private boolean init=true;
    void Init()
    {
         ObservableList<String>months=FXCollections.observableArrayList(
                "6:00","7:00","8:00","9:00","10:00",
                "11:00","12:00","13:00","14:00","15:00",
                "16:00","17:00","18:00","19:00","20:00","21:00"
                ,"22:00","23:00","24:00");
         Time1.getItems().addAll(months);
         Time2.getItems().addAll(months);
    }
    private void initializeColumns()
    {
        TableColumn<FoodReportClass, String> food_idCol = new TableColumn<>("Food_id");
        food_idCol.setMinWidth(100);
        food_idCol.setCellValueFactory(new PropertyValueFactory<FoodReportClass,String>("food_id"));

        TableColumn<FoodReportClass, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<FoodReportClass,String>("name"));

        TableColumn<FoodReportClass, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(200);
        typeCol.setCellValueFactory(new PropertyValueFactory<FoodReportClass, String >("type"));

        TableColumn<FoodReportClass, String> costCol = new TableColumn<>("Cost");
        costCol.setMinWidth(200);
        costCol.setCellValueFactory(new PropertyValueFactory<FoodReportClass, String>("cost"));

        TableColumn<FoodReportClass, String> originCol = new TableColumn<>("Origin");
        originCol.setMinWidth(200);
        originCol.setCellValueFactory(new PropertyValueFactory<FoodReportClass, String>("origin"));
        
        TableColumn<FoodReportClass, String> total_sellCol = new TableColumn<>("Total_Sell");
        total_sellCol.setMinWidth(200);
        total_sellCol.setCellValueFactory(new PropertyValueFactory<FoodReportClass, String>("total_sell"));
        
        table.getColumns().addAll(food_idCol, nameCol, typeCol, costCol, originCol,total_sellCol);
    }

    public void load(int n)
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        //List<List<String>> userDataList = new Users().getAllUsers();
        if(n==1){
            List<List<String>> foodDataList = new Reports().getAllFoodsSells();
            for (List<String> row : foodDataList)
            {
                FoodReportClass u = new FoodReportClass(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4),row.get(5));
                //data.add(new User(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4)));
                data.add(u);
            }
            System.out.println(data);
        }
        else if(n==2)
        {
            List<List<String>> foodDataList = new Reports().getTimeFoodsSells(Time1.getValue().toString(),Time2.getValue().toString());
            for (List<String> row : foodDataList)
            {
                FoodReportClass u = new FoodReportClass(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4),row.get(5));
                //data.add(new User(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4)));
                data.add(u);
            }
            System.out.println(data);
        }
        table.setEditable(true);
        table.setItems(data);
        //data.get(0).setFirstName("Jacob2");

    }
    void setMain(Main main)
    {
        this.main=main;
    }
    @FXML
    void BackAction(ActionEvent event)
    {
        try {
            main.showReports();
        } catch (IOException ex) {
            Logger.getLogger(FoodReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void ClearAction(ActionEvent event)
    {
        for ( int i = 0; i<table.getItems().size(); i++) {
            table.getItems().clear();
        }
        init=true;
    }
    @FXML
    void GetResults1Action(ActionEvent event)
    {
        load(1);
    }
    @FXML
    void GetResults2Action(ActionEvent event)
    {
        if(Time1.getValue()!=null && Time2.getValue()!=null)
            load(2);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
