package com.example.ejercicio4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio4.adapt.ListaJugadoresAdapter;
import com.example.ejercicio4.db.DBJuegos;
import com.example.ejercicio4.entidades.Jogos;

import java.util.ArrayList;

public class EstadisticasActivity extends AppCompatActivity {
    Button btnVolver;

    RecyclerView listaJugadores;
    ArrayList<Jogos> listaArrayJogadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadisticas);

        listaJugadores = findViewById(R.id.listaJugadores);
        listaJugadores.setLayoutManager(new LinearLayoutManager(this));

        DBJuegos dbJuegos = new DBJuegos(EstadisticasActivity.this);

        listaArrayJogadores = new ArrayList<>();

        ListaJugadoresAdapter lAdapter = new ListaJugadoresAdapter(dbJuegos.mostrarJugadores());

        listaJugadores.setAdapter(lAdapter);

        Bundle bundle = this.getIntent().getExtras();
        btnVolver = (Button) findViewById(R.id.volver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent intent =
                        new Intent(EstadisticasActivity.this, MenuJuegosActivity.class);
                Bundle b = new Bundle();
                b.putInt("Imagen",bundle.getInt("Estadistica"));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }
}
