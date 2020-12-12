package sample;

import javafx.beans.property.SimpleStringProperty;

public class IngredientsTable {

    private final SimpleStringProperty ingredient_name;
    private final SimpleStringProperty type;
    private final SimpleStringProperty cost;

    public IngredientsTable(String ingredient_name, String type, String cost) {
        this.ingredient_name = new SimpleStringProperty(ingredient_name);
        this.type = new SimpleStringProperty(type);
        this.cost = new SimpleStringProperty(cost);
    }

    public String getIngredient_name() {
        return ingredient_name.get();
    }

    public SimpleStringProperty ingredient_nameProperty() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name.set(ingredient_name);
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
}
