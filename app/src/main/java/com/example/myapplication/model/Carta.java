package com.example.myapplication.model;

public class Carta {
    private String popularidade;
    private String critica;
    private String orcamento;
    private String bilheteria;
    private String nomeFilme;
    private String ano;
    private int imagem;

    public Carta(){

    }

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
}
