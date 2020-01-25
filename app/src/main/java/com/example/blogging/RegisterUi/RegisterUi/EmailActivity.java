package com.example.blogging.RegisterUi.RegisterUi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blogging.R;
import com.google.android.material.textfield.TextInputLayout;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    TextInputLayout emaail;
    Button btnemail;
    String et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);


        emaail = findViewById(R.id.txteml);
        btnemail = findViewById(R.id.btnemal);

        btnemail.setOnClickListener(this);

        sharedPreferences = getApplicationContext().getSharedPreferences("Register", 0);
        editor = sharedPreferences.edit();

        String regnumber = sharedPreferences.getString("regnumber", null);
        Toast.makeText(this, regnumber, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onClick(View v) {
        et_email = emaail.getEditText().getText().toString().trim();



        editor.putString("regemail",et_email);
        editor.commit();
        if (validate()) {
            Intent intent = new Intent(EmailActivity.this, PassActivity.class);
            startActivity(intent);
        }
    }
    public boolean validate(){
        if (TextUtils.isEmpty(et_email) && !Patterns.EMAIL_ADDRESS.matcher(et_email).matches()){
            emaail.setError("Please enter your email again.");
            emaail.requestFocus();
            return false;
        }



        return true;
    }
}
