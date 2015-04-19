/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Adresa;
import model.Zakaznik;
import service.AdresaService;
import service.ZakaznikService;

/**
 *
 * @author Honza
 */
public class RegistraceController implements Controller{

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if(req.getParameter("action") != null){
            switch (req.getParameter("action")) {
                case "register":
                    register(req);
                    break;
               }
        }else{
            showForm(req);
        }
    }
    
    private void showForm(HttpServletRequest req){
        req.setAttribute("view", "registrace");
    }
    
    private void register(HttpServletRequest req) throws SQLException, Exception{
        Adresa adresa = new Adresa();
        adresa.setDorucovaciUlice(req.getParameter("dorucovaci_ulice"));
        adresa.setDorucovaciCP(req.getParameter("dorucovaci_cp"));
        adresa.setDorucovaciMesto(req.getParameter("dorucovaci_mesto"));
        adresa.setDorucovaciPSC(req.getParameter("dorucovaci_psc"));

        if(req.getParameter("stejna_adresa").equals("ano")){
            adresa.setFakturacniUlice(req.getParameter("dorucovaci_ulice"));
            adresa.setFakturacniCP(req.getParameter("dorucovaci_cp"));
            adresa.setFakturacniMesto(req.getParameter("dorucovaci_mesto"));
            adresa.setFakturacniPSC(req.getParameter("dorucovaci_psc"));
        }else{
            adresa.setFakturacniUlice(req.getParameter("fakturacni_ulice"));
            adresa.setFakturacniCP(req.getParameter("fakturacni_cp"));
            adresa.setFakturacniMesto(req.getParameter("fakturacni_mesto"));
            adresa.setFakturacniPSC(req.getParameter("fakturacni_psc"));
        }

        adresa = AdresaService.save(adresa);

        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setJmeno(req.getParameter("jmeno"));
        zakaznik.setPrijmeni(req.getParameter("prijmeni"));
        zakaznik.setEmail(req.getParameter("email"));
        zakaznik.setTelefon(req.getParameter("telefon"));
        zakaznik.setHeslo(utils.Hash.getHash(req.getParameter("heslo"),"SHA-256"));
        zakaznik.setAdresa(adresa);
        zakaznik = ZakaznikService.save(zakaznik);
        
        ZakaznikService.login(req, zakaznik.getEmail(), req.getParameter("heslo"));
        
        req.setAttribute("view", "vitejte");
    }
    
}
