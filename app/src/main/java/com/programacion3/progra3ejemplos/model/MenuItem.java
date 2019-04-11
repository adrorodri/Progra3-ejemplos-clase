package com.programacion3.progra3ejemplos.model;

public class MenuItem {
    private String titulo;
    private Class clase;

    public MenuItem(String titulo, Class clase) {
        this.titulo = titulo;
        this.clase = clase;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Class getClase() {
        return clase;
    }

    public void setClase(Class clase) {
        this.clase = clase;
    }
}
