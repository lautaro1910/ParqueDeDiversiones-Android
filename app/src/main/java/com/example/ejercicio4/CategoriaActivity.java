package com.example.ejercicio4;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CategoriaActivity extends AppCompatActivity {

    private Button btnVolver;
    private Button btnMenu;
    private TextView textoUno;
    private TextView textoDos;
    private TextView textoTres;
    private TextView textoCuatro;
    private ImageView imagenUno;
    private ImageView imagenDos;
    private ImageView imagenTres;
    private ImageView imagenCuatro;
    androidx.constraintlayout.widget.ConstraintLayout layoutMenu;
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
        setContentView(R.layout.juegos);
        layoutMenu = (androidx.constraintlayout.widget.ConstraintLayout) findViewById(R.id.layoutJuegos);
        imagenUno = (ImageView) findViewById(R.id.imageJuego1);
        imagenDos = (ImageView) findViewById(R.id.imageJuego2);
        imagenTres = (ImageView) findViewById(R.id.imageJuego3);
        imagenCuatro = (ImageView) findViewById(R.id.imageJuego4);
        textoUno = (TextView) findViewById(R.id.textoJuego1);
        textoDos = (TextView) findViewById(R.id.textoJuego2);
        textoTres = (TextView) findViewById(R.id.textoJuego3);
        textoCuatro = (TextView) findViewById(R.id.textoJuego4);
        Bundle bundle = this.getIntent().getExtras();
        imagenUno.setImageResource(images[4 * bundle.getInt("Opcion")-4]);
        imagenDos.setImageResource(images[4 * bundle.getInt("Opcion")-3]);
        imagenTres.setImageResource(images[4 * bundle.getInt("Opcion")-2]);
        imagenCuatro.setImageResource(images[4 * bundle.getInt("Opcion")-1]);
        textoUno.setText(namesImages[4 * bundle.getInt("Opcion")-4]);
        textoDos.setText(namesImages[4 * bundle.getInt("Opcion")-3]);
        textoTres.setText(namesImages[4 * bundle.getInt("Opcion")-2]);
        textoCuatro.setText(namesImages[4 * bundle.getInt("Opcion")-1]);
        btnMenu = (Button) findViewById(R.id.menuPrincipal);
        btnVolver = (Button) findViewById(R.id.volver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(CategoriaActivity.this, MenuCategoriasActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent intent =
                        new Intent(CategoriaActivity.this, MainActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
        imagenUno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Creamos el Intent
                Intent intent =
                        new Intent(CategoriaActivity.this, MenuJuegosActivity.class);
                Bundle b = new Bundle();

                b.putInt("Imagen",(4 * bundle.getInt("Opcion")-4));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
        imagenDos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Creamos el Intent
                Intent intent =
                        new Intent(CategoriaActivity.this, MenuJuegosActivity.class);
                Bundle b = new Bundle();

                b.putInt("Imagen",(4 * bundle.getInt("Opcion")-3));//Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
        imagenTres.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Creamos el Intent
                Intent intent =
                        new Intent(CategoriaActivity.this, MenuJuegosActivity.class);
                Bundle b = new Bundle();

                b.putInt("Imagen",(4 * bundle.getInt("Opcion")-2));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
        imagenCuatro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Creamos el Intent
                Intent intent =
                        new Intent(CategoriaActivity.this, MenuJuegosActivity.class);
                Bundle b = new Bundle();

                b.putInt("Imagen",(4 * bundle.getInt("Opcion")-1));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        layoutMenu.setOnTouchListener(new OnSwipeTouchListener(CategoriaActivity.this) {
            public void onSwipeRight() {
                //Creamos el Intent
                Intent intent =
                        new Intent(CategoriaActivity.this, CategoriaActivity.class);
                Bundle b = new Bundle();
                b.putInt("Opcion", Math.floorMod(bundle.getInt("Opcion"),4)+1);
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
            public void onSwipeLeft() {
                //Creamos el Intent
                Intent intent =
                        new Intent(CategoriaActivity.this, CategoriaActivity.class);
                Bundle b = new Bundle();
                b.putInt("Opcion", Math.floorMod(bundle.getInt("Opcion")-2,4)+1);

                    //Añadimos la información al intent
                    intent.putExtras(b);
                    //Iniciamos la nueva actividad
                    startActivity(intent);
                }


        });
    }
}
