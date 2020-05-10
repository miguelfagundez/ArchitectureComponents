package com.devproject.miguelfagundez.employeemanagementapp.view.details;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devproject.miguelfagundez.employeemanagementapp.R;
import com.devproject.miguelfagundez.employeemanagementapp.utils.Constants;
import com.google.android.material.textfield.TextInputEditText;


public class EmployeeFragment extends Fragment {

    // View Members
    private TextInputEditText tvId;
    private TextInputEditText tvName;
    private TextInputEditText tvRole;

    public EmployeeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupViews();

    }

    private void setupViews() {
        tvId = getActivity().findViewById(R.id.etEmployeeFirstName);
        tvName = getActivity().findViewById(R.id.etEmployeeLastName);
        tvRole = getActivity().findViewById(R.id.etEmployeeRole);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee, container, false);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        setupViews();

        String id = getArguments().getString(Constants.EMPLOYEE_ID);
        String name = getArguments().getString(Constants.EMPLOYEE_NAME);
        String role = getArguments().getString(Constants.EMPLOYEE_ROLE);

        if (id != null && name != null && role != null){
            tvId.setText(id);
            tvName.setText(name);
            tvRole.setText(role);

            tvId.setEnabled(false);
            tvName.setEnabled(false);
            tvRole.setEnabled(false);
        }

    }
}
