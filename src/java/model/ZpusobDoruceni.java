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
public class ZpusobDoruceni {
    private int idZpusobDoruceni;
    private String nazevZpusobu;
    private double cenaDoruceni;

    public ZpusobDoruceni(int idZpusobDoruceni, String nazevZpusobu, double cenaDoruceni) {
	this.idZpusobDoruceni = idZpusobDoruceni;
	this.nazevZpusobu = nazevZpusobu;
	this.cenaDoruceni = cenaDoruceni;
    }

    public ZpusobDoruceni() {
    }
    
    public int getIdZpusobDoruceni() {
        return idZpusobDoruceni;
    }

    public String getNazevZpusobu() {
        return nazevZpusobu;
    }

    public double getCenaDoruceni() {
        return cenaDoruceni;
    }

    public void setNazevZpusobu(String nazevZpusobu) {
	this.nazevZpusobu = nazevZpusobu;
    }

    public void setIdZpusobDoruceni(int idZpusobDoruceni) {
	this.idZpusobDoruceni = idZpusobDoruceni;
    }

    public void setCenaDoruceni(double cenaDoruceni) {
	this.cenaDoruceni = cenaDoruceni;
    }
    
    
    
}
