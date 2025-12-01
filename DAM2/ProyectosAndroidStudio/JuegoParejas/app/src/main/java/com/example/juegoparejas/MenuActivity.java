package com.example.juegoparejas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void nivelFacil(View v){

        Intent intentFacil=new Intent(this, JuegoFacilActivity.class);
        startActivity(intentFacil);

    }

    public void nivelMedio(View v){

        Intent intentMedio=new Intent(this, JuegoMedioActivity.class);
        startActivity(intentMedio);

    }

    public void nivelDificil(View v){

        Intent intentDificil=new Intent(this, JuegoDificilActivity.class);
        startActivity(intentDificil);

    }
}