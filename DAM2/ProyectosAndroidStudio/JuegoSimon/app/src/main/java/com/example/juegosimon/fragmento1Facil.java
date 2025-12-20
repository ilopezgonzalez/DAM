package com.example.juegosimon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class fragmento1Facil extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmento1facil, container, false);

        // Si MainActivity generó colores, los aplicamos aquí
            if (MainActivity.coloresGanadores!= null) {
                ((TextView) v.findViewById(R.id.textViewJuego1)).setBackgroundColor(MainActivity.coloresGanadores[0]);
                ((TextView) v.findViewById(R.id.textViewJuego2)).setBackgroundColor(MainActivity.coloresGanadores[1]);
                ((TextView) v.findViewById(R.id.textViewJuego3)).setBackgroundColor(MainActivity.coloresGanadores[2]);
                ((TextView) v.findViewById(R.id.textViewJuego4)).setBackgroundColor(MainActivity.coloresGanadores[3]);
                ((TextView) v.findViewById(R.id.textViewJuego5)).setBackgroundColor(MainActivity.coloresGanadores[4]);
            }
        return v;
    }
}
