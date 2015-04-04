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
import model.ZpusobDoruceni;
import service.KategorieService;
import service.VyrobceService;
import service.ZpusobDoruceniService;

/**
 *
 * @author Roman
 */
public class AdminZpusobDoruceniController implements Controller{

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
        req.setAttribute("view", "zpusob_doruceni");
        
	List<ZpusobDoruceni> zpusob_doruceni = ZpusobDoruceniService.getAllZpusobyDoruceni();
        req.setAttribute("zpusob_doruceni", zpusob_doruceni);
    }
    
    private void showEdit(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        if(req.getParameter("id") != null){
            int id_zpusob = Integer.parseInt(req.getParameter("id").toString());
	    ZpusobDoruceni zpusob_doruceni = ZpusobDoruceniService.getZpusobDoruceniById(id_zpusob);

            req.setAttribute("zpusob_doruceni", zpusob_doruceni);
        }
        req.setAttribute("view", "zpusob_doruceni_edit");
    }
    
    private void edit(HttpServletRequest req, HttpServletResponse res) throws SQLException, Exception{
        ZpusobDoruceni zpusob = new ZpusobDoruceni();
        zpusob.setNazevZpusobu(req.getParameter("nazev"));
        zpusob.setCenaDoruceni(Double.parseDouble(req.getParameter("cena")));
        
        if(req.getParameter("id") != null){
            zpusob.setIdZpusobDoruceni(Integer.parseInt(req.getParameter("id")));
        }
        
        ZpusobDoruceniService.save(zpusob);
        
        showList(req, res);
        
    }
    
    private void delete(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        ZpusobDoruceni zpusob = ZpusobDoruceniService.getZpusobDoruceniById(Integer.parseInt(req.getParameter("id")));
        ZpusobDoruceniService.delete(zpusob);
        showList(req, res);
    }
}
