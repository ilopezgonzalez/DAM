package com.example.prueba_sonido;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button b1;
    MediaPlayer reproductor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.boton1);
        b1.setOnClickListener(listener1);

    }

    private View.OnClickListener listener1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            reproductor1=MediaPlayer.create(v.getContext(),R.raw.sonido);
            reproductor1.start();
        }
    };
}