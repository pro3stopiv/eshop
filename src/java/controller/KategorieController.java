/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Kategorie;
import service.KategorieService;

/**
 *
 * @author baresja1
 */
public class KategorieController implements Controller{

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {
        req.setAttribute("view","produkty_kategorie");
        
        showProducts(req);
    }
    
    private void showProducts(HttpServletRequest req) throws SQLException, ClassNotFoundException{
        int id_kategorie = Integer.parseInt(req.getParameter("id").toString());
        req.setAttribute("produkty", KategorieService.getProdukty(id_kategorie));
       
        Kategorie kategorie = KategorieService.getKategorieById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("kategorie", kategorie);
        req.setAttribute("title", kategorie.getNazev());
    
    }
    
}
