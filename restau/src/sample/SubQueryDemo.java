package sample;

import javafx.beans.property.SimpleStringProperty;

public class SubQueryDemo {

    private final SimpleStringProperty job_title;
    private final SimpleStringProperty employee_id;
    private final SimpleStringProperty employee_name;


    SubQueryDemo(String job_title, String employee_id, String employee_name) {
        this.job_title = new SimpleStringProperty(job_title);
        this.employee_id = new SimpleStringProperty(employee_id);
        this.employee_name = new SimpleStringProperty(employee_name);
    }

    public void setJob_title(String job_title) {
        this.job_title.set(job_title);
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id.set(employee_id);
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name.set(employee_name);
    }

    public String getJob_title() {
        return job_title.get();
    }

    public SimpleStringProperty job_titleProperty() {
        return job_title;
    }

    public String getEmployee_id() {
        return employee_id.get();
    }

    public SimpleStringProperty employee_idProperty() {
        return employee_id;
    }

    public String getEmployee_name() {
        return employee_name.get();
    }

    public SimpleStringProperty employee_nameProperty() {
        return employee_name;
    }

    //    public String getUserName() {
//        return food_id.get();
//    }
//    public void setUserName(String uName) {
//        food_id.set(uName);
//    }
//    public String getPassword() {
//        return name.get();
//    }
//    public void setPassword(String pass) {
//        name.set(pass);
//    }
//    public String getFullName() {
//        return type.get();
//    }
//    public void setFullName(String fName) {
//        type.set(fName);
//    }
//    public String getFood_id() {
//        return food_id.get();
//    }
//    public void setFood_id(String uName) {
//        food_id.set(uName);
//    }
//    public String getName() {
//        return name.get();
//    }
//    public void setName(String uName) {
//        name.set(uName);
//    }
//    public String getType() {
//        return type.get();
//    }
//    public void setType(String uName) {
//        type.set(uName);
//    }
//    public String getCost() {
//        return cost.get();
//    }
//    public void setCost(String uName) {
//        cost.set(uName);
//    }
//    public String getOrigin() {
//        return origin.get();
//    }
//    public void setOrigin(String uName) {
//        origin.set(uName);
//    }


    @Override
    public String toString() {
        return "showMaxSalary{" +
                "job_title=" + job_title +
                ", employee_id=" + employee_id +
                ", employee_name=" + employee_name +
                '}';
    }
}
