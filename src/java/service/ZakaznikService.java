/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import exceptions.ExceptionLogin;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Adresa;
import model.Produkt;
import model.Vyrobce;
import model.VyrobceKontakt;
import model.Zakaznik;

/**
 *
 * @author Honza
 */
public class ZakaznikService {
    
    public static void login(HttpServletRequest request, String email, String password) throws SQLException, ExceptionLogin, NoSuchAlgorithmException, ClassNotFoundException{
        
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select id_zakaznik from Zakaznik where email = ? and heslo = ?");
        ps.setString(1, email);
        ps.setString(2, utils.Hash.getHash(password, "SHA-256"));
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            HttpSession session = request.getSession();
            Zakaznik zakaznik = getZakaznikById(rs.getInt("id_zakaznik"));
            session.setAttribute("auth_user", zakaznik);
        }else{
            throw new ExceptionLogin("Přihlášení se nepodařilo");
        }
        
    }
    
    public static void logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("auth_user");
    }
    
    public static Zakaznik getZakaznikById(int id) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select * from Zakaznik join Adresa using(id_adresa) where id_zakaznik = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        Zakaznik zakaznik = new Zakaznik();
        Adresa adresa = new Adresa();
        
        while (rs.next()) {
            zakaznik.setIdZakaznik(rs.getInt("id_zakaznik"));
            zakaznik.setEmail(rs.getString("email"));
            zakaznik.setJmeno(rs.getString("jmeno"));
            zakaznik.setPrijmeni(rs.getString("prijmeni"));
            zakaznik.setTelefon(rs.getString("telefon"));
            
            adresa.setIdAdresa(rs.getInt("id_adresa"));
        }
        
        zakaznik.setAdresa(adresa);
        
        
        return zakaznik;
        
    }
    
        
    
    public static Zakaznik save(Zakaznik zakaznik) throws ClassNotFoundException, SQLException, Exception{

            PreparedStatement ps = db.DB.getConnection().prepareStatement("insert into Zakaznik (jmeno,prijmeni,email,heslo,telefon,id_adresa) values(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, zakaznik.getJmeno());
            ps.setString(2, zakaznik.getPrijmeni());
            ps.setString(3, zakaznik.getEmail());
            ps.setString(4, zakaznik.getHeslo());
            ps.setString(5, zakaznik.getTelefon());
            ps.setInt(6, zakaznik.getAdresa().getIdAdresa());
            
            ps.execute();
            
            int id = db.DB.getLastId(ps);
            
            zakaznik = ZakaznikService.getZakaznikById(id);
            
            return zakaznik;
    }
}
