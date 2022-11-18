package com.example.ejercicio4.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_V = 1; //version de la base de datos
    private static final String DATABASE_NAME = "parqueDeDiversiones_BD.db"; //nombre de la base de datos
    public static final String TABLE_JUEGOS = "t_Juegos";  //aca irian las tablas

    //constructor
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_V);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_JUEGOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombreJuego TEXT NOT NULL," +
                //"categoriaJuego TEXT NOT NULL," + //agregarla o no agregarla? es la cuestion
                "nombreJugador TEXT NOT NULL," +
                "complejidad TEXT NOT NULL," +
                "nivel TEXT NOT NULL," +
                "puntaje INTEGER NOT NULL) ;");
    }

    // este metodo se ejecuta cuando cambia la version de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_JUEGOS + ";");
        onCreate(sqLiteDatabase);
    }
}