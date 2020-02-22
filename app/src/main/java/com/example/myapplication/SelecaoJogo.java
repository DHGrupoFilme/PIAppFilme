package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

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
                startActivity(new Intent(getApplicationContext(), Trunfo.class));
            }
        });

//        imagemQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), );
//            }
//        });
    }

    public void initViews(){
        imagemTrunfo = findViewById(R.id.imagemTrunfo);
        //imagemQuiz = findViewById(R.id.imagemQuiz);
    }
}
