package com.example.ejercicio_3videosonido;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;




public class MainActivity extends AppCompatActivity {

    Button b1;
    VideoView visorVideo;

    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        b1=(Button) findViewById(R.id.boton1);
        visorVideo=(VideoView) findViewById(R.id.videoView1);

        mediaController=new MediaController(this);

        b1.setOnClickListener(listener1);


    }

    private View.OnClickListener listener1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Se pasa el string de la direccion del video, getPackageName devuelve el nombre del proyecto
            String ruta="android.resource://"+getPackageName()+"/"+R.raw.video1;
            //Se parsea el String a Uri para pasarselo al visorVideo
            Uri uri= Uri.parse(ruta);
            //Se pasa el Uri al visor de video
            visorVideo.setVideoURI(uri);
            visorVideo.setMediaController(mediaController);
            mediaController.setAnchorView(visorVideo);
            visorVideo.start();
        }
    };
}