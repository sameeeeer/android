package com.example.blogging.Users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blogging.APIs.UserAPIs;
import com.example.blogging.Activities.BlogActivity;
import com.example.blogging.Bbl.Userbbl;
import com.example.blogging.Fragment.UserProfileFragment;
import com.example.blogging.Model.Usermodel;
import com.example.blogging.R;
import com.example.blogging.RetrofitHelper.Helper;
import com.example.blogging.RetrofitHelper.UserSession;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Header;
import retrofit2.http.Url;

public class EdituserActivity extends AppCompatActivity {
    EditText txtfn, txtln, txtem, txtph, txtdob, txtpass;
    Button btnupdate;
    Userbbl userbbl = new Userbbl();
    Usermodel usermodel;
    UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edituser);

        txtfn = findViewById(R.id.txtfn);
        txtln = findViewById(R.id.txtlsn);
        txtem = findViewById(R.id.txtem);
        txtph = findViewById(R.id.txtph);
        txtdob = findViewById(R.id.txtdt);
        txtpass = findViewById(R.id.txtpss);
        btnupdate = findViewById(R.id.btnupdate);
        Context context;
        usermodel = userbbl.UserProfile(getIntent().getStringExtra("Id"));

        txtfn.setText(usermodel.getFname());
        txtln.setText(usermodel.getLname());
        txtem.setText(usermodel.getEmail());
        txtph.setText(usermodel.getNumber());
        txtdob.setText(usermodel.getDob());
        txtpass.setText(usermodel.getPassword());
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = usermodel.get_id();

                Usermodel usermodel = new Usermodel(txtfn.getText().toString(),txtln.getText().toString(),txtem.getText().toString()
                        ,txtdob.getText().toString(),txtph.getText().toString(),txtpass.getText().toString());
                if (userbbl.updateProfile(usermodel,id)){
                    Intent intent = new Intent(EdituserActivity.this, BlogActivity.class);
                    startActivity(intent);
                    Toast.makeText(EdituserActivity.this, "User Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(EdituserActivity.this, "Update fail", Toast.LENGTH_SHORT).show();
                }
            }
        });






    }
}