/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Update {
    public boolean updateJobClmn(String job_id, String clmnName, String value)
    {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String sql= "UPDATE jobs SET ";

        String sql1 = clmnName+"="+value+" where job_id="+job_id;
        if(clmnName.equals("job_title"))
            sql1=clmnName+"='"+value+"' where job_id="+job_id;
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
            success=false;
        }
        return success;
    }
    public boolean updateCustomerClmn(String customer_id, String clmnName, String value)
    {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String sql= "UPDATE customer SET ";

        String sql1 = clmnName+"='"+value+"' where customer_id="+customer_id;
        if(clmnName.equals("age") || clmnName.equals("phone_number"))
            sql1=clmnName+"="+value+" where customer_id="+customer_id;
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
            success=false;
        }
        return success;
    }
    
    public boolean updateEmployeeClmn(String employee_id, String clmnName, String value)
    {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String sql= "UPDATE employee SET ";

        String sql1 = clmnName+"='"+value+"' where employee_id="+employee_id;
        if(clmnName.equals("job_id") || clmnName.equals("phone_number") || clmnName.equals("salary") || clmnName.equals("commission_pct"))
            sql1=clmnName+"="+value+" where employee_id="+employee_id;
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
            success=false;
        }
        return success;
    }
    
    public boolean updateEventClmn(String event_id, String clmnName, String value)
    {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String sql= "UPDATE event SET ";

        String sql1 = clmnName+"='"+value+"' where event_id="+event_id;
        if(clmnName.equals("discount"))
            sql1=clmnName+"="+value+" where event_id="+event_id;
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
            success=false;
        }
        return success;
    }
}
