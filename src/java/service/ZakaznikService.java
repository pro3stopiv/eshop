/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import exceptions.ExceptionLogin;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Honza
 */
public class ZakaznikService {
    
    public static void login(HttpServletRequest request, String email, String password) throws SQLException, ExceptionLogin, NoSuchAlgorithmException, ClassNotFoundException{
        
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select id_zakaznik from Zakaznik where email = ? and heslo = ?");
        ps.setString(1, email);
        ps.setString(2, utils.Hash.getHash(password, "SHA-256"));
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            HttpSession session = request.getSession();
            session.setAttribute("auth_user", rs.getInt("id_zakaznik"));
        }else{
            throw new ExceptionLogin("Přihlášení se nepodařilo");
        }
        
    }
    
    public static void logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("auth_user");
    }
}
