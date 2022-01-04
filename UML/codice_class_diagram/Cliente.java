/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package Model1;

import java.util.*;
import java.time.*;



// ----------- << imports@AAAAAAF9/LfaxtsP/NE= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAF9/LfaxtsP/NE= >>
// ----------- >>
public class Cliente {
    // ----------- << attribute.annotations@AAAAAAF9/LlK9Ns5Nq4= >>
    // ----------- >>
    private String nome;

    // ----------- << attribute.annotations@AAAAAAF9/LutHNtRLNs= >>
    // ----------- >>
    private String cognome;

    // ----------- << attribute.annotations@AAAAAAF+Jw7KI2Ry/6A= >>
    // ----------- >>
    private String codiceFiscale;

    // ----------- << attribute.annotations@AAAAAAF9/OC4mPNo4GA= >>
    // ----------- >>
    private Set<Volo> Prenota = new HashSet<>();

    private String getNome() {
        return nome;
    }

    private String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public Set<Volo> getPrenota() {
        return Prenota;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void linkPrenota(Volo _Prenota) {
        if (_Prenota != null) {
    		_Prenota.getPrenotatoDa().add(this);
            getPrenota().add(_Prenota);
        }
    }

    public void unlinkPrenota(Volo _Prenota) {
        if (_Prenota != null) {
            _Prenota.getPrenotatoDa().remove(this);
            getPrenota().remove(_Prenota);
        }
    };

    public void unlinkPrenota(Volo _Prenota, Iterator<Volo> it) {
        if (_Prenota != null) {
            _Prenota.getPrenotatoDa().remove(this);
            it.remove();
        }
    }

    /**
    * @param numPersone 
    * @param numBagagliCabina 
    * @param listaAmici 
    * @param codiceVolo
    */

    // ----------- << method.annotations@AAAAAAF+Jwi3WymCLkI= >>
    // ----------- >>
    public void effettuaPrenotazione(int numPersone, int numBagagliCabina, List<Cliente> listaAmici, String codiceVolo) {
    // ----------- << method.body@AAAAAAF+Jwi3WymCLkI= >>
    // ----------- >>
    }
    /**
    * @param codiceFiscale
    */

    // ----------- << method.annotations@AAAAAAF+Jw4W3WFpOQY= >>
    // ----------- >>
    public void controlloStorico(String codiceFiscale) {
    // ----------- << method.body@AAAAAAF+Jw4W3WFpOQY= >>
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAF9/LfaxtsP/NE= >>
// ----------- >>
}