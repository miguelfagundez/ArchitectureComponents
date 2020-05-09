package com.devproject.miguelfagundez.employeemanagementapp.model.responses;

import com.devproject.miguelfagundez.employeemanagementapp.model.pojo.Employee;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/********************************************
 * Class- AllEmployeeResponse
 * This class handle the retrofit response
 * for a list of employees
 * @author: Miguel Fagundez
 * @date: May 09th, 2020
 * @version: 1.0
 * *******************************************/
public class AllEmployeeResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private List<Employee> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
