package com.example.myapplication.view;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.example.myapplication.adapter.AdapterCartas;
import com.example.myapplication.R;
import com.example.myapplication.model.FilmeDetalhes;
import com.example.myapplication.viewmodel.FilmeViewModel;
import static com.example.myapplication.util.Constantes.Hash.API_KEY;
import static com.example.myapplication.util.Constantes.Language.PT_BR;

public class TrunfoActivity extends AppCompatActivity {
    private RecyclerView recyclerCartas;
    private List<FilmeDetalhes> filmes = new ArrayList<>();
    private FilmeViewModel filmeViewModel;
    private AdapterCartas adapter;
    private String movieId = "297761";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trunfo);

        initViews();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCartas.setLayoutManager(layoutManager);
        recyclerCartas.setAdapter(adapter);

        filmeViewModel.getFilmes(movieId, API_KEY,  PT_BR);
        filmeViewModel.liveDataFilmeDetalhes.observe(this, filmeDetalhes -> adapter.setUpdate(filmeDetalhes));
    }

    public void initViews(){
        recyclerCartas = findViewById(R.id.recyclerCartas);
        filmeViewModel = ViewModelProviders.of(this).get(FilmeViewModel.class);
        adapter = new AdapterCartas(filmes);
    }
}
