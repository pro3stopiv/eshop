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
public class Vyrobce {
    private int idVyrobce;
    private String nazev;
    private String popis;
    private double latitude;
    private double longtitude;
    private double altitude;
    private VyrobceKontakt kontakt;

    public void setIdVyrobce(int idVyrobce) {
        this.idVyrobce = idVyrobce;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public void setKontakt(VyrobceKontakt kontakt) {
        this.kontakt = kontakt;
    }

    public int getIdVyrobce() {
        return idVyrobce;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public VyrobceKontakt getKontakt() {
        return kontakt;
    }
    
    
}
