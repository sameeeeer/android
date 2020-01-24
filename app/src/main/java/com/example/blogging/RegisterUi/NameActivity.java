package com.example.blogging.RegisterUi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blogging.R;
import com.google.android.material.textfield.TextInputLayout;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {
TextInputLayout fname,lname;
Button name;
    String et_fname;
    String et_lname;

private SharedPreferences sharedPreferences;
private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);


        fname = findViewById(R.id.txtfnl);
        lname = findViewById(R.id.txtlnl);
        name = findViewById(R.id.btnname);

        name.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {

            et_fname = fname.getEditText().getText().toString().trim();
            et_lname = lname.getEditText().getText().toString().trim();


        sharedPreferences = getApplicationContext().getSharedPreferences("Register",0);
        editor = sharedPreferences.edit();


        editor.putString("regfname",et_fname);
        editor.putString("reglname",et_lname);
        editor.commit();

        if (validate()) {
            Intent intent = new Intent(NameActivity.this, DateActivity.class);
            startActivity(intent);
        }
    }

    public boolean validate(){
        if (TextUtils.isEmpty(et_fname)){
            fname.setError("Please enter First Name");
            fname.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(et_lname)){
            lname.setError("Please enter First Name");
            lname.requestFocus();
            return false;
        }

        return true;
    }
}
