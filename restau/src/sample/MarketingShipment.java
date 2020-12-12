package sample;

import javafx.beans.property.SimpleStringProperty;

public class MarketingShipment {
    private final SimpleStringProperty marketing_number;
    private final SimpleStringProperty ingredient_name;
    private final SimpleStringProperty amount;

    public MarketingShipment(String marketing_number, String ingredient_name, String amount) {
        this.marketing_number = new SimpleStringProperty(marketing_number);
        this.ingredient_name = new SimpleStringProperty(ingredient_name);
        this.amount = new SimpleStringProperty(amount);
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

    public String getIngredient_name() {
        return ingredient_name.get();
    }

    public SimpleStringProperty ingredient_nameProperty() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name.set(ingredient_name);
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
