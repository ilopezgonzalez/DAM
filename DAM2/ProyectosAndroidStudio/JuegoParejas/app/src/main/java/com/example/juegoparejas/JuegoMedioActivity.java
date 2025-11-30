package com.example.juegoparejas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JuegoMedioActivity extends AppCompatActivity {

    List<Integer> lista= Arrays.asList(1,1,2,2,3,3,4,4,5,5,6,6);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_medio);
        Collections.shuffle(lista);
        for (Integer numero:lista) {
            System.out.println(numero);
        }
    }
}
