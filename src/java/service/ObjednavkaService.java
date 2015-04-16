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
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Objednavka;
import model.Produkt;
import model.Vyrobce;
import model.Zakaznik;
import model.ZpusobDoruceni;

/**
 *
 * @author baresja1
 */
public class ObjednavkaService {
    
    public static void addToCart(int id_produkt, int pocet, HttpServletRequest request){
        HttpSession session = request.getSession();
        
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
        
        if(cart.get(id_produkt) != null){
            cart.replace(id_produkt, cart.get(id_produkt) + pocet);
        }else{
            cart.put(id_produkt, pocet);
        }
        
        session.setAttribute("cart", cart);
            
    }
    
    public static void removeItem(int id_produkt, HttpServletRequest request){
        HttpSession session = request.getSession();
        
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
        
        if(cart.get(id_produkt) != null){
            cart.remove(id_produkt);
        }   
                
        session.setAttribute("cart", cart);
            
    }
    
    public static HashMap<Integer, Produkt> getProductsFromCart(HttpServletRequest req) throws SQLException, ClassNotFoundException{
        HashMap<Integer, Produkt> produkty = new HashMap<>();
        
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) req.getSession().getAttribute("cart");
        for (Map.Entry<Integer, Integer> item : cart.entrySet()) {
            produkty.put(item.getKey(), ProduktService.getProduktById(item.getKey()));
            
        }
        
        return produkty;
    }
    
    public static double getCartTotalPrice(HttpServletRequest req) throws SQLException, ClassNotFoundException{
        double price = 0;
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) req.getSession().getAttribute("cart");
        for (Map.Entry<Integer, Integer> item : cart.entrySet()) {
            Produkt p = ProduktService.getProduktById(item.getKey());
            price += p.getCena() * item.getValue();
        }
        return price;
    }
    
     public static Objednavka save(Objednavka objednavka) throws ClassNotFoundException, SQLException, Exception{

        PreparedStatement ps = db.DB.getConnection().prepareStatement("insert into Objednavka (datum,cenaDoruceni,stav,id_zpusobDoruceni,id_zakaznik) values(NOW(),?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setDouble(1, objednavka.getCenaDoruceni());
        ps.setInt(2, objednavka.getStav());
        ps.setInt(3, objednavka.getZpusobDoruceni().getIdZpusobDoruceni());
        ps.setInt(4, objednavka.getZakaznik().getIdZakaznik());
        ps.execute();

        int id = db.DB.getLastId(ps);

        objednavka = getObjednavkaById(id);

        return objednavka;
    }
     
    public static Objednavka getObjednavkaById(int id_objednavka) throws SQLException, ClassNotFoundException{
        Objednavka objednavka = new Objednavka();

        PreparedStatement ps = db.DB.getConnection().prepareStatement("select * from Objednavka where id_objednavka = ?");
        ps.setInt(1, id_objednavka);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
           objednavka.setIdObjednavka(rs.getInt("id_objednavka"));
           objednavka.setDatum(rs.getDate("datum"));
           objednavka.setCenaDoruceni(rs.getDouble("cenaDoruceni"));
           objednavka.setStav(rs.getInt("stav"));
           objednavka.setZpusobDoruceni(ZpusobDoruceniService.getZpusobDoruceniById(rs.getInt("id_zpusobDoruceni")));
           objednavka.setZakaznik(ZakaznikService.getZakaznikById(rs.getInt("id_zakaznik")));
        }
        
        return objednavka;
    }
    
}
