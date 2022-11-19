package com.example.ejercicio4.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.ejercicio4.entidades.Jogos;

import java.util.ArrayList;

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
            db.close();
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    //metodo q guarda en un arraylist los jugadores con la info
    public ArrayList<Jogos> mostrarJugadores (){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Jogos> listaJugadores = new ArrayList<>();

        Jogos juego = null;
        Cursor cursorJuegos = null;

        //consulta sql
        cursorJuegos = db.rawQuery("SELECT nombreJuego, nombreJugador, complejidad, puntaje FROM " + TABLE_JUEGOS + " ORDER BY puntaje", null);

        if(cursorJuegos.moveToFirst()){
            do {
                juego = new Jogos();
                juego.setNombreJugador(cursorJuegos.getString(1));
                juego.setNombreJuego(cursorJuegos.getString(0));
                juego.setComplejidad(cursorJuegos.getString(2));
                juego.setPuntaje(cursorJuegos.getInt(3));

                listaJugadores.add(juego);
            } while(cursorJuegos.moveToNext());
        }
        cursorJuegos.close();

        return listaJugadores;
    }



    //ver despues
    public boolean ifExists (String SQLSentence){
        boolean ret = Boolean.parseBoolean("");
        return ret;
    }
}
