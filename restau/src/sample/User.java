package sample;

import javafx.beans.property.SimpleStringProperty;

public class User {
    private final SimpleStringProperty userName;
    private final SimpleStringProperty password;
    private final SimpleStringProperty fullName;

    User(String fName, String lName, String email) {
        this.userName = new SimpleStringProperty(fName);
        this.password = new SimpleStringProperty(lName);
        this.fullName = new SimpleStringProperty(email);

    }
    
//    User(List<String> row) {
//        this.userName = new SimpleStringProperty(row.get(0));
//        this.password = new SimpleStringProperty(row.get(1));
//        this.fullName = new SimpleStringProperty(row.get(2));
//    }

    public String getUserName() {
        return userName.get();
    }
    public void setUserName(String uName) {
        userName.set(uName);
    }

    public String getPassword() {
        return password.get();
    }
    public void setPassword(String pass) {
        password.set(pass);
    }

    public String getFullName() {
        return fullName.get();
    }
    public void setFullName(String fName) {
        fullName.set(fName);
    }

    public String toString() {
        return userName + ", " + password + ", " + fullName;
    }



}

