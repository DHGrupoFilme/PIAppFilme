package com.example.myapplication.adapter;
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

public class AdapterCartas extends RecyclerView.Adapter<AdapterCartas.MyViewHolder> {
    private List<Carta> cartas;
    private Carta cartaFavorito;
    private List<Carta>  listaFavoritos;

    public AdapterCartas(List<Carta> listaCartas){
        this.cartas = listaCartas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View cartaLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.carta, parent, false);
        return new MyViewHolder(cartaLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Carta carta = cartas.get(position);
        holder.nomeDoFilme.setText( carta.getNomeFilme());
        holder.anoFilme.setText( carta.getAno());
        holder.bilheteria.setText( carta.getBilheteria());
        holder.orcamento.setText( carta.getOrcamento());
        holder.critica.setText( carta.getCritica());
        holder.popularidade.setText( carta.getPopularidade());
        holder.imagemCarta.setImageResource( carta.getImagem());
        cartaFavorito = carta;

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void atualizaListaFavoritos(List<Carta> novaListaFavoritos){
        this.listaFavoritos.clear();
        this.listaFavoritos = novaListaFavoritos;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeDoFilme;
        private TextView anoFilme;
        private TextView textPopularidade;
        private TextView popularidade;
        private TextView textCritica;
        private TextView critica;
        private TextView textOrcamento;
        private TextView orcamento;
        private TextView textBilheteria;
        private TextView bilheteria;
        private ImageView imagemCarta;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeDoFilme = itemView.findViewById(R.id.textNomeFilme);
            anoFilme = itemView.findViewById(R.id.textAno);
            textPopularidade = itemView.findViewById(R.id.textPopularidade);
            popularidade = itemView.findViewById(R.id.popularidade);
            textCritica = itemView.findViewById(R.id.textCritica);
            critica = itemView.findViewById(R.id.critica);
            textOrcamento = itemView.findViewById(R.id.textOrcamento);
            orcamento = itemView.findViewById(R.id.orcamento);
            textBilheteria = itemView.findViewById(R.id.text_bilheteria);
            bilheteria = itemView.findViewById(R.id.bilheteria);
            imagemCarta = itemView.findViewById(R.id.imagemCarta);

        }
    }
    public Carta getCartaFavoritos() {
        return cartaFavorito;
    }


}
