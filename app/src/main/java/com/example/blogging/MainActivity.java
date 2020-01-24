package com.example.blogging;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blogging.RegisterUi.NameActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText email, password;
    Button login, create;
    String em , pass;
    private static final String IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.txtemail);
        password = findViewById(R.id.txtpswd);
        login = findViewById(R.id.btnlogin);
        create = findViewById(R.id.btncreate);

        login.setOnClickListener(this);
        create.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnlogin:
                valdate();
                break;
            case R.id.btncreate:
                Intent intent = new Intent(MainActivity.this, NameActivity.class);
                startActivity(intent);
                valdate();
                break;

        }
    }


    public  boolean valdate(){
        if (TextUtils.isEmpty(em)){
            email.setError("please enter email address");
            email.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(pass)){
            password.setError("please enter password");
            password.requestFocus();
            return false;
        }


        return true;
    }

}
