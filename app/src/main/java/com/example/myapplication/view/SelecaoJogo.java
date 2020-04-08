package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.R;
public class SelecaoJogo extends Menu {
    private ImageView imagemTrunfo;
    private ImageView imagemQuiz;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_selecao_jogo;
    }

    public void initViews(){
        imagemTrunfo = findViewById(R.id.imagemTrunfo);
        imagemQuiz = findViewById(R.id.imagemQuiz);
    }
}
