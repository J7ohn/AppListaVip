package com.example.applistavip.controller;

import com.example.applistavip.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private List<Curso> cursos;

    public List getCursos() {

        cursos = new ArrayList<Curso>();

        cursos.add(new Curso("Java"));
        cursos.add(new Curso("Python"));
        cursos.add(new Curso("C#"));
        cursos.add(new Curso("HTML"));

        return cursos;
    }

    public ArrayList<String> dadosParaSpinner() {

        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getCursos().size(); i++) {
            Curso objeto = (Curso) getCursos().get(i);
            dados.add(objeto.getCursoDesejado());
        }
        return dados;
    }
}


