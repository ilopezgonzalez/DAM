package com.example.prueba_sonido;

import android.media.MediaPlayer; // Clase necesaria para reproducir archivos de audio y video
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 1. Declaración de variables globales
    Button b1;
    MediaPlayer reproductor1; // Objeto que controlará la reproducción del sonido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Enlace de la variable b1 con el botón definido en el archivo XML (ID: boton1)
        b1 = findViewById(R.id.boton1);

        // 3. Asignación del escuchador (listener) al botón para detectar clics
        b1.setOnClickListener(listener1);
    }

    /**
     * 4. Definición del objeto Listener.
     * Contiene la lógica que se ejecutará cada vez que el usuario pulse el botón.
     */
    private View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /* 5. Inicialización del MediaPlayer:
               - v.getContext(): Obtiene el contexto de la vista actual.
               - R.raw.sonido: Indica dónde está el archivo de audio (carpeta res/raw).

               IMPORTANTE: Cada vez que pulsas el botón, se crea una instancia nueva.
            */
            reproductor1 = MediaPlayer.create(v.getContext(), R.raw.sonido);

            // 6. Arranca la reproducción del sonido
            reproductor1.start();
        }
    };
}