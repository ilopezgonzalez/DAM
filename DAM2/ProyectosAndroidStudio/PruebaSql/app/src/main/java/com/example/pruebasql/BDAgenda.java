package com.example.pruebasql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDAgenda extends SQLiteOpenHelper {
    String crearTabla="CREATE TABLE agenda(codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)";
    public BDAgenda(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//Constructor generado con el asistente
        super(context, name, factory, version);
    }
    @Override
    //Solo se llama la primera vez, cuando todavía no tengo la BD
    //vamos aponer los create table aqui ya que solo se llamara la primera vez al crear el objeto
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crearTabla);//si ya existe no la vuelve a crear
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(crearTabla);
    }
}