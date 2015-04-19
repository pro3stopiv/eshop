/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Adresa;
import model.Objednavka;
import model.ObjednavkaProdukt;
import model.Produkt;
import model.Zakaznik;
import model.ZpusobDoruceni;
import service.AdresaService;
import service.ObjednavkaService;
import service.ProduktService;
import service.ZakaznikService;
import service.ZpusobDoruceniService;

/**
 *
 * @author baresja1
 */
public class ObjednavkaController implements Controller{

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, Exception {
        if(req.getParameter("action") != null){
            switch (req.getParameter("action")) {
                case "removeItem":
                    removeItem(req, res);
                    showCart(req, res);
                    break;
                case "order":
                    order(req, res);
                    break;
                default:
                    showCart(req, res);
               }
        }else{
            showCart(req, res);
        }
    }
    
    private void showCart(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException{
        req.setAttribute("title", "Košík");
        req.setAttribute("view", "kosik");
        req.setAttribute("polozky", req.getSession().getAttribute("cart"));
        HashMap<Integer, Produkt> produkty = ObjednavkaService.getProductsFromCart(req);
        req.setAttribute("produkty", produkty);
        req.setAttribute("totalPrice", ObjednavkaService.getCartTotalPrice(req));
        req.setAttribute("doprava", ZpusobDoruceniService.getAllZpusobyDoruceni());
        
        int dodani = 0;
        for (Map.Entry<Integer, Produkt> produkt : produkty.entrySet()) {
            if(produkt.getValue().getDobaDodani() > dodani) dodani = produkt.getValue().getDobaDodani();
            if(produkt.getValue().getDobaDodani() == 0) {
                dodani = 0;
                break;
            } 
        }
        
        req.setAttribute("dobaDodani", dodani);
    }
    
    private void removeItem(HttpServletRequest req, HttpServletResponse res){
        int id_produkt = Integer.parseInt(req.getParameter("id").toString());
        
        ObjednavkaService.removeItem(id_produkt, req);
    }
    
    private void order(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException, Exception{
        
        Objednavka objednavka = new Objednavka();
        objednavka.setStav(1);
        
        if(req.getSession().getAttribute("auth_user") != null){
            objednavka.setZakaznik((Zakaznik) req.getSession().getAttribute("auth_user"));
        }else{
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
            
            objednavka.setZakaznik(zakaznik);
        }
        
        ZpusobDoruceni zpusob = ZpusobDoruceniService.getZpusobDoruceniById(Integer.parseInt(req.getParameter("zpusobDoruceni")));
        objednavka.setZpusobDoruceni(zpusob);
        objednavka.setCenaDoruceni(zpusob.getCenaDoruceni());
        
        objednavka = ObjednavkaService.save(objednavka);
      
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) req.getSession().getAttribute("cart");
        for (Map.Entry<Integer, Integer> item : cart.entrySet()) {
            Produkt produkt = ProduktService.getProduktById(item.getKey());
            ObjednavkaProdukt objednavkaProdukt = new ObjednavkaProdukt();
            objednavkaProdukt.setObjednavka(objednavka);
            objednavkaProdukt.setProdukt(produkt);
            objednavkaProdukt.setCena(produkt.getCena());
            objednavkaProdukt.setPocetKusu(Integer.parseInt(req.getParameter("pocet["+item.getKey()+"]")));
            ObjednavkaService.saveObjednavkaProdukt(objednavkaProdukt);
        }
        
        req.setAttribute("title", "Objednávka dokončena");
        req.setAttribute("view", "objednavka_odeslano");
        req.setAttribute("objednavka", objednavka);
    }
    
}
