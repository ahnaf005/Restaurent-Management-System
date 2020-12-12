/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.beans.property.SimpleStringProperty;

public class ServiceHistory {
    private final SimpleStringProperty service_number;
    private final SimpleStringProperty event_id;
    private final SimpleStringProperty customer_id;
    private final SimpleStringProperty table_number;
    private final SimpleStringProperty date;
    private final SimpleStringProperty time;
    private final SimpleStringProperty rating;
    private final SimpleStringProperty delivery_status;
    private final SimpleStringProperty payment_status;
    ServiceHistory(String service_number, String event_id, String customer_id,String table_number,String date,
                   String time,String rating, String delivery_status, String payment_status) {
        this.service_number = new SimpleStringProperty(service_number);
        this.event_id = new SimpleStringProperty(event_id);
        this.customer_id = new SimpleStringProperty(customer_id);
        this.table_number=new SimpleStringProperty(table_number);
        this.date=new SimpleStringProperty(date);
        this.time=new SimpleStringProperty(time);
        this.rating=new SimpleStringProperty(rating);
        this.delivery_status=new SimpleStringProperty(delivery_status);
        this.payment_status=new SimpleStringProperty(payment_status);

    }

    public String getService_number() {
        return service_number.get();
    }

    public SimpleStringProperty service_numberProperty() {
        return service_number;
    }

    public void setService_number(String service_number) {
        this.service_number.set(service_number);
    }

    public String getEvent_id() {
        return event_id.get();
    }

    public SimpleStringProperty event_idProperty() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id.set(event_id);
    }

    public String getCustomer_id() {
        return customer_id.get();
    }

    public SimpleStringProperty customer_idProperty() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id.set(customer_id);
    }

    public String getTable_number() {
        return table_number.get();
    }

    public SimpleStringProperty table_numberProperty() {
        return table_number;
    }

    public void setTable_number(String table_number) {
        this.table_number.set(table_number);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getRating() {
        return rating.get();
    }

    public SimpleStringProperty ratingProperty() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating.set(rating);
    }

    public String getDelivery_status() {
        return delivery_status.get();
    }

    public SimpleStringProperty delivery_statusProperty() {
        return delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status.set(delivery_status);
    }

    public String getPayment_status() {
        return payment_status.get();
    }

    public SimpleStringProperty payment_statusProperty() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status.set(payment_status);
    }


    //    User(List<String> row) {
//        this.userName = new SimpleStringProperty(row.get(0));
//        this.password = new SimpleStringProperty(row.get(1));
//        this.fullName = new SimpleStringProperty(row.get(2));
//    }

//    public String getService_number() {
//        return service_number.get();
//    }
//    public void setService_number(String Service_Number) {
//        service_number.set(Service_Number);
//    }
//
//    public String getEvent_id() {
//        return event_id.get();
//    }
//    public void setEvent_id(String Event_Id) {
//        event_id.set(Event_Id);
//    }
//
//    public String getCustomer_id() {
//        return customer_id.get();
//    }
//    public void setCustomer_id(String Customer_Id) {
//        customer_id.set(Customer_Id);
//    }
//    public String getTable_number() {
//        return table_number.get();
//    }
//    public void setTable_number(String Table_Number) {
//        table_number.set(Table_Number);
//    }
//    public String getDate() {
//        return date.get();
//    }
//    public void setDate(String Date) {
//        date.set(Date);
//    }
//    public String getTime() {
//        return time.get();
//    }
//    public void setTime(String Time) {
//        time.set(Time);
//    }
//    public String getRating() {
//        return rating.get();
//    }
//    public void setRating(String Rating) {
//        rating.set(Rating);
//    }

//    public String toString() {
//        return userName + ", " + password + ", " + fullName;
//    }
}
