package sample;

import javafx.beans.property.SimpleStringProperty;

public class JoinQueryTableDemo {

    private final SimpleStringProperty customer_name;
    private final SimpleStringProperty first_name;
    private final SimpleStringProperty table_number;
    private final SimpleStringProperty date;
    private final SimpleStringProperty time;
    private final SimpleStringProperty rating;
    private final SimpleStringProperty event_id;

    public JoinQueryTableDemo(String customer_name, String first_name, String table_number,
                              String date, String time, String rating, String event_id) {
        this.customer_name = new SimpleStringProperty(customer_name);
        this.first_name = new SimpleStringProperty(first_name);
        this.table_number = new SimpleStringProperty(table_number);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.rating = new SimpleStringProperty(rating);
        this.event_id = new SimpleStringProperty(event_id);
    }

    public String getCustomer_name() {
        return customer_name.get();
    }

    public SimpleStringProperty customer_nameProperty() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name.set(customer_name);
    }

    public String getFirst_name() {
        return first_name.get();
    }

    public SimpleStringProperty first_nameProperty() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
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

    public String getEvent_id() {
        return event_id.get();
    }

    public SimpleStringProperty event_idProperty() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id.set(event_id);
    }

    @Override
    public String toString() {
        return "JoinQueryTableDemo{" +
                "customer_name=" + customer_name +
                ", first_name=" + first_name +
                ", table_number=" + table_number +
                ", date=" + date +
                ", time=" + time +
                ", rating=" + rating +
                ", event_id=" + event_id +
                '}';
    }
}
