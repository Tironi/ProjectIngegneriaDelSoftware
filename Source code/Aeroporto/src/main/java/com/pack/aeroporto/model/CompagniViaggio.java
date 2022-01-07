package com.pack.aeroporto.model;

public class CompagniViaggio {
   
    private String codiceFiscaleCliente;
    private String codiceFiscaleAmico;
    private String codiceVolo;
    
    public CompagniViaggio() {}
    
    private String getCodiceFiscaleCliente() {
        return codiceFiscaleCliente;
    }

    private String getCodiceFiscaleAmico() {
        return codiceFiscaleAmico;
    }

    private String getCodiceVolo() {
        return codiceVolo;
    }

    private void setCodiceFiscaleCliente(String codiceFiscaleCliente) {
        this.codiceFiscaleCliente = codiceFiscaleCliente;
    }

    private void setCodiceFiscaleAmico(String codiceFiscaleAmico) {
        this.codiceFiscaleAmico = codiceFiscaleAmico;
    }

    private void setCodiceVolo(String codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

}