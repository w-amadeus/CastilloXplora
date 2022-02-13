package com.example.castilloassignment.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.castilloassignment.R;
import com.example.castilloassignment.pojo.PDV;

import java.util.ArrayList;

public class ConstructorPDVs {
    private Context context;

    public ConstructorPDVs(Context context) {
        this.context = context;
    }

    public ArrayList<PDV> obtenerData(){

        Database dataBase = new Database(context);
        insertarPDVs(dataBase);
        return dataBase.obtenerPdvs();

    }

    public void insertarPDVs(Database database){

        ContentValues contentValues = new ContentValues();

        contentValues.put(DBConstants.TABLE_PDV_NAME, "Metro San Juan de Lurigancho");
        contentValues.put(DBConstants.TABLE_PDV_CODE, "CM-205556");
        contentValues.put(DBConstants.TABLE_PDV_LOCATION, "Av. Próceres de la Independencia 1632");
        contentValues.put(DBConstants.TABLE_PDV_LONGITUD, -77.00395534552649);
        contentValues.put(DBConstants.TABLE_PDV_LATITUD, -12.006371679668652);
        contentValues.put(DBConstants.TABLE_PDV_LOGO, R.drawable.metro);
        database.insertarPDV(contentValues);


        contentValues.put(DBConstants.TABLE_PDV_NAME, "Tottus Lima Centro");
        contentValues.put(DBConstants.TABLE_PDV_CODE, "CM-205557");
        contentValues.put(DBConstants.TABLE_PDV_LOCATION, "Av. Tacna Nro. 665, Lima");
        contentValues.put(DBConstants.TABLE_PDV_LONGITUD, -77.03849333097712);
        contentValues.put(DBConstants.TABLE_PDV_LATITUD, -12.048323972166536);
        contentValues.put(DBConstants.TABLE_PDV_LOGO, R.drawable.tottus_logo);
        database.insertarPDV(contentValues);



        contentValues.put(DBConstants.TABLE_PDV_NAME, "Falabella Santa Anita");
        contentValues.put(DBConstants.TABLE_PDV_CODE, "CM-205558");
        contentValues.put(DBConstants.TABLE_PDV_LOCATION, "Av. Carretera central No. 111");
        contentValues.put(DBConstants.TABLE_PDV_LONGITUD, -76.97135969354174);
        contentValues.put(DBConstants.TABLE_PDV_LATITUD, -12.056864017334588);
        contentValues.put(DBConstants.TABLE_PDV_LOGO, R.drawable.saga_logo);
        database.insertarPDV(contentValues);


        contentValues.put(DBConstants.TABLE_PDV_NAME, "Ripley Chorrillos");
        contentValues.put(DBConstants.TABLE_PDV_CODE, "CM-205559");
        contentValues.put(DBConstants.TABLE_PDV_LOCATION, "Av Paseo de la Republica 355");
        contentValues.put(DBConstants.TABLE_PDV_LONGITUD, -77.01412863101524);
        contentValues.put(DBConstants.TABLE_PDV_LATITUD, -12.172285588286877);
        contentValues.put(DBConstants.TABLE_PDV_LOGO, R.drawable.ripley_logo);
        database.insertarPDV(contentValues);


    }
}
