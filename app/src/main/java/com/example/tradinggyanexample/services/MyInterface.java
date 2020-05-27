package com.example.tradinggyanexample.services;

import android.content.Intent;

import com.example.tradinggyanexample.MainActivity;

public interface MyInterface {
    // for login
    void register();
    void login(String name, String email, String created_at);
    void logout();
}
