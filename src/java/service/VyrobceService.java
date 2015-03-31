/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Vyrobce;
import model.VyrobceKontakt;

/**
 *
 * @author Honza
 */
public class VyrobceService {
    
    
    public static Vyrobce getVyrobceById(int id) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select id_vyrobce, nazev, popis, latitude, longtitude, altitude, id_kontakt, ulice, cp, psc, mesto, telefon, www, email from vyrobce join vyrobcekontakt using(id_kontakt) where id_vyrobce = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        VyrobceKontakt kontakt = new VyrobceKontakt();
        Vyrobce vyrobce = new Vyrobce();
        
        while (rs.next()) {
            vyrobce.setIdVyrobce(rs.getInt("id_vyrobce"));
            vyrobce.setNazev(rs.getString("nazev"));
            vyrobce.setPopis(rs.getString("popis"));
            vyrobce.setAltitude(rs.getDouble("altitude"));
            vyrobce.setLatitude(rs.getDouble("latitude"));
            vyrobce.setLongtitude(rs.getDouble("longtitude"));
            
            kontakt.setIdKontakt(rs.getInt("id_kontakt"));
            kontakt.setCp(rs.getString("cp"));
            kontakt.setUlice(rs.getString("ulice"));
            kontakt.setMesto(rs.getString("mesto"));
            kontakt.setPsc(rs.getString("psc"));
            kontakt.setTelefon(rs.getString("telefon"));
            kontakt.setEmail(rs.getString("email"));
            kontakt.setWww(rs.getString("www"));
        }
        
        vyrobce.setKontakt(kontakt);
        
        return vyrobce;
        
    }
    
    public static List<Vyrobce> getAllVyrobce() throws SQLException, ClassNotFoundException{
        List<Vyrobce> vyrobci = new ArrayList<>();
        
        
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select id_vyrobce from vyrobce");
        ResultSet rs = ps.executeQuery();
      
        while (rs.next()) {
            Vyrobce v = VyrobceService.getVyrobceById(rs.getInt("id_vyrobce"));
            vyrobci.add(v);
        }
        
        return vyrobci;
    }
}
