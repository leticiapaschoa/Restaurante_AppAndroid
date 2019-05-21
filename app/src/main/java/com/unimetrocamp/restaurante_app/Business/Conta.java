package com.unimetrocamp.restaurante_app.Business;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import com.unimetrocamp.restaurante_app.R;
public class Conta extends AppCompatActivity {

    private Button button;
    String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conta_final);

        TextView valor_final = (TextView) findViewById(R.id.valor_final);

        Intent i = getIntent();

        valor = savedInstanceState == null ? i.getStringExtra("ValorFinal") : savedInstanceState.getString("Valor");

        valor_final.setText("R$ " + valor);

        button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.concluido);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Valor", valor);
    }
}