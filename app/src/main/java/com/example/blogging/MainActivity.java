package com.example.blogging;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blogging.RegisterUi.NameActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText email, password;
    Button login, create;

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
                break;
            case R.id.btncreate:
                Intent intent = new Intent(MainActivity.this, NameActivity.class);
                startActivity(intent);
                break;

        }
    }





}

