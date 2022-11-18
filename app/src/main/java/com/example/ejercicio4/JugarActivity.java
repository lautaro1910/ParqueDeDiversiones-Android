package com.example.ejercicio4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class JugarActivity extends AppCompatActivity {

    Button btnFinalizar;
    Button btnVolver;
    Spinner spinnerNiveles;
    Spinner spinnerDificultad;
    ImageView imagenPrincipal;
    static Integer[] images = {R.drawable.topo,R.drawable.pinball,R.drawable.pato,R.drawable.skeeball,
            R.drawable.martillo,R.drawable.punching_bag,R.drawable.soccer,R.drawable.vencidas,
            R.drawable.bowling,R.drawable.disquito_flotador,R.drawable.basquet,R.drawable.minigolf,
            R.drawable.dardo,R.drawable.aros,R.drawable.sapito,R.drawable.pistola_de_agua};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jugar);
        Bundle bundle = this.getIntent().getExtras();
        imagenPrincipal = (ImageView) findViewById(R.id.imagePrin);
        imagenPrincipal.setImageResource(images[bundle.getInt("Juego")]);
        spinnerNiveles = findViewById(R.id.spinnerNiveles);
        spinnerDificultad = findViewById(R.id.spinnerDificultad);
        ArrayAdapter<CharSequence> adapterNiveles=ArrayAdapter.createFromResource(this, R.array.niveles, android.R.layout.simple_spinner_item);
        adapterNiveles.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence>adapterDificultad=ArrayAdapter.createFromResource(this, R.array.dificultad, android.R.layout.simple_spinner_item);
        adapterDificultad.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerNiveles.setAdapter(adapterNiveles);
        spinnerDificultad.setAdapter(adapterDificultad);
        btnVolver = (Button) findViewById(R.id.volverA);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent intent =
                        new Intent(JugarActivity.this, MenuJuegosActivity.class);
                Bundle b = new Bundle();
                //DEPORTE == 3
                b.putInt("Imagen",bundle.getInt("Juego"));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

    }
}
