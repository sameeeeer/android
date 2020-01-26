package com.example.blogging.RegisterUi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blogging.R;
import com.example.blogging.Users.SignActivity;
import com.google.android.material.textfield.TextInputLayout;

public class PassActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    TextInputLayout password;
    Button btnpass;
    String et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);


        password = findViewById(R.id.pass);
        btnpass = findViewById(R.id.btnpas);

        btnpass.setOnClickListener(this);

        sharedPreferences = getApplicationContext().getSharedPreferences("Register", 0);
        editor = sharedPreferences.edit();

        String regemail = sharedPreferences.getString("regemail", null);
        Toast.makeText(this, regemail, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onClick(View v) {
        et_pass = password.getEditText().getText().toString().trim();


        editor.putString("regpass", et_pass);
        editor.commit();

        if (validate()) {
            Intent intent = new Intent(PassActivity.this, SignActivity.class);
            startActivity(intent);
        }
    }

    public boolean validate() {
        if (TextUtils.isEmpty(et_pass)) {
            password.setError("Please enter a password");
            password.requestFocus();
            return false;
        }
        return true;
    }
}
