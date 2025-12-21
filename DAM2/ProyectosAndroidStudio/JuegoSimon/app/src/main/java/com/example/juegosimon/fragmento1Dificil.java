package com.example.juegosimon;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * fragmento1Dificil
 * Fragmento que muestra el modelo de la secuencia en nivel difícil (10 cuadros).
 * Se sincroniza con el estado de MainActivity para persistir tras la rotación.
 */
public class fragmento1Dificil extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos el layout del fragmento
        rootView = inflater.inflate(R.layout.fragmento1dificil, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // LÓGICA DE PERSISTENCIA TRAS ROTACIÓN:
        // Si el juego ya está iniciado, reseteamos a gris
        if (MainActivity.juegoIniciado) {
            resetearColores();
        }
        // Si no ha iniciado pero ya existe la secuencia, la mostramos
        else if (MainActivity.coloresGanadores != null) {
            mostrarSecuenciaModelo();
        }
    }

    // Inicializa los 10 cuadros en gris
    public void resetearColores() {
        int[] idsModelos = {
                R.id.textViewJuego1, R.id.textViewJuego2, R.id.textViewJuego3,
                R.id.textViewJuego4, R.id.textViewJuego5, R.id.textViewJuego6,
                R.id.textViewJuego7, R.id.textViewJuego8, R.id.textViewJuego9,
                R.id.textViewJuego10
        };

        for (int id : idsModelos) {
            TextView tv = rootView.findViewById(id);
            if (tv != null) tv.setBackgroundColor(Color.LTGRAY);
        }
    }

    // Muestra la secuencia generada por MainActivity
    public void mostrarSecuenciaModelo() {
        if (rootView == null || MainActivity.coloresGanadores == null) return;

        int[] idsModelos = {
                R.id.textViewJuego1, R.id.textViewJuego2, R.id.textViewJuego3,
                R.id.textViewJuego4, R.id.textViewJuego5, R.id.textViewJuego6,
                R.id.textViewJuego7, R.id.textViewJuego8, R.id.textViewJuego9,
                R.id.textViewJuego10
        };

        for (int i = 0; i < idsModelos.length && i < MainActivity.coloresGanadores.length; i++) {
            TextView tv = rootView.findViewById(idsModelos[i]);
            if (tv != null) {
                tv.setBackgroundColor(MainActivity.coloresGanadores[i]);
            }
        }
    }
}