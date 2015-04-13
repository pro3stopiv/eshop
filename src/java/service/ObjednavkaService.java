/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Produkt;

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
    
}
