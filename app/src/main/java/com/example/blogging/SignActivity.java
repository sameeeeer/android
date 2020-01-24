package com.example.blogging;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class SignActivity extends AppCompatActivity{

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    Button btnsign;
//    String fname,lname,email,password,number,gender,dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        btnsign = findViewById(R.id.btnsignup);


        sharedPreferences = getApplicationContext().getSharedPreferences("Register", 0);
        editor = sharedPreferences.edit();


    }
}

