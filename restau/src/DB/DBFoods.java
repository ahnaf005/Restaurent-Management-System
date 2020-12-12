package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DBFoods {

    public List<List<String>> getAllFoods()
    {
        String sql = "SELECT * FROM food";
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
                row.add(rs.getString("type"));
                row.add(rs.getString("cost"));
                row.add(rs.getString("origin"));
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
        return resultList;
    }

    public List<String> getOneFoodDetails(String food_id)
    {
        String sql = "SELECT * FROM food where food_id= "+food_id;
        List<String> resultList = new ArrayList<>();
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
                row.add(rs.getString("type"));
                row.add(rs.getString("cost"));
                row.add(rs.getString("origin"));
                //row.add(rs.getString("lname"));
                resultList=row ;
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
