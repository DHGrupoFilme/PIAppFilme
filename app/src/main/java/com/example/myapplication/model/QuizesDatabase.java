package com.example.myapplication.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import androidx.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import com.example.myapplication.model.Quizes;


@Database(entities = {Quizes.class}, version = 2, exportSchema = false)

@TypeConverters(QuizesConverter.class)
public abstract class QuizesDatabase {

    public abstract Dao DAO();
    private static volatile QuizesDatabase INSTANCE;

    public static QuizesDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuizesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuizesDatabase.class, "quizes_bd")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
}


