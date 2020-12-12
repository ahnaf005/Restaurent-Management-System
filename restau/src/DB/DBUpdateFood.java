package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class DBUpdateFood {

    public boolean updateFood(List<String> foodDetails)
    {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String food_id=foodDetails.get(0);
        String name=foodDetails.get(1);
        String type=foodDetails.get(2);
        String cost=foodDetails.get(3);
        String origin=foodDetails.get(4);
        String sql= "UPDATE food SET ";
        String sql1 = "name = '"+name+"', type = '"+type+"', cost= "+cost+", origin= '"+origin+"' where food_id="+food_id;

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

    public boolean updateFoodClmn(String food_id, String clmnName, String value)
    {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String sql= "UPDATE food SET ";

        String sql1 = clmnName+"= '"+value+"' where food_id="+food_id;
        if(clmnName.equals("cost"))
            sql1 = clmnName+"= "+value+" where food_id="+food_id;
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
