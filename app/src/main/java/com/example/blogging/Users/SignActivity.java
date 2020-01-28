package com.example.blogging.Users;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.blogging.Bbl.Userbbl;
import com.example.blogging.Model.Usermodel;
import com.example.blogging.Notification.Notification;
import com.example.blogging.R;
import com.example.blogging.RetrofitHelper.Helper;


public class SignActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    Button btnsign;
    private Userbbl userbbl;
//    String fname,lname,email,password,number,gender,dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        initToolbar();
        userbbl=new Userbbl();
        btnsign=findViewById(R.id.btnsignup);
        btnsign.setOnClickListener(this);

        sharedPreferences = getApplicationContext().getSharedPreferences("Register", 0);
        editor = sharedPreferences.edit();

        

    }
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Terms & Privacy");
    }
    public void signup(){
        Helper.StrictMode();
        String fname=sharedPreferences.getString("regfname",null);
        String lname=sharedPreferences.getString("reglname",null);
        String number=sharedPreferences.getString("regnumber",null);
        String dob=sharedPreferences.getString("regdate",null);
        String email=sharedPreferences.getString("regemail",null);
        String password=sharedPreferences.getString("regpass",null);
        String gender=sharedPreferences.getString("reggender",null);
        
        Usermodel usermodel=new Usermodel(fname,lname,email,dob,number,password,gender,"");
        if(userbbl.register(usermodel)==false){

            Toast.makeText(this, "Register Fail", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Succesfull", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(SignActivity.this, MainActivity.class);
            startActivity(intent);
            Notification.givenotification(SignActivity.this,"Register Successfully");
        }
    }

    @Override
    public void onClick(View v) {
        signup();
    }
}
