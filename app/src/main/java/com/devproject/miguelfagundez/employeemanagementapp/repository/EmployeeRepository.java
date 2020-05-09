package com.devproject.miguelfagundez.employeemanagementapp.repository;

import com.devproject.miguelfagundez.employeemanagementapp.model.network.EmployeeApiClient;
import com.devproject.miguelfagundez.employeemanagementapp.model.pojo.Employee;

import java.util.List;

import androidx.lifecycle.LiveData;

/********************************************
 * Class- EmployeeRepository
 * Middle class that connect my ViewModel layer
 * with my model - Business logic, validations,
 * and more can be added here
 * @author: Miguel Fagundez
 * @date: May 09th, 2020
 * @version: 1.0
 * *******************************************/
public class EmployeeRepository {

    //*********************************
    // Singleton pattern
    //*********************************
    private static EmployeeRepository repository = null;

    //*********************************
    // Client member
    // Connecting with my model layer
    //*********************************
    private EmployeeApiClient client;

    public static EmployeeRepository getInstance(){
        if (repository == null){
            repository = new EmployeeRepository();
        }
        return repository;
    }

    private EmployeeRepository(){
        client = EmployeeApiClient.getInstance();
    }

    public LiveData<List<Employee>> getListEmployees() {
        return client.getListOfEmployees();
    }

    public void searchAllEmployees(){
        client.searchAllEmployees();
    }
}
