package com.example.applistavip.model;

public class Pessoa {

    // atributos
    private String primeiroNome;
    private String segundoNome;
    private String nomeCurso;
    private int tel;

    // construtores
    public Pessoa (String primeiroNome, String segundoNome, String nomeCurso, int tel) {

        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.nomeCurso = nomeCurso;
        this.tel = tel;
    }
    public Pessoa(){}

    // getters e setters

    public String getPrimeiroNome(){
        return primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome){
        this.primeiroNome = primeiroNome;
    }

    public String getSegundoNome() {
        return segundoNome;
    }
    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", segundoNome='" + segundoNome + '\'' +
                ", nomeCurso='" + nomeCurso + '\'' +
                ", tel=" + tel +
                '}';
    }
}
