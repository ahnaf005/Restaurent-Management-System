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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sample.Constants;

public class Insert {
    String name;
    public boolean InsertJob(List<String>Joblist)
    {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String job_id=Joblist.get(0);
        String job_title=Joblist.get(1);
        String min_salary=Joblist.get(2);
        String max_salary=Joblist.get(3);
        String sql= "Insert into jobs(job_id,job_title,min_salary,max_salary) values(?,?,?,?)";
        
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,job_id);
           pst.setString(2, job_title);
           pst.setString(3,min_salary);
           pst.setString(4,max_salary);
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
            success=false;
        }
        return success;
    }
     public void InsertEmployees(List<String>InfoList,boolean success) throws ParseException
    {
        success=true;
        //String Employee_id="2";
        //String Employee_id= Constants.ID;
        //String Employee_id=InfoList.get(0);
        String Job_Id=InfoList.get(0);
        String First_Name=InfoList.get(1);
        String Last_Name=InfoList.get(2);
        String Phone_Number=InfoList.get(3);
        String Hire_Date=InfoList.get(4);
        String Birth_Date=InfoList.get(5);
        String Email=InfoList.get(6);
        String Salary=InfoList.get(7);
        String Commission_Pct=InfoList.get(8);
        String Gender=InfoList.get(9);
        DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
        Date mydate=formatter.parse(Hire_Date);
        java.sql.Date sqlDate1=new java.sql.Date(mydate.getTime());
        java.sql.Date sqlDate2=new java.sql.Date(formatter.parse(Birth_Date).getTime());
        String sql= "Insert into employee(job_id,first_name,last_name,phone_number,hire_date,birth_date,email,salary,commission_pct,gender) values(?,?,?,?,?,?,?,?,?,?)";
        
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,Job_Id);
           pst.setString(2,First_Name);
           pst.setString(3,Last_Name);
           pst.setString(4,Phone_Number);
           pst.setDate(5,sqlDate1);
           pst.setDate(6,sqlDate2);
           pst.setString(7,Email);
           pst.setString(8,Salary);
           pst.setString(9,Commission_Pct);
           pst.setString(10,Gender);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            success=false;
            e.printStackTrace();
            System.out.println(sql);
        }
        
        name=" ";
        String job_title="";
        String sql2="Select employee_id from employee where first_name='"+First_Name+"'and last_name='"+Last_Name+"'and phone_number="+Phone_Number+" and birth_date='"+sqlDate2+"'";
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
        sql2="Select job_title from jobs where job_id="+Job_Id;
        System.out.println(sql2);
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql2);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next())
            {
                job_title=rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception Hoiache");
        }
        //System.out.println("Service No:"+name)
        sql="Insert into adminstration(id,password,user_type) values(?,?,?)";
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,name);
           pst.setString(2,"1234"+name);
           pst.setString(3,job_title);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            success=false;
            e.printStackTrace();
            System.out.println(sql);
        }
   }
    public List<String> getAllJobId()
    {
        String sql = "SELECT job_id FROM jobs";
        System.out.println(sql);
        List<String> resultList = new ArrayList<>();
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while (rs.next())
            {
                resultList.add(rs.getString("job_id"));
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            
        }
        return resultList;
    }
}
