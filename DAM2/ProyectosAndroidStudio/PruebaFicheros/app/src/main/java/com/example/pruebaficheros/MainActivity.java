package com.example.pruebaficheros;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    ContentResolver resolver;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void iniciar(View v){
        grabar();
        cargar();


    }

    public void grabar(){
        resolver=getContentResolver();
        ContentValues values=new ContentValues();
        values.put(MediaStore.MediaColumns.DISPLAY_NAME, "saludo.txt");
        values.put(MediaStore.MediaColumns.MIME_TYPE, "text/plain");
        values.put(MediaStore.MediaColumns.RELATIVE_PATH, "Download/");

        uri=resolver.insert(MediaStore.Files.getContentUri("external"), values);

        try (OutputStream os= resolver.openOutputStream(uri)){
            os.write("hola".getBytes());
            os.write("\n".getBytes());
            os.write("adios".getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargar(){
        //Leer el contenido del archivo
        resolver=getContentResolver();
        try (InputStream is=resolver.openInputStream(uri)) {
            byte[] buffer =new byte[is.available()];
            is.read(buffer);
            String contenido= new String(buffer);
            System.out.println("Contenido leido: "+contenido);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}