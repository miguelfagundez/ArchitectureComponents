package com.devproject.miguelfagundez.employeemanagementapp.model.network;

import com.devproject.miguelfagundez.employeemanagementapp.model.responses.AllEmployeeResponse;
import com.devproject.miguelfagundez.employeemanagementapp.model.responses.EmployeeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/********************************************
 * Interface- EmployeeService
 * Defining HTTP annotations for this service
 * @author: Miguel Fagundez
 * @date: May 09th, 2020
 * @version: 1.0
 * *******************************************/
public interface EmployeeService {

    //**************************
    // GET Annotations
    //**************************

    // Searching All Employees
    @GET("api/v1/employees")
    Call<AllEmployeeResponse> getListEmployees();

    // Searching for a specific employee
    @GET("api/v1/employee/{id}")
    Call<EmployeeResponse> getEmployeeData(
            @Path("id") String id);
}
