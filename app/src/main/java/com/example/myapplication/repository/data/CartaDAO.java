package com.example.myapplication.repository.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.myapplication.model.Carta;
import java.util.List;
import io.reactivex.Flowable;

@Dao
public interface CartaDAO {

    @Insert
    void inserirCartaBD(Carta carta);

    @Delete
    void deletarCartaBD(Carta carta);

    @Query("SELECT * FROM cartas")
    Flowable<List<Carta>> todasAsCartasDB();
}
