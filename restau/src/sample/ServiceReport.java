package sample;

import javafx.beans.property.SimpleStringProperty;

public class ServiceReport {

    private final SimpleStringProperty service_number;
    private final SimpleStringProperty event_id;
    private final SimpleStringProperty customer_id;
    private final SimpleStringProperty employee_id;
    private final SimpleStringProperty table_number;
    private final SimpleStringProperty date;
    private final SimpleStringProperty time;
    private final SimpleStringProperty rating;
    private final SimpleStringProperty delivery_status;
    private final SimpleStringProperty payment_status;
    private final SimpleStringProperty delivery_address;
    public ServiceReport(String service_number, String event_id, String customer_id, String employee_id, String table_number, String date,
     String time, String rating, String delivery_status, String payment_status,String delivery_address) {
        this.service_number = new SimpleStringProperty(service_number);
        this.event_id = new SimpleStringProperty(event_id);
        this.customer_id = new SimpleStringProperty(customer_id);
        this.employee_id = new SimpleStringProperty(employee_id);
        this.table_number = new SimpleStringProperty(table_number);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.rating = new SimpleStringProperty(rating);
        this.delivery_status = new SimpleStringProperty(delivery_status);
        this.payment_status = new SimpleStringProperty(payment_status);
        this.delivery_address=new SimpleStringProperty(delivery_address);
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

    public String getEmployee_id() {
        return employee_id.get();
    }

    public SimpleStringProperty employee_idProperty() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id.set(employee_id);
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

    public void setDelivery_address(String delivery_address) {
        this.delivery_address.set(delivery_address);
    }

    @Override
    public String toString() {
        return "ServiceReport{" + "service_number=" + service_number + ", event_id=" + event_id + ", customer_id=" + customer_id + ", employee_id=" + employee_id + ", table_number=" + table_number + ", date=" + date + ", time=" + time + ", rating=" + rating + ", delivery_status=" + delivery_status + ", payment_status=" + payment_status + ", delivery_address=" + delivery_address + '}';
    }
    public String getDelivery_address()
    {
        return delivery_address.get();
    }
}
