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
public class VyrobceKontakt {
    private int idKontakt;
    private String ulice;
    private String cp;
    private String psc;
    private String mesto;
    private String telefon;
    private String www;
    private String email;

    public void setIdKontakt(int idKontakt) {
        this.idKontakt = idKontakt;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdKontakt() {
        return idKontakt;
    }

    public String getUlice() {
        return ulice;
    }

    public String getCp() {
        return cp;
    }

    public String getPsc() {
        return psc;
    }

    public String getMesto() {
        return mesto;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getWww() {
        return www;
    }

    public String getEmail() {
        return email;
    }
    
    
}
