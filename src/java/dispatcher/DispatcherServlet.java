/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dispatcher;

import controller.Controller;
import controller.IndexController;
import controller.KategorieController;
import controller.MojeObjednavkyController;
import controller.ObjednavkaController;
import controller.ProduktController;
import controller.RegistraceController;
import controller.StrankyController;
import controller.VyrobceController;
import controller.admin.AdminIndexController;
import controller.admin.AdminKategorieController;
import controller.admin.AdminObjednavkaController;
import controller.admin.AdminProduktController;
import controller.admin.AdminVyrobceController;
import controller.admin.AdminZakaznikController;
import controller.admin.AdminZpusobDoruceniController;
import exceptions.ExceptionLogin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.AdministratorService;
import service.KategorieService;
import service.VyrobceService;
import service.ZakaznikService;


/**
 *
 * @author baresja1
 */
public class DispatcherServlet extends HttpServlet {
    
    private HashMap<String, Controller> mapovaniURL = new HashMap<String, Controller>();
    private HashMap<String, Controller> mapovaniURLAdmin = new HashMap<String, Controller>();
    private static final String ERR_PAGE_URL = "/error.html"; 

    @Override
    public void init() throws ServletException {
       HashMap<String, Controller> controllers = new HashMap<>();
       controllers.put("index", new IndexController());
       controllers.put("kategorie", new KategorieController());
       controllers.put("produkt", new ProduktController());
       controllers.put("vyrobce", new VyrobceController());
       controllers.put("stranky", new StrankyController());
       controllers.put("objednavka", new ObjednavkaController());
       controllers.put("registrace", new RegistraceController());
       controllers.put("moje_objednavky", new MojeObjednavkyController());
       controllers.put("admin.index", new AdminIndexController());
       controllers.put("admin.vyrobce", new AdminVyrobceController());
       controllers.put("admin.kategorie", new AdminKategorieController());
       controllers.put("admin.zpusob_doruceni", new AdminZpusobDoruceniController());
       controllers.put("admin.produkt", new AdminProduktController());
       controllers.put("admin.objednavka", new AdminObjednavkaController());
       controllers.put("admin.zakaznik", new AdminZakaznikController());
        
       mapovaniURL.put("/index.do", controllers.get("index"));
       mapovaniURL.put("/kategorie.do", controllers.get("kategorie"));
       mapovaniURL.put("/produkt.do", controllers.get("produkt"));
       mapovaniURL.put("/vyrobce.do", controllers.get("vyrobce"));
       mapovaniURL.put("/vyrobceVypis.do", controllers.get("vyrobce"));
       mapovaniURL.put("/kontakt.do", controllers.get("stranky"));
       mapovaniURL.put("/obchodni-podminky.do", controllers.get("stranky"));
       mapovaniURL.put("/o-nas.do", controllers.get("stranky"));
       mapovaniURL.put("/kosik.do", controllers.get("objednavka"));
       mapovaniURL.put("/registrace.do", controllers.get("registrace"));
       mapovaniURL.put("/moje-objednavky.do", controllers.get("moje_objednavky"));
       
       mapovaniURLAdmin.put("/admin/", controllers.get("admin.index"));
       mapovaniURLAdmin.put("/admin/index.do", controllers.get("admin.index"));
       mapovaniURLAdmin.put("/admin/vyrobce.do", controllers.get("admin.vyrobce"));
       mapovaniURLAdmin.put("/admin/kategorie.do", controllers.get("admin.kategorie"));
       mapovaniURLAdmin.put("/admin/zpusob_doruceni.do", controllers.get("admin.zpusob_doruceni"));
       mapovaniURLAdmin.put("/admin/produkt.do", controllers.get("admin.produkt"));
       mapovaniURLAdmin.put("/admin/objednavka.do", controllers.get("admin.objednavka"));
       mapovaniURLAdmin.put("/admin/zakaznik.do", controllers.get("admin.zakaznik"));
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
        
        request.setCharacterEncoding("utf-8");
        
        if(request.getServletPath().matches("^/admin/.*")){
            proccessAdminRequest(request, response);
        }else{
            proccessFrontendRequest(request, response);
        }
        
        
    }
    
    private void proccessFrontendRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            HttpSession session = request.getSession();
            if(session.getAttribute("cart") == null){
                session.setAttribute("cart", new HashMap<>());
            }
            
            setGlobalFrontendAttributes(request, response);
            
            frontedAuth(request);
            
            Controller controller = mapovaniURL.get(request.getServletPath());

            if(controller != null){
                controller.handleRequest(request, response);
            }
            else{
                request.setAttribute("view", "error");
                request.setAttribute("message","Stránka neexistuje");
            }
            
        }
        catch(Exception ex){
            request.setAttribute("view", "error");
            request.setAttribute("message",ex.getMessage());
        }
        
        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
    }
    
    private void proccessAdminRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            Controller controller = mapovaniURLAdmin.get(request.getServletPath());
           
            if(!isAdminLogged(request)){
                controller = mapovaniURLAdmin.get("/admin/index.do");
            }
            
            if(controller != null){
                controller.handleRequest(request, response);
            }
            else{
                request.setAttribute("view", "error");
                request.setAttribute("message","Stránka neexistuje");
            }
            
            adminAuth(request);
            setGlobalAdminAttributes(request, response);
            
        }
        catch(Exception ex){
            request.setAttribute("view", "error");
            request.setAttribute("message",ex.getMessage());
        }
        
        request.getRequestDispatcher("/WEB-INF/view/admin/index.jsp").forward(request, response);
    }
    
    private void setGlobalFrontendAttributes(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException{
        request.setAttribute("menuKategorie", KategorieService.getAllKategorie());
        request.setAttribute("menuVyrobci", VyrobceService.getAllVyrobce());
        
        request.setAttribute("current_url",request.getServletPath());
        request.setAttribute("base_url", getBaseUrl(request)+"/");
    }

    private void frontedAuth(HttpServletRequest request) throws Exception{
        if(request.getParameter("action") != null && request.getParameter("action").equals("login")){
            if(request.getParameter("email") == null) throw new ExceptionLogin("Zadejte e-mail.");
            if(request.getParameter("password") == null) throw new ExceptionLogin("Zadejte heslo.");
            
            ZakaznikService.login(request, request.getParameter("email"), request.getParameter("password"));
        }else if(request.getParameter("logout") != null && request.getParameter("logout").equals("t")){
            ZakaznikService.logout(request);
        }
        if(request.getSession().getAttribute("auth_user") != null){
            request.setAttribute("auth_state", true);
            request.setAttribute("auth_user", request.getSession().getAttribute("auth_user"));
        }else{
            request.setAttribute("auth_state", false);
        }
    }
    
    private void setGlobalAdminAttributes(HttpServletRequest request, HttpServletResponse reponse) {
        if(request.getSession().getAttribute("admin_auth_user") != null){
            request.setAttribute("admin_auth_state", true);
            request.setAttribute("admin_auth_user", request.getSession().getAttribute("admin_auth_user"));
        }else{
            request.setAttribute("admin_auth_state", false);
        }
        request.setAttribute("base_url", getBaseUrl(request)+"/admin/");
        request.setAttribute("title", "Administrace");
    }
    
    private void adminAuth(HttpServletRequest request) throws Exception{
        if(request.getParameter("action") != null && request.getParameter("action").equals("login")){
            if(request.getParameter("login") == null) throw new ExceptionLogin("Zadejte e-mail.");
            if(request.getParameter("password") == null) throw new ExceptionLogin("Zadejte heslo.");
            
            AdministratorService.login(request, request.getParameter("login"), request.getParameter("password"));
        }else if(request.getParameter("logout") != null && request.getParameter("logout").equals("t")){
            AdministratorService.logout(request);
        }
    }
    
    private boolean isAdminLogged(HttpServletRequest request){
        return request.getSession().getAttribute("admin_auth_user") != null;
    }
    
    private static String getBaseUrl( HttpServletRequest request ) {
    if ( ( request.getServerPort() == 80 ) ||
         ( request.getServerPort() == 443 ) )
      return request.getScheme() + "://" +
             request.getServerName() +
             request.getContextPath();
    else
      return request.getScheme() + "://" +
             request.getServerName() + ":" + request.getServerPort() +
             request.getContextPath();
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
