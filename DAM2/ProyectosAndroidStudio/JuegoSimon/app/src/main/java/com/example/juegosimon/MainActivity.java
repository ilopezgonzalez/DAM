package com.example.juegosimon;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    public final int[] COLORES = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

    private Fragment miFragmentoModelo;
    private Fragment miFragmentoSolucion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragmentobotones fragmentoSuperior = new fragmentobotones();
        transaction.add(R.id.LinearLayoutBotones, fragmentoSuperior);
        transaction.commit();
    }

    public void seleccionarNivel(View v) {

        if (v.getId() == R.id.botonFacil) {
            miFragmentoModelo = new fragmento1Facil();
            miFragmentoSolucion = new fragmento2();
            System.out.println("1");
        } else if (v == findViewById(R.id.botonMedio)) {
            miFragmentoModelo = new fragmento1Medio();
            miFragmentoSolucion = new fragmento2();

            System.out.println("2");
        } else if (v == findViewById(R.id.botonDificil)) {
            miFragmentoModelo = new fragmento1Dificil();
            miFragmentoSolucion = new fragmento2();
            System.out.println("3");
        } else {
            miFragmentoModelo = new fragmento1Facil();
            miFragmentoSolucion = new fragmento2();
            System.out.println("4");
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.LinearLayoutModelo, miFragmentoModelo);
        transaction.replace(R.id.LinearLayoutJuego, miFragmentoSolucion);

        transaction.addToBackStack(null);
        transaction.commit();
    }
}




