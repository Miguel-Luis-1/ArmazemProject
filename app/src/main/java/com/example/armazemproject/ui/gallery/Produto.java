package com.example.armazemproject.ui.gallery;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String codigo;
    private String nome;
    private String descricao;
    private double precoUnitario;
    private String categoria;

    // Construtor
    public Produto(String codigo, String nome, String descricao, double precoUnitario, String categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.categoria = categoria;
    }

    // Getters e Setters
    // ...
}

