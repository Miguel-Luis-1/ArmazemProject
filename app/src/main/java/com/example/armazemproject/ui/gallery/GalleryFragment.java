package com.example.armazemproject.ui.gallery;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.armazemproject.R;
import com.example.armazemproject.databinding.FragmentGalleryBinding;
import com.example.armazemproject.dados.Produto;
import com.example.armazemproject.dados.ProdutoSharedPreferences;
import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private FragmentGalleryBinding binding;
    private List<Produto> produtos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        produtos = new ArrayList<>();

        Button buttonSubmit = root.findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProdutoSharedPreferences produtoSharedPreferences = new ProdutoSharedPreferences(getContext());
                EditText editTextCodigo = root.findViewById(R.id.editTextCodigo);
                EditText editTextNome = root.findViewById(R.id.editTextNome);
                EditText editTextDescricao = root.findViewById(R.id.editTextDescricao);
                EditText editTextPrecoUnitario = root.findViewById(R.id.editTextPrecoUnitario);
                EditText editTextCategoria = root.findViewById(R.id.editTextCategoria);
                EditText editTextqtdUnidades = root.findViewById(R.id.editTextqtdUnidades);

                String codigo = editTextCodigo.getText().toString();
                String nome = editTextNome.getText().toString();
                String descricao = editTextDescricao.getText().toString();
                String precoUnitarioStr = editTextPrecoUnitario.getText().toString();
                String categoria = editTextCategoria.getText().toString();
                String qtdUnidadesStr = editTextqtdUnidades.getText().toString();

                // Verificar se todos os campos estão preenchidos
                if (codigo.isEmpty()) {
                    editTextCodigo.setHintTextColor(Color.RED);
                    return;
                }
                if (nome.isEmpty()) {
                    editTextNome.setHintTextColor(Color.RED);
                    return;
                }
                if (descricao.isEmpty()) {
                    editTextDescricao.setHintTextColor(Color.RED);
                    return;
                }
                if (precoUnitarioStr.isEmpty()) {
                    editTextPrecoUnitario.setHintTextColor(Color.RED);
                    return;
                }
                if (categoria.isEmpty()) {
                    editTextCategoria.setHintTextColor(Color.RED);
                    return;
                }
                if (qtdUnidadesStr.isEmpty()) {
                    editTextqtdUnidades.setHintTextColor(Color.RED);
                    return;
                }

                double precoUnitario = Double.parseDouble(precoUnitarioStr);
                double qtdUnidades = Double.parseDouble(qtdUnidadesStr);

                Produto produto = new Produto(codigo, nome, descricao, precoUnitario, categoria, qtdUnidades);
                produtos.add(produto);
                produtoSharedPreferences.saveProducts(produtos);
                // Imprimir a lista de produtos no terminal
                for (Produto p : produtos) {
                    Log.d("Produto", p.toString());
                }
                Log.d("Lista de produtos", produtos.toString());

                // Limpar campos após a inserção
                editTextCodigo.setText("");
                editTextNome.setText("");
                editTextDescricao.setText("");
                editTextPrecoUnitario.setText("");
                editTextCategoria.setText("");
                editTextqtdUnidades.setText("");

            }

        });

        return root;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
