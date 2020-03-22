package com.example.myapplication.model;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@android.arch.persistence.room.Dao
public interface Dao {

    /// A anotação @Insert determina que o método fará uma inserção no BD
    @Insert
    void inserirQuizesBd(Quizes quizes);

    /// A anotação @Delete determina que o método fará um delete no BD
    @Delete
    void apagaQuizesBd(Quizes quizes);

    /// A anotação @Query determina que o método fará uma consulta
    //Flowable é um observable que suporta uma grande quantidade de dados emitido
    //Método que retorna um Flowable do tipo List<Produto> fazendo um select que retorna todos os dados da  tabela
    @Query("SELECT * from quizes")
    Flowable<List<Quizes>> todosOsQuizesBd();

    //Método que retorna um produto especifico a partir de uma consulta usando nome como parametro
    @Query("SELECT * FROM quizes WHERE pergunta=:pergunta")
    Quizes getQuizesPorPerguntaBd(String pergunta);
}
