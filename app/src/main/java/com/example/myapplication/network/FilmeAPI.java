package com.example.myapplication.network;
import com.example.myapplication.model.FilmeDetalhes;
import com.example.myapplication.model.FilmeResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FilmeAPI {

    @GET("movie/now_playing")
    Observable<FilmeResponse> getAllFilmes(@Query("api_key") String apiKey,
                                           @Query("language") String language,
                                           @Query("page") int pagina);
    @GET("movie/{movie_id}")
    Observable<FilmeDetalhes> getFilme(@Path("movie_id") String movieId,
                                       @Query("api_key") String apiKey,
                                       @Query("language") String language);


}
