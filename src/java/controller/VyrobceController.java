/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produkt;
import model.Vyrobce;
import service.KategorieService;
import service.ProduktService;
import service.VyrobceService;

/**
 *
 * @author baresja1
 */
public class VyrobceController implements Controller{

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{
        
        System.out.println(req.getServletPath());
        if(req.getServletPath().equals("/vyrobceVypis.do")){
            showProducts(req);
        }else{
            showDetail(req);
        }
      
        
    }
    
    private void showDetail(HttpServletRequest req) throws SQLException, ClassNotFoundException{
        int id_vyrobce = Integer.parseInt(req.getParameter("id"));
        Vyrobce vyrobce = VyrobceService.getVyrobceById(id_vyrobce);
      
        req.setAttribute("title", "Výrobce");
        req.setAttribute("view", "vyrobce");
        
        req.setAttribute("vyrobce", vyrobce);
    }
    
    private void showProducts(HttpServletRequest req) throws SQLException, ClassNotFoundException{
        int id_vyrobce = Integer.parseInt(req.getParameter("id"));
        List<Produkt> produkty = VyrobceService.getProdukty(id_vyrobce);
        
        req.setAttribute("produkty", produkty);
        req.setAttribute("view", "vyrobce_produkty");
    }
    
}
