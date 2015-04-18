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
import model.Adresa;
import model.Kategorie;
import model.Objednavka;
import model.Vyrobce;
import model.ZpusobDoruceni;
import service.AdresaService;
import service.KategorieService;
import service.ObjednavkaService;
import service.VyrobceService;
import service.ZpusobDoruceniService;

/**
 *
 * @author Roman
 */
public class AdminObjednavkaController implements Controller{

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
        req.setAttribute("view", "objednavka");
        
	List<Objednavka> objednavky = ObjednavkaService.getAllObjednavky();
        req.setAttribute("objednavky", objednavky);
    }
    
    private void showEdit(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        if(req.getParameter("id") != null){
            int id_objednavky = Integer.parseInt(req.getParameter("id").toString());
	    Objednavka objednavka = ObjednavkaService.getObjednavkaById(id_objednavky);
	    ZpusobDoruceni zpusobDoruceni = objednavka.getZpusobDoruceni();
	    Adresa adresa = objednavka.getZakaznik().getAdresa();
            req.setAttribute("objednavka", objednavka);
        }
        req.setAttribute("view", "objednavka_edit");
    }
    
    private void edit(HttpServletRequest req, HttpServletResponse res) throws SQLException, Exception {
	Objednavka objednavka = new Objednavka();

	objednavka.setStav(Integer.parseInt(req.getParameter("stav")));
        
        if(req.getParameter("id") != null){
	    objednavka.setIdObjednavka(Integer.parseInt(req.getParameter("id")));
        }
        
        ObjednavkaService.save(objednavka);
        
        showList(req, res);
        
    }
    
    private void delete(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
	Objednavka objednavka = ObjednavkaService.getObjednavkaById(Integer.parseInt(req.getParameter("id")));
	ObjednavkaService.delete(objednavka);
        showList(req, res);
    }
}
