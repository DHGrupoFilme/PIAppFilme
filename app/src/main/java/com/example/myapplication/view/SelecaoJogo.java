package com.example.myapplication.view;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SelecaoJogo extends Menu{
    private ImageView imagemTrunfo;
    private ImageView imagemQuiz;
    private List<String> listaCheck = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        recebeCheck();

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

    private void recebeCheck(){
        Intent intent = getIntent();
        if(intent != null) {
            listaCheck = (List<String>) getIntent().getSerializableExtra("check");
        }
    }
}
