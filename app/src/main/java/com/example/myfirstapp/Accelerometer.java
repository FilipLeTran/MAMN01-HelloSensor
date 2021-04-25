package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    TextView xAxis;
    TextView yAxis;
    TextView zAxis;

    TextView directionText;

    private String[] direction = {null, null};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        // Initialize values
        xAxis = findViewById(R.id.xAxis);
        yAxis = findViewById(R.id.yAxis);
        zAxis = findViewById(R.id.zAxis);
        directionText = findViewById(R.id.directionText);


        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        // Retrieve phone coordinates
        float xValue = event.values[0];
        float yValue = event.values[1];
        float zValue = event.values[2];

        // Display coordinates on screen
        xAxis.setText("X: " + Float.toString(xValue));
        yAxis.setText("Y: " + Float.toString(yValue));
        zAxis.setText("Z: " + Float.toString(zValue));

        // Gives direction depending on x-axis value
        if(xValue < -0.5) {
            direction[0] = "Right";
        } else if (xValue > 0.5) {
            direction[0] = "Left";
        } else {
            direction[0] = null;
        }

        // Gives direction depending on y-axis value
        if(yValue < -0.5) {
            direction[1] = "Down";
        } else if (yValue > 0.5) {
            direction[1] = "Up";
        } else {
            direction[1] = null;
        }


        // Shows direction of phone in text and changes background color when flat
        if(direction[0] != null || direction[1] != null) {
            if(direction[0] != null && direction[1] != null) {
                directionText.setText(direction[0] + " + " + direction[1]);
            } else if (direction[0] != null) {
                directionText.setText(direction[0]);
            } else if (direction[1] != null) {
                directionText.setText(direction[1]);
            }

            getWindow().getDecorView().setBackgroundColor(Color.WHITE); // Change background to white if previously green
        } else {
            directionText.setText("FLAT");
            getWindow().getDecorView().setBackgroundColor(Color.GREEN); // change background to green
        }

    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}