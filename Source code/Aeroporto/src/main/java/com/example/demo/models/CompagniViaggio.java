package com.example.demo.models;

import java.util.*;
import java.time.*;

public class CompagniViaggio {
   
    private String codiceFiscaleCliente;
    private String codiceFiscaleAmico;
    private String codiceVolo;

    
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