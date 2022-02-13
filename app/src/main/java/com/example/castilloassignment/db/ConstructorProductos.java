package com.example.castilloassignment.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.castilloassignment.R;
import com.example.castilloassignment.pojo.PDV;
import com.example.castilloassignment.pojo.Producto;

import java.util.ArrayList;


public class ConstructorProductos {

        private Context context;

        public ConstructorProductos(Context context) {
            this.context = context;
        }

    public ArrayList<Producto> obtenerDataProductos(int id){

        Database dataBase = new Database(context);
        insertarProductos(dataBase);
        return dataBase.obtenerProductos(id);

    }

    public void insertarProductos(Database database){

        ContentValues contentValues = new ContentValues();


        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 1);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Samsung Galaxy S21");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 4099.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 48.20);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 50);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 1);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Laptop Zenbook 14");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 4999.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 24.2);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 25);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 1);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Audífonos Sony Over Ear");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 149.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 62.80);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 10);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 1);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Helado Italiano Tiramisu");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 12.59);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 32.30);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 22);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 2);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Laptop HP 15-dy2053la");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 2499.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 42.20);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 20);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 2);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Bombones Helena");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 29.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 14.2);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 100);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 2);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Impresora Multifuncional HP");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 449.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 22.20);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 12);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 2);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Dormitorio Majestic 1.5");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 589.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 42.30);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 10);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 3);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Mochila Doo Australia");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 99.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 18.20);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 20);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 3);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Zapatillas Nike Air Max");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 399.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 28.20);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 10);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 3);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Aire Acondicionado AC350");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 2549.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 70.80);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 5);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 3);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Cilindro Asador Master");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 259.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 22.30);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 4);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 4);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Reloj Casio G-SHOCK ");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 5999.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 22.20);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 40);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 4);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Sofá 3C Carolina Gris");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 1099.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 32.20);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 7);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 4);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Polo Index Para Hombre");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 59.99);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 12.80);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 15);
        database.insertarProducto(contentValues);

        contentValues.put(DBConstants.TABLE_PRODUCT_ID_PDV, 4);
        contentValues.put(DBConstants.TABLE_PRODUCT_NAME, "Adidas Predator EDGE.4");
        contentValues.put(DBConstants.TABLE_PRODUCT_COST, 299.59);
        contentValues.put(DBConstants.TABLE_PRODUCT_RM, 26.30);
        contentValues.put(DBConstants.TABLE_PRODUCT_STOCK, 10);
        database.insertarProducto(contentValues);

        }
    }
