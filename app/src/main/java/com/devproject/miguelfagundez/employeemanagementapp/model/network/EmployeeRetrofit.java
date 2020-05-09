package com.devproject.miguelfagundez.employeemanagementapp.model.network;

import com.devproject.miguelfagundez.employeemanagementapp.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/********************************************
 * Class- EmployeeRetrofit
 * Create the retrofit service using a
 * singleton pattern
 * @author: Miguel Fagundez
 * @date: May 09th, 2020
 * @version: 1.0
 * *******************************************/
public class EmployeeRetrofit {

    //*******************************
    // Singleton pattern
    //*******************************
    private static EmployeeService service = null;

    public static EmployeeService getEmployeeService(){
        if (service == null){
            service = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(EmployeeService.class);
        }
        return service;
    }
}
