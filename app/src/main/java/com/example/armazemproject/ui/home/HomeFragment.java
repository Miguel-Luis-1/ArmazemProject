package com.example.armazemproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.armazemproject.dados.ProdutoAdapter;
import com.example.armazemproject.dados.ProdutoList;
import com.example.armazemproject.databinding.FragmentHomeBinding;
import com.example.armazemproject.dados.Produto;
import com.example.armazemproject.dados.ProdutoSharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ProdutoList produtoList = new ProdutoList();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        ViewGroup root = binding.getRoot();

        ProdutoSharedPreferences produtoSharedPreferences = new ProdutoSharedPreferences(getContext());
        List<Produto> produtos = produtoSharedPreferences.loadProducts();
        if (produtos == null) {
            produtos = new ArrayList<>();
        }

        ListView listView = new ListView(getContext());
        ProdutoAdapter adapter = new ProdutoAdapter(getContext(), produtos);
        listView.setAdapter(adapter);

        // Adicione a ListView ao seu layout
        root.addView(listView);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


