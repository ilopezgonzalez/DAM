package com.example.pruebasql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Abrimos la BD BDAgenda y la pongo en modo escritura. Si no existe la crea. lo que hay ya creado en la bd se mantiene
        //SQLiteOpenHelper es una clase abstracta asi que no se puede instanciar directamente, hay que crear una clase que la extienda
        BDAgenda bdAgenda = new BDAgenda(getApplicationContext(), "BDAgenda", null, 1);
        //los create table ya los hicimos en el constructor.
        bd=bdAgenda.getReadableDatabase();
        bd.execSQL("INSERT INTO agenda (nombre) VALUES('paco')");
        bd.execSQL("INSERT INTO agenda (nombre) VALUES('Maria')");
        Cursor c = bd.rawQuery("SELECT * FROM agenda WHERE codigo=?", new String[]{"2"});//se pone asi para evitar sqlinjection
        c.moveToFirst();
        //en c tendremos las columnas que me devolvio la select, en esta tabla concreta tenemos el codigo y el nombre
        System.out.println(c.getInt(0));
        System.out.println(c.getString(1));
        //  c.moveToNext();     para ir al siguiente, aqui se que solo hay una fila
        c.close();
        //otra consulta para ver cuantas filas hay
        Cursor c2 = bd.rawQuery("SELECT count(*) FROM agenda", null);
        c2.moveToFirst();
        System.out.println(c2.getInt(0));
    }


}
