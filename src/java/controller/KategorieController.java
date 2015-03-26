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

/**
 *
 * @author baresja1
 */
public class KategorieController implements Controller{

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        req.setAttribute("title", "Kategorie");
        req.setAttribute("view","produkty");
        
        System.out.println("ahoj");
        showProducts(req);
    }
    
    private void showProducts(HttpServletRequest req) throws SQLException{
        int id_kategorie = Integer.parseInt(req.getParameter("id").toString());
        req.setAttribute("produkty", KategorieService.getProdukty(id_kategorie));
    }
    
}
