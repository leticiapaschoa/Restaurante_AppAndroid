package com.unimetrocamp.restaurante_app.Business;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.unimetrocamp.restaurante_app.Entity.ContaFinal;
import com.unimetrocamp.restaurante_app.Entity.Prato;
import com.unimetrocamp.restaurante_app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.unimetrocamp.restaurante_app.R.id.addButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton addButon;
    private TextView tvcarrinho;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cardapio);

        List<Prato> cardapio = PratosCardapio();

        ListView CardapioLista = (ListView) findViewById(R.id.lista);

        //chamada da nossa implementação
        AdapterCardapio adapter = new AdapterCardapio(cardapio, this);
        CardapioLista.setAdapter(adapter);


        ImageButton addButton = new ImageButton(MainActivity.this);
        addButton.setOnClickListener(addButtonClickListener);

        tvcarrinho = (TextView) findViewById(R.id.tvcarrinho);

        //Chamada tela final
        Button Chamada = (Button) findViewById(R.id.goContaFinal);
        Chamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int1= new Intent(MainActivity.this,Conta.class);
                startActivity(int1);
            }
        });


    }

    public void addcarrinho(View view){
        addButon = (ImageButton) findViewById(addButton);

        this.addButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;

                tvcarrinho.setText("Nº de Itens add: "+contador);
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
                new Prato("Esfiha", 8.00, "esfiha"),
                new Prato("Milk Shake", 10.00, "milkshake")
        ));
    }



    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
            Toast.makeText(MainActivity.this, position,Toast.LENGTH_SHORT);
        }

    };


    private View.OnClickListener addButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            View parentRow = (View) v.getParent();
            ListView listView = (ListView) parentRow.getParent();
            final int position = listView.getPositionForView(parentRow);
        }
    };


}