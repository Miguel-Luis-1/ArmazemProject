package com.example.armazemproject.dados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.armazemproject.dados.Produto;
import com.example.armazemproject.R;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto> {
    public ProdutoAdapter(Context context, List<Produto> produtos) {
        super(context, 0, produtos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produto produto = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_produto, parent, false);
        }

        TextView nomeProduto = convertView.findViewById(R.id.nomeProduto);
        TextView precoUnitario = convertView.findViewById(R.id.precoUnitario);
        TextView quantidadeUnidades = convertView.findViewById(R.id.quantidadeUnidades);

        nomeProduto.setText("Nome: " + produto.getNome());
        precoUnitario.setText("Preço: " + String.valueOf(produto.getPrecoUnitario()));
        quantidadeUnidades.setText("Quantidade: " + String.valueOf(produto.getQuantidadeUnidades()));


        return convertView;
    }
}

