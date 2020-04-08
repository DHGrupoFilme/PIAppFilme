package com.example.myapplication.network;

import com.example.myapplication.model.Filme;
import com.example.myapplication.model.Result;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeAPI {

    @GET("discover/movie")
    Flowable<Filme> getAllFilme(@Query("api_key") String apiKey,
                                @Query("language") String language,
                                @Query("sort_by") String sortBy,
                                @Query("with_genres") int genre,
                                @Query("page") int pagina);

    @GET("discover/movie")
    Flowable<Result> getFilme(@Query("api_key") String apiKey,
                              @Query("language") String language,
                              @Query("sort_by") String sortBy,
                              @Query("with_genres") int genre,
                              @Query("page") int pagina);
}
