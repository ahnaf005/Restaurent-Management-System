package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBJoinTableQuery {

    public List<List<String>> joinQuery(String employee_id, String customer_id)
    {
        List<List<String>> resultList = new ArrayList<>();
        String sql = "Select c.name, e.first_name, sr.table_number, sr.date, sr.time, sr.rating, sr.event_id " +
                "From employee e join service_report sr on(sr.employee_id=e.employee_id) " +
                "join customer c on(sr.customer_id=c.customer_id) where e.employee_id="+
                employee_id+" and c.customer_id="+customer_id;
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("name"));
                row.add(rs.getString("first_name"));
                row.add(rs.getString("table_number"));
                row.add(rs.getString("date"));
                row.add(rs.getString("time"));
                row.add(rs.getString("rating"));
                row.add(rs.getString("event_id"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(sql);
        }
        return resultList;
    }
}
