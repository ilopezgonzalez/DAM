package com.example.ejercicio_3videosonido;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 1. Declaración de variables globales
    private Button b1;
    private VideoView visorVideo;
    private MediaController mediaController;
    private int posicionActual = 0; // Para guardar el progreso del video

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Inicialización de componentes
        b1 = (Button) findViewById(R.id.boton1);
        visorVideo = (VideoView) findViewById(R.id.videoView1);
        mediaController = new MediaController(this);

        // 3. Asignar el listener al botón
        b1.setOnClickListener(listener1);

        // 4. Lógica de recuperación tras girar la pantalla
        if (savedInstanceState != null) {
            // Recuperamos los milisegundos donde se quedó el video
            posicionActual = savedInstanceState.getInt("posicion");

            // Volvemos a cargar la ruta del video
            String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video1;
            visorVideo.setVideoURI(Uri.parse(ruta));

            // Usamos este listener para que el video arranque cuando esté listo
            visorVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    visorVideo.seekTo(posicionActual); // Ir al segundo guardado
                    visorVideo.start();                // Continuar reproducción
                }
            });

            // Reconectar los controles visuales
            visorVideo.setMediaController(mediaController);
            mediaController.setAnchorView(visorVideo);
        }
    }

    // 5. Metodo para salvar el estado antes de que la Activity se destruya por el giro
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (visorVideo != null) {
            // Guardamos la posición actual en el "Bundle"
            outState.putInt("posicion", visorVideo.getCurrentPosition());
            visorVideo.pause();
        }
    }

    // 6. Definición del Listener (El objeto que escucha el clic del botón)
    private View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Ruta del video en la carpeta res/raw
            String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video1;
            Uri uri = Uri.parse(ruta);

            // Configuración del visor
            visorVideo.setVideoURI(uri);
            visorVideo.setMediaController(mediaController);
            mediaController.setAnchorView(visorVideo);

            // Arrancar el video por primera vez
            visorVideo.start();
        }
    }; // IMPORTANTE: Este punto y coma cierra la asignación de la variable
} // Cierre final de la clase MainActivity