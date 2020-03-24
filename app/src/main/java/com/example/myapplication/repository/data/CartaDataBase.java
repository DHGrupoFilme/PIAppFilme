package com.example.myapplication.repository.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.myapplication.model.Carta;

@Database(entities = {Carta.class}, version = 1, exportSchema = false)

@TypeConverters(CartaConverter.class)
public abstract class CartaDataBase extends RoomDatabase {

    public abstract CartaDAO cartaDAO();
    private static volatile CartaDataBase INSTANCE;

    public static CartaDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CartaDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CartaDataBase.class, "carta_bd")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
