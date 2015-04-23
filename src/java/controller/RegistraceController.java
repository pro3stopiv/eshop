/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        req.setAttribute("title", "Registrace");
        req.setAttribute("zakaznik", new Zakaznik());
    }
    
    private void register(HttpServletRequest req) throws SQLException, Exception{
        
        List<String> errors = new ArrayList<>();
        
        Adresa adresa = new Adresa();
        Zakaznik zakaznik = new Zakaznik();
        
        zakaznik.setJmeno(req.getParameter("jmeno"));
        zakaznik.setPrijmeni(req.getParameter("prijmeni"));
        zakaznik.setEmail(req.getParameter("email"));
        zakaznik.setTelefon(req.getParameter("telefon"));
        zakaznik.setHeslo(utils.Hash.getHash(req.getParameter("heslo"),"SHA-256"));
        
        if(zakaznik.getJmeno().isEmpty()) errors.add("Zadejte jméno");
        if(zakaznik.getPrijmeni().isEmpty()) errors.add("Zadejte příjmení");
        if(zakaznik.getEmail().isEmpty()) errors.add("Zadejte e-mail");
        
        if(ZakaznikService.getZakaznikByEmail(zakaznik.getEmail()).getIdZakaznik() != 0){
            errors.add("Tento e-mail již je zaregistrován, použijte jiný");
        }
        if(req.getParameter("heslo").isEmpty()) errors.add("Zadejte heslo");
        
        if(!req.getParameter("heslo").isEmpty() && !req.getParameter("heslo").isEmpty() && !req.getParameter("heslo").equals(req.getParameter("heslo_znovu"))) errors.add("Hesla se musí shodovat");
        
        
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

        if(adresa.getDorucovaciUlice().isEmpty()) errors.add("Zadejte doručovací ulici");
        if(adresa.getDorucovaciCP().isEmpty()) errors.add("Zadejte doručovací číslo popisné");
        if(adresa.getDorucovaciMesto().isEmpty()) errors.add("Zadejte doručovací město");
        if(adresa.getDorucovaciPSC().isEmpty()) errors.add("Zadejte doručovací PSČ");
        
        if(adresa.getFakturacniUlice() == null || adresa.getFakturacniUlice().isEmpty()) errors.add("Zadejte fakturační ulici");
        if(adresa.getFakturacniCP() == null || adresa.getFakturacniCP().isEmpty()) errors.add("Zadejte fakturační číslo popisné");
        if(adresa.getFakturacniMesto() == null || adresa.getFakturacniMesto().isEmpty()) errors.add("Zadejte fakturační město");
        if(adresa.getFakturacniPSC() == null || adresa.getFakturacniPSC().isEmpty()) errors.add("Zadejte fakturační PSČ");
       
        
        
        if(errors.size() > 0){
            req.setAttribute("errors", errors);
            showForm(req);
            zakaznik.setAdresa(adresa);
            req.setAttribute("zakaznik", zakaznik);
        }else{
            adresa = AdresaService.save(adresa);
            zakaznik.setAdresa(adresa);
            zakaznik = ZakaznikService.save(zakaznik);

            ZakaznikService.login(req, zakaznik.getEmail(), req.getParameter("heslo"));

            req.setAttribute("view", "vitejte");
        }
        
       
    }
    
}
