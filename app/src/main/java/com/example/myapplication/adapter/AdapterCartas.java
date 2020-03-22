package com.example.myapplication.adapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import com.example.myapplication.R;
import com.example.myapplication.model.FilmeDetalhes;
import com.squareup.picasso.Picasso;
import static com.example.myapplication.util.Constantes.UrlImagemFilme.URL_IMAGEM;

public class AdapterCartas extends RecyclerView.Adapter<AdapterCartas.MyViewHolder> {
    private List<FilmeDetalhes> filmeList;
    public AdapterCartas(List<FilmeDetalhes> filmesList){
        this.filmeList = filmesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carta, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final FilmeDetalhes filme = filmeList.get(position);
         holder.onBind(filme);
    }

    @Override
    public int getItemCount() {
        return filmeList.size();
    }

    public void setUpdate(FilmeDetalhes novaLista){
        if (this.filmeList.isEmpty()){
            this.filmeList.add(novaLista);
        }else{
            this.filmeList.clear();
            this.filmeList.add(novaLista);
        }
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

        public void onBind(FilmeDetalhes filme) {
            nomeDoFilme.setText(filme.getTitle());
            anoFilme.setText(filme.getReleaseDate().substring(0,4));
            bilheteria.setText(filme.getRevenue().toString() );
            orcamento.setText(filme.getBudget().toString());
            critica.setText(filme.getVoteAverage().toString());
            popularidade.setText(filme.getPopularity().toString());
            Picasso.get().load(URL_IMAGEM+ filme.getPosterPath()).into(imagemCarta);
        }
    }
}
