package com.example.ejercicioresueltopermisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);//se suele usar una variable static para el codigo por si hay que comprobarlo en otras partes del programa
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){
            leerContactos();
        }else{
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)){
                mostrarDialogoIrAjustes();
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);

            }
        }
        //si hemos denegado el permiso 2 veces no lo vuelve a preguntar nunca jamas, y hay que hacerlo manualmente en los ajustes
       // ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1); mostrarDialogoIrAjustes();
    }
    private void leerContactos() {

        Cursor cursor = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String nombre = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                        )
                );

                String telefono = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                ContactsContract.CommonDataKinds.Phone.NUMBER
                        )
                );

                Log.d("CONTACTO", "Nombre: " + nombre + " - Tel: " + telefono);

            } while (cursor.moveToNext());

            cursor.close();
        }
    }
    private void mostrarDialogoIrAjustes() {
        new AlertDialog.Builder(this)
                .setTitle("Permiso necesario")
                .setMessage("Debes habilitar el permiso de contactos manualmente en Ajustes.")
                .setPositiveButton("Abrir Ajustes", (dialog, which) -> {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }

}