package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class DBInsertIngredients {
    public boolean validateInsert(List<String> ingredietsList)
    {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        //String food_id=ingredietsList.get(0);
        String name=ingredietsList.get(0);
        String type=ingredietsList.get(1);
        String cost=ingredietsList.get(2);
        //String origin=foodlist.get(4);
        String sql= "Insert into ingredients(ingredient_name,type,cost) values(?,?,?)";

        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
            //pst.setString(1,food_id);
            pst.setString(1, name);
            pst.setString(2,type);
            pst.setString(3,cost);
            //pst.setString(5,origin);
            //st.execute("USE restaurant");
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(sql);
            success=false;
        }
        return success;
    }
}
