/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select id_vyrobce, nazev, popis, latitude, longtitude, altitude, id_kontakt, ulice, cp, psc, mesto, telefon, www, email from Vyrobce join VyrobceKontakt using(id_kontakt) where id_vyrobce = ?");
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
        
        
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select id_vyrobce from Vyrobce");
        ResultSet rs = ps.executeQuery();
      
        while (rs.next()) {
            Vyrobce v = VyrobceService.getVyrobceById(rs.getInt("id_vyrobce"));
            vyrobci.add(v);
        }
        
        return vyrobci;
    }
    
    public static Vyrobce save(Vyrobce vyrobce) throws ClassNotFoundException, SQLException, Exception{
        System.out.println("save netoda");

        
        // udpate
        if(vyrobce.getIdVyrobce() > 0){
            System.out.println("update");
            PreparedStatement ps = db.DB.getConnection().prepareStatement("update Vyrobce set nazev = ?, popis = ?, latitude = ?, longtitude = ?, altitude = ? where id_vyrobce = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, vyrobce.getNazev());
            ps.setString(2, vyrobce.getPopis());
            ps.setDouble(3, vyrobce.getLatitude());
            ps.setDouble(4, vyrobce.getLongtitude());
            ps.setDouble(5, vyrobce.getAltitude());
            ps.setInt(6, vyrobce.getIdVyrobce());
            ps.execute();
            return vyrobce;
        }
        // insert
        else{
            System.out.println("insert");
            PreparedStatement ps = db.DB.getConnection().prepareStatement("insert into Vyrobce (nazev,popis,latitude,longtitude,altitude,id_kontakt) values(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, vyrobce.getNazev());
            ps.setString(2, vyrobce.getPopis());
            ps.setDouble(3, vyrobce.getLatitude());
            ps.setDouble(4, vyrobce.getLongtitude());
            ps.setDouble(5, vyrobce.getAltitude());
            ps.setInt(6, 1);
            ps.execute();
            
            int id = db.DB.getLastId(ps);
            
            vyrobce = VyrobceService.getVyrobceById(id);
            
            return vyrobce;
           
        }
    }
    
    public static void delete(Vyrobce vyrobce) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = db.DB.getConnection().prepareStatement("delete from Vyrobce where id_vyrobce = ?");
        ps.setInt(1, vyrobce.getIdVyrobce());
        ps.execute();
    }
}
