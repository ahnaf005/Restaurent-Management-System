/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import sample.Constants;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdatePassWord {
    public void Update(String NewPass)
    {
        String sql= "UPDATE adminstration SET password=";

        String sql1 =NewPass+" where id="+Constants.ID;

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
        }
    }
}
