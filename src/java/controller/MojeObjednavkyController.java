/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Objednavka;
import model.Zakaznik;
import service.ObjednavkaService;

/**
 *
 * @author Roman
 */
public class MojeObjednavkyController implements Controller {

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
	 if(req.getParameter("action") != null){
	     switch(req.getParameter("action")) {
		 case "detail":
		     if(req.getParameter("id") != null) {
			 showDetail(Integer.parseInt(req.getParameter("id")),req);
		     }
		     break;
		     
		 case "storno":
		     if(req.getParameter("id") != null) {
			 setStorno(Integer.parseInt(req.getParameter("id")),req);
		     }
		     break;
	     }
	 }
	 else {
	     showList(req);
	 }
    }
    
    
    private void showDetail(int id,HttpServletRequest req) throws SQLException, ClassNotFoundException {
	if(isObjednavkaMy(id, req)) {
	    Objednavka o = ObjednavkaService.getObjednavkaById(id);
	    req.setAttribute("view", "mojeobjednavky-detail");
	    req.setAttribute("objednavka", o);
	    
	}
	
	
    }
    
    private void showList(HttpServletRequest req) throws ClassNotFoundException, SQLException {
	List<Objednavka> objednavky = ObjednavkaService.getObjednavkyByIdZakaznika(getZakaznikFromSession(req).getIdZakaznik());
	req.setAttribute("view", "mojeobjednavky");
	req.setAttribute("objednavky", objednavky);
    }
    
    private void setStorno(int id_objednavky, HttpServletRequest req) throws SQLException, ClassNotFoundException {
	if(isObjednavkaMy(id_objednavky, req)) {
	    ObjednavkaService.setStorno(id_objednavky);
	}
	showList(req);
	

    }
    
    private Boolean isObjednavkaMy(int id,HttpServletRequest req) throws SQLException, ClassNotFoundException {
	Objednavka o = ObjednavkaService.getObjednavkaById(id);
	Zakaznik z = getZakaznikFromSession(req);
	
	return (o.getZakaznik().getIdZakaznik() == z.getIdZakaznik());
	
    }
    
    
    private Zakaznik getZakaznikFromSession(HttpServletRequest req) {
	return (Zakaznik)req.getSession().getAttribute("auth_user");
    }
    
    
}
