/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package Model1;

import java.util.*;
import java.time.*;



// ----------- << imports@AAAAAAF9/M0bFeIb0tI= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAF9/M0bFeIb0tI= >>
// ----------- >>
public class Operatore {
    // ----------- << attribute.annotations@AAAAAAF9/M1AduLodPM= >>
    // ----------- >>
    private String nome;

    // ----------- << attribute.annotations@AAAAAAF9/NAwHeb1LB8= >>
    // ----------- >>
    private String cognome;

    // ----------- << attribute.annotations@AAAAAAF+JydpHXqGq5w= >>
    // ----------- >>
    private String email;

    // ----------- << attribute.annotations@AAAAAAF+Jye61XwVbTQ= >>
    // ----------- >>
    private String PSW;

    // ----------- << attribute.annotations@AAAAAAF9/OCsePMHhkw= >>
    // ----------- >>
    private Set<Volo> inserisceVolo = new HashSet<>();

    private String getNome() {
        return nome;
    }

    private String getCognome() {
        return cognome;
    }

    private String getEmail() {
        return email;
    }

    private String getPSW() {
        return PSW;
    }

    public Set<Volo> getInserisceVolo() {
        return inserisceVolo;
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

    private void setPSW(String PSW) {
        this.PSW = PSW;
    }

    public void linkInserisceVolo(Volo _inserisceVolo) {
        if (_inserisceVolo != null) {
            _inserisceVolo.unlinkInseritoDa();
            _inserisceVolo.setInseritoDa(this);
            getInserisceVolo().add(_inserisceVolo);
        }
    }

    public void unlinkInserisceVolo(Volo _inserisceVolo) {
        if (_inserisceVolo != null) {
            _inserisceVolo.setInseritoDa(null);
            getInserisceVolo().remove(_inserisceVolo);
        }
    }

    public void unlinkInserisceVolo(Volo _inserisceVolo, Iterator<Volo> it) {
        if (_inserisceVolo != null) {
            _inserisceVolo.setInseritoDa(null);
            it.remove();
        }
    }

    /**
    * @param codiceAereo 
    * @param aeroporto 
    * @param orario 
    * @param prezzo
    */

    // ----------- << method.annotations@AAAAAAF+JwWtNiP8vMM= >>
    // ----------- >>
    public void inserisciVolo(String codiceAereo, String aeroporto, LocalDateTime orario, double prezzo) {
    // ----------- << method.body@AAAAAAF+JwWtNiP8vMM= >>
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAF9/M0bFeIb0tI= >>
// ----------- >>
}