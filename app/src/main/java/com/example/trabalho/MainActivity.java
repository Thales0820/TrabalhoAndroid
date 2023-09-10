package com.example.trabalho;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button botaoCalcular;
    Button botaoAluno;
    EditText edtPeso, edtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        botaoCalcular = findViewById(R.id.btnCalcular);
        botaoAluno = findViewById(R.id.btnAluno);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });

        botaoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaAluno();
            }
        });
    }

    private void calcular() {
        int valorPeso = Integer.parseInt(edtPeso.getText().toString());
        double valorAltura = Double.parseDouble(edtAltura.getText().toString());

        double imc = valorPeso / (valorAltura * valorAltura);

        if (imc < 18.5){
            mostrarMensagem("Seu IMC indica magreza");
        } else if (imc >= 18.5 && imc <= 24.9) {
            mostrarMensagem("Seu IMC indica que você está normal");
        } else if (imc >= 25 && imc <= 29.9) {
            mostrarMensagem("Seu IMC indica que você está com sobrepeso");
        } else if (imc >= 30 && imc <= 39.9) {
            mostrarMensagem("Seu IMC indica obesidade");
        } else {
            mostrarMensagem("Seu IMC indica obesidade grave");
        }
    }

    private void mostrarMensagem(String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        alerta.setTitle("Resultado");
        
        alerta.setMessage(texto);

        alerta.setNeutralButton("Ok", null);

        alerta.show();
    }
    
    private void abrirTelaAluno() {
        Intent telaAluno = new Intent(MainActivity.this, AlunoActivity.class);

        startActivity(telaAluno);
    }

}