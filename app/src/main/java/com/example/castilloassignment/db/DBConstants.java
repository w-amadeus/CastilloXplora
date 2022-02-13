package com.example.castilloassignment.db;

public final class  DBConstants {

    public static final String DATABASE_NAME = "luckydb_beta";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_USUARIO = "usuario";
    public static final String TABLE_USUARIO_ID = "id";
    public static final String TABLE_USUARIO_NAME = "nombre";
    public static final String TABLE_USUARIO_EMAIL = "email";
    public static final String TABLE_USUARIO_PASSWORD = "password";
    public static final String TABLE_USUARIO_PHOTO = "foto";

    public static final String TABLE_PDV = "pdvs";
    public static final String TABLE_PDV_ID = "id";
    public static final String TABLE_PDV_NAME = "nombre";
    public static final String TABLE_PDV_CODE = "codigo";
    public static final String TABLE_PDV_LOCATION = "direccion";
    public static final String TABLE_PDV_LONGITUD= "longitud";
    public static final String TABLE_PDV_LATITUD = "latitud";
    public static final String TABLE_PDV_LOGO = "logo";


    public static final String TABLE_PRODUCT = "data_pdvs";
    public static final String TABLE_PRODUCT_ID = "id";
    public static final String TABLE_PRODUCT_ID_PDV = "pdv_id" ;
    public static final String TABLE_PRODUCT_NAME = "nombre";
    public static final String TABLE_PRODUCT_COST = "costo" ;
    public static final String TABLE_PRODUCT_RM = "ruta_mayor";
    public static final String TABLE_PRODUCT_STOCK = "stock";
}
