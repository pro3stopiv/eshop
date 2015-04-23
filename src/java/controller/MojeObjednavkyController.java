/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
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
		     
		 case "setStorno":
		     
		     break;
	     }
	 }
    }
    
    
    private void showDetail(int id,HttpServletRequest req) {
	if(isObjednavkaMy(id, req)) {
	    
	}
	
	
    }
    
    
    private Boolean isObjednavkaMy(int id,HttpServletRequest req) throws SQLException, ClassNotFoundException {
	Objednavka o = ObjednavkaService.getObjednavkaById(id);
	Zakaznik z = (Zakaznik)req.getSession().getAttribute("auth_user");
	
	return (o.getZakaznik().getIdZakaznik() == z.getIdZakaznik());
	
    }
    
}
