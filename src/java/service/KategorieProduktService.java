/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Produkt;
import model.Vyrobce;

/**
 *
 * @author Honza
 */
public class ProduktService {
    
    public static Produkt getProduktById(int id_produkt) throws SQLException, ClassNotFoundException{
        Produkt p = new Produkt();
        
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select * from Produkt where id_produkt = ?");
        ps.setInt(1, id_produkt);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            p.setNazev(rs.getString("nazev"));
            p.setCena(rs.getDouble("cena"));
            p.setDobaDodani(rs.getInt("dobadodani"));
            p.setNazevObrazku(rs.getString("nazevobrazku"));
            p.setObsahAlkoholu(rs.getDouble("obsahalkoholu"));
            p.setIdProdukt(rs.getInt("id_produkt"));
            p.setPopis(rs.getString("popis"));
            
            Vyrobce v = VyrobceService.getVyrobceById(rs.getInt("id_vyrobce"));
            p.setVyrobce(v);
        }
        
        return p;
    }
    
}
