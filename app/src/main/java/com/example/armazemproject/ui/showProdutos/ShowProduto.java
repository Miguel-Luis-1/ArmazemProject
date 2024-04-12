package com.example.armazemproject.ui.showProdutos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.armazemproject.R;
import com.example.armazemproject.dados.Produto;

public class ShowProduto extends Fragment {

    private static final String ARG_PRODUTO = "produto";

    private Produto produto;

    public ShowProduto() {
        // Required empty public constructor
    }

    public static ShowProduto newInstance(Produto produto) {
        ShowProduto fragment = new ShowProduto();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PRODUTO, produto);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            produto = (Produto) getArguments().getSerializable(ARG_PRODUTO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_produto, container, false);

        if (produto != null) {
            // Exibir os detalhes do produto nos TextViews
            TextView nomeProdutoTextView = view.findViewById(R.id.nomeProduto);
            TextView precoUnitarioTextView = view.findViewById(R.id.precoUnitario);
            TextView quantidadeUnidadesTextView = view.findViewById(R.id.quantidadeUnidades);

            nomeProdutoTextView.setText("Nome: " + produto.getNome());
            precoUnitarioTextView.setText("Preço: " + produto.getPrecoUnitario());
            quantidadeUnidadesTextView.setText("Quantidade: " + produto.getQuantidadeUnidades());
        }

        return view;
    }
}
