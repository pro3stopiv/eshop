/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @param request
 * @param response
 * @return nazev view
 * @author baresja1
 */
public interface Controller {
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
