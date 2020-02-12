package com.example.myapplication;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    private TextInputLayout inputSenha;
    private TextInputLayout inputEmail;
    private TextInputLayout inputConfirmarSenha;
    private Button botaoPronto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        initViews();

        botaoPronto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmação();
            }
        });

    }

    private void initViews() {
        inputEmail = findViewById(R.id.inputEmail);
        inputSenha = findViewById(R.id.inputSenha);
        inputConfirmarSenha = findViewById(R.id.inputConfirmarSenha);
        botaoPronto = findViewById(R.id.botaoPronto);
    }

    private void confirmação() {
        String senha = inputSenha.getEditText().getText().toString();
        String confirmarSenha = inputConfirmarSenha.getEditText().getText().toString();
        String email = inputEmail.getEditText().getText().toString();
        if (!senha.isEmpty() && !confirmarSenha.isEmpty() && !email.isEmpty()) {
            if (senha.equals(confirmarSenha)) {
                Toast.makeText(getApplicationContext(), "Cadastrado com sucesso", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Senhas incompatives", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Preencha os campos", Toast.LENGTH_LONG).show();
        }

    }
}
