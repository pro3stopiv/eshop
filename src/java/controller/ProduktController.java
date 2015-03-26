/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.KategorieService;
import service.ProduktService;

/**
 *
 * @author baresja1
 */
public class ProduktController implements Controller{

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{
        req.setAttribute("title", "Produkt");
        req.setAttribute("view", "produkt_detail");
        
        showDetail(req);
    }
    
    private void showDetail(HttpServletRequest req) throws SQLException{
        int id_produkt = Integer.parseInt(req.getParameter("id").toString());
        req.setAttribute("produkt", ProduktService.getProduktById(id_produkt));
    }
    
}
