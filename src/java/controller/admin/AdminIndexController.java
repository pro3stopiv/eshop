/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.admin;

import controller.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author baresja1
 */
public class AdminIndexController implements Controller {

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{
        req.setAttribute("title", "Osoba");
        req.setAttribute("view","uvod");
    }
    
}
