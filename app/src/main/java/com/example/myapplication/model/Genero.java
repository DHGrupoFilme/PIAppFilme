package com.example.myapplication.model;
import com.google.gson.annotations.SerializedName;
public class Genero {

    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
