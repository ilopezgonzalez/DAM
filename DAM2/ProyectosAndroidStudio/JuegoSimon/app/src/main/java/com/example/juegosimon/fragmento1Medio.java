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
 * fragmento1Medio
 * Fragmento que muestra el modelo de la secuencia en nivel medio.
 * Se encarga de gestionar la visibilidad de la secuencia según el estado del juego.
 */
public class fragmento1Medio extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos el layout del fragmento
        rootView = inflater.inflate(R.layout.fragmento1medio, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // LÓGICA DE PERSISTENCIA TRAS ROTACIÓN:
        // Si el juego ya ha comenzado (botón JUGAR pulsado), mantenemos los cuadros grises
        if (MainActivity.juegoIniciado) {
            resetearColores();
        }
        // Si el juego no ha empezado pero la secuencia existe, la mostramos para memorizar
        else if (MainActivity.coloresGanadores != null) {
            mostrarSecuenciaModelo();
        }
    }

    // Inicializa los 7 cuadros del nivel medio en gris
    public void resetearColores() {
        int[] idsModelos = {
                R.id.textViewJuego1,
                R.id.textViewJuego2,
                R.id.textViewJuego3,
                R.id.textViewJuego4,
                R.id.textViewJuego5,
                R.id.textViewJuego6,
                R.id.textViewJuego7
        };

        for (int id : idsModelos) {
            TextView tv = rootView.findViewById(id);
            if (tv != null) tv.setBackgroundColor(Color.LTGRAY);
        }
    }

    // Muestra la secuencia de colores que el usuario debe memorizar
    public void mostrarSecuenciaModelo() {
        if (rootView == null || MainActivity.coloresGanadores == null) return;

        int[] idsModelos = {
                R.id.textViewJuego1,
                R.id.textViewJuego2,
                R.id.textViewJuego3,
                R.id.textViewJuego4,
                R.id.textViewJuego5,
                R.id.textViewJuego6,
                R.id.textViewJuego7
        };

        for (int i = 0; i < idsModelos.length && i < MainActivity.coloresGanadores.length; i++) {
            TextView tv = rootView.findViewById(idsModelos[i]);
            if (tv != null) {
                tv.setBackgroundColor(MainActivity.coloresGanadores[i]);
            }
        }
    }
}