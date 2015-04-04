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
    
    public static List<Produkt> getAllProdukt() throws SQLException, ClassNotFoundException{
        List<Produkt> produkty = new ArrayList<>();
        
        
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select id_produkt from Produkt");
        ResultSet rs = ps.executeQuery();
      
        while (rs.next()) {
            Produkt p = ProduktService.getProduktById(rs.getInt("id_produkt"));
            produkty.add(p);
        }
        
        return produkty;
    }
    
    
    public static void delete(Produkt produkt) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = db.DB.getConnection().prepareStatement("delete from Produkt where id_produkt = ?");
        ps.setInt(1, produkt.getIdProdukt());
        ps.execute();
    }
    
    
    public static List<Kategorie> getKategorieByIdProdukt(int id_produkt) throws ClassNotFoundException, SQLException {
	List<Kategorie> kategorie = new ArrayList<>();
	PreparedStatement ps = db.DB.getConnection().prepareStatement("select id_kategorie from KategorieProdukt where id_produkt = ?");
        ps.setInt(1, id_produkt);
	ResultSet rs = ps.executeQuery();
      
        while (rs.next()) {
	    Kategorie k = KategorieService.getKategorieById(rs.getInt("id_kategorie"));
            kategorie.add(k);
        }
	return kategorie;
    }
    
    
public static Produkt save(Produkt produkt) throws ClassNotFoundException, SQLException, Exception{

        
        // udpate
        if(produkt.getIdProdukt() > 0){
            PreparedStatement ps = db.DB.getConnection().prepareStatement("update Produkt set nazev = ?, cena = ?, popis = ?, DobaDodani = ?, ObsahAlkoholu = ?, NazevObrazku = ?, ID_vyrobce = ? where id_produkt = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produkt.getNazev());
            ps.setDouble(2, produkt.getCena());
            ps.setString(3, produkt.getPopis());
            ps.setInt(4, produkt.getDobaDodani());
            ps.setDouble(5, produkt.getObsahAlkoholu());
            ps.setString(6, produkt.getNazevObrazku());
	    ps.setInt(7, produkt.getVyrobce().getIdVyrobce());
	    ps.setInt(8, produkt.getIdProdukt());
            ps.execute();
            return produkt;
        }
        // insert
        else{
            PreparedStatement ps = db.DB.getConnection().prepareStatement("insert into Produkt (nazev,cena,popis,DobaDodani,ObsahAlkoholu,NazevObrazku,id_vyrobce) values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produkt.getNazev());
            ps.setDouble(2, produkt.getCena());
            ps.setString(3, produkt.getPopis());
            ps.setInt(4, produkt.getDobaDodani());
            ps.setDouble(5, produkt.getObsahAlkoholu());
            ps.setString(6, produkt.getNazevObrazku());
	    ps.setInt(7, produkt.getVyrobce().getIdVyrobce());
            ps.execute();
            
            int id = db.DB.getLastId(ps);
            
            produkt = ProduktService.getProduktById(id);
            
            return produkt;
           
        }
    }
    
    
    
    
}
