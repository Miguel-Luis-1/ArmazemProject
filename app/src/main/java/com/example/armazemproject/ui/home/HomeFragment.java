package com.example.armazemproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.armazemproject.dados.ProdutoAdapter;
import com.example.armazemproject.dados.ProdutoDAO;
import com.example.armazemproject.dados.DatabaseHelper;
import com.example.armazemproject.databinding.FragmentHomeBinding;
import com.example.armazemproject.dados.Produto;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        ViewGroup root = binding.getRoot();

        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        ProdutoDAO produtoDAO = new ProdutoDAO(dbHelper.getWritableDatabase());

        List<Produto> produtos = produtoDAO.listarTodos();

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
