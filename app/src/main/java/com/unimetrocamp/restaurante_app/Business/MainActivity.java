package com.unimetrocamp.restaurante_app.Business;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.unimetrocamp.restaurante_app.Entity.ContaFinal;
import com.unimetrocamp.restaurante_app.Entity.Prato;
import com.unimetrocamp.restaurante_app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cardapio);

        List<Prato> cardapio = PratosCardapio();

        ListView CardapioLista = (ListView) findViewById(R.id.lista);

        //chamada da nossa implementação
        AdapterCardapio adapter = new AdapterCardapio(cardapio, this);
        CardapioLista.setAdapter(adapter);
    }

    private List<Prato> PratosCardapio() {

        return new ArrayList<>(Arrays.asList(
                new Prato("Lanche",  29.00, "lanche"),
                new Prato("Hot Dog",  20.00, "hotdog"),
                new Prato("Milk Shake", 10.00, "milkshake")
        ));
    }

    public void AddItem(View view) {

        ContaFinal conta = new ContaFinal();
        String item = String.valueOf(view.getId());

    }
}
