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
import model.Vyrobce;
import service.VyrobceService;

/**
 *
 * @author Honza
 */
public class AdminVyrobceController implements Controller{

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if(req.getParameter("action") != null){
            if(req.getParameter("action").equals("showEdit")){
                showEdit(req, res);
            }else if(req.getParameter("action").equals("edit")){
                edit(req, res);
            }else if(req.getParameter("action").equals("delete")){
                delete(req, res);
            }
        }
        else{
            showList(req, res);
        }
    }
    
    private void showList(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        req.setAttribute("view", "vyrobci");
        
        List<Vyrobce> vyrobci = VyrobceService.getAllVyrobce();
        req.setAttribute("vyrobci", vyrobci);
    }
    
    private void showEdit(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        if(req.getParameter("id") != null){
            int id_vyrobce = Integer.parseInt(req.getParameter("id").toString());
            Vyrobce vyrobce = VyrobceService.getVyrobceById(id_vyrobce);

            req.setAttribute("vyrobce", vyrobce);
        }
        req.setAttribute("view", "vyrobce_edit");
    }
    
    private void edit(HttpServletRequest req, HttpServletResponse res) throws SQLException, Exception{
        Vyrobce vyrobce = new Vyrobce();
        vyrobce.setNazev(req.getParameter("nazev"));
        vyrobce.setPopis(req.getParameter("popis"));
        vyrobce.setAltitude(Double.parseDouble(req.getParameter("altitude")));
        vyrobce.setLongtitude(Double.parseDouble(req.getParameter("longtitude")));
        vyrobce.setLatitude(Double.parseDouble(req.getParameter("latitude")));
        
        if(req.getParameter("id") != null){
            vyrobce.setIdVyrobce(Integer.parseInt(req.getParameter("id")));
        }
        
        System.out.println("pred save");
        VyrobceService.save(vyrobce);
        
        showList(req, res);
        
    }
    
    private void delete(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        Vyrobce vyrobce = VyrobceService.getVyrobceById(Integer.parseInt(req.getParameter("id")));
        VyrobceService.delete(vyrobce);
        showList(req, res);
    }
}
