package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DBInsertEvent {

    public boolean validateInsert(List<String> eventlist) throws ParseException {
        boolean success = true;
        //String sql = "SELECT * FROM adminstration WHERE username = '"+userName+ "' AND password= '" + password+"'";// WHERE USERNAME = ? AND PASSWORD=?";
        String event_id=eventlist.get(0);
        String name=eventlist.get(1);
        String venue=eventlist.get(2);
        String start_date=eventlist.get(3);
        String end_date=eventlist.get(4);
        String discount=eventlist.get(5);
        String event_type=eventlist.get(6);

        DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
        Date SDate=formatter.parse(start_date);
        java.sql.Date sqlSDate=new java.sql.Date(SDate.getTime());

        //DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
        Date EDate=formatter.parse(end_date);
        java.sql.Date sqlEDate=new java.sql.Date(EDate.getTime());
        String sql;
        if(event_id.equals(""))
             sql= "Insert into event(event_name,venue,start_date,end_date, discount,event_type) values(?,?,?,?,?,?)";
        else sql= "Insert into event(event_id,event_name,venue,start_date,end_date, discount,event_type) values(?,?,?,?,?,?,?)";

        try{
            Connection con = new OracleDBMS().getConnection();
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
            if(event_id.equals(""))
            {
                //pst.setString(1,event_id);
                pst.setString(1, name);
                pst.setString(2,venue);
                pst.setDate(3,sqlSDate);
                pst.setDate(4,sqlEDate);
                pst.setString(5,discount);
                pst.setString(6,event_type);
            }
            else{
                pst.setString(1,event_id);
                pst.setString(1, name);
                pst.setString(2,venue);
                pst.setDate(3,sqlSDate);
                pst.setDate(4,sqlEDate);
                pst.setString(5,discount);
                pst.setString(6,event_type);
            }

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
