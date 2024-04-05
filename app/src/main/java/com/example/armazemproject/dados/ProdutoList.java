package com.example.armazemproject.dados;

import java.util.ArrayList;
import java.util.List;

public class ProdutoList {

    private List<Produto> produtoList;

    public ProdutoList(){
        this.produtoList = new ArrayList<>();
    }

    public ProdutoList(List<Produto> produtos){
        this.produtoList = produtos;
    }

    public List<Produto> getProdutos() {
        return produtoList;
    }

    public void addProduto(Produto item) {
        produtoList.add(item);
    }
}
