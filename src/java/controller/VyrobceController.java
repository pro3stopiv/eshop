/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vyrobce;
import service.VyrobceService;

/**
 *
 * @author baresja1
 */
public class VyrobceController implements Controller{

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{
        req.setAttribute("title", "Výrobce");
        req.setAttribute("view", "vyrobce");
        
        int id_vyrobce = Integer.parseInt(req.getParameter("id").toString());
        Vyrobce vyrobce = VyrobceService.getVyrobceById(id_vyrobce);
      
        req.setAttribute("vyrobce", vyrobce);
        
    }
    
}
