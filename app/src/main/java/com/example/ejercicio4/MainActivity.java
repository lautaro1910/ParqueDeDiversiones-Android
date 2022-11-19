package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ejercicio4.db.DBHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnCategories;
    private Button btnInformacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCategories = (Button) findViewById(R.id.buttonCategories);
        btnInformacion = (Button) findViewById(R.id.btnInfo);

        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ------------------------------
                // aca esta la parte de la DB
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase(); //indicamos que vamos a escribir en nuestra db
                /*
                if(db != null){
                    Toast.makeText(MainActivity.this, "Base de Datos creada!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText( MainActivity.this, "ERROR. Base de Datos no creada!", Toast.LENGTH_LONG).show();
                }
                */
                // aca termina la parte de DB
                // falta probar
                // ------------------------------



                //Creamos el Intent
                Intent intent =
                        new Intent(MainActivity.this, MenuCategoriasActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        btnInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MainActivity.this, InformacionActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }

        });
    }

}