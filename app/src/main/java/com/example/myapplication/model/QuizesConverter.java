package com.example.myapplication.model;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class QuizesConverter {


    @TypeConverter
    public List<Quizes> fromString(String value) {
        Type listType = (Type) new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }


    @TypeConverter
    public String fromList(List<Quizes> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


}
