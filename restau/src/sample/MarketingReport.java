package sample;

import javafx.beans.property.SimpleStringProperty;

public class MarketingReport {
    private final SimpleStringProperty marketing_number;
    private final SimpleStringProperty employee_id;
    private final SimpleStringProperty date;
    private final SimpleStringProperty time;

    public MarketingReport(String marketing_number, String employee_id, String date, String time) {
        this.marketing_number = new SimpleStringProperty(marketing_number);
        this.employee_id = new SimpleStringProperty(employee_id);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
    }

    public String getMarketing_number() {
        return marketing_number.get();
    }

    public SimpleStringProperty marketing_numberProperty() {
        return marketing_number;
    }

    public void setMarketing_number(String marketing_number) {
        this.marketing_number.set(marketing_number);
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
}
