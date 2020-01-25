package com.example.blogging.RegisterUi.RegisterUi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blogging.R;

public class DateActivity extends AppCompatActivity implements View.OnClickListener {
private SharedPreferences sharedPreferences;
private SharedPreferences.Editor editor;

DatePicker picker;
Button date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);


        picker = findViewById(R.id.datePicker1);
        date = findViewById(R.id.btndate);

        date.setOnClickListener(this);

        sharedPreferences = getApplicationContext().getSharedPreferences("Register",0);
        editor = sharedPreferences.edit();
    String fname = sharedPreferences.getString("regfname",null);
        Toast.makeText(this, fname, Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onClick(View v) {
        String selectdate = picker.getDayOfMonth()+"/"+(picker.getMonth()+1)+"/"+picker.getYear();
        editor.putString("regdate",selectdate);
        editor.commit();

        Intent intent = new Intent(DateActivity.this,GenderActivity.class);
        startActivity(intent);
    }


}
