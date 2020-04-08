package com.example.myapplication.viewmodel;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;
import com.example.myapplication.repository.FilmeRepository;
import com.example.myapplication.model.Result;
import java.util.List;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FilmeViewModel extends AndroidViewModel {
    private CompositeDisposable disposable = new CompositeDisposable();
    private FilmeRepository repository = new FilmeRepository();
    private MutableLiveData<List<Result>> mutableLiveData = new MutableLiveData<>();
    public LiveData<List<Result>> liveData = mutableLiveData;
    private MutableLiveData<String> mutableErro = new MutableLiveData<>();
    public LiveData<String> liveDataErro = mutableErro;

    public FilmeViewModel(@NonNull Application application) {
        super(application);
    }

    public void getFilmes(String apiKey, String language, String sortBy, int genre, int pagina) {
        disposable.add(
                repository.getAllFilme(apiKey, language, sortBy, genre, pagina)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(filme -> mutableLiveData.setValue(filme.getResults()),
                                throwable -> {
                                    mutableErro.setValue(throwable.getMessage());
                                    Log.i("LOG", "MESSAGE ->" + throwable.getMessage());
                                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
