package com.devproject.miguelfagundez.employeemanagementapp.viewmodel;

import android.app.Application;

import com.devproject.miguelfagundez.employeemanagementapp.model.pojo.Employee;
import com.devproject.miguelfagundez.employeemanagementapp.repository.EmployeeRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/********************************************
 * Class- EmployeeViewModel
 * This class handle the ViewModel and
 * repository components
 * @author: Miguel Fagundez
 * @date: May 09th, 2020
 * @version: 1.0
 * *******************************************/
public class EmployeeViewModel extends AndroidViewModel {

    // Members
    private EmployeeRepository repository;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        repository = EmployeeRepository.getInstance();
    }

    public LiveData<List<Employee>> getListEmployees(){ return repository.getListEmployees(); }
    public void searchAllEmployees(){
        repository.searchAllEmployees();
    }

    //******************************************
    // Testing
    //******************************************
    public List<Employee> testingRequest(){
        return repository.getListEmployees().getValue();
    }
}
