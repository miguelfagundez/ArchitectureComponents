package com.devproject.miguelfagundez.employeemanagementapp.model.network;

import android.util.Log;

import com.devproject.miguelfagundez.employeemanagementapp.model.pojo.Employee;
import com.devproject.miguelfagundez.employeemanagementapp.model.responses.AllEmployeeResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/********************************************
 * Class- EmployeeApiClient
 * Model layer where I connect and make a call.
 * This layer connect with repository
 * @author: Miguel Fagundez
 * @date: May 09th, 2020
 * @version: 1.0
 * *******************************************/
public class EmployeeApiClient {

    private static final String TAG = "Test";
    //******************************************
    // Singleton pattern
    //******************************************
    private static EmployeeApiClient client = null;

    // Data Member LiveData
    private MutableLiveData<List<Employee>> listEmployees;

    public static EmployeeApiClient getInstance(){
        if (client == null){
            client = new EmployeeApiClient();
        }
        return client;
    }

    private EmployeeApiClient(){
        listEmployees = new MutableLiveData<>();
    }

    public LiveData<List<Employee>> getListOfEmployees(){
        return listEmployees;
    }

    //******************************************
    // Making the network connection - Call
    //******************************************
    public void searchAllEmployees() {
        EmployeeService service = EmployeeRetrofit.getEmployeeService();

        Call<AllEmployeeResponse> response = service.getListEmployees();
        response.enqueue(new Callback<AllEmployeeResponse>() {
            @Override
            public void onResponse(Call<AllEmployeeResponse> call, Response<AllEmployeeResponse> response) {
                if(response.code() == 200){
                    listEmployees.setValue(new ArrayList<>(response.body().getData()));
                    Log.e(TAG, "Response: 200 code");
                }else{
                    Log.e(TAG, "onFailure: Another code = " + response.code());
                }
            }

            @Override
            public void onFailure(Call<AllEmployeeResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: Error", t);
            }
        });
    }
}
