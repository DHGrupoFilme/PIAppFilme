package com.example.myapplication.model;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class QuizesRepository {


    public Flowable<List<Quizes>> getAllProdutos(Context context){

        return QuizesDatabase.getDatabase(context).DAO().todosOsQuizesBd();
    }

    public void insereProduto(Quizes quizes, Context context){
        QuizesDatabase.getDatabase(context).DAO().inserirQuizesBd(quizes);
    }

    public void apagaProduto(Quizes produto, Context context){
        QuizesDatabase.getDatabase(context).DAO().apagaQuizesBd(produto);
    }

    public Quizes retornaProdutoPorNome(String nome, Context context){
        return QuizesDatabase.getDatabase(context).DAO().getQuizesPorPerguntaBd(nome);
    }

    public Single<Resposta> getProdutosDoArquivo(Context context) {

        try {
            AssetManager manager = context.getAssets();
            InputStream newJson = manager.open("quiz.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(newJson));

            Gson gson = new Gson();

            Resposta resposta = gson.fromJson(reader, Resposta.class);

            return Single.just(resposta);

        } catch (IOException e) {
            e.printStackTrace();
            return Single.error(e);
        }
    }


}
