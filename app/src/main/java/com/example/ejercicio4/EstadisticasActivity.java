package com.example.ejercicio4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ejercicio4.adapt.ListaJugadoresAdapter;
import com.example.ejercicio4.db.DBJuegos;
import com.example.ejercicio4.entidades.Jogos;

import java.util.ArrayList;

public class EstadisticasActivity extends AppCompatActivity {
    Button btnVolver;

    ListView listaJugadores;
    ArrayList<Jogos> listaArrayJogadores;

    static Integer[] namesImages = {R.string.topo,R.string.pinball,R.string.pato,R.string.skeeball,
            R.string.martillo,R.string.punchingBag,R.string.soccer,R.string.vencidas,
            R.string.bowling,R.string.disquito,R.string.basquet,R.string.minigolf,
            R.string.dardo,R.string.aros,R.string.sapito,R.string.pistolaDeAgua};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadisticas);
        Bundle bundle = this.getIntent().getExtras();

        listaJugadores = findViewById(R.id.listaJugadores);
        //listaJugadores.setLayoutManager(new LinearLayoutManager(this));

        DBJuegos dbJuegos = new DBJuegos(EstadisticasActivity.this);

        listaArrayJogadores = new ArrayList<>();

        ListaJugadoresAdapter lAdapter = new ListaJugadoresAdapter(EstadisticasActivity.this, R.layout.item_jugador, dbJuegos.mostrarJugadores(Integer.toString(namesImages[bundle.getInt("Estadistica")])));

        listaJugadores.setAdapter(lAdapter);


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
