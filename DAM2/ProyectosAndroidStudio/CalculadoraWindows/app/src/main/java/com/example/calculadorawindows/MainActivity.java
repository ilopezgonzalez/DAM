package com.example.calculadorawindows;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int operador1;
    private int operador2;
    private String operacion;
    private TextView pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton0 = (Button) findViewById(R.id.boton0);
        boton0.setOnClickListener(new ReceptorBotonesNumeros());

        Button boton1 = (Button) findViewById(R.id.boton1);
        boton1.setOnClickListener(new ReceptorBotonesNumeros());

        Button boton2 = (Button) findViewById(R.id.boton2);
        boton2.setOnClickListener(new ReceptorBotonesNumeros());

        Button boton3 = (Button) findViewById(R.id.boton3);
        boton3.setOnClickListener(new ReceptorBotonesNumeros());

        Button boton4 = (Button) findViewById(R.id.boton4);
        boton4.setOnClickListener(new ReceptorBotonesNumeros());

        Button boton5 = (Button) findViewById(R.id.boton5);
        boton5.setOnClickListener(new ReceptorBotonesNumeros());

        Button boton6 = (Button) findViewById(R.id.boton6);
        boton6.setOnClickListener(new ReceptorBotonesNumeros());

        Button boton7 = (Button) findViewById(R.id.boton7);
        boton7.setOnClickListener(new ReceptorBotonesNumeros());

        Button boton8 = (Button) findViewById(R.id.boton8);
        boton8.setOnClickListener(new ReceptorBotonesNumeros());

        Button boton9 = (Button) findViewById(R.id.boton9);
        boton9.setOnClickListener(new ReceptorBotonesNumeros());

        Button botonComa = (Button) findViewById(R.id.botonComa);
        botonComa.setOnClickListener(new ReceptorBotonesNumeros());

        Button botonMas = (Button) findViewById(R.id.botonMas);
        botonMas.setOnClickListener(new ReceptorBotonesOperaciones());

        Button botonMenos = (Button) findViewById(R.id.botonMenos);
        botonMenos.setOnClickListener(new ReceptorBotonesOperaciones());

        Button botonPor = (Button) findViewById(R.id.botonPor);
        botonPor.setOnClickListener(new ReceptorBotonesOperaciones());

        Button botonBorrar = (Button) findViewById(R.id.botonBorrar);
        botonBorrar.setOnClickListener(new ReceptorBotonesOperaciones());

        Button botonIgual = (Button) findViewById(R.id.botonIgual);
        botonIgual.setOnClickListener(new ReceptorBotonesOperaciones());

    }

    ;

    private class ReceptorBotonesNumeros implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            pantalla = (TextView) findViewById(R.id.pantalla);
            if (v.getId() == R.id.boton0) {
                pantalla.append("0");
            } else if (v.getId() == R.id.boton1) {
                pantalla.append("1");
            } else if (v.getId() == R.id.boton2) {
                pantalla.append("2");
            } else if (v.getId() == R.id.boton3) {
                pantalla.append("3");
            } else if (v.getId() == R.id.boton4) {
                pantalla.append("4");
            } else if (v.getId() == R.id.boton5) {
                pantalla.append("5");
            } else if (v.getId() == R.id.boton6) {
                pantalla.append("6");
            } else if (v.getId() == R.id.boton7) {
                pantalla.append("7");
            } else if (v.getId() == R.id.boton8) {
                pantalla.append("8");
            } else if (v.getId() == R.id.boton9) {
                pantalla.append("9");
            } else if (v.getId() == R.id.botonComa) {
                pantalla.append(".");
            }

        }


    }

    private class ReceptorBotonesOperaciones implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            pantalla = (TextView) findViewById(R.id.pantalla);
            int resultado;
            if (v.getId() == R.id.botonMas) {
                operador1 = Integer.parseInt(pantalla.getText().toString());
                operacion = "+";
                pantalla.setText("");
            } else if (v.getId() == R.id.botonMenos) {
                operador1 = Integer.parseInt(pantalla.getText().toString());
                operacion = "-";
                pantalla.setText("");
            } else if (v.getId() == R.id.botonPor) {
                operador1 = Integer.parseInt(pantalla.getText().toString());
                operacion = "*";
                pantalla.setText("");
            } else if (v.getId() == R.id.botonIgual) {
                operador2 = Integer.parseInt(pantalla.getText().toString());
                if (operacion.equals("+")) {
                    resultado = operador1 + operador2;
                    pantalla.setText(String.valueOf(resultado));
                } else if (operacion.equals("-")) {
                    resultado = operador1 - operador2;
                    pantalla.setText(String.valueOf(resultado));
                } else if (operacion.equals("*")) {
                    resultado = operador1 * operador2;
                    pantalla.setText(String.valueOf(resultado));
                }
            } else if (v.getId()==R.id.botonBorrar){
                pantalla.setText("");
                operador1=0;
                operador2=0;
                operacion="";
            }
        }

        }


    }

