package sample;
import javafx.beans.property.SimpleStringProperty;
public class CustomerDelivery {
    private final SimpleStringProperty food_id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty cost;
    private final SimpleStringProperty amount;

    public CustomerDelivery(String food_id, String name,String cost, String amount) {
        this.food_id = new SimpleStringProperty(food_id);
        this.name = new SimpleStringProperty(name);
        this.cost=new SimpleStringProperty(cost);
        this.amount = new SimpleStringProperty(amount);
    }
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
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

    public String getCost() {
        return cost.get();
    }

    public void setCost(String cost) {
        this.cost.set(cost);
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
    @Override
    public String toString() {
        return "CustomerDelivery{" + "food_id=" + food_id + ", name=" + name + ", cost=" + cost + ", amount=" + amount + '}';
    }
    
}
