/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;

/**
 *
 * @author baresja1
 */
public class Kategorie {
    private int idKategorie;
    private String nazev;
    private String popis;

    public Kategorie() {
    }

    public Kategorie(int idKategorie, String nazev, String popis) {
        this.idKategorie = idKategorie;
        this.nazev = nazev;
        this.popis = popis;
    }

    public void setIdKategorie(int idKategorie) {
        this.idKategorie = idKategorie;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }
    
    public int getIdKategorie() {
        return idKategorie;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }
        
}
