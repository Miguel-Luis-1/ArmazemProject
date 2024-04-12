package com.example.armazemproject.dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Produto implements Serializable {
    private String codigo;
    private String nome;
    private String descricao;
    private double precoUnitario;
    private String categoria;

    private double qtdUnidades;

    // Construtor
    public Produto(String codigo, String nome, String descricao, double precoUnitario, String categoria, double qtdUnidades) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.categoria = categoria;
        this.qtdUnidades = qtdUnidades;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", precoUnitario=" + precoUnitario +
                ", categoria='" + categoria + '\'' +
                ", qtdUnidades='" + qtdUnidades + '\'' +
                '}';
    }


    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getQuantidadeUnidades() {
        return qtdUnidades;
    }

}

