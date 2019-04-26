package com.unimetrocamp.restaurante_app.Entity;

public class Prato {
    public String nome;
    public double preco;
    public String imgNome;


    public Prato(String nome, double preco, String imgNome) {
        this.nome = nome;
        this.preco = preco;
        this.imgNome = imgNome;
    }
}
