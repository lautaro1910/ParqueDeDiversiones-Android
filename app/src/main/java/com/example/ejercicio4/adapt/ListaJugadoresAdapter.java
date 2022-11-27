package com.example.ejercicio4.adapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.ejercicio4.R;
import com.example.ejercicio4.entidades.Jogos;

import java.util.ArrayList;

public class ListaJugadoresAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Jogos> listaJugadores;
    public ListaJugadoresAdapter(Context context, int layout, ArrayList<Jogos> names){
        this.context = context;
        this.layout = layout;
        this.listaJugadores = names;
    }

    @Override
    public int getCount() {
        return listaJugadores.size();
    }

    @Override
    public Object getItem(int i) {
        return listaJugadores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        TextView viewNombreJugador, viewNivel, viewComplejidad, viewPuntaje;
        // Copiamos la vista
        View v;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.item_jugador, null);

        // Valor actual según la posición

        String nombreJugador  = listaJugadores.get(position).getNombreJugador();
        String nivel  = listaJugadores.get(position).getNivel();
        String complejidad  = listaJugadores.get(position).getComplejidad();
        int puntaje  = listaJugadores.get(position).getPuntaje();


        // Referenciamos el elemento a modificar y lo rellenamos
        viewNombreJugador = v.findViewById(R.id.viewNombreJugador);
        viewNivel = v.findViewById(R.id.viewNivel);
        viewComplejidad = v.findViewById(R.id.viewComplejidad);
        viewPuntaje = v.findViewById(R.id.viewPuntaje);

        viewNombreJugador.setText(nombreJugador);
        viewComplejidad.setText(complejidad);
        viewPuntaje.setText(Integer.toString(puntaje)+" pts");
        viewNivel.setText(nivel);
        //Devolvemos la vista inflada
        return v;
    }

}
