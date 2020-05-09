package com.devproject.miguelfagundez.employeemanagementapp.model.responses;

import com.devproject.miguelfagundez.employeemanagementapp.model.pojo.Employee;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/********************************************
 * Class- EmployeeResponse
 * This class handle the retrofit response
 * for a single employee (id)
 * @author: Miguel Fagundez
 * @date: May 09th, 2020
 * @version: 1.0
 * *******************************************/
public class EmployeeResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private Employee data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getData() {
        return data;
    }

    public void setData(Employee data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EmployeeResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
