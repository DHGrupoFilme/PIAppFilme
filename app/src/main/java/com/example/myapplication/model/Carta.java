package com.example.myapplication.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "cartas")
public class Carta {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idCarta")
    private int id;

    @ColumnInfo(name = "popularidade")
    private String popularidade;

    @ColumnInfo(name = "critica")
    private String critica;

    @ColumnInfo(name = "orcamento")
    private String orcamento;

    @ColumnInfo(name = "bilheteria")
    private String bilheteria;

    @ColumnInfo(name = "nomeFilme")
    private String nomeFilme;

    @ColumnInfo(name = "ano")
    private String ano;

    @ColumnInfo(name = "imagem")
    private int imagem;

    public Carta(){ }

    public Carta(String nomeFilme, String ano, String popularidade, String critica, String orcamento, String bilheteria, int imagem) {
        this.nomeFilme = nomeFilme;
        this.ano = ano;
        this.popularidade = popularidade;
        this.critica = critica;
        this.orcamento = orcamento;
        this.bilheteria = bilheteria;
        this.imagem = imagem;
    }

    public String getPopularidade() {
        return popularidade;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setPopularidade(String popularidade) {
        this.popularidade = popularidade;
    }

    public String getCritica() {
        return critica;
    }

    public void setCritica(String critica) {
        this.critica = critica;
    }

    public String getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(String orcamento) {
        this.orcamento = orcamento;
    }

    public String getBilheteria() {
        return bilheteria;
    }

    public void setBilheteria(String bilheteria) {
        this.bilheteria = bilheteria;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
