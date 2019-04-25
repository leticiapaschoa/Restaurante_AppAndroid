package com.unimetrocamp.restaurante_app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterCardapio extends BaseAdapter {

    private final List<Prato> cardapio;
    private final Activity act;

    public AdapterCardapio(List<Prato> cardapio, Activity act) {
        this.cardapio = cardapio;
        this.act = act;
    }

    @Override
    public int getCount() {
        return cardapio.size();
    }

    @Override
    public Object getItem(int position) {
        return cardapio.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.activity_main, parent, false);
        Prato prato = cardapio.get(position);

        TextView nome = (TextView)
                view.findViewById(R.id.lista_cardapio_nome_prato);
        TextView preco = (TextView)
                view.findViewById((R.id.lista_cardapio_preco_prato));
        ImageView imagem = (ImageView)
                view.findViewById(R.id.lista_cardapio_imagem_prato);

        Resources resources = parent.getResources();
        final int img = resources.getIdentifier(prato.imgNome, "drawable", this.act.getPackageName());

        nome.setText(prato.nome);
        imagem.setImageResource(img);
        preco.setText(Double.toString(prato.preco));

        return view;
    }
}
