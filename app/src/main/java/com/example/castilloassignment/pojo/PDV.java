package com.example.castilloassignment.pojo;

public class PDV {

    private int id;
    private String nombre;
    private String codigo;
    private String direccion;
    private double latitud;
    private double longitud;
    private int logo;

    public PDV(int id, String nombre, String codigo, String direccion, double latitud, double longitud, int logo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.logo = logo;
    }

    public PDV() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
