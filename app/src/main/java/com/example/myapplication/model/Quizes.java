package com.example.myapplication.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.List;

@Entity (tableName = "Quizes")
public class Quizes {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pergunta")
    @Expose
    private String pergunta;

    @ColumnInfo(name = "correta")
    @Expose
    private String correta;

    @ColumnInfo(name = "respostas")
    @Expose
    private List<Resposta> respostas;

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getCorreta() {
        return correta;
    }

    public void setCorreta(String correta) {
        this.correta = correta;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
}
