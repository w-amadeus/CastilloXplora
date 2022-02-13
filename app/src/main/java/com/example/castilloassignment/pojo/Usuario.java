package com.example.castilloassignment.pojo;

public class Usuario {

    private int id;
    private String name;
    private String email;
    private String password;
    private int foto;

    public Usuario(int id, String name, String email, String password, int foto) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.foto = foto;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
