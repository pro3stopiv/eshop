/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author baresja1
 */
public class StrankyController implements Controller {

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) {
        switch (req.getServletPath()) {
            case "/kontakt.do":
                req.setAttribute("view", "kontakt");
                break;
            case "/obchodni-podminky.do":
                req.setAttribute("view", "podminky");
                break;
            case "/o-nas.do":
                req.setAttribute("view", "o_nas");
                break;
        }
    }

}
