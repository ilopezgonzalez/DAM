package com.example.campotextoyboton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button botonEscribir;
    TextView pantalla;
    EditText campoTexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonEscribir = findViewById(R.id.button);
        botonEscribir.setOnClickListener(listener1);
        pantalla = findViewById(R.id.textView);
        campoTexto = findViewById(R.id.editTextText);

    }

    private View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pantalla = (TextView) findViewById(R.id.textView);
            campoTexto = (EditText) findViewById((R.id.editTextText));
            if (v.getId() == R.id.button) {
                String texto = campoTexto.getText().toString();
                pantalla.setText(texto);
            }

        }
    };
}


