package com.programacion3.progra3ejemplos.model;

public class LoginAttempt {
    public String usuario;
    public String password;
    public boolean successful;

    public LoginAttempt(String usuario, String password, boolean successful) {
        this.usuario = usuario;
        this.password = password;
        this.successful = successful;
    }
}
