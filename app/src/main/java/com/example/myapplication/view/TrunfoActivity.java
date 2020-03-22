package com.example.myapplication.view;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.adapter.AdapterCartas;
import com.example.myapplication.model.Carta;
import com.example.myapplication.R;
import com.example.myapplication.viewmodel.CartaViewModel;

import java.util.ArrayList;
import java.util.List;

public class TrunfoActivity extends AppCompatActivity {
    private TextView textGanhou;
    private TextView textPerdeu;
    private ImageView setaGanhou;
    private ImageView setaPerdeu;
    private TextView pontosGanhou;
    private TextView pontosPerdeu;
    private RecyclerView recyclerCartas;
    private List<Carta> cartas = new ArrayList<>();
    private ImageButton botaoFavoritos;
    private CartaViewModel viewModel;
    private AdapterCartas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trunfo);
        initViews();
        viewModel.getTodasCartas(this);
        onBind();
    }

    public void onBind() {
        Carta c = new Carta("Joker", "2019", "90", "*****", "62.000.000", "1.200.000.000", R.drawable.joker);
        cartas.add(c);
        c = new Carta("It", "2017", "80", "****", "50.000.000", "900.000.000", R.drawable.it);
        cartas.add(c);
    }

    public void initViews() {
        textGanhou = findViewById(R.id.textGanhou);
        textPerdeu = findViewById(R.id.textPerdeu);
        setaGanhou = findViewById(R.id.setaGanhou);
        setaPerdeu = findViewById(R.id.setaPerdeu);
        pontosGanhou = findViewById(R.id.pontosGanhou);
        pontosPerdeu = findViewById(R.id.pontosPerdeu);
        botaoFavoritos = findViewById(R.id.botaoFavorito);

        recyclerCartas = findViewById(R.id.recyclerCartas);
        adapter = new AdapterCartas(cartas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCartas.setLayoutManager(layoutManager);
        recyclerCartas.setAdapter(adapter);
        viewModel = ViewModelProviders.of(this).get(CartaViewModel.class);
    }

    public void clickFavorito(View view){
        insereCarta();
        Toast.makeText(this, "Adicionado aos favoritos", Toast.LENGTH_SHORT).show();
    }

    public void insereCarta(){
        Carta carta = (adapter.getCartaFavoritos());
        viewModel.insereCarta(carta, this);
    }
}
