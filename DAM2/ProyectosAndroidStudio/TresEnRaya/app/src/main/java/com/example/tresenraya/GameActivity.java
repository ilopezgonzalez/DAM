package com.example.tresenraya;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private TextView pantalla;
    private Button botonReiniciar;
    Button[] botones = new Button[9];
    String[] tablero = new String[9]; // guarda el estado de cada casilla
    boolean turnoJugador = true; // true = Jugador 1 (X), false = Jugador 2 (O)
    int numeroTurnos=0;
    boolean partidaTerminada = false; // para mantener el estado tras girar

    int[][] combinacionesGanadoras = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = findViewById(R.id.pantalla);
        botonReiniciar = findViewById(R.id.buttonReiniciar);

        // Asignar botones y listener
        botones[0] = findViewById(R.id.boton0);
        botones[1] = findViewById(R.id.boton1);
        botones[2] = findViewById(R.id.boton2);
        botones[3] = findViewById(R.id.boton3);
        botones[4] = findViewById(R.id.boton4);
        botones[5] = findViewById(R.id.boton5);
        botones[6] = findViewById(R.id.boton6);
        botones[7] = findViewById(R.id.boton7);
        botones[8] = findViewById(R.id.boton8);

        for (Button b : botones) {
            b.setOnClickListener(new ReceptorBotones());
        }

        botonReiniciar.setOnClickListener(this::reiniciar);

        // Inicializa tablero vacío (por si es la primera vez)
        for (int i = 0; i < 9; i++) {
            tablero[i] = "";
        }

        // Iniciar partida automáticamente
        reiniciar(null);
    }

    // Controlador de clics de los botones del tablero
    private class ReceptorBotones implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (partidaTerminada) return; // si ya hay ganador, no permitir más jugadas

            Button button = (Button) v;
            if(numeroTurnos%3==0){
                if (button.getText().toString().equals("")) {
                    if (turnoJugador) {
                        button.setText("X");
                        if (button.getText().toString().equals("O")){
                            button.setText("");
                        }
                        pantalla.setText("Turno del jugador 2: O");
                        numeroTurnos++;
                    } else {
                        button.setText("O");
                        if(button.getText().toString().equals("X")){
                            button.setText("");
                        }
                        pantalla.setText("Turno del jugador 1: X");
                        numeroTurnos++;

                    }
            }else{
                 if(button.getText().toString().equals("")){
                     if(turnoJugador){
                         button.setText("X");
                         pantalla.setText("Turno del jugador 2: O");
                     }else{
                         button.setText("O");
                         pantalla.setText("Turno del jugador 1: X");
                     }
                 }
                }


                // Guardar movimiento en el array tablero
                for (int i = 0; i < botones.length; i++) {
                    if (v.getId() == botones[i].getId()) {
                        tablero[i] = button.getText().toString();
                        break;
                    }
                }

                // Comprobar si alguien gana
                if (hayGanador()) {
                    if (turnoJugador==true){
                        Toast.makeText(GameActivity.this, "Ha ganado el Jugador 1", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(GameActivity.this, "Ha ganado el Jugador 2", Toast.LENGTH_SHORT).show();
                    }
                    deshabilitarBotones();
                    partidaTerminada = true;
                } else if (empate()) {
                    pantalla.setText("Empate");
                    partidaTerminada = true;
                } else {
                    turnoJugador = !turnoJugador; // Cambia de turno
                }
            }
        }
    }

    // Comprobación de ganador
    private boolean hayGanador() {
        for (int[] c : combinacionesGanadoras) {
            String a = botones[c[0]].getText().toString();
            String b = botones[c[1]].getText().toString();
            String d = botones[c[2]].getText().toString();

            if (!a.equals("") && a.equals(b) && b.equals(d)) {
                return true;
            }
        }
        return false;
    }

    // Comprobar si todas las casillas están llenas (empate)
    private boolean empate() {
        for (Button b : botones) {
            if (b.getText().toString().equals("")) {
                return false;
            }
        }
        return true;
    }

    // Deshabilitar todos los botones (cuando termina el juego)
    private void deshabilitarBotones() {
        for (Button b : botones) {
            b.setEnabled(false);
        }
    }

    // Reiniciar partida
    public void reiniciar(View v) {
        for (int i = 0; i < 9; i++) {
            botones[i].setText("");
            botones[i].setEnabled(true);
            tablero[i] = "";
        }
        turnoJugador = true;
        partidaTerminada = false;
        pantalla.setText("Turno del jugador 1 (X)");
    }

    // Guardar estado al rotar pantalla
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Guarda el contenido de los botones
        for (int i = 0; i < 9; i++) {
            tablero[i] = botones[i].getText().toString();
        }

        outState.putStringArray("tablero", tablero);
        outState.putBoolean("turnoJugador", turnoJugador);
        outState.putString("textoPantalla", pantalla.getText().toString());
        outState.putBoolean("partidaTerminada", partidaTerminada);
    }

    //  Restaurar estado tras girar pantalla
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        tablero = savedInstanceState.getStringArray("tablero");
        turnoJugador = savedInstanceState.getBoolean("turnoJugador");
        pantalla.setText(savedInstanceState.getString("textoPantalla"));
        partidaTerminada = savedInstanceState.getBoolean("partidaTerminada");

        for (int i = 0; i < 9; i++) {
            botones[i].setText(tablero[i]);
            // Si la partida terminó o el botón ya tiene texto, deshabilitar
            if (!tablero[i].equals("") || partidaTerminada) {
                botones[i].setEnabled(false);
                botones[i].setAlpha(1.0f);
            } else {
                botones[i].setEnabled(true);
            }
        }
    }
}
