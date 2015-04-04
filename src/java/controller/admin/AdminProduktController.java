/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import controller.Controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Kategorie;
import model.KategorieProdukt;
import model.Produkt;
import model.Vyrobce;
import model.ZpusobDoruceni;
import service.KategorieProduktService;
import service.KategorieService;
import service.ProduktService;
import service.VyrobceService;
import service.ZpusobDoruceniService;

/**
 *
 * @author Roman
 */

public class AdminProduktController implements Controller{

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
        req.setAttribute("view", "produkt");
       
	List<Produkt> produkty = ProduktService.getAllProdukt();
        req.setAttribute("produkty", produkty);
    }
    
    private void showEdit(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        if(req.getParameter("id") != null){
            int id_produkt = Integer.parseInt(req.getParameter("id").toString());
	    Produkt produkt = ProduktService.getProduktById(id_produkt);

            req.setAttribute("produkt", produkt);
	   
	    
        }
	List<Vyrobce> vyrobci = VyrobceService.getAllVyrobce();
	List<Kategorie> kategorie = KategorieService.getAllKategorie();
	    
	req.setAttribute("kategorie", kategorie);
	req.setAttribute("vyrobci", vyrobci);
        req.setAttribute("view", "produkt_edit");
    }
    
    private void edit(HttpServletRequest req, HttpServletResponse res) throws SQLException, Exception{
        Produkt produkt = new Produkt();
        produkt.setNazev(req.getParameter("nazev"));
        produkt.setCena(Double.parseDouble(req.getParameter("cena")));
        produkt.setPopis(req.getParameter("popis"));
	produkt.setDobaDodani(Integer.parseInt(req.getParameter("doba_dodani")));
	produkt.setObsahAlkoholu(Double.parseDouble(req.getParameter("obsah_alkoholu")));
	Vyrobce v = VyrobceService.getVyrobceById(Integer.parseInt(req.getParameter("vyrobce")));
	produkt.setVyrobce(v);
	
	
	
	
	
	produkt.setNazevObrazku("a");
	//if(req.getParameter("obrazek") != "") {
	    // TODO: ulozit obrazek


	//}
	
	
	
        if(req.getParameter("id") != null){
            produkt.setIdProdukt(Integer.parseInt(req.getParameter("id")));
        }
        
        Produkt pk = ProduktService.save(produkt);
        
	List<Integer> kat = new ArrayList<>();
	for(Kategorie k : KategorieService.getAllKategorie()) {
	    if(req.getParameter("kategorie[" + k.getIdKategorie() + "]")!= null) {
		kat.add(k.getIdKategorie());
	    }
	}
	KategorieProduktService.save(kat,pk.getIdProdukt());
        showList(req, res);
        
    }
    
    private void delete(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        Produkt produkt = ProduktService.getProduktById(Integer.parseInt(req.getParameter("id")));
        ProduktService.delete(produkt);
        showList(req, res);
    }
    
    
    
}
