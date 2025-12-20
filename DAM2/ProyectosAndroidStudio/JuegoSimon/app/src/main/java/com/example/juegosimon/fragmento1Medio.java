package com.example.juegosimon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class fragmento1Medio extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmento1medio, container, false);

        if (MainActivity.coloresGanadores != null && MainActivity.coloresGanadores.length >= 7) {
            v.findViewById(R.id.textViewJuego1).setBackgroundColor(MainActivity.coloresGanadores[0]);
            v.findViewById(R.id.textViewJuego2).setBackgroundColor(MainActivity.coloresGanadores[1]);
            v.findViewById(R.id.textViewJuego3).setBackgroundColor(MainActivity.coloresGanadores[2]);
            v.findViewById(R.id.textViewJuego4).setBackgroundColor(MainActivity.coloresGanadores[3]);
            v.findViewById(R.id.textViewJuego5).setBackgroundColor(MainActivity.coloresGanadores[4]);
            v.findViewById(R.id.textViewJuego6).setBackgroundColor(MainActivity.coloresGanadores[5]);
            v.findViewById(R.id.textViewJuego7).setBackgroundColor(MainActivity.coloresGanadores[6]);
        }
        return v;
    }

}
