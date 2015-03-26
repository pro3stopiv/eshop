/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dispatcher;

import db.DB;
import controller.Controller;
import controller.IndexController;
import controller.KategorieController;
import controller.ObjednavkaController;
import controller.ProduktController;
import controller.VyrobceController;
import exceptions.ExceptionLogin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.KategorieService;
import service.ZakaznikService;


/**
 *
 * @author baresja1
 */
public class DispatcherServlet extends HttpServlet {
    
    private HashMap<String, Controller> mapovaniURL = new HashMap<String, Controller>();
    private static final String ERR_PAGE_URL = "/error.html"; 

    @Override
    public void init() throws ServletException {
       mapovaniURL.put("/index.do", new IndexController());
       mapovaniURL.put("/kategorie.do", new KategorieController());
       mapovaniURL.put("/produkt.do", new ProduktController());
       mapovaniURL.put("/vyrobce.do", new VyrobceController());
    }
    
    public DispatcherServlet() {
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            Controller controller = mapovaniURL.get(request.getServletPath());
            
            if(controller != null){
                controller.handleRequest(request, response);
            }
            else{
                request.setAttribute("view", "error");
                request.setAttribute("message","Stránka neexistuje");
            }
            
            auth(request);
            setGlobalAttributes(request, response);
        }
        catch(Exception ex){
            request.setAttribute("view", "error");
            request.setAttribute("message",ex.getMessage());
        }
        
        
        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
        
    }
    
    private void setGlobalAttributes(HttpServletRequest request, HttpServletResponse response) throws SQLException{
        request.setAttribute("menuKategorie", KategorieService.getAllKategorie());
        
        if(request.getSession().getAttribute("auth_user") != null){
            request.setAttribute("auth_state", true);
            request.setAttribute("auth_user", request.getSession().getAttribute("auth_user"));
        }else{
            request.setAttribute("auth_state", false);
        }
        
    }

    private void auth(HttpServletRequest request) throws Exception{
        if(request.getParameter("action") != null && request.getParameter("action").equals("login")){
            if(request.getParameter("email") == null) throw new ExceptionLogin("Zadejte e-mail.");
            if(request.getParameter("password") == null) throw new ExceptionLogin("Zadejte heslo.");
            
            ZakaznikService.login(request, request.getParameter("email"), request.getParameter("password"));
        }else if(request.getParameter("logout") != null && request.getParameter("logout").equals("t")){
            ZakaznikService.logout(request);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
