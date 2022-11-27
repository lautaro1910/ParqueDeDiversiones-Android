package com.example.ejercicio4.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.ejercicio4.JugarActivity;
import com.example.ejercicio4.entidades.Jogos;

import java.util.ArrayList;

public class DBJuegos extends DBHelper{

    Context context;

    public DBJuegos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarJogo (String nombreJuego, String nombreJugador, String complejidad, String nivel, int puntaje, Context context) { //existe alguna forma de mejorar el pasaje de tantos parametros? buscar
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
            dbHelper.close();
        } catch (Exception ex) {
            Toast.makeText(context,"Existio un problema al ingresar los datos, por favor compruebe los campos y vuelva a intentar", Toast.LENGTH_LONG).show();
        }
        return id;
    }

    //metodo q guarda en un arraylist los jugadores con la info
    public ArrayList<Jogos> mostrarJugadores (String nombreJuego){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Jogos> listaJugadores = new ArrayList<>();

        Jogos juego = null;
        Cursor cursorJuegos = null;

        //consulta sql
        cursorJuegos = db.rawQuery("SELECT * FROM " + TABLE_JUEGOS + " WHERE nombreJuego = " + nombreJuego, null);
        if(cursorJuegos.getCount() != 0){
            if(cursorJuegos.moveToFirst()){
                do{
                    juego = new Jogos();
                    juego.setNombreJuego(cursorJuegos.getString(1));
                    juego.setNombreJugador(cursorJuegos.getString(2));
                    juego.setComplejidad(cursorJuegos.getString(3));
                    juego.setNivel(cursorJuegos.getString(4));
                    juego.setPuntaje(cursorJuegos.getInt(5));
                    listaJugadores.add(juego);
                }while(cursorJuegos.moveToNext() && listaJugadores.size() < 10);
            }
        }
        cursorJuegos.close();
        db.close();
        dbHelper.close();
        return listaJugadores;
    }



    //ver despues
    public boolean ifExists (String SQLSentence){
        boolean ret = Boolean.parseBoolean("");
        return ret;
    }
}
