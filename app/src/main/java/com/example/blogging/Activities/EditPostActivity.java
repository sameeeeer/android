package com.example.blogging.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blogging.Bbl.PostBbl;
import com.example.blogging.Model.Post;
import com.example.blogging.R;
import com.example.eventscheduler.Sensor.ShakeDetector;

public class EditPostActivity extends AppCompatActivity {
EditText txtcate, txtdesc;
Button btnup;
PostBbl postBbl = new PostBbl();
Post post ;

    private ShakeDetector mShakeDetector;

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mShakeDetector);
    }

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);
        post = postBbl.findpost(getIntent().getStringExtra("Id"));


        txtcate = findViewById(R.id.category);
        txtdesc = findViewById(R.id.stat);
        btnup = findViewById(R.id.Update);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {

                txtcate.setText("");
                txtdesc.setText("");
            }
        });

        txtcate.setText(post.getCategory());
        txtdesc.setText(post.getStatus());
        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post = new Post(txtdesc.getText().toString(),txtcate.getText().toString());
                if (postBbl.updatepost(getIntent().getStringExtra("Id"),post)){
                    Toast.makeText(EditPostActivity.this, "Post Updated", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });




    }
}
