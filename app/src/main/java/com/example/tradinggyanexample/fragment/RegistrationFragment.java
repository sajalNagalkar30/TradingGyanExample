package com.example.tradinggyanexample.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


import com.example.tradinggyanexample.R;
import com.example.tradinggyanexample.activity.MyActivity;
import com.example.tradinggyanexample.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationFragment extends Fragment {

    private EditText nameInput, emailInput, phoneInput, passwordInput;
    Button regBtn;
        ;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_registration, container, false);
        nameInput = view.findViewById(R.id.nameInput);
        emailInput = view.findViewById(R.id.emailInput);
        phoneInput = view.findViewById(R.id.phoneInput);
        passwordInput = view.findViewById(R.id.passwordInput);
        regBtn = view.findViewById(R.id.regBtn);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
                Log.e("reg button", "clicked");
            }
        });
        return view;
    }

    public void registerUser() {
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String phone = phoneInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (TextUtils.isEmpty(name)){
            MyActivity.appPreference.showToast("Your name is required.");
        } else if (TextUtils.isEmpty(email)){
            MyActivity.appPreference.showToast("Your email is required.");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            MyActivity.appPreference.showToast("Invalid email");
        } else if (TextUtils.isEmpty(password)){
            MyActivity.appPreference.showToast("Password required");
        } else if (password.length() < 6){
            MyActivity.appPreference.showToast("Create a password at least 6 characters long.");
        }
        else {
            Call<User> userCall = MyActivity.serviceApi.doRegistration(name, email, phone, password);
            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.body().getResponse().equals("inserted")){
                        Log.e("response", String.valueOf(response.body().getResponse()));
                        nameInput.setText("");
                        emailInput.setText("");
                        phoneInput.setText("");
                        passwordInput.setText("");
                        MyActivity.appPreference.showToast("Registered Successfully");
                    } else if (response.body().getResponse().equals("exists")){
                        MyActivity.appPreference.showToast("This email already exists");
                    } else if (response.body().getResponse().equals("error")){
                        MyActivity.appPreference.showToast("Oops! something went wrong.");
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                }
            });
        }

    }
}
