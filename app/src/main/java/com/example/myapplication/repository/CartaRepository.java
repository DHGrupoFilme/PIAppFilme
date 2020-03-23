package com.example.myapplication.repository;

import android.content.Context;

import com.example.myapplication.model.Carta;
import com.example.myapplication.repository.data.CartaDataBase;

import java.util.List;

import io.reactivex.Flowable;

public class CartaRepository {

    public Flowable<List<Carta>> getAllCartas(Context context){
        return CartaDataBase.getDatabase(context).cartaDAO().todasAsCartasDB();
    }

    public void deletaCarta(Carta carta, Context context){
        CartaDataBase.getDatabase(context).cartaDAO().deletarCartaBD(carta);
    }

    public void insereCarta(Carta carta, Context context){
        CartaDataBase.getDatabase(context).cartaDAO().inserirCartaBD(carta);
    }
}
