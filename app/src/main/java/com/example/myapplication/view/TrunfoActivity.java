package com.example.myapplication.view;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.myapplication.adapter.AdapterCartas;
import com.example.myapplication.model.Carta;
import com.example.myapplication.R;
import java.util.ArrayList;
import java.util.List;

public class TrunfoActivity extends AppCompatActivity {
    private RecyclerView recyclerCartas;
    private List<Carta> cartas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trunfo);
        onBind();

        initViews();
        AdapterCartas adapter = new AdapterCartas(cartas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCartas.setLayoutManager(layoutManager);
        recyclerCartas.setAdapter(adapter);
    }

    public void onBind() {
        Carta c = new Carta("Joker", "2019", "90", "*****", "62.000.000", "1.200.000.000", R.drawable.joker);
        cartas.add(c);
        c = new Carta("It", "2017", "80", "****", "50.000.000", "900.000.000", R.drawable.it);
        cartas.add(c);
    }

    public void initViews(){
        recyclerCartas = findViewById(R.id.recyclerCartas);
    }
}
