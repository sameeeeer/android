package com.example.blogging.Users;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blogging.Bbl.Userbbl;
import com.example.blogging.Activities.BlogActivity;
import com.example.blogging.Model.Usermodel;
import com.example.blogging.Notification.Notification;
import com.example.blogging.R;
import com.example.blogging.RegisterUi.NameActivity;
import com.example.blogging.RetrofitHelper.Helper;
import com.example.blogging.RetrofitHelper.UserSession;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText email, password;
    FloatingActionButton login;
    Button create;
    Userbbl userbbl;
    UserSession userSession;
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

        userbbl = new Userbbl();
        userSession=new UserSession(this);
        if (userSession.isActive()) {
            navigateDashboard();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnlogin:
                signIn();
                valdate();
                break;
            case R.id.btncreate:
                Intent intent = new Intent(MainActivity.this, NameActivity.class);
                startActivity(intent);
                valdate();
                break;

        }
    }

    public void signIn() {
        Helper.StrictMode();
        em = email.getText().toString();
        pass = password.getText().toString();
        Usermodel userlogin = userbbl.login(em, pass);
//        Log.d("user",userlogin.getEmail());
        if (userlogin != null) {
            userSession.startSession(userlogin);
            navigateDashboard();
            Notification.givenotification(MainActivity.this,"Login Successfully");
            Toast.makeText(this, "Successfully Login", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "password error ", Toast.LENGTH_SHORT).show();
        }
    }
    private void navigateDashboard() {
        Intent intent= new Intent(MainActivity.this, BlogActivity.class);
        startActivity(intent);
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
