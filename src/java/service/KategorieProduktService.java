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
import model.Kategorie;
import model.KategorieProdukt;
import model.Produkt;
import model.Vyrobce;

/**
 *
 * @author Roman
 */
public class KategorieProduktService {
       
    public static void save(List<Integer> kategorie, int id_produktu) throws ClassNotFoundException, Exception{
	
	    KategorieProduktService.removeAllbyIdProdukt(id_produktu);
	    for(Integer k : kategorie) {
		PreparedStatement ps = db.DB.getConnection().prepareStatement("insert into KategorieProdukt (id_kategorie,id_produkt) values(?,?)",Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, k);
		ps.setInt(2, id_produktu);
           
		try {
		    ps.execute();
		}
		catch(SQLException sqle) {
		    System.out.print("Kategorie:" + k + ",Produkt:" + id_produktu);
		    System.out.print(sqle.getMessage());
		}
	    }
            
            
	
    }
    
    public static void removeAllbyIdProdukt(int produkt_id) throws ClassNotFoundException, SQLException {
	PreparedStatement ps = db.DB.getConnection().prepareStatement("delete from KategorieProdukt where id_produkt = ?");
        ps.setInt(1, produkt_id);
        ps.execute();
    }
    
    
    
    
}
