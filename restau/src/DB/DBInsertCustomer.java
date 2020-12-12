package DB;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class DBInsertCustomer {
    public boolean validateInsert(List<String> customerList)
    {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String name=customerList.get(0);
        String age=customerList.get(1);
        String address=customerList.get(2);
        String phoneNo=customerList.get(3);
        String email=customerList.get(4);
        String sql= "Insert into customer(name,age,address,phone_number, email, customer_type) values(?,?,?,?,?,?)";

        boolean exist = new DBGetCustomer().getCustomer(customerList);
        if(!exist)
        {
            try{
                Connection con = new OracleDBMS().getConnection();
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,name);
                pst.setString(2, age);
                pst.setString(3,address);
                pst.setString(4,phoneNo);
                pst.setString(5,email);
                pst.setString(6,"regular");
                pst.execute("USE restaurant");
                pst.executeUpdate();
                pst.close();
                con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.println(sql);
                System.out.println(name+" "+age+" "+address+" "+phoneNo+" "+email);
                success=false;
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("User already exists");
            alert.setHeaderText("User already exists");
            alert.setContentText("The user already exists.");
            alert.showAndWait();
            success = false;
        }

        return success;
    }




}
