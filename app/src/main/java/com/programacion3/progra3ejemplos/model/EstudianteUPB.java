package com.programacion3.progra3ejemplos.model;

import java.io.Serializable;

public class EstudianteUPB implements Serializable {
    private String nombre;
    private String apellido;
    private int codigo;
    private int foto;

    public EstudianteUPB(String nombre, String apellido, int codigo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
    }

    public EstudianteUPB(String nombre, String apellido, int codigo, int foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
