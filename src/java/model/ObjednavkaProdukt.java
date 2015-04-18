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
public class ObjednavkaProdukt {
    private Objednavka objednavka;
    private Produkt produkt;
    private double cena;
    private int pocetKusu;

    public Objednavka getObjednavka() {
        return objednavka;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public double getCena() {
        return cena;
    }

    public int getPocetKusu() {
	return pocetKusu;
    }

    public void setCena(double cena) {
	this.cena = cena;
    }

    public void setObjednavka(Objednavka objednavka) {
	this.objednavka = objednavka;
    }

    public void setPocetKusu(int pocetKusu) {
	this.pocetKusu = pocetKusu;
    }

    public void setProdukt(Produkt produkt) {
	this.produkt = produkt;
    }    
}
