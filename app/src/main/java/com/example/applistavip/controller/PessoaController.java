package com.example.applistavip.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.applistavip.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_CONTROLLER", "Controller iniciada...");

        return super.toString();
    }


    public void salvar (Pessoa pessoa){

        Log.d("MVC_CONTROLLER", "Salvo: "+pessoa.toString());
    }

}

