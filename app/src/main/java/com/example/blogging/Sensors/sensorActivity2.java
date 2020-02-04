package com.example.blogging.Sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blogging.R;

public class sensorActivity2 extends AppCompatActivity {

    SensorManager sensorManager;
    Sensor sensor;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        textView = findViewById(R.id.tvsensor);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorGyro();

//        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
//        int i = 1;
//        for(Sensor s:sensorList){
//            textView.append(i +"."+s.getName() + "/n");
//            i++;
//        }
    }
    public void sensorGyro(){
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY); //TYPE_ACCELEROMETER //TYPE_GYROSCOPE
        SensorEventListener listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                textView.setText("X: "+ event.values[0] );
                if(event.values[0]<7){
                    Toast.makeText(sensorActivity2.this, "Object is too near", Toast.LENGTH_SHORT).show();
                }

//                textView.setText("X: "+ event.values[0] +"\n"+
//                        "Y: "+ event.values[1] +"\n"+
//                        "Z: "+ event.values[2] +"\n");
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        if (sensor != null){
            sensorManager.registerListener(listener,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        }else{
            Toast.makeText(this, "Requested sensor is not available", Toast.LENGTH_SHORT).show();
        }
    }
}
