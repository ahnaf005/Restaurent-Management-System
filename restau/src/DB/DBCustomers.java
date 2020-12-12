package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DBCustomers {
    public List<List<String>> getAllCustomers()
    {
        String sql = "SELECT * FROM customer";
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
                row.add(rs.getString("customer_id"));
                row.add(rs.getString("name"));
                row.add(rs.getString("age"));
                row.add(rs.getString("address"));
                row.add(rs.getString("phone_number"));
                row.add(rs.getString("email"));
                row.add(rs.getString("customer_type"));
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
