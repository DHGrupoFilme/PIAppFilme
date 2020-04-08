package com.example.myapplication.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import com.example.myapplication.R;
import com.example.myapplication.view.adapter.AdapterCartas;
import com.example.myapplication.model.Result;
import com.example.myapplication.viewmodel.FilmeViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.myapplication.util.Constantes.Hash.API_KEY;
import static com.example.myapplication.util.Constantes.Language.PT_BR;

public class TrunfoActivity extends AppCompatActivity {
    private RecyclerView recyclerCartas;
    private List<Result> filmes = new ArrayList<>();
    private FilmeViewModel filmeViewModel;
    private AdapterCartas adapter;
    private ImageButton botaoFavoritos;
    private String[] sort = {"popularity.desc", "revenue.desc", "vote_count.desc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trunfo);
        initViews();
        filmeViewModel.getFilmes(API_KEY, PT_BR, sort[new Random().nextInt(2)], 28, 1 + new Random().nextInt(29));
        filmeViewModel.liveData.observe(this, (List<Result> results) -> adapter.atualizaLista(results));

    }

    public void initViews(){
        recyclerCartas = findViewById(R.id.recyclerCartas);
        botaoFavoritos = findViewById(R.id.botaoFavorito);
        filmeViewModel = ViewModelProviders.of(this).get(FilmeViewModel.class);
        adapter = new AdapterCartas(filmes);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCartas.setLayoutManager(layoutManager);
        recyclerCartas.setAdapter(adapter);
    }
}
