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
    
}
