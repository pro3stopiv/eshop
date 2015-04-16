/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author baresja1
 */
public class Zakaznik {
    private int idZakaznik;
    private String jmeno;
    private String prijmeni;
    private String email;
    private String heslo;
    private String telefon;
    private Adresa adresa;

    public int getIdZakaznik() {
        return idZakaznik;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getEmail() {
        return email;
    }

    public String getHeslo() {
        return heslo;
    }

    public String getTelefon() {
        return telefon;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setIdZakaznik(int idZakaznik) {
        this.idZakaznik = idZakaznik;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }
    
    
    
}
