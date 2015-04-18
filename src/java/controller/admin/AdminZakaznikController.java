package controller.admin;

import controller.Controller;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Adresa;
import model.Kategorie;
import model.Zakaznik;
import service.AdresaService;
import service.KategorieService;
import service.ZakaznikService;

/**
 *
 * @author Roman
 */
public class AdminZakaznikController implements Controller{

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
        req.setAttribute("view", "zakaznik");
        
	List<Zakaznik> zakaznici = ZakaznikService.getAllZakaznici();
        req.setAttribute("zakaznici", zakaznici);
    }
    
    private void showEdit(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        if(req.getParameter("id") != null){
            int id_zakaznik = Integer.parseInt(req.getParameter("id").toString());
	    Zakaznik zakaznik = ZakaznikService.getZakaznikById(id_zakaznik);

            req.setAttribute("zakaznik", zakaznik);
        }
        req.setAttribute("view", "zakaznik_edit");
    }
    
    private void edit(HttpServletRequest req, HttpServletResponse res) throws SQLException, Exception{
	Zakaznik zakaznik = new Zakaznik();
	
	zakaznik.setJmeno(req.getParameter("jmeno"));
	zakaznik.setEmail(req.getParameter("email"));
	zakaznik.setPrijmeni(req.getParameter("prijmeni"));
        zakaznik.setTelefon(req.getParameter("telefon"));
        
	Adresa adresa = new Adresa();
	adresa.setDorucovaciUlice(req.getParameter("dorucovaciUlice"));
	adresa.setDorucovaciCP(req.getParameter("dorucovaciCP"));
	adresa.setDorucovaciMesto(req.getParameter("dorucovaciMesto"));
	adresa.setDorucovaciPSC(req.getParameter("dorucovaciPSC"));
	adresa.setFakturacniUlice(req.getParameter("fakturacniUlice"));
	adresa.setFakturacniCP(req.getParameter("fakturacniCP"));
	adresa.setFakturacniMesto(req.getParameter("fakturacniMesto"));
	adresa.setFakturacniPSC(req.getParameter("fakturacniPSC"));
		
        if(req.getParameter("id") != null){
            zakaznik.setIdZakaznik(Integer.parseInt(req.getParameter("id")));
	    adresa.setIdAdresa(ZakaznikService.getZakaznikById(zakaznik.getIdZakaznik()).getAdresa().getIdAdresa());
        }
        
	adresa = AdresaService.save(adresa);
	zakaznik.setAdresa(adresa);
	 
        ZakaznikService.save(zakaznik);
		
        showList(req, res);
        
    }
    
    private void delete(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
	Zakaznik zakaznik = ZakaznikService.getZakaznikById(Integer.parseInt(req.getParameter("id")));
	ZakaznikService.delete(zakaznik);
        showList(req, res);
    }
}
