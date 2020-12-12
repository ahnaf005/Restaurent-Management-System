package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DBServiceReport {

    public List<List<String>> getAllServiceReports()
    {
        String sql = "SELECT * FROM service_report";
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
