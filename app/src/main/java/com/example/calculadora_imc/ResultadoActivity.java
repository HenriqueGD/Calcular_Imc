package com.example.calculadora_imc;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ImageView;



public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = getIntent();
        float altura = intent.getFloatExtra("altura", 0);
        float peso = intent.getFloatExtra("peso", 0);

        float imc = peso / (altura * peso);

        TextView textViewResultado = findViewById(R.id.textViewResultado);
        ImageView imageViewResultado = findViewById(R.id.imageViewResultado);

        int imageResource;
        String mensagem;

        if (imc < 18.5){
            mensagem = "Abaixo do peso.";
            imageResource=R.drawable.abaixopeso;
        }
        else if(imc > 18.6 && imc <= 24.9){
            mensagem = "Peso ideal (Parabéns!).";
            imageResource=R.drawable.normal;
        }
        else if(imc > 25.0 && imc <= 29.9){
            mensagem = "Levemente acima do peso.";
            imageResource=R.drawable.sobrepeso;
        }
        else if(imc > 30.0 && imc <= 34.9){
            mensagem = "Obesidade Grau I.";
            imageResource=R.drawable.obesidade1;
        }
        else if (imc > 35.0 && imc <= 39.9){
            mensagem = "Obesidade Grau II(Severa).";
            imageResource=R.drawable.obesidade2;
        }
        else
            mensagem = "Obesidade Grau III (Mórbida).";
            imageResource = R.drawable.obesidade3;

        textViewResultado.setText("Seu IMC é: " + String.format("%.2f", imc));

        imageViewResultado.setImageResource(imageResource);

    }
}