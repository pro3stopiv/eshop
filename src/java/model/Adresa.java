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
public class Adresa {    
    private int idAdresa;
    private String fakturacniUlice;
    private String fakturacniCP;
    private String fakturacniPSC;
    private String fakturacniMesto;
    private String dorucovaciUlice;
    private String dorucovaciCP;
    private String dorucovaciPSC;
    private String dorucovaciMesto;

    public Adresa() {
    }

    public Adresa(int idAdresa, String fakturacniUlice, String fakturacniCP, String fakturacniPSC, String fakturacniMesto, String dorucovaciUlice, String dorucovaciCP, String dorucovaciPSC, String dorucovaciMesto) {
        this.idAdresa = idAdresa;
        this.fakturacniUlice = fakturacniUlice;
        this.fakturacniCP = fakturacniCP;
        this.fakturacniPSC = fakturacniPSC;
        this.fakturacniMesto = fakturacniMesto;
        this.dorucovaciUlice = dorucovaciUlice;
        this.dorucovaciCP = dorucovaciCP;
        this.dorucovaciPSC = dorucovaciPSC;
        this.dorucovaciMesto = dorucovaciMesto;
    }

    public void setIdAdresa(int idAdresa) {
        this.idAdresa = idAdresa;
    }

    public void setFakturacniUlice(String fakturacniUlice) {
        this.fakturacniUlice = fakturacniUlice;
    }

    public void setFakturacniCP(String fakturacniCP) {
        this.fakturacniCP = fakturacniCP;
    }

    public void setFakturacniPSC(String fakturacniPSC) {
        this.fakturacniPSC = fakturacniPSC;
    }

    public void setFakturacniMesto(String fakturacniMesto) {
        this.fakturacniMesto = fakturacniMesto;
    }

    public void setDorucovaciUlice(String dorucovaciUlice) {
        this.dorucovaciUlice = dorucovaciUlice;
    }

    public void setDorucovaciCP(String dorucovaciCP) {
        this.dorucovaciCP = dorucovaciCP;
    }

    public void setDorucovaciPSC(String dorucovaciPSC) {
        this.dorucovaciPSC = dorucovaciPSC;
    }

    public void setDorucovaciMesto(String dorucovaciMesto) {
        this.dorucovaciMesto = dorucovaciMesto;
    }

    public int getIdAdresa() {
        return idAdresa;
    }

    public String getFakturacniUlice() {
        return fakturacniUlice;
    }

    public String getFakturacniCP() {
        return fakturacniCP;
    }

    public String getFakturacniPSC() {
        return fakturacniPSC;
    }

    public String getFakturacniMesto() {
        return fakturacniMesto;
    }

    public String getDorucovaciUlice() {
        return dorucovaciUlice;
    }

    public String getDorucovaciCP() {
        return dorucovaciCP;
    }

    public String getDorucovaciPSC() {
        return dorucovaciPSC;
    }

    public String getDorucovaciMesto() {
        return dorucovaciMesto;
    }
    
    
}
