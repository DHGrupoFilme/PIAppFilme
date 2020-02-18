package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Trunfo extends AppCompatActivity {
    private TextView textGanhou;
    private TextView textPerdeu;
    private ImageView setaGanhou;
    private ImageView setaPerdeu;
    private TextView pontosGanhou;
    private TextView pontosPerdeu;
    private RecyclerView recyclerCartas;
    private List<Carta> cartas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trunfo);
        recyclerCartas = findViewById(R.id.recyclerCartas);
        onBind();
        AdapterCartas adapter = new AdapterCartas(cartas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCartas.setLayoutManager(layoutManager);
        recyclerCartas.setAdapter(adapter);


    }

    public void onBind(){
        Carta c = new Carta("Joker", "2019", "90", "*****", "62.000.000", "1.200.000.000", R.drawable.joker);
        cartas.add(c);
        c = new Carta("It", "2017", "80", "****", "50.000.000", "900.000.000", R.drawable.it);
        cartas.add(c);
    }

    public void initViews(){
        textGanhou = findViewById(R.id.textGanhou);
        textPerdeu = findViewById(R.id.textPerdeu);
        setaGanhou = findViewById(R.id.setaGanhou);
        setaPerdeu = findViewById(R.id.setaPerdeu);
        pontosGanhou = findViewById(R.id.pontosGanhou);
        pontosPerdeu = findViewById(R.id.pontosPerdeu);
    }
}
