
package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Resposta {

    @SerializedName("a")
    private String mA;
    @SerializedName("b")
    private String mB;
    @SerializedName("c")
    private String mC;
    @SerializedName("d")
    private String mD;
    @SerializedName("Quizes")
    private List<Quizes> perguntas;

    public String getA() {
        return mA;
    }

    public void setA(String a) {
        mA = a;
    }

    public String getB() {
        return mB;
    }

    public void setB(String b) {
        mB = b;
    }

    public String getC() {
        return mC;
    }

    public void setC(String c) {
        mC = c;
    }

    public String getD() {
        return mD;
    }

    public void setD(String d) {
        mD = d;
    }

    public List<Quizes> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Quizes> perguntas) {
        this.perguntas = perguntas;
    }
}
