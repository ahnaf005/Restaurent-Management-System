/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Alavi
 */
public class DBInsertFood {
    public boolean validateInsert(List<String>foodlist)
    {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String food_id=foodlist.get(0);
        String name=foodlist.get(1);
        String type=foodlist.get(2);
        String cost=foodlist.get(3);
        String origin=foodlist.get(4);
        String sql= "Insert into food(food_id,name,type,cost,origin) values(?,?,?,?,?)";
        
        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,food_id);
           pst.setString(2, name);
           pst.setString(3,type);
           pst.setString(4,cost);
           pst.setString(5,origin);
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
