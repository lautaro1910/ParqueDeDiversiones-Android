package com.example.ejercicio4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
                //Creamos el Intent
                Intent intent =
                        new Intent(InformacionActivity.this, CategoriaActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }

        });
    }
}
