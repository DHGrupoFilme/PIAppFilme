package com.example.myapplication.view;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import com.example.myapplication.adapter.AdapterCartas;
import com.example.myapplication.R;
import com.example.myapplication.model.FilmeDetalhes;
import com.example.myapplication.viewmodel.CartaViewModel;
import com.example.myapplication.viewmodel.FilmeViewModel;
import static com.example.myapplication.util.Constantes.Hash.API_KEY;
import static com.example.myapplication.util.Constantes.Language.PT_BR;

public class TrunfoActivity extends AppCompatActivity {
    private RecyclerView recyclerCartas;
    private List<FilmeDetalhes> filmes = new ArrayList<>();
    private FilmeViewModel filmeViewModel;
    private AdapterCartas adapter;
    private CartaViewModel cartaViewModel;
    private String movieId = "297761";
    private ImageButton botaoFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trunfo);
        initViews();
        cartaViewModel.getTodasCartas(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCartas.setLayoutManager(layoutManager);
        recyclerCartas.setAdapter(adapter);

        filmeViewModel.getFilmes(movieId, API_KEY,  PT_BR);
        filmeViewModel.liveDataFilmeDetalhes.observe(this, filmeDetalhes -> adapter.setUpdate(filmeDetalhes));
    }

    public void initViews(){
        recyclerCartas = findViewById(R.id.recyclerCartas);
        botaoFavoritos = findViewById(R.id.botaoFavorito);
        cartaViewModel = ViewModelProviders.of(this).get(CartaViewModel.class);
        filmeViewModel = ViewModelProviders.of(this).get(FilmeViewModel.class);
        adapter = new AdapterCartas(filmes);
    }
}
