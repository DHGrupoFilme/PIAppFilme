package com.example.myapplication.repository.data;

import android.arch.persistence.room.TypeConverter;

import com.example.myapplication.model.Carta;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class CartaConverter {
    @TypeConverter
    public List<Carta> fromString(String value) {
        Type listType = (Type) new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromList(List<Carta> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}

