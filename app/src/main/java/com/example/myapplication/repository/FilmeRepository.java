package com.example.myapplication.repository;

import com.example.myapplication.model.Filme;
import com.example.myapplication.network.FilmeService;

import io.reactivex.Flowable;

public class FilmeRepository {

    public Flowable<Filme> getAllFilme(String apiKey, String language, String sortBy, int genre, int pagina) {
        return FilmeService.getApiService().getAllFilme(apiKey, language, sortBy, genre, pagina);
    }

}