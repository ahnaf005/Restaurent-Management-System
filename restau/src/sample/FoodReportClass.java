package sample;

import javafx.beans.property.SimpleStringProperty;

public class FoodReportClass {
    private final SimpleStringProperty food_id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleStringProperty cost;
    private final SimpleStringProperty origin;
    private final SimpleStringProperty total_sell;

    FoodReportClass(String food_id, String name, String type, String cost, String origin,String total_sell) {
        this.food_id = new SimpleStringProperty(food_id);
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.cost = new SimpleStringProperty(cost);
        this.origin = new SimpleStringProperty(origin);
        this.total_sell=new SimpleStringProperty(total_sell);
    }
    public String getUserName() {
        return food_id.get();
    }
    public void setUserName(String uName) {
        food_id.set(uName);
    }
    public String getPassword() {
        return name.get();
    }
    public void setPassword(String pass) {
        name.set(pass);
    }
    public String getFullName() {
        return type.get();
    }
    public void setFullName(String fName) {
        type.set(fName);
    }
    public String getFood_id() {
        return food_id.get();
    }
    public void setFood_id(String uName) {
        food_id.set(uName);
    }
    public String getName() {
        return name.get();
    }
    public void setName(String uName) {
        name.set(uName);
    }
    public String getType() {
        return type.get();
    }
    public void setType(String uName) {
        type.set(uName);
    }
    public String getCost() {
        return cost.get();
    }
    public void setCost(String uName) {
        cost.set(uName);
    }
    public String getOrigin() {
        return origin.get();
    }
    public void setOrigin(String uName) {
        origin.set(uName);
    }
    public String getTotal_sell() {
        return total_sell.get();
    }
    public void setTotal_sell(String Total_Sell) {
        total_sell.set(Total_Sell);
    }
    public String toString() {
        return food_id + ", " + name + ", " + type+ ", "+ cost + ", "+ origin+","+total_sell;
    }



}

