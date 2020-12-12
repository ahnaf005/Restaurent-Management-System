/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class Reports {
    int getMonth(String Month)
    {
        if(Month.equals("Jan"))
            return 1;
        else if(Month.equals("Feb"))
            return 2;
        else if(Month.equals("Mar"))
            return 3;
        else if(Month.equals("Apr"))
            return 4;
        else if(Month.equals("May"))
            return 5;
        else if(Month.equals("Jun"))
            return 6;
        else if(Month.equals("Jul"))
            return 7;
        else if(Month.equals("Aug"))
            return 8;
        else if(Month.equals("Sep"))
            return 9;
        else if(Month.equals("Oct"))
            return 10;
        else if(Month.equals("Nov"))
            return 11;
        else if(Month.equals("Dec"))
            return 12;
        return 0;
    }
    public String getMonthlySell(String year,String Month)
    {
        String profit="0";
        int mon=getMonth(Month);
        String sql="SELECT Total_Sell("+year+","+mon+")";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while (rs.next())
            {
                profit=rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception Hoiache");
        }
        return profit;
    }
    public String getMonthlyExpense(String year,String Month)
    {
        String profit="0";
        int mon=getMonth(Month);
        String sql="SELECT Total_Buy("+year+","+mon+")";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while (rs.next())
            {
                profit=rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception Hoiache");
        }
        return profit;
    }
    public String getMonthlyProfit(String year,String Month)
    {
        String profit="0";
        int mon=getMonth(Month);
        String sql="SELECT Total_Profit("+year+","+mon+")";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while (rs.next())
            {
                profit=rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception Hoiache");
        }
        return profit;
    }
    public String getYearlyProfit(String year)
    {
        String profit="0";
        String sql="SELECT Yearly_Profit("+year+")";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute("USE restaurant");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while (rs.next())
            {
                profit=rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception Hoiache");
        }
        return profit;
    }
    public List<List<String>> getAllFoodsSells()
    {
        String sql = "SELECT * ,Popular_Food(food_id) as 'total_sell' FROM food ORDER BY total_sell DESC";
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
                row.add(rs.getString("total_sell"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            //System.out.println(sql);
            e.printStackTrace();
        }
        return resultList;
    }
    public List<List<String>> getTimeFoodsSells(String start,String end)
    {
        String sql = "SELECT * ,Time_Sell("+"'"+start+"'"+","+"'"+end+"'"+",food_id) as 'total_sell' FROM food ORDER BY total_sell DESC";
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
                row.add(rs.getString("total_sell"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(sql);
            e.printStackTrace();
        }
        return resultList;
    }
}
