package com.programacion3.progra3ejemplos.model;

import android.graphics.Color;

public class MenuItem {
    private String titulo;
    private Class clase;
    private String color;

    public MenuItem(String titulo, Class clase, String color) {
        this.titulo = titulo;
        this.clase = clase;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
