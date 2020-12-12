package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeUser {

    private static Users instance;
    public String userType = "";

//    private Users()
//    {
//    }

    //    public static Users getInstance()
//    {
//        if (instance == null)
//        {
//            instance = new Users();
//        }
//        return instance;
//    }
    public boolean validateLogin(String userName, String password)
    {
        boolean success = false;
        String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";

        try{
            Connection con = new OracleDBMS().getConnection();
            Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1, userName);
//            pst.setString(2, password);
            st.execute("USE restaurant");
            ResultSet rs = st.executeQuery(sql);
            System.out.println(rs.toString());

            //ResultSet rs = pst.executeQuery();
            if (rs.next())
            {
                userType = rs.getString("user_type");
                success = true;
            }

            System.out.println(userType);
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return success;
    }
    public List<List<String>> getAllUsers()
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
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {

        }
        return resultList;
    }
}
