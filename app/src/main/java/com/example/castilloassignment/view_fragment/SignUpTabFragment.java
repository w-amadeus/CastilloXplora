package com.example.castilloassignment.view_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.castilloassignment.InputsValidation;
import com.example.castilloassignment.R;
import com.example.castilloassignment.db.ConstructorUsuarios;
import com.example.castilloassignment.db.Database;
import com.example.castilloassignment.pojo.Usuario;

public class SignUpTabFragment extends Fragment {

    EditText edtCorreo, edtName, edtPassword;
    Button btnSignup;
    String name, email, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        edtCorreo = root.findViewById(R.id.edtCorreo);
        edtName = root.findViewById(R.id.edtName);
        edtPassword = root.findViewById(R.id.edtPassword);
        btnSignup = root.findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtName.getText().toString().trim();
                email = edtCorreo.getText().toString().trim();
                password = edtPassword.getText().toString().trim();
                postDataToSQLite();

            }
        });

        return root;
    }

    private void postDataToSQLite() {

        Database database = new Database(getContext());
        ConstructorUsuarios constructorUsuarios = new ConstructorUsuarios(getContext());
        InputsValidation inputsValidation = new InputsValidation(getContext());
        Usuario usuario = new Usuario();

        if (!inputsValidation.isEditTextFilled(name)) {
            return;
        }
        if (!inputsValidation.isEditTextFilled(email)) {
            return;
        }
        if (!inputsValidation.isEditTextEmail(email)) {
            return;
        }
        if (!inputsValidation.isEditTextFilled(password)) {
            return;
        }

        if (!database.checkUser(email)) {
            usuario.setName(name);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setFoto(R.drawable.amadeus);
            constructorUsuarios.registrarUsuarios(usuario, database);
            emptyInputEditText();
            Toast.makeText(getContext(), R.string.success_user_reg,
                    Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(getContext(), R.string.error_user_reg,
                    Toast.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText() {
        edtName.setText(null);
        edtCorreo.setText(null);
        edtPassword.setText(null);
    }
}
