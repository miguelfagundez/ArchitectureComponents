package com.devproject.miguelfagundez.employeemanagementapp.model.pojo;

/********************************************
 * Class- Employee
 * Pojo class to handle employee information.
 * Parcelable should be implemented.
 * @author: Miguel Fagundez
 * @date: May 09th, 2020
 * @version: 1.0
 * *******************************************/
public class Employee {

    private String id;
    private String employee_name;
    private String employee_salary;
    private String employee_age;

    public Employee() {
    }

    public Employee(String id, String employee_name, String employee_salary, String employee_age) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", employee_name='" + employee_name + '\'' +
                ", employee_salary='" + employee_salary + '\'' +
                ", employee_age='" + employee_age + '\'' +
                '}';
    }
}
