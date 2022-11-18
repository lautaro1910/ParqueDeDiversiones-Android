package com.example.ejercicio4.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DBJuegos extends DBHelper{

    Context context;

    public DBJuegos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarJogo (String nombreJuego, String nombreJugador, String complejidad, String nivel, int puntaje) { //existe alguna forma de mejorar el pasaje de tantos parametros? buscar
        long id = 0;
        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nombreJuego", nombreJuego);
            valores.put("nombreJugador", nombreJugador);
            valores.put("complejidad", complejidad);
            valores.put("nivel", nivel);
            valores.put("puntaje", puntaje);

            id = db.insert( TABLE_JUEGOS, null, valores);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }



    //ver despues
    public boolean ifExists (String SQLSentence){
        boolean ret = Boolean.parseBoolean("");
        return ret;
    }
}
