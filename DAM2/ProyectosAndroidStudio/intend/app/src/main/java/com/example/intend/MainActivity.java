package com.example.intend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void abrirVentana1(View v) {
        // Intent(Contexto_actual, Clase_a_la_que_quieres_ir.class)
        Intent intent = new Intent(this, ventana1.class);
        startActivity(intent);
    }

    public void abrirVentana2(View v) {
        Intent intent = new Intent(this, ventana2.class);
        startActivity(intent);
    }
}