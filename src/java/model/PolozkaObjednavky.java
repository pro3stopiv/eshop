/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Honza
 */
public class PolozkaObjednavky {
    
    private Produkt produkt;
    private int pocet;

    public PolozkaObjednavky(Produkt produkt, int pocet) {
        this.produkt = produkt;
        this.pocet = pocet;
    }
    
    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }
    
    
}
