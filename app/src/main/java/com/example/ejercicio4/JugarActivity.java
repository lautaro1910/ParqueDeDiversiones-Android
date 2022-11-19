package com.example.ejercicio4;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ejercicio4.db.DBHelper;
import com.example.ejercicio4.db.DBJuegos;

public class JugarActivity extends AppCompatActivity {

    Button btnFinalizar;
    Button btnVolver;
    Spinner spinnerNiveles;
    Spinner spinnerDificultad;
    ImageView imagenPrincipal;
    TextView textJuego;

    //textEdit
    EditText nombreJugador, puntaje;

    static Integer[] images = {R.drawable.topo,R.drawable.pinball,R.drawable.pato,R.drawable.skeeball,
            R.drawable.martillo,R.drawable.punching_bag,R.drawable.soccer,R.drawable.vencidas,
            R.drawable.bowling,R.drawable.disquito_flotador,R.drawable.basquet,R.drawable.minigolf,
            R.drawable.dardo,R.drawable.aros,R.drawable.sapito,R.drawable.pistola_de_agua};

    static Integer[] namesImages = {R.string.topo,R.string.pinball,R.string.pato,R.string.skeeball,
            R.string.martillo,R.string.punchingBag,R.string.soccer,R.string.vencidas,
            R.string.bowling,R.string.disquito,R.string.basquet,R.string.minigolf,
            R.string.dardo,R.string.aros,R.string.sapito,R.string.pistolaDeAgua};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.jugar);
        Bundle bundle = this.getIntent().getExtras();

        //TextView
        textJuego = (TextView) findViewById(R.id.juego);
        textJuego.setText(namesImages[bundle.getInt("Juego")]);

        //images
        imagenPrincipal = (ImageView) findViewById(R.id.imagePrin);
        imagenPrincipal.setImageResource(images[bundle.getInt("Juego")]);

        //spinners
        spinnerNiveles = findViewById(R.id.spinnerNiveles);
        spinnerDificultad = findViewById(R.id.spinnerDificultad);
        ArrayAdapter<CharSequence> adapterNiveles=ArrayAdapter.createFromResource(this, R.array.niveles, android.R.layout.simple_spinner_item);
        adapterNiveles.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence>adapterDificultad=ArrayAdapter.createFromResource(this, R.array.dificultad, android.R.layout.simple_spinner_item);
        adapterDificultad.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerNiveles.setAdapter(adapterNiveles);
        spinnerDificultad.setAdapter(adapterDificultad);

        //editText
        nombreJugador = findViewById(R.id.nombre);
        puntaje = findViewById(R.id.puntaje);

        //buttons
        btnVolver = (Button) findViewById(R.id.volverA);
        btnFinalizar = (Button) findViewById(R.id.buttonFinalizar);

        //functions
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent intent =
                        new Intent(JugarActivity.this, MenuJuegosActivity.class);
                Bundle b = new Bundle();
                b.putInt("Imagen",bundle.getInt("Juego"));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent intent =
                        new Intent(JugarActivity.this, MenuJuegosActivity.class);
                Bundle b = new Bundle();
                b.putInt("Imagen", bundle.getInt("Juego"));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);

                long id = 0;

                if(!(puntaje.getText().toString() != null && nombreJugador.getText().toString() != null)){
                    Toast.makeText(JugarActivity.this, "Es necesario llenar todos los campos!", Toast.LENGTH_LONG).show();
                }else{
                    DBJuegos dbJuegos = new DBJuegos(JugarActivity.this);
                    String dificultad = spinnerDificultad.getSelectedItem().toString();
                    String nivel = spinnerNiveles.getSelectedItem().toString();
                    String nombreJogo = namesImages[bundle.getInt("Juego")].toString();
                    id = dbJuegos.insertarJogo( nombreJogo, nombreJugador.getText().toString(), dificultad, nivel, Integer.parseInt(puntaje.getText().toString()));

                    if (id > 0){
                        Toast.makeText(JugarActivity.this, "Se registro correctamente!", Toast.LENGTH_LONG).show();
                        cleanFields();
                    } else {
                        Toast.makeText(JugarActivity.this, "ERROR. Fallo al registrar informacion", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    private void cleanFields () {
        nombreJugador.setText("");
        puntaje.setText("");
    }
}
