package com.example.ejercicio4;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ejercicio4.db.DBHelper;

public class InformacionActivity extends AppCompatActivity {

    private Button btnVolver;
    private Button btnCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion);

        btnVolver = (Button) findViewById(R.id.volver);
        btnCategorias = (Button) findViewById(R.id.btnCategorias);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(InformacionActivity.this, MainActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }

        });

        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ------------------------------
                // aca esta la parte de la DB
                DBHelper dbHelper = new DBHelper(InformacionActivity.this);
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
                        new Intent(InformacionActivity.this, MenuCategoriasActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }

        });
    }
}
