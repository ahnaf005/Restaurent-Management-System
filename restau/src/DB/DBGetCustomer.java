package DB;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DBGetCustomer {

    boolean available = false;
    private String customerID=null;

    public boolean getCustomer(List<String> customerList)
    {
        String name=customerList.get(0);
        String age=customerList.get(1);
        String address=customerList.get(2);
        String phoneNo=customerList.get(3);
        String email=customerList.get(4);

        String sql = "SELECT * FROM customer WHERE email = '"+email+ "' AND phone_number= "+ phoneNo;

        try{
            Connection con = new OracleDBMS().getConnection();
            Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1, userName);
//            pst.setString(2, password);
            st.execute("USE restaurant");
            ResultSet rs = st.executeQuery(sql);
            System.out.println(rs.toString());

            //ResultSet rs = pst.executeQuery();
            if (rs.next())
            {
                available = true;
                //return available;
            }else
                available = false;

            //System.out.println(userType);
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        return available;
    }


    public void showCustomerID(String phoneNo, String email, String password)
    {
        String sql = "SELECT * FROM customer WHERE email= '"+email+ "' AND phone_number= "+ phoneNo+"";

        try{
            Connection con = new OracleDBMS().getConnection();
            Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                customerID = rs.getString("customer_id");
                new DBAdminstration().addUser(password,"customer",customerID);
            }
            pst.close();
            con.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Insertion Successful");
            alert.setHeaderText("UserID: "+customerID);
            alert.setContentText("Use this customer ID for Customer Account login.");
            alert.showAndWait();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //System.out.println(rs.getString("name"));
            System.out.println(sql);
        }


    }

    public String getCustomerID() {
        return customerID;
    }
}
