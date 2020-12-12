package sample;

import javafx.beans.property.SimpleStringProperty;

public class EventTable {

    private final SimpleStringProperty event_id;
    private final SimpleStringProperty event_name;
    private final SimpleStringProperty venue;
    private final SimpleStringProperty start_date;
    private final SimpleStringProperty end_date;
    private final SimpleStringProperty discount;
    private final SimpleStringProperty event_type;
    private final SimpleStringProperty total_got;

    public EventTable(String event_id, String event_name, String venue, String start_date, String end_date, String discount, String event_type) {
        this.event_id = new SimpleStringProperty(event_id);
        this.event_name = new SimpleStringProperty(event_name);
        this.venue = new SimpleStringProperty(venue);
        this.start_date = new SimpleStringProperty(start_date);
        this.end_date = new SimpleStringProperty(end_date);
        this.discount = new SimpleStringProperty(discount);
        this.event_type = new SimpleStringProperty(event_type);
        this.total_got=new SimpleStringProperty("");
    }
    public String getTotal_got() {
        return total_got.get();
    }

    public void setTotal_got(String total_got) {
        this.total_got.set(total_got);
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

    public String getEvent_name() {
        return event_name.get();
    }

    public SimpleStringProperty event_nameProperty() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name.set(event_name);
    }

    public String getVenue() {
        return venue.get();
    }

    public SimpleStringProperty venueProperty() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue.set(venue);
    }

    public String getStart_date() {
        return start_date.get();
    }

    public SimpleStringProperty start_dateProperty() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date.set(start_date);
    }

    public String getEnd_date() {
        return end_date.get();
    }

    public SimpleStringProperty end_dateProperty() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date.set(end_date);
    }

    public String getDiscount() {
        return discount.get();
    }

    public SimpleStringProperty discountProperty() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount.set(discount);
    }

    public String getEvent_type() {
        return event_type.get();
    }

    public SimpleStringProperty event_typeProperty() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type.set(event_type);
    }
}
