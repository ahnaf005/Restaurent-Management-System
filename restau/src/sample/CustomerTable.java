package sample;

import javafx.beans.property.SimpleStringProperty;

public class CustomerTable {

    private final SimpleStringProperty customer_id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty age;
    private final SimpleStringProperty address;
    private final SimpleStringProperty phone_number;
    private final SimpleStringProperty email;
    private final SimpleStringProperty customer_type;
    private final SimpleStringProperty spent_money;

    public CustomerTable(String customer_id, String name, String age, String address, String phone_number, String email, String customer_type) {
        this.customer_id = new SimpleStringProperty(customer_id);
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleStringProperty(age);
        this.address = new SimpleStringProperty(address);
        this.phone_number = new SimpleStringProperty(phone_number);
        this.email = new SimpleStringProperty(email);
        this.customer_type = new SimpleStringProperty(customer_type);
        this.spent_money=new SimpleStringProperty("");
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
    public String getSpent_money() {
        return spent_money.get();
    }


    public void setSpent_money(String spent_money) {
        this.spent_money.set(spent_money);
    }
    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPhone_number() {
        return phone_number.get();
    }

    public SimpleStringProperty phone_numberProperty() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number.set(phone_number);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getCustomer_type() {
        return customer_type.get();
    }

    public SimpleStringProperty customer_typeProperty() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type.set(customer_type);
    }
}
