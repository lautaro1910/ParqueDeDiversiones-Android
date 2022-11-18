package com.example.ejercicio4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EstadisticasActivity extends AppCompatActivity {
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadisticas);
        Bundle bundle = this.getIntent().getExtras();
        btnVolver = (Button) findViewById(R.id.volver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent intent =
                        new Intent(EstadisticasActivity.this, MenuJuegosActivity.class);
                Bundle b = new Bundle();
                //DEPORTE == 3
                b.putInt("Imagen",bundle.getInt("Estadistica"));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }
}
