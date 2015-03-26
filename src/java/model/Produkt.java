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
public class Produkt {
    private int idProdukt;
    private String nazev;
    private double cena;
    private String popis;
    private int dobaDodani;
    private double obsahAlkoholu;
    private String nazevObrazku;
    private Vyrobce vyrobce;

    public Produkt() {
    }

    public void setIdProdukt(int idProdukt) {
        this.idProdukt = idProdukt;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public void setDobaDodani(int dobaDodani) {
        this.dobaDodani = dobaDodani;
    }

    public void setObsahAlkoholu(double obsahAlkoholu) {
        this.obsahAlkoholu = obsahAlkoholu;
    }

    public void setNazevObrazku(String nazevObrazku) {
        this.nazevObrazku = nazevObrazku;
    }

    public void setVyrobce(Vyrobce vyrobce) {
        this.vyrobce = vyrobce;
    }

    public int getIdProdukt() {
        return idProdukt;
    }

    public String getNazev() {
        return nazev;
    }

    public double getCena() {
        return cena;
    }

    public String getPopis() {
        return popis;
    }

    public int getDobaDodani() {
        return dobaDodani;
    }

    public double getObsahAlkoholu() {
        return obsahAlkoholu;
    }

    public String getNazevObrazku() {
        return nazevObrazku;
    }

    public Vyrobce getVyrobce() {
        return vyrobce;
    }
       
}
