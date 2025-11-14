package com.cidead.pmdm.interfazmultiidioma;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button n = (Button) findViewById(R.id.button_begin);
        n.setOnClickListener(login);
        };

    private View.OnClickListener login = new View.OnClickListener() { //Al contrario que al añadir texto al entrar o salir,
        // aquí queremos que el lo cambie sea un botón en concreto
        @Override
        public void onClick(View v) {
            EditText usuario = (EditText) findViewById(R.id.edit_name);
            String user=usuario.getText().toString();

            EditText password = (EditText) findViewById(R.id.edit_pass);
            String pass=password.getText().toString();

            TextView texto=(TextView) findViewById(R.id.title);


            if (pass.contains("1234")){
                texto.setText(R.string.correct);
            } else {
                texto.setText(R.string.incorrect);
            }


    }
    };
}