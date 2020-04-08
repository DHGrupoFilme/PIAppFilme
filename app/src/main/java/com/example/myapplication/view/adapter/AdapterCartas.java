package com.example.myapplication.view.adapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.Random;

import com.example.myapplication.R;
import com.example.myapplication.model.Result;
import com.squareup.picasso.Picasso;

import io.reactivex.annotations.NonNull;

import static com.example.myapplication.util.Constantes.UrlImagemFilme.URL_IMAGEM;

public class AdapterCartas extends RecyclerView.Adapter<AdapterCartas.MyViewHolder> {
    private List<Result> listaResult;

    public AdapterCartas(List<Result> result) {
        this.listaResult = result;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@io.reactivex.annotations.NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carta, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@io.reactivex.annotations.NonNull MyViewHolder holder, int position) {
        Result resultFilme =listaResult.get(new Random().nextInt(19));
        holder.onBind(resultFilme);
    }

    @Override
    public int getItemCount() {
        return listaResult.size() -19;
    }

    public void atualizaLista(List<Result> novaLista){
        if (this.listaResult.isEmpty()){
            this.listaResult = novaLista;
        }else {
            this.listaResult.addAll(novaLista);
        }
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
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
            imagemCarta = itemView.findViewById(R.id.imagemCarta);
        }

        public void onBind(Result filme){
            nomeDoFilme.setText(filme.getTitle());
            anoFilme.setText(filme.getReleaseDate());
            critica.setText(String.valueOf(filme.getVoteAverage()));
            popularidade.setText(String.valueOf(filme.getPopularity()));
            Picasso.get().load(URL_IMAGEM+ filme.getPosterPath()).into(imagemCarta);
        }
    }
}
