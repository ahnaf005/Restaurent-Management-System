package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBJobMaxSalary {

    public List<List<String>> getMaxSalary()
    {
        List<List<String>> resultList = new ArrayList<>();
        String sql = "select j.job_title,e.employee_id,e.first_name " +
                "from jobs j join employee e on (e.job_id=j.job_id) " +
                "where not exists(" +
                "select e2.employee_id from employee e2 " +
                "where e2.salary>e.salary and e2.job_id=e.job_id" +
                ")";
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("job_title"));
                row.add(rs.getString("employee_id"));
                row.add(rs.getString("first_name"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(sql);
        }
        return resultList;
    }
}
