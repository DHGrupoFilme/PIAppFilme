package com.example.myapplication.view.adapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.model.Carta;
import java.util.List;

public class AdapterCartasQuiz extends RecyclerView.Adapter<AdapterCartasQuiz.MyViewHolder> {
    private List<Carta> cartas;
    public AdapterCartasQuiz(List<Carta> listaCartas){
        this.cartas = listaCartas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View cartaLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.carta_quiz, parent, false);
        return new MyViewHolder(cartaLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Carta carta = cartas.get(position);
        holder.nomeDoFilme.setText( carta.getNomeFilme());
        holder.anoFilme.setText( carta.getAno());
        holder.imagemCarta.setImageResource( carta.getImagem());
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeDoFilme;
        private TextView anoFilme;
        private ImageView imagemCarta;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeDoFilme = itemView.findViewById(R.id.tituloCartaQuiz);
            anoFilme = itemView.findViewById(R.id.anoCartaQuiz);
            imagemCarta = itemView.findViewById(R.id.imagemCartaQuiz);
        }
    }
}
