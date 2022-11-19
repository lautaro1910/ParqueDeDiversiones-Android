package com.example.ejercicio4.adapt;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ejercicio4.R;
import com.example.ejercicio4.entidades.Jogos;

import java.util.ArrayList;

public class ListaJugadoresAdapter extends RecyclerView.Adapter<ListaJugadoresAdapter.JugadorViewHolder> {
    ArrayList<Jogos> listaJugadores;

    public ListaJugadoresAdapter(ArrayList<Jogos> listaJugadores){
        this.listaJugadores = listaJugadores;
    }

    @NonNull
    @Override
    public JugadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jugador, null, false);
        return new JugadorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JugadorViewHolder holder, int position) {
        holder.viewNombreJugador.setText(listaJugadores.get(position).getNombreJugador());
        holder.viewNombreJuego.setText(listaJugadores.get(position).getNombreJuego());
        holder.viewComplejidad.setText(listaJugadores.get(position).getComplejidad());
        holder.viewPuntaje.setText(listaJugadores.get(position).getPuntaje());
    }

    @Override
    public int getItemCount() {
        return listaJugadores.size();
    }

    public class JugadorViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombreJugador, viewNombreJuego, viewComplejidad, viewPuntaje;

        public JugadorViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombreJugador = itemView.findViewById(R.id.viewNombreJugador);
            viewNombreJuego = itemView.findViewById(R.id.viewNombreJuego);
            viewComplejidad = itemView.findViewById(R.id.viewComplejidad);
            viewPuntaje = itemView.findViewById(R.id.viewPuntaje);
        }
    }
}
