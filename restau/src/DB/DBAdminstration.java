package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBAdminstration {



    public void addUser(String password, String userType, String id){
        String sql= "Insert into adminstration(password,user_type,id) values(?,?,?)";

        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,password);
            pst.setString(2,userType);
            pst.setString(3,id);
            pst.execute("USE restaurant");
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //System.out.println(sql);

        }
    }
}
