package com.example.intend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ventana2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Aquí conectamos el Java con el XML de la ventana 1
        // Asegúrate de que el XML se llame exactamente "ventana2" o como le hayas puesto
        setContentView(R.layout.ventana2);
    }

    public void volver(View v) {
        // Intent(Contexto_actual, Clase_a_la_que_quieres_ir.class)
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
