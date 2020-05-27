package com.example.tradinggyanexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tradinggyanexample.MainActivity;
import com.example.tradinggyanexample.R;
import com.example.tradinggyanexample.constants.Constant;
import com.example.tradinggyanexample.extras.AppPreference;
import com.example.tradinggyanexample.fragment.LoginFragment;
import com.example.tradinggyanexample.fragment.ProfileFragment;
import com.example.tradinggyanexample.fragment.RegistrationFragment;
import com.example.tradinggyanexample.services.MyInterface;
import com.example.tradinggyanexample.services.RetrofitClient;
import com.example.tradinggyanexample.services.ServiceApi;

public class MyActivity extends AppCompatActivity implements MyInterface {
    public static AppPreference appPreference;
    public static String c_date;
    FrameLayout container_layout;
    public static ServiceApi serviceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myactivity);

        container_layout = findViewById(R.id.fragment_container);
        appPreference = new AppPreference(this);

        //Log.e("created_at: ", c_date);

        serviceApi = RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(ServiceApi.class);

        if (container_layout != null) {
            if (savedInstanceState != null) {
                return;
            }

            //check login status from sharedPreference
            if (appPreference.getLoginStatus()) {
                //when true
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                // when get false
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, new LoginFragment())
                        .commit();
            }
        }

    } // ending onCreate


    // overridden from MyInterface
    @Override
    public void register() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new RegistrationFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void login(String name, String email, String created_at) {
        appPreference.setDisplayName(name);
        appPreference.setDisplayEmail(email);
        appPreference.setCreDate(created_at);
        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void logout() {
        appPreference.setLoginStatus(false);
        appPreference.setDisplayName("Name");
        appPreference.setDisplayEmail("Email");
        appPreference.setCreDate("DATE");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new LoginFragment())
                .commit();
    }
}

