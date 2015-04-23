/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author baresja1
 */
public class Objednavka {
    private int idObjednavka;
    private Date datum;
    private double cenaDoruceni;
    private int stav;
    private ZpusobDoruceni zpusobDoruceni;
    private Zakaznik zakaznik;
    private List<ObjednavkaProdukt> produkty;
    
    public static final int STAV_STORNO = 4;
    
    private static final String[] stavyObjednavky = {"Nová","Zpracovává se", "Vyřízená", "Storno"};
    
    public int getIdObjednavka() {
        return idObjednavka;
    }

    public Date getDatum() {
        return datum;
    }

    public double getCenaDoruceni() {
        return cenaDoruceni;
    }

    public int getStav() {
        return stav;
    }

    public ZpusobDoruceni getZpusobDoruceni() {
        return zpusobDoruceni;
    }

    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    public List<ObjednavkaProdukt> getProdukty() {
        return produkty;
    }

    public void setIdObjednavka(int idObjednavka) {
        this.idObjednavka = idObjednavka;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setCenaDoruceni(double cenaDoruceni) {
        this.cenaDoruceni = cenaDoruceni;
    }

    public void setStav(int stav) {
        this.stav = stav;
    }

    public void setZpusobDoruceni(ZpusobDoruceni zpusobDoruceni) {
        this.zpusobDoruceni = zpusobDoruceni;
    }

    public void setZakaznik(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }

    public void setProdukty(List<ObjednavkaProdukt> produkty) {
        this.produkty = produkty;
    }

    public double getCelkovaCena() {
	double cena = cenaDoruceni;
	for(ObjednavkaProdukt op : produkty) {
	    double c = op.getPocetKusu() * op.getCena();
	    cena += c;
	}
	return cena;
    }
    
    public String getStavObjednavky() {
	String stav = "N/A";
	try {
	    stav = stavyObjednavky[this.stav-1];
	}
	catch(ArrayIndexOutOfBoundsException e) {
	    
	}
	return stav;
    }

    public String[] getStavyObjednavky() {
	return stavyObjednavky;
    }
    
    public int getPocetStavuObjednavky() {
	return stavyObjednavky.length;
    }
    
}
