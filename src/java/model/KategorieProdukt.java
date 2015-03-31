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
public class KategorieProdukt {
    private Kategorie kategorie;
    private Produkt produkt;

    public KategorieProdukt(Kategorie kategorie, Produkt produkt) {
        this.kategorie = kategorie;
        this.produkt = produkt;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public Produkt getProdukt() {
        return produkt;
    }
    
    
}
