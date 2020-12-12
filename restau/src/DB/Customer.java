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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sample.Constants;

public class Customer {
    String name;
    public String getUserName(String ID)
    {
        String name=" ";
        String sql="SELECT name from customer where customer_id="+ID+";";
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
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
            System.out.println("Exception Hoiache :D");
        }
        return name;
    }
    public List<String>LoadProfile()
    {
        String sql="SELECT *,Spend_Customer(customer_id)total_spent from customer where customer_id="+Constants.ID;
        List<String>row=new ArrayList<>();
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next())
            {
                row.add(rs.getString("customer_id"));
                row.add(rs.getString("name"));
                row.add(rs.getString("age"));
                row.add(rs.getString("address"));
                row.add(rs.getString("phone_number"));
                row.add(rs.getString("email"));
                row.add(rs.getString("customer_type"));
                row.add(rs.getString("total_spent"));
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
     public void InsertFromCustomerWindow(List<String>InfoList,boolean value) throws Exception
    {
        //String Employee_id="2";
        String Customer_id=Constants.ID;
        String Address=InfoList.get(0);
        String food_id=InfoList.get(1);
        String ammount=InfoList.get(2);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter dateform = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime=LocalTime.now();
        DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
        Date mydate=formatter.parse(dateform.format(localDate));
        java.sql.Date sqlDate=new java.sql.Date(mydate.getTime());
        DateFormat timeformatter=new SimpleDateFormat("HH:mm");
        java.sql.Time sqlTime=new java.sql.Time(timeformatter.parse(dtf.format(localTime)).getTime());
        System.out.println(sqlDate);
        System.out.println(sqlTime);
        if(value){
        String sql= "Insert into service_report(customer_id,date,time,delivery_status,payment_status) values(?,?,?,?,?)";
        
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,Customer_id);
           pst.setDate(2,sqlDate);
           pst.setTime(3,sqlTime);
           pst.setString(4,"no");
           pst.setString(5,"pending");
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
        String sql2="Select service_number from service_report where customer_id="+Customer_id+" and date='"+sqlDate+"' and time="+"'"+sqlTime+"'";
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
           pst.setString(3,Address);
           pst.setString(4,ammount);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            System.out.println(sql);
            throw new Exception();
        }
   }
   public List<List<String>> getAllCustomerServiceReports(String ID)
    {
        String sql = "SELECT *,(SELECT distinct delivery_address from delivery d where d.service_number=s.service_number)delivery_address FROM service_report s where s.customer_id="+ID;
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
                row.add(rs.getString("employee_id"));
                row.add(rs.getString("table_number"));
                row.add(rs.getString("date"));
                row.add(rs.getString("time"));
                row.add(rs.getString("rating"));
                row.add(rs.getString("delivery_status"));
                row.add(rs.getString("payment_status"));
                row.add(rs.getString("delivery_address"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.printf(resultList.toString());
        return resultList;
    }
   public void updateServiceReport(String ID,String Field,String NewValue)
   {
       //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String sql= "UPDATE service_report SET ";

        String sql1 = Field+"="+NewValue+" where service_number="+ID;
        if(Field.equals("payment_status"))
            sql1=Field+"='"+NewValue+"' where service_number="+ID;
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
            e.printStackTrace();
            System.out.println(sql+sql1);
        }
   }
   public List<List<String>> getAllCustomerDelivery(String Service_Number)
    {
        String sql = "SELECT food_id,(SELECT name from food f where f.food_id=d.food_id)name,(SELECT cost from food f where f.food_id=d.food_id)cost,amount FROM delivery d where d.service_number="+Service_Number;
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
                row.add(rs.getString("food_id"));
                row.add(rs.getString("name"));
                row.add(rs.getString("cost"));
                row.add(rs.getString("amount"));
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
}
