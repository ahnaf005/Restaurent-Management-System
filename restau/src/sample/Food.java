package sample;

import javafx.beans.property.SimpleStringProperty;

public class Food {
    private final SimpleStringProperty food_id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleStringProperty cost;
    private final SimpleStringProperty origin;

    Food(String food_id, String name, String type, String cost, String origin) {
        this.food_id = new SimpleStringProperty(food_id);
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.cost = new SimpleStringProperty(cost);
        this.origin = new SimpleStringProperty(origin);

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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getCost() {
        return cost.get();
    }

    public SimpleStringProperty costProperty() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost.set(cost);
    }

    public String getOrigin() {
        return origin.get();
    }

    public SimpleStringProperty originProperty() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin.set(origin);
    }

    @Override
    public String toString() {
        return "Food{" +
                "food_id=" + food_id +
                ", name=" + name +
                ", type=" + type +
                ", cost=" + cost +
                ", origin=" + origin +
                '}';
    }
}

