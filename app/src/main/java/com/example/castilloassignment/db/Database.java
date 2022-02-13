package com.example.castilloassignment.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.castilloassignment.pojo.PDV;
import com.example.castilloassignment.pojo.Producto;
import com.example.castilloassignment.pojo.Usuario;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private Context context;

    public Database(@Nullable Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryTablaUsuario = "CREATE TABLE " + DBConstants.TABLE_USUARIO +"( " +
                DBConstants.TABLE_USUARIO_ID    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DBConstants.TABLE_USUARIO_NAME  + " TEXT, " +
                DBConstants.TABLE_USUARIO_EMAIL + " TEXT, " +
                DBConstants.TABLE_USUARIO_PASSWORD + " TEXT, " +
                DBConstants.TABLE_USUARIO_PHOTO + " INTEGER" +
                ")";

        String queryTablaPDV = "CREATE TABLE " + DBConstants.TABLE_PDV +"( " +
                DBConstants.TABLE_PDV_ID    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DBConstants.TABLE_PDV_NAME  + " TEXT, " +
                DBConstants.TABLE_PDV_CODE + " TEXT, " +
                DBConstants.TABLE_PDV_LOCATION + " TEXT, " +
                DBConstants.TABLE_PDV_LONGITUD + " REAL, " +
                DBConstants.TABLE_PDV_LATITUD + " REAL," +
                DBConstants.TABLE_PDV_LOGO + " INTEGER" +
                ")";

        String queryTablaProducto = "CREATE TABLE "                                 + DBConstants.TABLE_PRODUCT + "(" +
                DBConstants.TABLE_PRODUCT_ID              + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DBConstants.TABLE_PRODUCT_ID_PDV      + " INTEGER, " +
                DBConstants.TABLE_PRODUCT_NAME     + " TEXT, " +
                DBConstants.TABLE_PRODUCT_COST     + " REAL, " +
                DBConstants.TABLE_PRODUCT_RM     + " REAL, " +
                DBConstants.TABLE_PRODUCT_STOCK   + " INTEGER, " +
                "FOREIGN KEY ("                                 + DBConstants.TABLE_PRODUCT_ID_PDV + ") " +
                "REFERENCES "                                   + DBConstants.TABLE_PDV + "("+ DBConstants.TABLE_PDV_ID +")" +

                ")";

        sqLiteDatabase.execSQL(queryTablaUsuario);
        sqLiteDatabase.execSQL(queryTablaPDV);
        sqLiteDatabase.execSQL(queryTablaProducto);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBConstants.TABLE_USUARIO);

        onCreate(sqLiteDatabase);

    }

    public void insertarUsuario(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DBConstants.TABLE_USUARIO, null, contentValues);
        sqLiteDatabase.close();
    }

    public void insertarPDV(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DBConstants.TABLE_PDV, null, contentValues);
        sqLiteDatabase.close();
    }

    public void insertarProducto(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DBConstants.TABLE_PRODUCT, null, contentValues);
        sqLiteDatabase.close();
    }


    public boolean checkUser(String email) {

        String[] columns = {
                DBConstants.TABLE_USUARIO_ID
        };
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String selection = DBConstants.TABLE_USUARIO_EMAIL + " = ?";

        String[] selectionArgs = {email};

        Cursor cursor = sqLiteDatabase.query(DBConstants.TABLE_USUARIO,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password) {

        String[] columns = {
                DBConstants.TABLE_USUARIO_ID
        };
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String selection = DBConstants.TABLE_USUARIO_EMAIL + " = ?" + " AND " + DBConstants.TABLE_USUARIO_PASSWORD + " = ?";

        String[] selectionArgs = {email, password};


        Cursor cursor = sqLiteDatabase.query(DBConstants.TABLE_USUARIO,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    public ArrayList<Usuario> obtenerUsuarios(){

        ArrayList<Usuario> usuarios = new ArrayList<>();

        String query = "SELECT * FROM " + DBConstants.TABLE_USUARIO;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registrosUsuarios = sqLiteDatabase.rawQuery(query,null);

        while (registrosUsuarios.moveToNext()) {

            Usuario usuarioActual = new Usuario();

            usuarioActual.setId(registrosUsuarios.getInt(0));
            usuarioActual.setName(registrosUsuarios.getString(1));
            usuarioActual.setEmail(registrosUsuarios.getString(2));
            usuarioActual.setPassword(registrosUsuarios.getString(3));
            usuarioActual.setFoto(registrosUsuarios.getInt(4));

        }

        sqLiteDatabase.close();

        return usuarios;


    }

    public ArrayList<PDV> obtenerPdvs(){

        ArrayList<PDV> pdvs = new ArrayList<>();

        String query = "SELECT * FROM " + DBConstants.TABLE_PDV;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registrosPdvs = sqLiteDatabase.rawQuery(query,null);

        while (registrosPdvs.moveToNext()) {

            PDV pdvActual = new PDV();

            pdvActual.setId(registrosPdvs.getInt(0));
            pdvActual.setNombre(registrosPdvs.getString(1));
            pdvActual.setCodigo(registrosPdvs.getString(2));
            pdvActual.setDireccion(registrosPdvs.getString(3));
            pdvActual.setLongitud(registrosPdvs.getDouble(4));
            pdvActual.setLatitud(registrosPdvs.getDouble(5));
            pdvActual.setLogo(registrosPdvs.getInt(6));

            pdvs.add(pdvActual);

        }
        sqLiteDatabase.close();

        return pdvs;


    }


    public ArrayList<Producto> obtenerProductos(int id) {

        ArrayList<Producto> productos = new ArrayList<>();


        String query = "SELECT * FROM " + DBConstants.TABLE_PDV;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String queryData = "SELECT * FROM " + DBConstants.TABLE_PRODUCT + " WHERE " + DBConstants.TABLE_PRODUCT_ID_PDV + " = "+ id;
        Cursor registrosProductos= sqLiteDatabase.rawQuery(queryData,null);

        while(registrosProductos.moveToNext()){

            Producto productoActual = new Producto();

            productoActual.setId(registrosProductos.getInt(0));
            productoActual.setIdPdv(registrosProductos.getInt(1));
            productoActual.setNombre(registrosProductos.getString(2));
            productoActual.setCosto(registrosProductos.getDouble(3));
            productoActual.setRuta_mayor(registrosProductos.getDouble(4));
            productoActual.setStock(registrosProductos.getInt(5));


            productos.add(productoActual);
        }

        sqLiteDatabase.close();
        return productos;

    }



}
