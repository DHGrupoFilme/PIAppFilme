package com.example.myapplication.repository;
import com.example.myapplication.model.FilmeDetalhes;
import com.example.myapplication.model.FilmeResponse;
import io.reactivex.Observable;
import static com.example.myapplication.network.RetrofitService.getApiService;

public class FilmeRepository {

    public Observable<FilmeResponse> getAllFilmes(String apiKey, String language, int pagina){
       return getApiService().getAllFilmes(apiKey, language, pagina);
    }

    public Observable<FilmeDetalhes> getFilme(String movieId, String apiKey, String language){
        return getApiService().getFilme(movieId, apiKey, language);
    }
}
