package com.example.castilloassignment.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.castilloassignment.R;
import com.example.castilloassignment.pojo.Usuario;

import java.util.ArrayList;

public class ConstructorUsuarios {

    private Context context;

    public ConstructorUsuarios(Context context) {
        this.context = context;
    }

    public ArrayList<Usuario> obtenerDatos(){

        Database dataBase = new Database(context);
        insertarUsuarios(dataBase);
        return dataBase.obtenerUsuarios();

    }

    public void insertarUsuarios(Database database){
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBConstants.TABLE_USUARIO_NAME, "Jandy Castillo");
        contentValues.put(DBConstants.TABLE_USUARIO_EMAIL, "jandy@gmail.com");
        contentValues.put(DBConstants.TABLE_USUARIO_PASSWORD, "Tecsup00$$");
        contentValues.put(DBConstants.TABLE_USUARIO_PHOTO, R.drawable.amadeus);
        database.insertarUsuario(contentValues);

    }

    public void registrarUsuarios(Usuario usuario, Database database) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.TABLE_USUARIO_NAME, usuario.getName());
        contentValues.put(DBConstants.TABLE_USUARIO_EMAIL, usuario.getEmail());
        contentValues.put(DBConstants.TABLE_USUARIO_PASSWORD, usuario.getPassword());
        contentValues.put(DBConstants.TABLE_USUARIO_PHOTO, R.drawable.salieri);
        database.insertarUsuario(contentValues);
    }
}
