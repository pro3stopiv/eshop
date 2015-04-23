/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ProduktService;

/**
 *
 * @author baresja1
 */
public class IndexController implements Controller {

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{
        req.setAttribute("title", "Úvod");
        req.setAttribute("view","uvod");
        req.setAttribute("produkty", ProduktService.getRandomProdukty(6));
    }
    
}
