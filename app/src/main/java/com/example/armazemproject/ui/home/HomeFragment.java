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

import com.example.armazemproject.databinding.FragmentHomeBinding;
import com.example.armazemproject.ui.gallery.GalleryFragment;
import com.example.armazemproject.ui.gallery.Produto;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Obtenha a instância do GalleryFragment
        GalleryFragment galleryFragment = (GalleryFragment) getFragmentManager().findFragmentByTag("GalleryFragment");

        // Verifique se o fragmento existe
        if (galleryFragment != null) {
            // Obtenha a lista de produtos
            List<Produto> produtos = galleryFragment.getProdutos();

            ListView listView = new ListView(getContext());
            ArrayAdapter<Produto> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, produtos);
            listView.setAdapter(adapter);

            // Adicione a ListView ao seu layout
            ((ViewGroup) root).addView(listView);
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
