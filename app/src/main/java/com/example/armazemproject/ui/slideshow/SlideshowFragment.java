package com.example.armazemproject.ui.slideshow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.armazemproject.R;
import com.example.armazemproject.dados.DatabaseHelper;
import com.example.armazemproject.dados.ProdutoDAO;
import com.example.armazemproject.dados.Senha;
import com.example.armazemproject.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private Senha senha;
    private ProdutoDAO produtoDAO;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        senha = new Senha();
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        produtoDAO = new ProdutoDAO(dbHelper.getWritableDatabase());

        Button criarSenhaButton = root.findViewById(R.id.criarSenha);
        String senhaRegistrada = senha.getSenha(getActivity());
        if (senhaRegistrada != null && !senhaRegistrada.isEmpty()) {
            criarSenhaButton.setText("Trocar a senha");
        }
        criarSenhaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senhaRegistrada = senha.getSenha(getActivity());
                if (senhaRegistrada != null && !senhaRegistrada.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Digite a senha");

                    final EditText input = new EditText(getActivity());
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    builder.setView(input);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String senhaInserida = input.getText().toString();
                            if (senhaInserida.equals(senhaRegistrada)) {
                                Navigation.findNavController(v).navigate(R.id.action_slideshowFragment_to_senhaFragment);
                            } else {
                                Toast.makeText(getActivity(), "Senha incorreta", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.show();
                } else {
                    Navigation.findNavController(v).navigate(R.id.action_slideshowFragment_to_senhaFragment);
                }
            }
        });

        Button limparListaButton = root.findViewById(R.id.button);
        limparListaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senhaRegistrada = senha.getSenha(getActivity());
                if (senhaRegistrada == null) {
                    Toast.makeText(getActivity(), "Por favor, registre uma senha", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Digite a senha");

                    final EditText input = new EditText(getActivity());
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    builder.setView(input);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String senhaInserida = input.getText().toString();
                            if (senhaInserida.equals(senhaRegistrada)) {
                                produtoDAO.limparTodos(); // Limpa a lista de produtos
                                Toast.makeText(getActivity(), "Lista limpa com sucesso", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getActivity(), "Senha incorreta", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.show();
                }
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
