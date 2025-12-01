package com.example.juegoparejas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JuegoFacilActivity extends AppCompatActivity {

    List<Integer> lista = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4);
    Button[] arrayBotones=new Button[8];

    private final View.OnClickListener receptorBotones=new View.OnClickListener();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_facil);
        Collections.shuffle(lista);

        arrayBotones[0]= (Button) findViewById(R.id.boton0);

        Button boton1 = (Button) findViewById(R.id.boton1);
        boton1.setOnClickListener(new ReceptorBotones());

        Button boton2 = (Button) findViewById(R.id.boton2);
        boton2.setOnClickListener(new ReceptorBotones());

        Button boton3 = (Button) findViewById(R.id.boton3);
        boton3.setOnClickListener(new ReceptorBotones());

        Button boton4 = (Button) findViewById(R.id.boton4);
        boton4.setOnClickListener(new ReceptorBotones());

        Button boton5 = (Button) findViewById(R.id.boton5);
        boton5.setOnClickListener(new ReceptorBotones());

        Button boton6 = (Button) findViewById(R.id.boton6);
        boton6.setOnClickListener(new ReceptorBotones());

        Button boton7 = (Button) findViewById(R.id.boton7);
        boton7.setOnClickListener(new ReceptorBotones());

        for (int i = 0; i < arrayBotones.length; i++) {
            arrayBotones[i].setOnClickListener(receptorBotones);
        }


        for (Integer numero : lista) {
            System.out.println(numero);
        }


    }

    private class ReceptorBotones implements View.OnClickListener {
        public void onClick(View v) {


        }
    }
}
