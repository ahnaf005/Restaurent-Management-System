package sample;

import javafx.beans.property.SimpleStringProperty;

public class JobsTable {

    private final SimpleStringProperty job_id;
    private final SimpleStringProperty title;
    private final SimpleStringProperty min_salary;
    private final SimpleStringProperty max_salary;
    public JobsTable(String job_id, String title, String min_salary, String max_salary) {
        this.job_id = new SimpleStringProperty(job_id);
        this.title = new SimpleStringProperty(title);
        this.min_salary = new SimpleStringProperty(min_salary);
        this.max_salary = new SimpleStringProperty(max_salary);
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

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getMin_salary() {
        return min_salary.get();
    }

    public SimpleStringProperty min_salaryProperty() {
        return min_salary;
    }

    public void setMin_salary(String min_salary) {
        this.min_salary.set(min_salary);
    }

    public String getMax_salary() {
        return max_salary.get();
    }

    public SimpleStringProperty max_salaryProperty() {
        return max_salary;
    }

    public void setMax_salary(String max_salary) {
        this.max_salary.set(max_salary);
    }

    @Override
    public String toString() {
        return "JobsTable{" + "job_id=" + job_id + ", title=" + title + ", min_salary=" + min_salary + ", max_salary=" + max_salary + '}';
    }
}
