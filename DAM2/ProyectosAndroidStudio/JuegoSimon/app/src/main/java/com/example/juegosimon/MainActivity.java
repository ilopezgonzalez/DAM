package com.example.juegosimon;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Random;

/**
 * Actividad principal que actúa como controlador central del juego.
 * Gestiona la lógica de niveles, la generación de colores y la validación final.
 */
public class MainActivity extends AppCompatActivity {

    // Constante con los colores disponibles en el juego. Usada para generar la secuencia y rotar colores.
    public static final int[] COLORES_SIMON = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

    // Variables ESTÁTICAS: Se pueden consultar desde cualquier Fragmento sin necesidad de pasar Bundles.
    public static int numeroCuadros;       // Cantidad de cuadros según el nivel (5, 7 o 10).
    public static int[] coloresGanadores;  // Array que guarda la combinación correcta de colores.

    // Referencias a los fragmentos actuales para poder darles órdenes (limpiar colores o habilitar clics).
    private Fragment miFragmentoModelo;
    private Fragment miFragmentoSolucion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // MANEJO DE GIRO DE PANTALLA:
        // Si savedInstanceState no es nulo, la actividad se está recreando tras un giro.
        if (savedInstanceState != null) {
            // Recuperamos los fragmentos que Android ya restauró automáticamente para no perder la referencia.
            miFragmentoModelo = getSupportFragmentManager().findFragmentById(R.id.LinearLayoutModelo);
            miFragmentoSolucion = getSupportFragmentManager().findFragmentById(R.id.LinearLayoutJuego);
        } else {
            // Si es la primera vez que se abre la App, cargamos el fragmento de los botones de niveles.
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            fragmentobotones fragmentoSuperior = new fragmentobotones();
            transaction.add(R.id.LinearLayoutBotones, fragmentoSuperior);
            transaction.commit();
        }
    }

    /**
     * Crea un array de números aleatorios que representan colores de la paleta COLORES_SIMON.
     */
    public static int[] generarSecuenciaAleatoria(int cantidad) {
        int[] nuevaSecuencia = new int[cantidad];
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            // Selecciona un índice aleatorio entre 0 y el tamaño de la paleta.
            nuevaSecuencia[i] = COLORES_SIMON[random.nextInt(COLORES_SIMON.length)];
        }
        return nuevaSecuencia;
    }

    /**
     * Método vinculado a los botones de nivel en el XML (android:onClick).
     * Configura el nivel, genera la solución y carga los fragmentos de juego.
     */
    public void seleccionarNivel(View v) {
        // 1. Identificamos qué botón se pulsó para definir la dificultad.
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
            numeroCuadros = 5; // Por defecto
            miFragmentoModelo = new fragmento1Facil();
        }

        // 2. Generamos la combinación ganadora que el usuario tendrá que memorizar.
        coloresGanadores = generarSecuenciaAleatoria(numeroCuadros);

        // 3. Instanciamos el fragmento de juego (donde el usuario pulsa cuadros).
        miFragmentoSolucion = new fragmento2();

        // 4. Transacción de fragmentos: reemplazamos los contenedores por los nuevos fragmentos.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.LinearLayoutModelo, miFragmentoModelo);
        transaction.replace(R.id.LinearLayoutJuego, miFragmentoSolucion);
        transaction.addToBackStack(null); // Permite volver atrás con el botón físico del móvil.
        transaction.commit();
    }

    /**
     * Método para el botón "JUGAR": "limpia" el modelo para que no se vea y activa el juego.
     */
    public void empezarJuego(View v) {
        // A. OCULTAR SOLUCIÓN: Buscamos los TextViews del modelo y los pintamos de gris.
        if (miFragmentoModelo != null && miFragmentoModelo.getView() != null) {
            int[] idsModelos = {
                    R.id.textViewJuego1, R.id.textViewJuego2, R.id.textViewJuego3,
                    R.id.textViewJuego4, R.id.textViewJuego5, R.id.textViewJuego6,
                    R.id.textViewJuego7, R.id.textViewJuego8, R.id.textViewJuego9,
                    R.id.textViewJuego10
            };

            for (int id : idsModelos) {
                // Buscamos la vista dentro del layout del fragmento de modelo.
                View tv = miFragmentoModelo.getView().findViewById(id);
                if (tv != null) {
                    tv.setBackgroundColor(Color.LTGRAY); // Ocultamos el color original.
                }
            }
        }

        // B. ACTIVAR JUEGO: Llamamos al método público del fragmento2 para permitir clics.
        if (miFragmentoSolucion instanceof fragmento2) {
            ((fragmento2) miFragmentoSolucion).habilitarJuego();
        }

        // C. UI: Ocultamos este botón (JUGAR) para que no se pueda volver a pulsar.
        v.setVisibility(View.GONE);
    }

    /**
     * Método para el botón "COMPROBAR": Compara la respuesta del usuario con la solución.
     */
    public void comprobarResultado(View v) {
        if (miFragmentoSolucion instanceof fragmento2) {
            fragmento2 frag = (fragmento2) miFragmentoSolucion;

            // Obtenemos los índices de colores que el usuario ha marcado en el fragmento2.
            int[] respuestaUsuarioIndices = frag.obtenerRespuestaUsuario();

            boolean victoria = true;

            // Comparamos uno por uno los colores puestos por el usuario con los colores ganadores.
            for (int i = 0; i < numeroCuadros; i++) {
                int indiceElegido = respuestaUsuarioIndices[i];

                // Verificamos:
                // 1. Que el cuadro no esté vacío (índice -1).
                // 2. Que el color en la paleta coincida con el color ganador en esa posición.
                if (indiceElegido == -1 || COLORES_SIMON[indiceElegido] != coloresGanadores[i]) {
                    victoria = false; // Si uno falla, ya no hay victoria.
                    break;
                }
            }

            // Mostramos un mensaje emergente (Toast) con el resultado.
            if (victoria) {
                Toast.makeText(this, "¡FELICIDADES! Has acertado la secuencia", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Combinación incorrecta. ¡Inténtalo de nuevo!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}