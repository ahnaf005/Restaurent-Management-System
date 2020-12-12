package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DBEmployee {

    public List<List<String>> getAllEmployee()
    {
        String sql = "SELECT * FROM employee";
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

    public List<List<String>> getExistingEmployee(String employeeID)
    {
        String sql = "SELECT * FROM employee where employee_id= "+employeeID;
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
}
