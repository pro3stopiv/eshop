/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    
    
}
