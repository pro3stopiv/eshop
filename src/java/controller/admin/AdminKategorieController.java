/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import controller.Controller;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Kategorie;
import model.Vyrobce;
import service.KategorieService;
import service.VyrobceService;

/**
 *
 * @author Roman
 */
public class AdminKategorieController implements Controller{

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if(req.getParameter("action") != null){
            switch (req.getParameter("action")) {
                case "showEdit":
                    showEdit(req, res);
                    break;
                case "edit":
                    edit(req, res);
                    break;
                case "delete":
                    delete(req, res);
                    break;
            }
        }
        else{
            showList(req, res);
        }
    }
    
    private void showList(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        req.setAttribute("view", "kategorie");
        
	List<Kategorie> kategorie = KategorieService.getAllKategorie();
        req.setAttribute("kategorie", kategorie);
    }
    
    private void showEdit(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        if(req.getParameter("id") != null){
            int id_kategorie = Integer.parseInt(req.getParameter("id").toString());
	    Kategorie kategorie = KategorieService.getKategorieById(id_kategorie);

            req.setAttribute("kategorie", kategorie);
        }
        req.setAttribute("view", "kategorie_edit");
    }
    
    private void edit(HttpServletRequest req, HttpServletResponse res) throws SQLException, Exception{
        Kategorie kategorie = new Kategorie();
        kategorie.setNazev(req.getParameter("nazev"));
        kategorie.setPopis(req.getParameter("popis"));
        
        if(req.getParameter("id") != null){
            kategorie.setIdKategorie(Integer.parseInt(req.getParameter("id")));
        }
        
        KategorieService.save(kategorie);
        
        showList(req, res);
        
    }
    
    private void delete(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        Kategorie kategorie = KategorieService.getKategorieById(Integer.parseInt(req.getParameter("id")));
        KategorieService.delete(kategorie);
        showList(req, res);
    }
}
