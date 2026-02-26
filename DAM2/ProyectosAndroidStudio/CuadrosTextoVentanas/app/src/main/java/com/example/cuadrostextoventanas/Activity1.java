package com.example.cuadrostextoventanas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Activity1 extends AppCompatActivity {
    
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        
        textview = findViewById(R.id.textView);

        ConstraintLayout miLayout = findViewById(R.id.activity1);
        miLayout.setBackgroundColor(Color.GREEN);

        // 1. Recuperar el Intent que inició esta actividad
        Intent intent = getIntent(); 

        // 2. Extraer los valores usando las mismas claves que en MainActivity
        int valor1 = intent.getIntExtra("valor1", 0); // 0 es un valor por defecto
        int valor2 = intent.getIntExtra("valor2", 0);

        // 3. Calcular la suma
        int suma = valor1 + valor2;

        // 4. Convertir la suma a String y mostrarla en el TextView
        textview.setText(String.valueOf(suma));
    }
}
