/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.beans.property.SimpleStringProperty;

public class MarkettingHistory {
    private final SimpleStringProperty marketting_number;
    private final SimpleStringProperty date;
    private final SimpleStringProperty time;
    MarkettingHistory(String marketting_number,String date,String time) {
        this.marketting_number = new SimpleStringProperty(marketting_number);
        this.date=new SimpleStringProperty(date);
        this.time=new SimpleStringProperty(time);

    }
    
//    User(List<String> row) {
//        this.userName = new SimpleStringProperty(row.get(0));
//        this.password = new SimpleStringProperty(row.get(1));
//        this.fullName = new SimpleStringProperty(row.get(2));
//    }

    public String getMarketting_number() {
        return marketting_number.get();
    }
    public void setMarketting_number(String Marketting_Number) {
        marketting_number.set(Marketting_Number);
    }
    public String getDate() {
        return date.get();
    }
    public void setDate(String Date) {
        date.set(Date);
    }
    public String getTime() {
        return time.get();
    }
    public void setTime(String Time) {
        time.set(Time);
    }

//    public String toString() {
//        return userName + ", " + password + ", " + fullName;
//    }
}
