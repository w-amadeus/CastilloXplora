package com.example.castilloassignment.view_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.castilloassignment.DashActivity;
import com.example.castilloassignment.InputsValidation;
import com.example.castilloassignment.R;
import com.example.castilloassignment.SessionManager;
import com.example.castilloassignment.db.ConstructorUsuarios;
import com.example.castilloassignment.db.Database;
import com.example.castilloassignment.pojo.Usuario;

import java.util.ArrayList;

public class LoginTabFragment extends Fragment {

    EditText edtEmail, edtPass;
    Button button;
    float v;
    String email, password, name, foto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        edtEmail    = root.findViewById(R.id.edtEmail);
        edtPass     = root.findViewById(R.id.edtPass);
        button      = root.findViewById(R.id.button);

        edtEmail.setTranslationX(800);
        edtPass.setTranslationX(800);
        button.setTranslationX(800);

        edtEmail.setAlpha(v);
        edtPass.setAlpha(v);
        button.setAlpha(v);

        edtEmail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        edtPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        button.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email       = edtEmail.getText().toString().trim();
                password    = edtPass.getText().toString().trim();

                verifyFromSQLite();
                userData();



            }
        });

        return root;


    }

    public void verifyFromSQLite() {

                Database database = new Database(getContext());
                InputsValidation inputsValidation = new InputsValidation(getContext());

                if (!inputsValidation.isEditTextFilled(email)) {
                    return;
                }
                if (!inputsValidation.isEditTextFilled(password)) {
                     return;
                }
                if (!inputsValidation.isEditTextEmail(email)) {
                    return;
                }
                if (database.checkUser(email,password)) {

                    Intent dashIntent = new Intent(getContext(), DashActivity.class);
                    emptyInputEditText();
                    startActivity(dashIntent);
                } else {

                    Toast.makeText(getContext(), R.string.error_message_user,
                            Toast.LENGTH_LONG).show();

                }
    }

    private void emptyInputEditText() {
        edtEmail.setText(null);
        edtPass.setText(null);
    }

    private  void userData(){

        ConstructorUsuarios constructorUsuarios = new ConstructorUsuarios(getContext());
        ArrayList<Usuario> usuarios = constructorUsuarios.obtenerDatos();

        for(Usuario usuario:usuarios){

            if(email.equals(usuario.getEmail())){

                name = usuario.getName();
                foto = String.valueOf(usuario.getFoto());

            }


        }

        SessionManager sessionManager = new SessionManager(getContext());
        sessionManager.createLoginSession(name, email, foto);
    }



}
