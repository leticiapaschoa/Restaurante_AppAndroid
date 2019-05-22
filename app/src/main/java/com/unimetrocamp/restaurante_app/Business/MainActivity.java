package com.unimetrocamp.restaurante_app.Business;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.unimetrocamp.restaurante_app.Entity.Prato;
import com.unimetrocamp.restaurante_app.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable {

    double valor = 0;
    private int contador;
    private TextView tvcarrinho;
    List<Prato> cardapio = PratosCardapio();
    AdapterCardapio adapter = new AdapterCardapio(cardapio, this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cardapio);

        ListView CardapioLista = (ListView) findViewById(R.id.lista);

        //chamada da nossa implementação
        CardapioLista.setAdapter(adapter);

        //Chamada tela final
        Button Chamada = (Button) findViewById(R.id.goContaFinal);
        Chamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int1= new Intent(MainActivity.this,Conta.class);
                int1.putExtra ("ValorFinal", valor+"");
                startActivity(int1);
            }
        });
    }

    private List<Prato> PratosCardapio() {

        return new ArrayList<>(Arrays.asList(
                new Prato("Lanche",  29.00, "lanche"),
                new Prato("Hot Dog",  20.00, "hotdog"),
                new Prato("Batata Frita", 15.00, "batata"),
                new Prato("Pizza", 25.00, "pizza"),
                new Prato("Pastel", 5.00, "pastel"),
                new Prato("Esfiha", 8.00, "esfiha")
        ));
    }


    public void addcarrinho(View view) {
        tvcarrinho = (TextView) findViewById(R.id.tvcarrinho);
        contador++;
        tvcarrinho.setText("Nº Itens: " + contador);


        View parentRow = (View) view.getParent();
        ListView listView = (ListView) parentRow.getParent();
        final int position = listView.getPositionForView(parentRow);

        Prato p = adapter.getItem(position);
        valor += p.preco;

    }

}