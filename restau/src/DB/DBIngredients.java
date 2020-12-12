package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DBIngredients {
    public List<List<String>> getAllIngredients()
    {
        String sql = "SELECT * FROM ingredients";
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
                row.add(rs.getString("ingredient_name"));
                row.add(rs.getString("type"));
                row.add(rs.getString("cost"));
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

    public boolean updateIngredientsClmn(String ingredient_name, String clmnName, String value)
    {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String sql= "UPDATE ingredients SET ";

        String sql1 = clmnName+"= '"+value+"' where ingredient_name= '"+ingredient_name+"'";
        if(clmnName.equals("cost"))
            sql1 = clmnName+"= "+value+" where ingredient_name= '"+ingredient_name+"'";
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
