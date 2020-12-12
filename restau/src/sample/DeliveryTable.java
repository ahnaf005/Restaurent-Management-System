package sample;

import javafx.beans.property.SimpleStringProperty;

public class DeliveryTable {

    private final SimpleStringProperty service_number;
    private final SimpleStringProperty food_id;
    private final SimpleStringProperty delivery_address;
    private final SimpleStringProperty amount;

    public DeliveryTable(String service_number, String food_id, String delivery_address, String amount) {
        this.service_number = new SimpleStringProperty(service_number);
        this.food_id = new SimpleStringProperty(food_id);
        this.delivery_address = new SimpleStringProperty(delivery_address);
        this.amount = new SimpleStringProperty(amount);
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

    public String getFood_id() {
        return food_id.get();
    }

    public SimpleStringProperty food_idProperty() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id.set(food_id);
    }

    public String getDelivery_address() {
        return delivery_address.get();
    }

    public SimpleStringProperty delivery_addressProperty() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address.set(delivery_address);
    }

    public String getAmount() {
        return amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }
}
