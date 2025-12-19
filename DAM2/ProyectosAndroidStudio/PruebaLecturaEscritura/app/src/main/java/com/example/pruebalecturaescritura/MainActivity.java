package com.example.pruebalecturaescritura;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Escribir fichero para guardar estado de partida
        try {

            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("notas2.txt", MainActivity.MODE_PRIVATE));
            archivo.write("hola caracola");
            archivo.flush();
            archivo.close();

        } catch (IOException e) {
        }

        //Leer fichero

        File fichero=new File("notas2.txt");
        try {
            InputStreamReader archivo= new InputStreamReader(openFileInput("notas2.txt"));
            BufferedReader br =new BufferedReader(archivo);
            String linea=br.readLine();
            String todo="";
            while (linea !=null){
                todo=todo+linea;
                linea=br.readLine();
            }
            br.close();
            archivo.close();
            System.out.println(todo);
        }catch (IOException e){

        }
    }
}