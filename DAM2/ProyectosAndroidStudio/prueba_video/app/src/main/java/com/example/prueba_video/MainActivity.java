package com.example.prueba_video;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    VideoView visorVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visorVideo=findViewById(R.id.videoView1);
        //Se pasa el string de la direccio, getPackageName devuelve el nombre del proyecto
        String ruta="android.resource://"+getPackageName()+"/"+R.raw.video1;
        //Se parsea el String a Uri para pasarselo al visorVideo
        Uri uri= Uri.parse(ruta);
        //Se pasa el Uri al visor de video
        visorVideo.setVideoURI(uri);
        visorVideo.start();

    }
}