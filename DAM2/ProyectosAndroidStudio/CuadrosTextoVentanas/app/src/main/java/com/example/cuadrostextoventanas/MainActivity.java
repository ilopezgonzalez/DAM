package com.example.cuadrostextoventanas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText campo1;
    EditText campo2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        campo1 = findViewById(R.id.campo1);
        campo2 = findViewById(R.id.campo2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void cambiarVentana(View v) {
        // Intent(Contexto_actual, Clase_a_la_que_quieres_ir.class)
        String textoCampo1 = campo1.getText().toString();
        String textoCampo2 = campo2.getText().toString();

        try {
            int val1 = Integer.parseInt(textoCampo1);
            int val2 = Integer.parseInt(textoCampo2);

            if (val1 > 0 && val2 > 0) {
                Intent intent = new Intent(this, Activity1.class);
                intent.putExtra("valor1", val1);
                intent.putExtra("valor2", val2);
                startActivity(intent);
            } else if (val1 < 0 && val2 < 0) {
                Intent intent = new Intent(this, Activity2.class);
                intent.putExtra("valor1", val1);
                intent.putExtra("valor2", val2);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, Activity3.class);
                startActivity(intent);
            }

        } catch (NumberFormatException e) {
            // Opcional: Mostrar un error al usuario si el texto no es un número válido
            e.printStackTrace();
        }
    }

}
