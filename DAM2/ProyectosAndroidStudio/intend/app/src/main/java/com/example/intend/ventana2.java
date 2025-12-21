package com.example.intend;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ventana2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Aquí conectamos el Java con el XML de la ventana 1
        // Asegúrate de que el XML se llame exactamente "ventana1" o como le hayas puesto
        setContentView(R.layout.ventana2);
    }
}
