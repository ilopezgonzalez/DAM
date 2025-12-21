package com.example.juegosimon;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Random;

/**
 * MainActivity
 * Actividad principal del juego Simon.
 */
public class MainActivity extends AppCompatActivity {

    // Colores posibles
    public static final int[] COLORES_SIMON = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

    // Número de cuadros de la secuencia
    public static int numeroCuadros;

    // Secuencia correcta
    public static int[] coloresGanadores;

    // NUEVA VARIABLE: Controla si el usuario ya pulsó "Jugar"
    public static boolean juegoIniciado = false;

    // Fragmentos
    private Fragment miFragmentoModelo;
    private Fragment miFragmentoSolucion;

    // Sonido
    private MediaPlayer reproductor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            // Restauramos fragmentos existentes
            miFragmentoModelo = getSupportFragmentManager()
                    .findFragmentById(R.id.LinearLayoutModelo);
            miFragmentoSolucion = getSupportFragmentManager()
                    .findFragmentById(R.id.LinearLayoutJuego);

            // RESTAURACIÓN: Recuperamos si el juego estaba iniciado antes de rotar
            juegoIniciado = savedInstanceState.getBoolean("juegoIniciado", false);
        } else {
            // Primera creación: fragmento superior con botones
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            fragmentobotones fragmentoSuperior = new fragmentobotones();
            transaction.add(R.id.LinearLayoutBotones, fragmentoSuperior);
            transaction.commit();

            // Inicializamos el estado
            juegoIniciado = false;
        }
    }

    /**
     * PERSISTENCIA: Guardamos el estado del juego para la rotación.
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("juegoIniciado", juegoIniciado);
    }

    // Genera una secuencia aleatoria
    public static int[] generarSecuenciaAleatoria(int cantidad) {
        int[] secuencia = new int[cantidad];
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            secuencia[i] = COLORES_SIMON[random.nextInt(COLORES_SIMON.length)];
        }
        return secuencia;
    }

    // Selección de nivel
    public void seleccionarNivel(View v) {
        // Al seleccionar un nivel nuevo, el juego NO está iniciado aún
        juegoIniciado = false;

        // Elegir dificultad y fragmento modelo
        if (v.getId() == R.id.botonFacil) {
            numeroCuadros = 5;
            miFragmentoModelo = new fragmento1Facil();
        } else if (v.getId() == R.id.botonMedio) {
            numeroCuadros = 7;
            miFragmentoModelo = new fragmento1Medio();
        } else if (v.getId() == R.id.botonDificil) {
            numeroCuadros = 10;
            miFragmentoModelo = new fragmento1Dificil();
        } else {
            numeroCuadros = 5;
            miFragmentoModelo = new fragmento1Facil();
        }

        // Generamos la secuencia correcta
        coloresGanadores = generarSecuenciaAleatoria(numeroCuadros);

        // Fragmento de solución
        miFragmentoSolucion = new fragmento2();

        // Reemplazamos fragmentos en pantalla
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.LinearLayoutModelo, miFragmentoModelo);
        transaction.replace(R.id.LinearLayoutJuego, miFragmentoSolucion);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // Comenzar juego
    public void empezarJuego(View v) {
        // Marcamos que el juego ha comenzado oficialmente
        juegoIniciado = true;

        // Sonido
        if (reproductor1 != null) reproductor1.release();
        reproductor1 = MediaPlayer.create(this, R.raw.sonido_click);
        reproductor1.start();
        reproductor1.setOnCompletionListener(mp -> mp.release());

        // Reseteamos los colores del modelo a gris antes de jugar
        if (miFragmentoModelo != null && miFragmentoModelo.getView() != null) {
            int[] idsModelos = {
                    R.id.textViewJuego1, R.id.textViewJuego2, R.id.textViewJuego3,
                    R.id.textViewJuego4, R.id.textViewJuego5,
                    R.id.textViewJuego6, R.id.textViewJuego7,
                    R.id.textViewJuego8, R.id.textViewJuego9,
                    R.id.textViewJuego10
            };
            for (int id : idsModelos) {
                View tv = miFragmentoModelo.getView().findViewById(id);
                if (tv != null) tv.setBackgroundColor(Color.LTGRAY);
            }
        }

        // Habilitar interacción del usuario
        if (miFragmentoSolucion instanceof fragmento2) {
            ((fragmento2) miFragmentoSolucion).habilitarJuego();
        }

        if (v != null) v.setVisibility(View.GONE);
    }

    // Comprobar resultado del jugador
    public void comprobarResultado(View v) {
        // Sonido
        if (reproductor1 != null) reproductor1.release();
        reproductor1 = MediaPlayer.create(this, R.raw.sonido_click);
        reproductor1.start();
        reproductor1.setOnCompletionListener(mp -> mp.release());

        if (miFragmentoSolucion instanceof fragmento2) {
            fragmento2 frag = (fragmento2) miFragmentoSolucion;
            int[] respuestaUsuarioIndices = frag.obtenerRespuestaUsuario(); //
            boolean victoria = true;

            for (int i = 0; i < numeroCuadros; i++) {
                int indiceElegido = respuestaUsuarioIndices[i];
                if (indiceElegido == -1 || COLORES_SIMON[indiceElegido] != coloresGanadores[i]) {
                    victoria = false;
                    break;
                }
            }

            if (victoria) {
                Toast.makeText(this, "¡FELICIDADES! Has acertado la secuencia", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Combinación incorrecta. ¡Inténtalo de nuevo!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}