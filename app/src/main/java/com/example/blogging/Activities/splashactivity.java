package com.example.blogging.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blogging.R;
import com.example.blogging.Users.MainActivity;

public class splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashactivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1000);

    }
}