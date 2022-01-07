package com.pack.aeroporto.model;

public class Operatore {

    private String nome;
    private String cognome;
    private String email;
    private String password;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String getNome() {
        return nome;
    }

    private String getCognome() {
        return cognome;
    }

    private String getEmail() {
        return email;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setCognome(String cognome) {
        this.cognome = cognome;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}