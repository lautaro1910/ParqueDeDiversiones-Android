package com.example.ejercicio4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuCategoriasActivity extends AppCompatActivity {

    private ImageView imageDestreza;
    private ImageView imagePunteria;
    private ImageView imageOneVSOne;
    private ImageView imageFuerza;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorias);

        btnVolver = (Button) findViewById(R.id.volver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(MenuCategoriasActivity.this, MainActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        imageDestreza = (ImageView) findViewById(R.id.imageDestreza);
        imageDestreza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MenuCategoriasActivity.this, CategoriaActivity.class);
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                //DESTREZA == 1
                b.putInt("Opcion",1);
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }

        });
        imagePunteria = (ImageView) findViewById(R.id.imagePunteria);
        imagePunteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            //Creamos el Intent
            Intent intent =
                    new Intent(MenuCategoriasActivity.this, CategoriaActivity.class);
                Bundle b = new Bundle();
                //PUNTERIA == 4
                b.putInt("Opcion",4);
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
        imageFuerza = (ImageView) findViewById(R.id.imageFuerza);
        imageFuerza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MenuCategoriasActivity.this, CategoriaActivity.class);
                Bundle b = new Bundle();
                //FUERZA == 2
                b.putInt("Opcion",2);
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
        imageOneVSOne = (ImageView) findViewById(R.id.imageOneVSOne);
        imageOneVSOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MenuCategoriasActivity.this, CategoriaActivity.class);
                Bundle b = new Bundle();
                //DEPORTE == 3
                b.putInt("Opcion",3);
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }
}
