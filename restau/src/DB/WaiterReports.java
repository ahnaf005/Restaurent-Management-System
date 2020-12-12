package DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

public class WaiterReports {
    public List<List<String>> getAllWaiters()
    {
        String sql = "SELECT employee_id,job_id,last_name,salary,commission_pct,(select count(*) FROM  service_report s where s.employee_id=e.employee_id)cnt \n" +
"from employee e order by cnt DESC";
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
                row.add(rs.getString("last_name"));
                row.add(rs.getString("salary"));
                row.add(rs.getString("commission_pct"));
                row.add(rs.getString("cnt"));
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
    public void UpdateWaiterSalary(String ID,String amount)
    {
        String sql= "call Employee_Salary("+ID+","+amount+")";
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("This Employeee DoesNot Exist");
            alert.showAndWait();
            //e.printStackTrace();
        }
    }
    public void UpdateAllWaiterSalary(String ThresHold)
    {
        String sql= "UPDATE  employee SET salary=salary+salary*"+ThresHold;
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public List<String>getStats(String ID)
    {
        String sql="SELECT first_name,last_name,Spend_Employee(employee_id)Total_Got,Avg_Rating(employee_id)Avg_Rating from employee where employee_id="+ID;
        List<String>row=new ArrayList<>();
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next())
            {
                row.add(rs.getString("first_name"));
                row.add(rs.getString("last_name"));
                row.add(rs.getString("Total_Got"));
                row.add(rs.getString("Avg_Rating"));
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //System.out.println(sql);
        //System.out.println(row);
        return row;
    }
}
