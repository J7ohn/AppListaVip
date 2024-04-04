package com.example.applistavip.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.applistavip.R;

import com.example.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa, pessoa2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa("joao", "victor", "engenharia", 998732041);
        pessoa2 = new Pessoa();

        pessoa2.setPrimeiroNome("duda");
        pessoa2.setSegundoNome("peitudinha");
        pessoa2.setNomeCurso("engenharia");
        pessoa2.setTel(12345612);



    }
}