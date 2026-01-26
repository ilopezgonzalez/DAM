package com.example.ejerciciopropuestosensorproximidad;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor sensorProximidad;
    private SensorEventListener escuchadorSensorProximidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorProximidad = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        escuchadorSensorProximidad = new SensorEventListener() {
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }

            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[0] < sensorProximidad.getMaximumRange()) {
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }else{
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
            }


            }

            ;
        mSensorManager.registerListener(escuchadorSensorProximidad,sensorProximidad,2*1000*1000);
        }
    }