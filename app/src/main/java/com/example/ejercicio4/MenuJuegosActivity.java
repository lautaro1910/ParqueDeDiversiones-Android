package com.example.ejercicio4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuJuegosActivity extends AppCompatActivity {

    Button btnVolver;
    Button btnCategorias;
    Button btnMenuPrincipal;
    Button btnJugar;
    Button btnEstadisticas;
    ImageView imagenPrincipal;
    androidx.constraintlayout.widget.ConstraintLayout layoutMenu;

    static Integer[] images = {R.drawable.topo,R.drawable.pinball,R.drawable.pato,R.drawable.skeeball,
            R.drawable.martillo,R.drawable.punching_bag,R.drawable.soccer,R.drawable.vencidas,
            R.drawable.bowling,R.drawable.disquito_flotador,R.drawable.basquet,R.drawable.minigolf,
            R.drawable.dardo,R.drawable.aros,R.drawable.sapito,R.drawable.pistola_de_agua};

    static Integer[] namesImages = {R.string.topo,R.string.pinball,R.string.pato,R.string.skeeball,
            R.string.martillo,R.string.punchingBag,R.string.soccer,R.string.vencidas,
            R.string.bowling,R.string.disquito,R.string.basquet,R.string.minigolf,
            R.string.dardo,R.string.aros,R.string.sapito,R.string.pistolaDeAgua};

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_juego);

        Bundle bundle = this.getIntent().getExtras();
        imagenPrincipal = (ImageView) findViewById(R.id.imagePrincipal);
        imagenPrincipal.setImageResource(images[bundle.getInt("Imagen")]);
        btnVolver = findViewById(R.id.volver);
        btnJugar = findViewById(R.id.jugar);
        btnEstadisticas = findViewById(R.id.estadisticas);
        btnCategorias = findViewById(R.id.btnCategorias);
        btnMenuPrincipal = findViewById(R.id.menuPrincipal);
        layoutMenu = (androidx.constraintlayout.widget.ConstraintLayout) findViewById(R.id.layoutMenuJuegos);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MenuJuegosActivity.this, CategoriaActivity.class);
                Bundle b = new Bundle();
                //DEPORTE == 3
                b.putInt("Opcion", (int) Math.ceil((bundle.getInt("Imagen")/4)+1));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MenuJuegosActivity.this, JugarActivity.class);
                Bundle b = new Bundle();
                //DEPORTE == 3
                b.putInt("Juego", bundle.getInt("Imagen"));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        btnEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MenuJuegosActivity.this, EstadisticasActivity.class);
                Bundle b = new Bundle();
                //DEPORTE == 3
                b.putInt("Estadistica", bundle.getInt("Imagen"));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MenuJuegosActivity.this, MenuCategoriasActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        btnMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MenuJuegosActivity.this, MainActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        layoutMenu.setOnTouchListener(new OnSwipeTouchListener(MenuJuegosActivity.this) {
            public void onSwipeRight() {
                //Creamos el Intent
                Intent intent =
                        new Intent(MenuJuegosActivity.this, MenuJuegosActivity.class);
                Bundle b = new Bundle();
                if(Math.floorMod(bundle.getInt("Imagen"),4) == 3){
                    b.putInt("Imagen", Math.floorMod(bundle.getInt("Imagen")-3,16));
                }else{
                    b.putInt("Imagen", Math.floorMod(bundle.getInt("Imagen") + 1,16));
                }
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
            public void onSwipeLeft() {
                //Creamos el Intent
                Intent intent =
                        new Intent(MenuJuegosActivity.this, MenuJuegosActivity.class);
                Bundle b = new Bundle();
                if(Math.floorMod(bundle.getInt("Imagen"),4) == 0){
                    b.putInt("Imagen", Math.floorMod(bundle.getInt("Imagen")+3,16));
                }else{
                    b.putInt("Imagen", Math.floorMod(bundle.getInt("Imagen")-1,16));
                }
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }


        });
    }
}
