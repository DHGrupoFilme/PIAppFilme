package com.example.myapplication.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import com.example.myapplication.model.Carta;
import com.example.myapplication.repository.CartaRepository;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CartaViewModel extends ViewModel {
    private CartaRepository repository = new CartaRepository();
    private MutableLiveData<List<Carta>> mutableCarta =  new MutableLiveData<>();
    public LiveData<List<Carta>> liveData = mutableCarta;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<String> erroMutable = new MutableLiveData<>();
    public LiveData<String> erro = erroMutable;

    public void getTodasCartas(Context context){
        disposable.add(
                repository.getAllCartas(context)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread()).subscribe(cartas -> {
                    mutableCarta.setValue(cartas);
                }, throwable ->{
                    erroMutable.setValue(throwable.getMessage());
                } )
        );
    }

    public void insereCarta(Carta carta, Context context){
        new Thread((() -> {
            if(carta != null){
                repository.insereCarta(carta, context);
            }
        })).start();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
