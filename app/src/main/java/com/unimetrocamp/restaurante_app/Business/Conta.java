package com.unimetrocamp.restaurante_app.Business;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.unimetrocamp.restaurante_app.Entity.ContaFinal;
import com.unimetrocamp.restaurante_app.R;

public class Conta extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conta_final);

        //Elementos tela:
        TextView textoDefault = (TextView) findViewById(R.id.mensagem_dafault);

        //Instâncias
        ContaFinal contaFinal = new ContaFinal();

        String mensagemDefault = contaFinal.itensCardapio.isEmpty() ? "Você não adicionou nenhum item." : "Obrigado pela preferência!";
        textoDefault.setText(mensagemDefault);


    }
}
