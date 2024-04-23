package com.example.applistavip.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.applistavip.model.Pessoa;
import com.example.applistavip.view.MainActivity;

public class PessoaController {


    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;


    public static final String NOME_PREFERENCES = "pref_listaVip";

    public PessoaController(MainActivity mainActivity){

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_CONTROLLER", "Controller iniciada...");

        return super.toString();
    }


    public Pessoa salvar (Pessoa pessoa){

        Log.d("MVC_CONTROLLER", "Salvo: "+pessoa.toString());
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("segundoNome", pessoa.getSegundoNome());
        listaVip.putString("nomeCurso", pessoa.getNomeCurso());
        listaVip.putString("tel", pessoa.getTel());
        listaVip.apply();

        return pessoa;
    }

    public void buscar(Pessoa pessoa){
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSegundoNome(preferences.getString("segundoNome", ""));
        pessoa.setNomeCurso(preferences.getString("nomeCurso", ""));
        pessoa.setTel(preferences.getString("tel", ""));
    }

    public void limpar() {

        listaVip.clear();
        listaVip.apply();

    }

}

