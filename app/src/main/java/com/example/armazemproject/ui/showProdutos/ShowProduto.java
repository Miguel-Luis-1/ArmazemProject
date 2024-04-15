package com.example.armazemproject.ui.showProdutos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.armazemproject.R;
import com.example.armazemproject.dados.Produto;
import com.example.armazemproject.dados.ProdutoSharedPreferences;

import java.util.List;

public class ShowProduto extends Fragment {

    private List<Produto> produtos;
    private Produto produto;
    private ProdutoSharedPreferences produtoSharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        produtoSharedPreferences = new ProdutoSharedPreferences(getContext());
        produtos = produtoSharedPreferences.loadProducts();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_produto, container, false);

        EditText searchInput = view.findViewById(R.id.searchInput);
        Button searchButton = view.findViewById(R.id.searchButton);
        Button deleteButton = view.findViewById(R.id.deleteButton);

        TextView nomeProdutoTextView = view.findViewById(R.id.nomeProduto);
        TextView codigoProdutoTextView = view.findViewById(R.id.codigoProduto);
        TextView descricaoProdutoTextView = view.findViewById(R.id.descricaoProduto);
        TextView precoUnitarioTextView = view.findViewById(R.id.precoUnitario);
        TextView categoriaProdutoTextView = view.findViewById(R.id.categoriaProduto);
        TextView quantidadeUnidadesTextView = view.findViewById(R.id.quantidadeUnidades);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchQuery = searchInput.getText().toString();
                for (Produto p : produtos) {
                    if (p.getNome().equalsIgnoreCase(searchQuery)) {
                        produto = p;
                        break;
                    }
                }

                if (produto != null) {
                    // Exibir os detalhes do produto nos TextViews
                    nomeProdutoTextView.setText("Nome: " + produto.getNome());
                    codigoProdutoTextView.setText("Código: " + produto.getCodigo());
                    descricaoProdutoTextView.setText("Descrição: " + produto.getDescricao());
                    precoUnitarioTextView.setText("Preço: " + produto.getPrecoUnitario());
                    categoriaProdutoTextView.setText("Categoria: " + produto.getCategoria());
                    quantidadeUnidadesTextView.setText("Quantidade: " + produto.getQuantidadeUnidades());
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (produto != null) {
                    produtos.remove(produto);
                    produtoSharedPreferences.saveProducts(produtos);

                    // Limpar os campos de texto
                    nomeProdutoTextView.setText("Nome: ");
                    codigoProdutoTextView.setText("Código: ");
                    descricaoProdutoTextView.setText("Descrição: ");
                    precoUnitarioTextView.setText("Preço: ");
                    categoriaProdutoTextView.setText("Categoria: ");
                    quantidadeUnidadesTextView.setText("Quantidade: ");

                    produto = null;
                }
            }
        });

        return view;
    }
}

