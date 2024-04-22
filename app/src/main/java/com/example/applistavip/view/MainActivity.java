package com.example.applistavip.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;

import com.example.applistavip.R;

import com.example.applistavip.controller.PessoaController;
import com.example.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listaVip";

    PessoaController controller;
    Pessoa pessoa;
    EditText editPrimeiroNome, editSegundoNome, editCurso, editTel;
    Button btnLimpar, btnSalvar, btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        // instanciei o objeto pessoa do model
        pessoa = new Pessoa("joao", "victor", "engenharia", "12112345678");

        // ligação entre o id e a classe java
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSegundoNome = findViewById(R.id.editSegundoNome);
        editCurso = findViewById(R.id.editCurso);
        editTel = findViewById(R.id.editTel);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // Trazendo os dados a tela
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSegundoNome.setText(pessoa.getSegundoNome());
        editCurso.setText(pessoa.getNomeCurso());
        editTel.setText(pessoa.getTel());

        // funcao dos botoes
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editPrimeiroNome.setText("");
                editSegundoNome.setText("");
                editCurso.setText("");
                editTel.setText("");
            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSegundoNome(editSegundoNome.getText().toString());
                pessoa.setNomeCurso(editCurso.getText().toString());
                pessoa.setTel(editTel.getText().toString());

                Toast.makeText(MainActivity.this, pessoa.toString(), Toast.LENGTH_LONG).show();

                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("segundoNome", pessoa.getSegundoNome());
                listaVip.putString("nomeCurso", pessoa.getNomeCurso());
                listaVip.putString("tel", pessoa.getTel());
                listaVip.apply();

                controller.salvar(pessoa);
            }
        });
    }
}