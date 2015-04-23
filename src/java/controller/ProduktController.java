/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produkt;
import service.KategorieService;
import service.ObjednavkaService;
import service.ProduktService;

/**
 *
 * @author baresja1
 */
public class ProduktController implements Controller{

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{
        
        if(req.getParameter("action") != null){
            switch (req.getParameter("action")) {
                case "addToCart":
                    addToCart(req);
                    break;
               }
        }
        //else{
            showDetail(req);
       // }
    }
    
    private void showDetail(HttpServletRequest req) throws SQLException, ClassNotFoundException{
        int id_produkt = Integer.parseInt(req.getParameter("id").toString());
        req.setAttribute("view", "produkt_detail");
        Produkt produkt = ProduktService.getProduktById(id_produkt);
        req.setAttribute("produkt", produkt);
        req.setAttribute("title", produkt.getNazev());
    }
    
    private void addToCart(HttpServletRequest req) throws SQLException, ClassNotFoundException{
        int id_produkt = Integer.parseInt(req.getParameter("id_produkt").toString());
        int pocet = Integer.parseInt(req.getParameter("pocet").toString());
        
        ObjednavkaService.addToCart(id_produkt, pocet, req);
    }
    
}
