package com.example.myapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.R;

public class SelecaoJogo extends AppCompatActivity {
    private ImageView imagemTrunfo;
    private ImageView imagemQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_jogo);
        initViews();

        imagemTrunfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TrunfoActivity.class));
            }
        });

        imagemQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),QuizActivity.class));
            }
        });
    }

    public void initViews(){
        imagemTrunfo = findViewById(R.id.imagemTrunfo);
        imagemQuiz = findViewById(R.id.imagemQuiz);
    }
}
