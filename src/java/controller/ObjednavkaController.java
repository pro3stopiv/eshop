/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ObjednavkaService;
import service.ProduktService;

/**
 *
 * @author baresja1
 */
public class ObjednavkaController implements Controller{

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) {
        if(req.getParameter("action") != null){
            switch (req.getParameter("action")) {
                case "removeItem":
                    removeItem(req, res);
                    break;
               }
        }
        showCart(req, res);
    }
    
    private void showCart(HttpServletRequest req, HttpServletResponse res){
        req.setAttribute("title", "Košík");
        req.setAttribute("view", "kosik");
        req.setAttribute("produkty", req.getSession().getAttribute("cart"));
    }
    
    private void removeItem(HttpServletRequest req, HttpServletResponse res){
        int id_produkt = Integer.parseInt(req.getParameter("id").toString());
        
        ObjednavkaService.removeItem(id_produkt, req);
    }
}
