package com.example.myapplication.view;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.AdapterCartas;
import com.example.myapplication.adapter.FavoritoAdapter;
import com.example.myapplication.model.Carta;
import com.example.myapplication.viewmodel.CartaViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoritosActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CartaViewModel viewModel;
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
        viewModel.erro.observe(this, erroMessagem ->{
            Toast.makeText(this, erroMessagem, Toast.LENGTH_SHORT).show();
        });

    }

    public void initViews(){
        recyclerView = findViewById(R.id.recyclerFavoritos);
        adapter = new FavoritoAdapter(listFavoritos);
        viewModel = ViewModelProviders.of(this).get(CartaViewModel.class);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(FavoritosActivity.this, SelecaoJogo.class));
        finishAffinity();
    }
}
