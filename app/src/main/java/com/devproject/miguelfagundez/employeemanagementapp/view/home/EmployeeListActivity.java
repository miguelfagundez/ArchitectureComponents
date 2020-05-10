package com.devproject.miguelfagundez.employeemanagementapp.view.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.devproject.miguelfagundez.employeemanagementapp.R;
import com.devproject.miguelfagundez.employeemanagementapp.adapters.EmployeeAdapter;
import com.devproject.miguelfagundez.employeemanagementapp.listeners.EmployeeListener;
import com.devproject.miguelfagundez.employeemanagementapp.model.pojo.Employee;
import com.devproject.miguelfagundez.employeemanagementapp.utils.Constants;
import com.devproject.miguelfagundez.employeemanagementapp.utils.Testing;
import com.devproject.miguelfagundez.employeemanagementapp.view.BaseActivity;
import com.devproject.miguelfagundez.employeemanagementapp.view.details.EmployeeFragment;
import com.devproject.miguelfagundez.employeemanagementapp.viewmodel.EmployeeViewModel;

import java.util.List;

/********************************************
 * Class- EmployeeListActivity
 * This activity will display a list of employees
 * @author: Miguel Fagundez
 * @date: May 09th, 2020
 * @version: 1.0
 * *******************************************/
public class EmployeeListActivity extends BaseActivity implements EmployeeListener {

    private String TAG = "Test";

    // View members
    private Button button;
    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;

    // ViewModel Data
    private EmployeeViewModel viewModel;

    // Fragments
    private EmployeeFragment employeeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        setupViews();
        setupFragments();
        setupViewModel();
        setupObservers();
        setupListeners();
        setupRecyclerView();


    }

    private void setupViews() {
        //******************
        // Testing
        //******************
        button = findViewById(R.id.btnTestSearchEmployees);
        recyclerView = findViewById(R.id.rvEmployeeList);
    }

    private void setupFragments() {
        employeeFragment = new EmployeeFragment();
    }


    private void setupViewModel() {
        // Setup ViewModel
        viewModel = ViewModelProviders.of(EmployeeListActivity.this).get(EmployeeViewModel.class);
    }

    private void setupObservers(){
        viewModel.getListEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                if (employees != null){
                    adapter.setEmployeeInfo(employees);
                    Testing.printEmployeesName(viewModel.getListEmployees().getValue());
                }else{
                    Toast.makeText(EmployeeListActivity.this, "No employees found", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void setupListeners() {
        // Listeners
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.searchAllEmployees();
            }
        });
    }

    private void setupRecyclerView() {
        adapter = new EmployeeAdapter( this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.searchAllEmployees();
    }

    @Override
    public void employeeClick(String id, String name, String role) {

        // Here I will be calling a fragment
        Toast.makeText(this, "Click: " + id, Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();

        bundle.putString(Constants.EMPLOYEE_ID, id);
        bundle.putString(Constants.EMPLOYEE_NAME, name);
        bundle.putString(Constants.EMPLOYEE_ROLE, role);

        employeeFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.anim_in,
                        R.anim.anim_out,
                        R.anim.anim_in,
                        R.anim.anim_out)
                .replace(R.id.fragmentContainer, employeeFragment)
                .addToBackStack(employeeFragment.getTag())
                .commit();
    }
}
