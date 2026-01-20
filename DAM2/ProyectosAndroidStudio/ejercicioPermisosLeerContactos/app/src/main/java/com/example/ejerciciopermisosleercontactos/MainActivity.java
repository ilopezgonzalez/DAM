package com.example.ejerciciopermisosleercontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button botonContactoAntiguedad;
    Button botonBuscar;
    TextView pantallaContactos;
    EditText campoTelefono;

    String nombre;
    String telefono;
    String stringFechaModificacion;
    Long fechaModificacion;
    ArrayList<Contacto> arrayContactos=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonContactoAntiguedad=findViewById(R.id.button);
        botonContactoAntiguedad.setOnClickListener(listener1);

        botonBuscar=findViewById(R.id.button2);
        botonBuscar.setOnClickListener(listener1);

        campoTelefono=findViewById(R.id.editTextText);

        pantallaContactos=findViewById(R.id.textView);




        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);//se suele usar una variable static para el codigo por si hay que comprobarlo en otras partes del programa
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            leerContactos();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                mostrarDialogoIrAjustes();
            } else {
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
                nombre = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                        )
                );

                telefono = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                ContactsContract.CommonDataKinds.Phone.NUMBER
                        )
                );

                stringFechaModificacion=cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                ContactsContract.CommonDataKinds.Phone.CONTACT_LAST_UPDATED_TIMESTAMP
                        )
                );
                fechaModificacion=Long.parseLong(stringFechaModificacion);

                Contacto contacto=new Contacto(nombre,telefono,fechaModificacion);
                arrayContactos.add(contacto);

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

    private View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.button) {
                pantallaContactos.setText("");
                arrayContactos.sort((o1, o2) -> o1.getFechaModificacion().compareTo(o2.getFechaModificacion()));
                for (Contacto contacto:arrayContactos
                     ) {
                    pantallaContactos.append(contacto.toString());
                    pantallaContactos.append(System.lineSeparator());
                }
            }
            if (v.getId() == R.id.button2) {
                pantallaContactos.setText("");
                for (Contacto contacto:arrayContactos
                     ) {
                    if (contacto.getTelefono().equals(campoTelefono.getText().toString())){
                        pantallaContactos.append(contacto.toString());
                    }
                }
            }

        }
    };

}


