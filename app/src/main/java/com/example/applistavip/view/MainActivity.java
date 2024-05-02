package com.example.applistavip.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;

import com.example.applistavip.R;

import com.example.applistavip.controller.CursoController;
import com.example.applistavip.controller.PessoaController;

import com.example.applistavip.model.Pessoa;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    CursoController cursoController;
    PessoaController controller;
    List<String> nomesDosCursos;
    Pessoa pessoa;
    EditText editPrimeiroNome, editSegundoNome, editCurso, editTel;
    Button btnLimpar, btnSalvar, btnFinalizar;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosParaSpinner();

        // instanciei o objeto pessoa do model
        pessoa = new Pessoa();
        controller.buscar(pessoa);

        // ligação entre o id e a classe java
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSegundoNome = findViewById(R.id.editSegundoNome);
        editCurso = findViewById(R.id.editCurso);
        editTel = findViewById(R.id.editTel);
        spinner = findViewById(R.id.spinner);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosParaSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

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

                controller.limpar();

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


                controller.salvar(pessoa);
            }
        });
    }
}