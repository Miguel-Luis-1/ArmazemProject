package com.example.armazemproject.ui.gallery;

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
import com.example.armazemproject.ui.gallery.Produto;

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
                String codigo = ((EditText) root.findViewById(R.id.editTextCodigo)).getText().toString();
                String nome = ((EditText) root.findViewById(R.id.editTextNome)).getText().toString();
                String descricao = ((EditText) root.findViewById(R.id.editTextDescricao)).getText().toString();
                double precoUnitario = Double.parseDouble(((EditText) root.findViewById(R.id.editTextPrecoUnitario)).getText().toString());
                String categoria = ((EditText) root.findViewById(R.id.editTextCategoria)).getText().toString();

                Produto produto = new Produto(codigo, nome, descricao, precoUnitario, categoria);
                produtos.add(produto);

                // Limpar campos após a inserção
                ((EditText) root.findViewById(R.id.editTextCodigo)).setText("");
                ((EditText) root.findViewById(R.id.editTextNome)).setText("");
                ((EditText) root.findViewById(R.id.editTextDescricao)).setText("");
                ((EditText) root.findViewById(R.id.editTextPrecoUnitario)).setText("");
                ((EditText) root.findViewById(R.id.editTextCategoria)).setText("");
                
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
