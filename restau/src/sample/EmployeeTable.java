package sample;

import javafx.beans.property.SimpleStringProperty;
import sun.java2d.pipe.SpanShapeRenderer;

public class EmployeeTable {

    private final SimpleStringProperty employee_id;
    private final SimpleStringProperty job_id;
    private final SimpleStringProperty fname;
    private final SimpleStringProperty lname;
    private final SimpleStringProperty phone_number;
    private final SimpleStringProperty hire_date;
    private final SimpleStringProperty birth_date;
    private final SimpleStringProperty email;
    private final SimpleStringProperty salary;
    private final SimpleStringProperty commission_pct;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty total_services;

    public EmployeeTable(String employee_id, String job_id, String fname, String lname, String phone_number, String hire_date, String birth_date, String email, String salary, String commission_pct, String gender) {
        this.employee_id = new SimpleStringProperty(employee_id);
        this.job_id = new SimpleStringProperty(job_id);
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.phone_number = new SimpleStringProperty(phone_number);
        this.hire_date = new SimpleStringProperty(hire_date);
        this.birth_date = new SimpleStringProperty(birth_date);
        this.email = new SimpleStringProperty(email);
        this.salary = new SimpleStringProperty(salary);
        this.commission_pct = new SimpleStringProperty(commission_pct);
        this.gender = new SimpleStringProperty(gender);
        this.total_services=new SimpleStringProperty("");
    }

    public String getEmployee_id() {
        return employee_id.get();
    }

    public SimpleStringProperty employee_idProperty() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id.set(employee_id);
    }
    public String getTotal_services() {
        return total_services.get();
    }

    public void setTotal_services(String total_services) {
        this.total_services.set(total_services);
    }
    public String getJob_id() {
        return job_id.get();
    }

    public SimpleStringProperty job_idProperty() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id.set(job_id);
    }

    public String getFname() {
        return fname.get();
    }

    public SimpleStringProperty fnameProperty() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname.set(fname);
    }

    public String getLname() {
        return lname.get();
    }

    public SimpleStringProperty lnameProperty() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname.set(lname);
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

    public String getHire_date() {
        return hire_date.get();
    }

    public SimpleStringProperty hire_dateProperty() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date.set(hire_date);
    }

    public String getBirth_date() {
        return birth_date.get();
    }

    public SimpleStringProperty birth_dateProperty() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date.set(birth_date);
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

    public String getSalary() {
        return salary.get();
    }

    public SimpleStringProperty salaryProperty() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary.set(salary);
    }

    public String getCommission_pct() {
        return commission_pct.get();
    }

    public SimpleStringProperty commission_pctProperty() {
        return commission_pct;
    }

    public void setCommission_pct(String commission_pct) {
        this.commission_pct.set(commission_pct);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    @Override
    public String toString() {
        return "EmployeeTable{" +
                "employee_id=" + employee_id +
                ", job_id=" + job_id +
                ", fname=" + fname +
                ", lname=" + lname +
                ", phone_number=" + phone_number +
                ", hire_date=" + hire_date +
                ", birth_date=" + birth_date +
                ", email=" + email +
                ", salary=" + salary +
                ", commission_pct=" + commission_pct +
                ", gender=" + gender +
                '}';
    }
}
