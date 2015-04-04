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
import model.*;

/**
 *
 * @author baresja1
 */
public class KategorieService {
    
    public static List<Kategorie> getAllKategorie() throws SQLException, ClassNotFoundException{
        List<Kategorie> kategorie = new ArrayList<>();

        PreparedStatement ps = db.DB.getConnection().prepareStatement("select id_kategorie, nazev, popis from Kategorie");
        ResultSet rs = ps.executeQuery();
      
        while (rs.next()) {
            kategorie.add(new Kategorie(rs.getInt("id_kategorie"), rs.getString("nazev"), rs.getString("popis")));
        }
        
        return kategorie;
    }
    
    public static Kategorie getKategorieById(int id_kategorie) throws ClassNotFoundException, SQLException{
       PreparedStatement ps = db.DB.getConnection().prepareStatement("select id_kategorie, nazev, popis from Kategorie where id_kategorie = ?");
        ps.setInt(1, id_kategorie);
        ResultSet rs = ps.executeQuery();
        
        Kategorie kategorie = new Kategorie();
        
        while (rs.next()) {
            kategorie.setIdKategorie(rs.getInt("id_kategorie"));
            kategorie.setNazev(rs.getString("nazev"));
            kategorie.setPopis(rs.getString("popis"));

        }
	
        return kategorie;
    }
    
    public static List<KategorieProdukt> getProdukty(int id_kategorie) throws SQLException, ClassNotFoundException{
        
        Kategorie kategorie = getKategorieById(id_kategorie);
        
        List<KategorieProdukt> produkty = new ArrayList<>();
        
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select * from KategorieProdukt where id_kategorie = ?");
        ps.setInt(1, id_kategorie);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Produkt p = ProduktService.getProduktById(rs.getInt("id_produkt"));
        
            KategorieProdukt kp = new KategorieProdukt(kategorie, p);
            
            produkty.add(kp);
        }
        
        return produkty;
    }
    
     public static Kategorie save(Kategorie kategorie) throws ClassNotFoundException, SQLException, Exception{
       
        // udpate
        if(kategorie.getIdKategorie()> 0){
            PreparedStatement ps = db.DB.getConnection().prepareStatement("update Kategorie set nazev = ?, popis = ? where id_kategorie = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, kategorie.getNazev());
            ps.setString(2, kategorie.getPopis());
            ps.setInt(3, kategorie.getIdKategorie());
            ps.execute();
            return kategorie;
        }
        // insert
        else{
            PreparedStatement ps = db.DB.getConnection().prepareStatement("insert into Kategorie (nazev,popis) values(?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, kategorie.getNazev());
            ps.setString(2, kategorie.getPopis());
            ps.execute();
            
            int id = db.DB.getLastId(ps);
            
            kategorie = KategorieService.getKategorieById(id);
            
            return kategorie;
        }
    }
     
     
     public static void delete(Kategorie kategorie) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = db.DB.getConnection().prepareStatement("delete from Kategorie where id_kategorie = ?");
        ps.setInt(1, kategorie.getIdKategorie());
        ps.execute();
    }
}
