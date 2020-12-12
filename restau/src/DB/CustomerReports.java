/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import sample.Constants;

public class CustomerReports {
    public List<List<String>> getAllCustomers()
    {
        String sql = "SELECT customer_id,name,phone_number,customer_type,Spend_Customer(customer_id)total_spent FROM customer order by total_spent DESC";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("customer_id"));
                row.add(rs.getString("name"));
                row.add(rs.getString("phone_number"));
                row.add(rs.getString("customer_type"));
                row.add(rs.getString("total_spent"));
                //row.add(rs.getString("lname"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //System.out.printf(resultList.toString());
        return resultList;
    }
    public void UpdateCustomerType(String ID,String type)
    {
        String sql= "UPDATE customer SET customer_type";

        String sql1 = "='"+type+"' where customer_id="+ID;
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql+sql1);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("This Customer DoesNot Exist");
            alert.showAndWait();
            //e.printStackTrace();
            System.out.println(sql+sql1);
        }
    }
    public void UpdateAllCustomerTypes(String ThresHold)
    {
        String sql= "UPDATE customer SET customer_type='regular' where Spend_Customer(customer_id)<"+ThresHold;
        String sql1= "UPDATE customer SET customer_type='premium' where Spend_Customer(customer_id)>="+ThresHold;
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
            PreparedStatement pst1 = con.prepareStatement(sql1);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst1.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            pst1.executeUpdate();
            pst1.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(sql+sql1);
        }
    }
    public List<String>getStats(String ID)
    {
        String sql="SELECT name,Spend_Customer(customer_id)total_spent from customer where customer_id="+ID;
        List<String>row=new ArrayList<>();
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next())
            {
                row.add(rs.getString("name"));
                row.add(rs.getString("total_spent"));
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //System.out.println(row);
        return row;
    }
}
