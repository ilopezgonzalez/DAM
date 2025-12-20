package com.example.juegosimon;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Este fragmento gestiona la zona de juego donde el usuario introduce su respuesta.
 * Controla los cuadros, el cambio de colores y la persistencia al girar la pantalla.
 */
public class fragmento2 extends Fragment {

    // Array para almacenar las referencias a los 10 TextViews definidos en el XML
    public TextView[] respuestas;

    // Interruptor de seguridad: si es false, el usuario no puede cambiar colores (antes de darle a JUGAR)
    private boolean juegoHabilitado = false;

    // Color por defecto (gris) para indicar que el cuadro no ha sido pulsado
    private final int COLOR_INICIAL = Color.LTGRAY;

    /**
     * Se ejecuta al crear la vista del fragmento. Aquí enlazamos el XML con el Java.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // "Inflamos" el layout XML para convertirlo en un objeto View
        View v = inflater.inflate(R.layout.fragmento2, container, false);

        // 1. RELLENAR EL ARRAY: Buscamos cada TextView por su ID y lo guardamos en el array
        respuestas = new TextView[]{
                v.findViewById(R.id.textViewJuego1), v.findViewById(R.id.textViewJuego2),
                v.findViewById(R.id.textViewJuego3), v.findViewById(R.id.textViewJuego4),
                v.findViewById(R.id.textViewJuego5), v.findViewById(R.id.textViewJuego6),
                v.findViewById(R.id.textViewJuego7), v.findViewById(R.id.textViewJuego8),
                v.findViewById(R.id.textViewJuego9), v.findViewById(R.id.textViewJuego10)
        };

        // 2. ADAPTAR EL NIVEL: Mostramos solo los cuadros necesarios según el nivel elegido
        for (int i = 0; i < respuestas.length; i++) {
            if (i >= MainActivity.numeroCuadros) {
                // Si el índice supera el nivel (ej: cuadro 6 en nivel fácil), lo ocultamos y eliminamos su espacio
                respuestas[i].setVisibility(View.GONE);
            } else {
                // Si el cuadro debe estar visible:
                respuestas[i].setBackgroundColor(COLOR_INICIAL); // Ponemos color gris
                respuestas[i].setTag(-1); // El TAG guarda el índice del color actual (-1 = ninguno)
                respuestas[i].setVisibility(View.VISIBLE); // Aseguramos que sea visible
            }
        }

        // Preparamos los detectores de clics para los cuadros
        configurarClicks();
        return v;
    }

    /**
     * SALVAGUARDA (Giro de pantalla): Se ejecuta justo antes de que el fragmento se destruya.
     * Guardamos los datos importantes en un "fardo" (Bundle) para recuperarlos luego.
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Guardamos si el juego ya estaba empezado para que no se bloquee al girar
        outState.putBoolean("estado_juego", juegoHabilitado);

        // Guardamos los colores que el usuario ya había puesto para no borrárselos
        int[] coloresActuales = new int[MainActivity.numeroCuadros];
        for (int i = 0; i < MainActivity.numeroCuadros; i++) {
            coloresActuales[i] = (int) respuestas[i].getTag();
        }
        outState.putIntArray("colores_usuario", coloresActuales);
    }

    /**
     * RECUPERACIÓN (Giro de pantalla): Se ejecuta después de que la vista se ha recreado.
     * Si hay datos guardados (savedInstanceState != null), los restauramos.
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            // Restauramos el estado del interruptor (si estaba habilitado, seguirá habilitado)
            juegoHabilitado = savedInstanceState.getBoolean("estado_juego");

            // Restauramos los colores que el usuario ya había marcado
            int[] coloresGuardados = savedInstanceState.getIntArray("colores_usuario");

            if (coloresGuardados != null) {
                for (int i = 0; i < coloresGuardados.length; i++) {
                    // Si el cuadro tenía un color asignado (distinto de -1)
                    if (coloresGuardados[i] != -1) {
                        respuestas[i].setTag(coloresGuardados[i]); // Restauramos el índice en el Tag
                        // Buscamos el color real en la paleta del Main y lo aplicamos al fondo
                        respuestas[i].setBackgroundColor(MainActivity.COLORES_SIMON[coloresGuardados[i]]);
                    }
                }
            }
        }
    }

    /**
     * Método público llamado desde MainActivity para permitir que el usuario empiece a jugar.
     */
    public void habilitarJuego() {
        this.juegoHabilitado = true;
    }

    /**
     * Define qué pasa cuando el usuario toca un cuadro.
     */
    private void configurarClicks() {
        for (TextView tv : respuestas) {
            tv.setOnClickListener(v -> {
                // Si el usuario no ha pulsado el botón "JUGAR" en el Main, no hacemos nada
                if (!juegoHabilitado) {
                    return;
                }

                // Leemos el índice del color que tiene ahora el cuadro
                int indiceActual = (int) tv.getTag();
                int siguienteIndice;

                if (indiceActual == -1) {
                    // Si estaba en gris, empezamos por el primer color de la paleta (Rojo)
                    siguienteIndice = 0;
                } else {
                    // Si ya tenía color, pasamos al siguiente (0 -> 1 -> 2 -> 3 -> vuelve a 0)
                    siguienteIndice = (indiceActual + 1) % MainActivity.COLORES_SIMON.length;
                }

                // Actualizamos visualmente el color y guardamos el nuevo índice en el Tag
                tv.setBackgroundColor(MainActivity.COLORES_SIMON[siguienteIndice]);
                tv.setTag(siguienteIndice);
            });
        }
    }

    /**
     * Método que llama el MainActivity al pulsar "COMPROBAR".
     * Devuelve la lista de colores elegidos por el usuario.
     */
    public int[] obtenerRespuestaUsuario() {
        int[] seleccion = new int[MainActivity.numeroCuadros];
        for (int i = 0; i < MainActivity.numeroCuadros; i++) {
            // Extraemos el índice guardado en el Tag de cada TextView activo
            seleccion[i] = (int) respuestas[i].getTag();
        }
        return seleccion;
    }
}