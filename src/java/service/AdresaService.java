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
import model.Adresa;
import model.Produkt;
import model.Vyrobce;

/**
 *
 * @author Honza
 */
public class AdresaService {
     public static Adresa save(Adresa adresa) throws ClassNotFoundException, SQLException, Exception{
	 if (adresa.getIdAdresa() > 0) {
	     // update
	    PreparedStatement ps = db.DB.getConnection().prepareStatement("update Adresa set fakturacni_ulice = ?, fakturacni_CP = ?, fakturacni_PSC = ?, fakturacni_Mesto = ?, dorucovaci_ulice = ?, dorucovaci_CP = ?, dorucovaci_mesto = ?, dorucovaci_PSC = ? where id_adresa = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, adresa.getFakturacniUlice());
            ps.setString(2, adresa.getFakturacniCP());
            ps.setString(3, adresa.getFakturacniPSC());
            ps.setString(4, adresa.getFakturacniMesto());
            ps.setString(5, adresa.getDorucovaciUlice());
            ps.setString(6, adresa.getDorucovaciCP());
	    ps.setString(7, adresa.getDorucovaciMesto());
	    ps.setString(8, adresa.getDorucovaciPSC());
	    ps.setInt(9, adresa.getIdAdresa());
            ps.execute();
            return adresa;
	     
	 } else {
	    // insert

	     PreparedStatement ps = db.DB.getConnection().prepareStatement("insert into Adresa (fakturacni_ulice,fakturacni_cp,fakturacni_psc,fakturacni_mesto, dorucovaci_ulice, dorucovaci_cp, dorucovaci_mesto, dorucovaci_psc) values(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
	     ps.setString(1, adresa.getFakturacniUlice());
	     ps.setString(2, adresa.getFakturacniCP());
	     ps.setString(3, adresa.getFakturacniPSC());
	     ps.setString(4, adresa.getFakturacniMesto());
	     ps.setString(5, adresa.getDorucovaciUlice());
	     ps.setString(6, adresa.getDorucovaciCP());
	     ps.setString(7, adresa.getDorucovaciMesto());
	     ps.setString(8, adresa.getDorucovaciPSC());
	     ps.execute();

	     int id = db.DB.getLastId(ps);

	     adresa = getAdresaById(id);

	     return adresa;
	 }
    }
     
    public static Adresa getAdresaById(int id_adresa) throws SQLException, ClassNotFoundException{
        Adresa adresa = new Adresa();
        
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select * from Adresa where id_adresa = ?");
        ps.setInt(1, id_adresa);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            adresa.setIdAdresa(rs.getInt("id_adresa"));
            adresa.setFakturacniUlice(rs.getString("fakturacni_ulice"));
            adresa.setFakturacniCP(rs.getString("fakturacni_cp"));
            adresa.setFakturacniMesto(rs.getString("fakturacni_mesto"));
            adresa.setFakturacniPSC(rs.getString("fakturacni_psc"));
            adresa.setDorucovaciUlice(rs.getString("dorucovaci_ulice"));
            adresa.setDorucovaciCP(rs.getString("dorucovaci_cp"));
            adresa.setDorucovaciMesto(rs.getString("dorucovaci_mesto"));
            adresa.setDorucovaciPSC(rs.getString("dorucovaci_psc"));
        }
        
        return adresa;
    }
    
}
