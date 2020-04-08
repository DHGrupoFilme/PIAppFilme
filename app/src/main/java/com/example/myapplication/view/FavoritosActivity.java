package com.example.myapplication.view;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.view.adapter.AdapterCartas;
import com.example.myapplication.view.adapter.FavoritoAdapter;
import com.example.myapplication.model.Carta;
import com.example.myapplication.viewmodel.FilmeViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoritosActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FilmeViewModel viewModel;
    private FavoritoAdapter adapter;
    private AdapterCartas adapterCartas;
    private List<Carta> listFavoritos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        initViews();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    public void initViews(){
        recyclerView = findViewById(R.id.recyclerFavoritos);
        adapter = new FavoritoAdapter(listFavoritos);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(FavoritosActivity.this, SelecaoJogo.class));
        finishAffinity();
    }
}
