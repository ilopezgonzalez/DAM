package com.example.ejerciciosql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    SQLiteDatabase bd;
    private EditText campo;
    private TextView pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonGuardar = (Button) findViewById(R.id.botonGuardar);
        botonGuardar.setOnClickListener(new ReceptorBotones());

        Button botonConsultar = (Button) findViewById(R.id.botonConsultar);
        botonConsultar.setOnClickListener(new ReceptorBotones());

        campo=(EditText)findViewById(R.id.campoTexto);
        pantalla=(TextView) findViewById(R.id.textViewResultados);

        BDAgenda bdAgenda = new BDAgenda(getApplicationContext(), "BDAgenda", null, 1);
        bd=bdAgenda.getReadableDatabase();


    }

    private class ReceptorBotones implements View.OnClickListener{
        @Override
        public void onClick(View v){
            pantalla=(TextView) findViewById(R.id.textViewResultados);
            if (v.getId()==R.id.botonConsultar){
                Cursor cursor=bd.rawQuery("SELECT * FROM agenda", null);
                cursor.moveToFirst();
                pantalla.setText(cursor.getInt(0)+" "+ cursor.getString(1));
                while (cursor.moveToNext())
                pantalla.append(System.lineSeparator());
                pantalla.append(cursor.getInt(0)+" "+cursor.getString(1));
            }
            if (v.getId()==R.id.botonGuardar){
                String input=campo.getText().toString();
                String aux="Insert into agenda (nombre) values('"+input+"')";
                System.out.println(aux);
                bd.execSQL(aux);

            }
        }

    }
}