package com.example.blogging.RegisterUi.RegisterUi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blogging.R;
import com.google.android.material.textfield.TextInputLayout;

public class NumberActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    TextInputLayout number;
    Button btnnumber;
    String et_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);


        number=findViewById(R.id.txtnuml);
        btnnumber=findViewById(R.id.btnnumber);

        btnnumber.setOnClickListener(this);

        sharedPreferences = getApplicationContext().getSharedPreferences("Register", 0);
        editor = sharedPreferences.edit();

        String reggender = sharedPreferences.getString("reggender", null);
        Toast.makeText(this, reggender, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        et_number = number.getEditText().getText().toString().trim();


        editor.putString("regnumber", et_number);
        editor.commit();
        if (validate()) {
            Intent intent = new Intent(NumberActivity.this, EmailActivity.class);
            startActivity(intent);
        }
    }

    public boolean validate(){
        if (TextUtils.isEmpty(et_number)){
            number.setError("Please enter your number");
            number.requestFocus();
            return false;
        }
        return true;
    }
}
