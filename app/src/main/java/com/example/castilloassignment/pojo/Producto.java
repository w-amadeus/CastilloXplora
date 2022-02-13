package com.example.castilloassignment.pojo;

public class Producto {

    private int id;
    private int idPdv;
    private String nombre;
    private double costo;
    private double ruta_mayor;
    private int stock;

    public Producto(int id, int idPdv, String nombre, double costo, double ruta_mayor, int stock) {
        this.id = id;
        this.idPdv = idPdv;
        this.nombre = nombre;
        this.costo = costo;
        this.ruta_mayor = ruta_mayor;
        this.stock = stock;
    }

    public Producto() {
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getRuta_mayor() {
        return ruta_mayor;
    }

    public void setRuta_mayor(double ruta_mayor) {
        this.ruta_mayor = ruta_mayor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdPdv() {
        return idPdv;
    }

    public void setIdPdv(int idPdv) {
        this.idPdv = idPdv;
    }
}
