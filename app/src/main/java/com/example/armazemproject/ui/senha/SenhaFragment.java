package com.example.armazemproject.ui.senha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.armazemproject.R;

public class SenhaFragment extends Fragment {

    private EditText editTextPassword1;
    private EditText editTextPassword2;
    private Button buttonConfirm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_senha, container, false);

        editTextPassword1 = view.findViewById(R.id.editTextPassword1);
        editTextPassword2 = view.findViewById(R.id.editTextPassword2);
        buttonConfirm = view.findViewById(R.id.buttonConfirm);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1 = editTextPassword1.getText().toString();
                String password2 = editTextPassword2.getText().toString();

                if (!password1.equals(password2)) {
                    Toast.makeText(getActivity(), "As senhas não correspondem", Toast.LENGTH_SHORT).show();
                } else {
                    // TODO: Implementar a lógica para lidar com a confirmação da senha
                }
            }
        });

        return view;
    }
}
