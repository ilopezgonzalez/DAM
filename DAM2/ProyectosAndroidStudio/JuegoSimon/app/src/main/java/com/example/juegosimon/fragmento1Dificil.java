package com.example.juegosimon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

public class fragmento1Dificil extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmento1dificil, container, false);
        int [] modelos={R.id.textViewJuego1, R.id.textViewJuego2, R.id.textViewJuego3, R.id.textViewJuego4, R.id.textViewJuego5, R.id.textViewJuego6, R.id.textViewJuego7, R.id.textViewJuego8, R.id.textViewJuego9, R.id.textViewJuego10};
        if (MainActivity.coloresGanadores != null && MainActivity.coloresGanadores.length >= 10) {
            v.findViewById(R.id.textViewJuego1).setBackgroundColor(MainActivity.coloresGanadores[0]);
            v.findViewById(R.id.textViewJuego2).setBackgroundColor(MainActivity.coloresGanadores[1]);
            v.findViewById(R.id.textViewJuego3).setBackgroundColor(MainActivity.coloresGanadores[2]);
            v.findViewById(R.id.textViewJuego4).setBackgroundColor(MainActivity.coloresGanadores[3]);
            v.findViewById(R.id.textViewJuego5).setBackgroundColor(MainActivity.coloresGanadores[4]);
            v.findViewById(R.id.textViewJuego6).setBackgroundColor(MainActivity.coloresGanadores[5]);
            v.findViewById(R.id.textViewJuego7).setBackgroundColor(MainActivity.coloresGanadores[6]);
            v.findViewById(R.id.textViewJuego8).setBackgroundColor(MainActivity.coloresGanadores[7]);
            v.findViewById(R.id.textViewJuego9).setBackgroundColor(MainActivity.coloresGanadores[8]);
            v.findViewById(R.id.textViewJuego10).setBackgroundColor(MainActivity.coloresGanadores[9]);
        }

        //for (int modelo:modelos) {
          //  v.findViewById(modelo).setVisibility(View.INVISIBLE);
        //}

        return v;
    }
}
