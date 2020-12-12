package DB;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DBUpdateProfile {

    public boolean employeeProfileUpdate(List<String> employeeDetails)
    {

        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String employee_id = employeeDetails.get(0);
        String job_id = employeeDetails.get(1);
        String fName=employeeDetails.get(2);
        String lName=employeeDetails.get(3);
        String phnNo=employeeDetails.get(4);
        String hDate=employeeDetails.get(5);
        String bDate=employeeDetails.get(6);
        String email=employeeDetails.get(7);
        String salary=employeeDetails.get(8);
        String comm=employeeDetails.get(9);
        String gender=employeeDetails.get(10);
        String job_title=employeeDetails.get(11);


//        DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
//        Date myHDate= null;
//        try {
//            myHDate = formatter.parse(hDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        java.sql.Date sqlHDate=new java.sql.Date(myHDate.getTime());
//
//        Date myBDate= null;
//        try {
//            myBDate = formatter.parse(bDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        java.sql.Date sqlBDate=new java.sql.Date(myBDate.getTime());


        String sql= "UPDATE employee SET ";
        String sql1= "job_id = " + job_id+ ", first_name= '"+fName+ "', last_name= '"+lName+ "', phone_number= "+phnNo+", email= '"+email+ "', salary= "+salary+ ", commission_pct= "+comm+ ", gender= '"+gender+"'";
        String sql2 = " where employee_id= "+employee_id;

        //List<List<String>> exist = new DBEmployee().getExistingEmployee(employee_id);

        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql+sql1+sql2);

            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(sql+sql1+sql2);
            //System.out.println(name+" "+age+" "+address+" "+phoneNo+" "+email);
            success=false;
        }
        return success;
    }

    public boolean customerProfileUpdate(List<String> employeeDetails)
    {

        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String customer_id = employeeDetails.get(0);
        String name = employeeDetails.get(1);
        String age=employeeDetails.get(2);
        String address=employeeDetails.get(3);
        String phnNo=employeeDetails.get(4);
        String email=employeeDetails.get(5);
        String gender=employeeDetails.get(6);



//        DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
//        Date myHDate= null;
//        try {
//            myHDate = formatter.parse(hDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        java.sql.Date sqlHDate=new java.sql.Date(myHDate.getTime());
//
//        Date myBDate= null;
//        try {
//            myBDate = formatter.parse(bDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        java.sql.Date sqlBDate=new java.sql.Date(myBDate.getTime());


        String sql= "UPDATE customer SET ";
        String sql1= "name = '" + name+ "', age= "+age+ ", address= '"+address+ "', phone_number= "+phnNo+", email= '"+email+ "'";
        String sql2 = " where customer_id = "+customer_id;

        //List<List<String>> exist = new DBEmployee().getExistingEmployee(employee_id);

        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql+sql1+sql2);

            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(sql+sql1+sql2);
            //System.out.println(name+" "+age+" "+address+" "+phoneNo+" "+email);
            success=false;
        }
        return success;
    }
}
