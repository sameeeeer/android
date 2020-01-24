package com.example.blogging.RegisterUi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blogging.R;

public class GenderActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup radioGroup;
    RadioButton female, male;
    Button gender;
    String ugender;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        radioGroup = findViewById(R.id.rg);
        female = findViewById(R.id.rdfemale);
        male = findViewById(R.id.rdmale);
        gender=findViewById(R.id.btngender);

        gender.setOnClickListener(this);

        sharedPreferences = getApplicationContext().getSharedPreferences("Register", 0);
        editor = sharedPreferences.edit();

        String regdate = sharedPreferences.getString("regdate", null);
          Toast.makeText(this, regdate, Toast.LENGTH_SHORT).show();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i == R.id.rdfemale) {
                    ugender = "Female";
                    Toast.makeText(GenderActivity.this, ugender, Toast.LENGTH_SHORT).show();
                }
                if (i == R.id.rdmale) {
                    ugender = "Male";
                    Toast.makeText(GenderActivity.this, ugender, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }




    @Override
    public void onClick(View v) {
        editor.putString("reggender",ugender);
        editor.commit();
        if (validate()) {
            Intent intent = new Intent(GenderActivity.this, NumberActivity.class);
            startActivity(intent);
        }
    }
    public boolean validate() {
        if (TextUtils.isEmpty(ugender)) {
            Toast.makeText(this, "Select Your Gender", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    }
