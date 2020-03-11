package com.example.myapplication.view;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.myapplication.adapter.AdapterCartasQuiz;
import com.example.myapplication.model.Carta;
import com.example.myapplication.R;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private RecyclerView recyclerCartas;
    private List<Carta> cartas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        recyclerCarta1();
    }

    public void onBind(){
        Carta c = new Carta("Taxi Driver", "2000", "90", "*****", "62.000.000", "1.200.000.000", R.drawable.taxidriver);
        cartas.add(c);
        c = new Carta("Speed Racer", "2017", "80", "****", "50.000.000", "900.000.000", R.drawable.speed);
        cartas.add(c);
    }

    protected void recyclerCarta1(){
        recyclerCartas = findViewById(R.id.quizCarta1);
        onBind();
        AdapterCartasQuiz adapter = new AdapterCartasQuiz(cartas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCartas.setLayoutManager(layoutManager);
        recyclerCartas.setAdapter(adapter);
    }

}
