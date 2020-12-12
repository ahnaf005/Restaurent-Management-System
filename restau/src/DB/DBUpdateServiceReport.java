package DB;

import sample.Constants;
import sample.ServiceReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DBUpdateServiceReport {
    boolean success = true;

    public boolean updateSpecificReport(List<String> updatedList)
    {
        String serviceNo = updatedList.get(0);
        //String eventId = updatedList.get(1);
        String customerId = updatedList.get(1);
        String employeeId = updatedList.get(2);
        //String tableNo = updatedList.get(4);
        String date = updatedList.get(3);
        String time = updatedList.get(4);
        //String rating = updatedList.get(7);
        String delivery_status = updatedList.get(5);
        //String payment_status = updatedList.get(9);


        success = verifyUpdate(serviceNo);
        if(!success)
            return false;

        String sql = "UPDATE service_report SET ";
        String sql1 = "delivery_status = '" + delivery_status + "', employee_id = "+ Constants.ID;
        String sql2 = " where service_number = " + serviceNo;
        sql = sql+sql1+sql2;
        //List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
            success = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            success = false;
        }
        //System.out.printf(resultList.toString());
        //return resultList;
        return success;
    }

    public boolean verifyUpdate(String serviceNo)
    {
        String sql = "Select employee_id from service_report ";
        //String sql1 = "delivery_status = " + delivery_status + ", employee_id = "+ employeeId;
        String sql2 = " where service_number = " + serviceNo;
        sql = sql+sql2;

        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getString("employee_id"));
                if(rs.getString("employee_id") == null || rs.getString("employee_id").equals(Constants.ID))
                {
                    return true;
                }
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;

    }
}
