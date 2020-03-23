package com.example.myapplication.viewmodel;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;
import com.example.myapplication.model.Filme;
import com.example.myapplication.model.FilmeDetalhes;
import com.example.myapplication.repository.FilmeRepository;
import java.util.List;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FilmeViewModel extends AndroidViewModel {

    private MutableLiveData<List<Filme>> listMutableLiveData = new MutableLiveData<>();
    public LiveData<List<Filme>> listLiveData = listMutableLiveData;
    private CompositeDisposable disposable = new CompositeDisposable();
    private FilmeRepository repository = new FilmeRepository();
    private MutableLiveData<FilmeDetalhes> mLiveDataFilmeDetalhes = new MutableLiveData<>();
    public LiveData<FilmeDetalhes> liveDataFilmeDetalhes = mLiveDataFilmeDetalhes;

    public FilmeViewModel(@NonNull Application application) {
        super(application);
    }

    public void getAllFilmes(String apiKey, String language, int pagina) {
        disposable.add(
                repository.getAllFilmes(apiKey, language, pagina)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(filmeResponse -> listMutableLiveData.setValue(filmeResponse.getResults()),
                                throwable -> Log.i("LOG", "MESSAGE -> " + throwable.getMessage()))
        );
    }

    public void getFilmes(String movieId, String apiKey, String language) {
        disposable.add(
                repository.getFilme(movieId, apiKey, language)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(filmeDetalhes -> mLiveDataFilmeDetalhes.setValue(filmeDetalhes),
                                throwable -> Log.i("LOG", "MESSAGE -> " + throwable.getMessage()))
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
