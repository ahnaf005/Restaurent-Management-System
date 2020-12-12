package sample;

import DB.Users;
import DB.VariousQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

//import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import org.omg.PortableInterceptor.ACTIVE;

import javax.swing.text.html.ImageView;

public class AdminViewController {



    private Main main;
    @FXML
    private Label loginAs;
    @FXML
    private Label loginId;

    @FXML
    private Button profileBtn;

    ObservableList<User> data;

    @FXML
    private Button customerBtn;
    @FXML
    private Button employeeBtn;
    @FXML
    private Button foodBtn;
    @FXML
    private Button ingredientBtn;
    @FXML
    private Button marketing_reportBtn;
    @FXML
    private Button marketing_shipmentBtn;
    @FXML
    private Button service_reportBtn;
    @FXML
    private Button jobBtn;
    @FXML
    private Button deliveryBtn;
    @FXML
    private Button eventBtn;
    //private boolean init = true;
    private boolean init = false;

    private void initializeColumns()
    {
        TableColumn<User, String> userNameCol = new TableColumn<User, String>("Username");
        userNameCol.setMinWidth(100);
        userNameCol.setCellValueFactory(new PropertyValueFactory< User, String>("userName"));
        TableColumn<User, String> passwordCol = new TableColumn<User, String>("Password");
        passwordCol.setMinWidth(100);
        passwordCol.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        TableColumn<User, String> fullNameCol = new TableColumn<User, String>("Full Name");
        fullNameCol.setMinWidth(200);
        fullNameCol.setCellValueFactory(new PropertyValueFactory<User,String>("fullName"));

        //tableView.getColumns().addAll(userNameCol, passwordCol, fullNameCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new Users().getAllUsers();
        for (List<String> row : userDataList)
        {
            data.add(new User(row.get(0), row.get(1), row.get(2)));
        }

        //tableView.setEditable(true);
        //tableView.setItems(data);
        //data.get(0).setFirstName("Jacob2");

    }
    void setMain(Main main)
    {
        this.main = main;
    }


    void setText(String str)
    {
        if(str!=null)
            loginAs.setText(str);
        loginId.setText("0");
    }

    void setText()
    {
        String Name = new VariousQuery().getUsername(Integer.parseInt(Constants.ID));
        loginAs.setText(Name);
        loginId.setText("0");
    }


    @FXML
    void profileShow(ActionEvent event){
        try {
            main.showProfile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void foodViewShow(ActionEvent event){
        try {
            main.showTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void  customerShow(ActionEvent event){
        try{
            main.showCustomer();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void  employeeShow(ActionEvent event){
        try{
            main.showEmployee();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void  jobShow(ActionEvent event){
        try{
            main.showJobs();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void  ingredientShow(ActionEvent event){
        try{
            main.showIngredients();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void  eventShow(ActionEvent event){
        try{
            main.showEvent();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void  deliveryShow(ActionEvent event){
        try{
            main.showDelivery();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void  serviceReportShow(ActionEvent event){
        try{
            main.showServiceReport();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void  marketingShipmentShow(ActionEvent event){
        try{
            main.showMarketingShipment();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void  marketingReportShow(ActionEvent event){
        try{
            main.showMarketingReport();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void subQuery(ActionEvent event)
    {
        try {
            main.maxSalaryShow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void LogOutAction(ActionEvent event)
    {
        try {
            main.showLoginPage();
        } catch (Exception ex) {
            Logger.getLogger(WaiterWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void JoinQuery(ActionEvent event){
        try {
            main.joinShow();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
