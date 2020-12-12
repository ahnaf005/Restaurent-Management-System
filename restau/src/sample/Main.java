package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    Stage stage;
    public String adminType="";

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        //showLoginPage();
        showpic();
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("User Verification");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showpic() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("pic.fxml"));
        Parent root = loader.load();

        // Loading the controller
        PicController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("User Verification");
        stage.setScene(new Scene(root));
        stage.show();
    }

//    public void processUserType(String userType) throws Exception {
//        if(userType.equals("waiter")){
//            ShowWaiterWindow();
//        }
//        else if(userType.equals("admin")) showAdminWindow(userType);
//        else if(userType.equals("marketer")) ShowMarketerWindow();
//        else showAdminWindow(userType);
//    }

    public void processUserType(String userType) throws Exception {
        if(userType.equals("waiter")){
            ShowWaiterWindow();
        }
        //else if(userType.equals("admin")) showAdminWindow(userType);
        else if(userType.equals("admin")) showAdminWindow();
        else if(userType.equals("marketer")) ShowMarketerWindow();
        else if(userType.equals("manager")) showManagerWindow();
        else if(userType.equals("customer")) ShowCustomerWindow();
        else if(userType.equals("delivery_boy")) showDeliveryBoyWindow();
        else showAdminWindow();
        //else showAdminWindow(userType);
    }

    public void showUserWindow(String admin_type) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("userWindow.fxml"));
        Parent root = loader.load();

        // Loading the controller
        UserWindowController controller = loader.getController();
        adminType = admin_type;
        controller.setText(admin_type);
        //controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("User Window");
        Scene sc = new Scene(root);
        //sc.getStylesheets().add("style1.css");
        stage.setScene(sc);
        stage.show();
    }
    public void showAdminWindow() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("adminView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        AdminViewController controller = loader.getController();
        //adminType = admin_type;
        //controller.setText(admin_type);
        controller.setText();
        //controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Admin Window");
        //Scene sc = new Scene(root);
        //sc.getStylesheets().add("style1.css");
        //stage.setScene(sc);
        stage.setScene(new Scene(root));
        stage.setY(100);
        stage.setX(400);
        stage.show();
    }

    public void showTable() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("foodView.fxml"));
        Parent root = loader.load();
        
        // Loading the controller
        FoodViewController controller = loader.getController();
        controller.load();
        controller.setMain(this);
        
        // Set the primary stage
        stage.setTitle("DBFoods");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showRatingWindow() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RatingAndPayment.fxml"));
        Parent root = loader.load();
        
        // Loading the controller
        RatingAndPaymentController controller = loader.getController();
        controller.load();
        controller.setMain(this);
        
        // Set the primary stage
        stage.setTitle("DBFoods");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showCustomerDeliveredFood(String Service_Number) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CustomerDeliveredFood.fxml"));
        Parent root = loader.load();
        
        // Loading the controller
        CustomerDeliveredFoodController controller = loader.getController();
        controller.load(Service_Number);
        controller.setMain(this);
        
        // Set the primary stage
        stage.setTitle("Delivered Foods");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showCustomerReports() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CustomerReport.fxml"));
        Parent root = loader.load();
        
        // Loading the controller
        CustomerReportController controller = loader.getController();
        controller.load();
        controller.setMain(this);
        
        // Set the primary stage
        stage.setTitle("Reports");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void InsertFoodWindow() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InsertFood.fxml"));
        Parent root = loader.load();
        
        // Loading the controller
        InsertFoodController controller = loader.getController();
        controller.showOrHideAllFields(1);
        controller.getFoodDetails.setDisable(true);
        controller.done.setDisable(false);
        controller.done.setOpacity(1);
        controller.saveBtn.setOpacity(0);
        controller.saveBtn.setDisable(true);
        controller.setMain(this);
        
        // Set the primary stage
        stage.setTitle("Food");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void InsertJobs() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InsertJobs.fxml"));
        Parent root = loader.load();
        
        // Loading the controller
        InsertJobsController controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Jobs");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void InsertEmployee() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InsertEmployee.fxml"));
        Parent root = loader.load();
        
        // Loading the controller
        InsertEmployeeController controller = loader.getController();
        controller.init();
        controller.setMain(this);
        stage.setTitle("Employee");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void InsertIngredients() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InsertIngredients.fxml"));
        Parent root = loader.load();

        // Loading the controller
        InsertIngredientsController controller = loader.getController();
        //controller.;
        controller.setMain(this);
        stage.setTitle("Ingredients");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void InsertEvent() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InsertEvent.fxml"));
        Parent root = loader.load();

        // Loading the controller
        InsertEventController controller = loader.getController();
        //controller.;
        controller.setMain(this);
        stage.setTitle("Events");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void InsertCustomer() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InsertCustomer.fxml"));
        Parent root = loader.load();

        // Loading the controller
        InsertCustomerController controller = loader.getController();
        //controller.;
        controller.setMain(this);
        stage.setTitle("Customer Insert");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void UpdateFoodWindow() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InsertFood.fxml"));
        Parent root = loader.load();

        // Loading the controller
        InsertFoodController controller = loader.getController();
        //controller.load();
        controller.showFoodUpdateDetails();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Food");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void createAccountWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("createAccountView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        CreateAccountController controller = loader.getController();
        //controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Create Customer Account");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void maxSalaryShow() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("maxSalaryShow.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MaxSalaryController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Max Salary of each Job Title");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void joinShow() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("joinTable.fxml"));
        Parent root = loader.load();

        // Loading the controller
        JoinTableController controller = loader.getController();
        //controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Service Report");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void ShowCustomerWindow() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CustomerWindow.fxml"));
        Parent root = loader.load();

        // Loading the controller
        CustomerWindowController controller = loader.getController();
        //controller.load();
        controller.load();
        controller.setMain(this);
        // Set the primary stage
        stage.setTitle("Customer Window");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showDeliveryBoyWindow() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DeliveryBoyWindow.fxml"));
        Parent root = loader.load();

        // Loading the controller
        DeliveryBoyWindowController controller = loader.getController();
        controller.load();
        //controller.Initialize();
        controller.setMain(this);
        // Set the primary stage
        stage.setTitle("Delivery Boy Window");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void ShowCustomerProfile() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CustomerProfile.fxml"));
        Parent root = loader.load();

        // Loading the controller
        CustomerProfileController controller = loader.getController();
        //controller.load();
        controller.Init();
        controller.setMain(this);
        // Set the primary stage
        stage.setTitle("Customer Profile");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showCustomerAccountSettings() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CustomerAccountSettings.fxml"));
        Parent root = loader.load();

        // Loading the controller
        CustomerAccountSettingsController controller = loader.getController();
        controller.load();
        //controller.Init();
        controller.setMain(this);
        // Set the primary stage
        stage.setTitle("Settings");
        stage.setScene(new Scene(root));
        stage.show();
    }

    
    public void ShowWaiterWindow() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("WaiterWindow.fxml"));
        Parent root = loader.load();

        // Loading the controller
        WaiterWindowController controller = loader.getController();
        //controller.load();
        controller.Initialize();
        controller.setMain(this);
        // Set the primary stage
        stage.setTitle("Waiter Window");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showMarkettingHistory() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MarketterHistory.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MarketterHistoryController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("History");
        stage.setScene(new Scene(root));
        stage.show();
    }

public void ShowMarketerWindow() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MarketerWindow.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MarketerWindowController controller = loader.getController();
        //controller.load();
        controller.Initialize();
        controller.setMain(this);
        // Set the primary stage
        stage.setTitle("Marketer");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showServiceHistory() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("WaiterHistory.fxml"));
        Parent root = loader.load();

        // Loading the controller
        WaiterHistoryController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("History");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showProfile() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Profile.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ProfileController controller = loader.getController();
        controller.setMain(this);
        controller.Initialize();

        // Set the primary stage
        stage.setTitle("Profile");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void showCustomer() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Customer.fxml"));
        Parent root = loader.load();

        // Loading the controller
        CustomerTableController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        //controller.Initialize();

        // Set the primary stage
        stage.setTitle("Customer");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showEmployee() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EmployeeTableView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        EmployeeTableController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        //controller.Initialize();

        // Set the primary stage
        stage.setTitle("Employee");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showJobs() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("JobsTableView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        JobsTableController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        //controller.Initialize();

        // Set the primary stage
        stage.setTitle("Jobs");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showIngredients() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("IngredientsTableView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        IngredientsTableController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        //controller.Initialize();

        // Set the primary stage
        stage.setTitle("Ingredients");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showEvent() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EventTableView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        EventTableController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        //controller.Initialize();

        // Set the primary stage
        stage.setTitle("Events");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showDelivery() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DeliveryTableView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        DeliveryTableController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        //controller.Initialize();

        // Set the primary stage
        stage.setTitle("Delivery Table");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showMarketingShipment() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MarketingShipmentTableView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MarketingShipmentController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        //controller.Initialize();

        // Set the primary stage
        stage.setTitle("Marketing Shipment");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showMarketingReport() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MarketingReportTableView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MarketingReportTableController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        //controller.Initialize();

        // Set the primary stage
        stage.setTitle("Marketing Report");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showServiceReport() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ServiceReportTableView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ServiceReportController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        //controller.Initialize();

        // Set the primary stage
        stage.setTitle("Service Report");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void showAccountSettings() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountSettingsWindow.fxml"));
        Parent root = loader.load();

        // Loading the controller
        AccountSettingsWindowController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        //controller.Initialize();

        // Set the primary stage
        stage.setTitle("Account Settings");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void showManagerWindow() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ManagerView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ManagerViewController controller = loader.getController();
        controller.setText();
        //controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Manager Window");
        //Scene sc = new Scene(root);
        //sc.getStylesheets().add("style1.css");
        //stage.setScene(sc);
        stage.setScene(new Scene(root));
        stage.setY(100);
        stage.setX(400);
        stage.show();
    }
    public void showReports() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Reports.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ReportsController controller = loader.getController();
        //controller.load();
        controller.setMain(this);

        //controller.Initialize();

        // Set the primary stage
        stage.setTitle("Reports");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showProfitReport() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProfitReport.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ProfitReportController controller = loader.getController();
        controller.Load();
        //controller.Init();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Profile Report");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showFoodProfit() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FoodReport.fxml"));
        Parent root = loader.load();

        // Loading the controller
        FoodReportController controller = loader.getController();
        controller.Init();
        //controller.Init();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Food Report");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showDeliveryDetails(String servNo) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DeliveryDetails.fxml"));
        Parent root = loader.load();

        // Loading the controller
        DeliveryDetailsController controller = loader.getController();
        controller.setServNo(servNo);
        controller.load();
        //controller.Init();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Delivery Details");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showWaiterReports() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("WaiterReports.fxml"));
        Parent root = loader.load();

        // Loading the controller
        WaiterReportsController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Reports");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void showEventReports() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EventReports.fxml"));
        Parent root = loader.load();

        // Loading the controller
        EventReportsController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("DBFoods");
        stage.setScene(new Scene(root));
        stage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
