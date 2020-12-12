/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import sample.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.control.Alert;

public class VariousQuery {
    String name;
    public String getUsername(int employee_id)
    {
        String name=" ";
        String sql="SELECT first_name,last_name from employee where employee_id="+employee_id+";";
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while (rs.next())
            {
                name=rs.getString(1)+" "+rs.getString(2);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception Hoiache");
        }
        return name;
    }
    public void InsertFromWaiterWindow(List<String>InfoList,boolean value) throws ParseException
    {
        //String Employee_id="2";
        String Employee_id= Constants.ID;
        String Customer_id=InfoList.get(0);
        String Event_Id=InfoList.get(1);
        String Table_No=InfoList.get(2);
        String Time=InfoList.get(3);
        String date=InfoList.get(4);
        String food_id=InfoList.get(5);
        String ammount=InfoList.get(6);
        DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
        Date mydate=formatter.parse(date);
        java.sql.Date sqlDate=new java.sql.Date(mydate.getTime());
        DateFormat timeformatter=new SimpleDateFormat("HH:mm");
        java.sql.Time sqlTime=new java.sql.Time(timeformatter.parse(Time).getTime());
        if(value){
        String sql= "Insert into service_report(event_id,customer_id,employee_id,table_number,date,time,rating,payment_status) values(?,?,?,?,?,?,-1,?)";
        
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,Event_Id);
           pst.setString(2,Customer_id);
           pst.setString(3,Employee_id);
           pst.setString(4,Table_No);
           pst.setDate(5,sqlDate);
           pst.setTime(6,sqlTime);
           pst.setString(7,"paid");
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(sql);
        }
        
        name=" ";
        String sql2="Select service_number from service_report where table_number="+Table_No+" and date='"+sqlDate+"' and time="+"'"+sqlTime+"'";
        System.out.println(sql2);
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql2);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next())
            {
                name=rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception Hoiache");
        }
        //System.out.println("Service No:"+name);
        }
        String sql="Insert into delivery(service_number,food_id,delivery_address,amount) values(?,?,?,?)";
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,name);
           pst.setString(2,food_id);
           pst.setString(3,"-1");
           pst.setString(4,ammount);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(sql);
        }
   }
   public void InsertFromMarketerWindow(List<String>InfoList,boolean value) throws ParseException
    {
        //String Employee_id="2";
        String Employee_id= Constants.ID;
        String Time=InfoList.get(0);
        String date=InfoList.get(1);
        String food_id=InfoList.get(2);
        String ammount=InfoList.get(3);
        DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
        Date mydate=formatter.parse(date);
        java.sql.Date sqlDate=new java.sql.Date(mydate.getTime());
        DateFormat timeformatter=new SimpleDateFormat("HH:mm");
        java.sql.Time sqlTime=new java.sql.Time(timeformatter.parse(Time).getTime());
        if(value){
        String sql= "Insert into marketting_report(employee_id,date,time) values(?,?,?)";
        
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,Employee_id);
           pst.setDate(2,sqlDate);
           pst.setTime(3,sqlTime);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            
            e.printStackTrace();
            System.out.println(sql);
        }
        
        name=" ";
        String sql2="Select marketting_number from marketting_report where date='"+sqlDate+"' and time="+"'"+sqlTime+"'";
        System.out.println(sql2);
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql2);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next())
            {
                name=rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception Hoiache");
        }
        //System.out.println("Service No:"+name);
        }
        String sql="Insert into marketting_shipment(marketting_number,ingredient_name,amount) values(?,?,?)";
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,name);
           pst.setString(2,food_id);
           pst.setString(3,ammount);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error Occured");
            alert.setContentText("The Ingredient is not listed in the Database");
            alert.showAndWait();
            //e.printStackTrace();
            System.out.println(sql);
        }
   }
   public List<List<String>> getAllHistory(String employee_id)
    {
        String sql = "SELECT * FROM service_report where employee_id="+employee_id;
        System.out.println(sql);
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
                row.add(rs.getString("service_number"));
                row.add(rs.getString("event_id"));
                row.add(rs.getString("customer_id"));
                row.add(rs.getString("table_number"));
                row.add(rs.getString("date"));
                row.add(rs.getString("time"));
                row.add(rs.getString("rating"));
                row.add(rs.getString("delivery_status"));
                row.add(rs.getString("payment_status"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return resultList;
    }
    public List<List<String>> getAllMarkettingHistory(String employee_id)
    {
        String sql = "SELECT  marketting_number,date,time FROM marketting_report where employee_id="+employee_id;
        System.out.println(sql);
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
                row.add(rs.getString("marketting_number"));
                row.add(rs.getString("date"));
                row.add(rs.getString("time"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            
        }
        return resultList;
    }
    public List<String>LoadProfile()
    {
        String sql="SELECT e1.*,e2.job_title from employee e1 join jobs e2 on (e1.job_id=e2.job_id) where e1.employee_id="+Constants.ID;
        List<String>row=new ArrayList<>();
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next())
            {
                row.add(rs.getString("employee_id"));
                row.add(rs.getString("job_id"));
                row.add(rs.getString("first_name"));
                row.add(rs.getString("last_name"));
                row.add(rs.getString("phone_number"));
                row.add(rs.getString("hire_date"));
                row.add(rs.getString("birth_date"));
                row.add(rs.getString("email"));
                row.add(rs.getString("salary"));
                row.add(rs.getString("commission_pct"));
                row.add(rs.getString("gender"));
                row.add(rs.getString("job_title"));
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(row);
        return row;
    }
}
