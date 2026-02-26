package com.example.cuadrostextoventanas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        ConstraintLayout miLayout = findViewById(R.id.activity3);
        miLayout.setBackgroundColor(Color.RED);


    }
}
