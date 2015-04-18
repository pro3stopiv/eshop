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
import model.VyrobceKontakt;

/**
 *
 * @author Roman
 */
public class VyrobceKontaktService {
     public static VyrobceKontakt save(VyrobceKontakt kontakt) throws ClassNotFoundException, SQLException, Exception{
	 if (kontakt.getIdKontakt()> 0) {
	     // update
	    PreparedStatement ps = db.DB.getConnection().prepareStatement("update VyrobceKontakt set ulice = ?, cp = ?, psc = ?, mesto = ?, telefon = ?, www = ?, email = ? where id_kontakt = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, kontakt.getUlice());
            ps.setString(2, kontakt.getCp());
            ps.setString(3, kontakt.getPsc());
            ps.setString(4, kontakt.getMesto());
            ps.setString(5, kontakt.getTelefon());
            ps.setString(6, kontakt.getWww());
	    ps.setString(7, kontakt.getEmail());
	    ps.setInt(8, kontakt.getIdKontakt());
            ps.execute();
            return kontakt;
	     
	 } else {
	    // insert

	     PreparedStatement ps = db.DB.getConnection().prepareStatement("insert into VyrobceKontakt (ulice,cp,psc,mesto,telefon,www,email) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
	     ps.setString(1, kontakt.getUlice());
	     ps.setString(2, kontakt.getCp());
	     ps.setString(3, kontakt.getPsc());
	     ps.setString(4, kontakt.getMesto());
	     ps.setString(5, kontakt.getTelefon());
	     ps.setString(6, kontakt.getWww());
	     ps.setString(7, kontakt.getEmail());
	     ps.execute();

	     int id = db.DB.getLastId(ps);

	     kontakt = getVyrobceKontaktById(id);

	     return kontakt;
	 }
    }
     
    public static VyrobceKontakt getVyrobceKontaktById(int id_kontakt) throws SQLException, ClassNotFoundException{
        VyrobceKontakt kontakt = new VyrobceKontakt();
        
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select * from VyrobceKontakt where id_kontakt = ?");
        ps.setInt(1, id_kontakt);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            kontakt.setUlice(rs.getString("ulice"));
            kontakt.setCp(rs.getString("cp"));
            kontakt.setPsc(rs.getString("psc"));
            kontakt.setMesto(rs.getString("mesto"));
            kontakt.setTelefon(rs.getString("telefon"));
            kontakt.setWww(rs.getString("www"));
            kontakt.setEmail(rs.getString("email"));
            kontakt.setIdKontakt(rs.getInt("id_kontakt"));
        }
        
        return kontakt;
    }
    
}
