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
import model.Administrator;
import model.Adresa;
import model.Zakaznik;

/**
 *
 * @author Honza
 */
public class AdministratorService {
    public static void login(HttpServletRequest request, String email, String password) throws SQLException, ExceptionLogin, NoSuchAlgorithmException, ClassNotFoundException{
        
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select id_administrator from Administrator where login = ? and heslo = ?");
        ps.setString(1, email);
        ps.setString(2, utils.Hash.getHash(password, "SHA-256"));
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            HttpSession session = request.getSession();
            Administrator administrator = getAdministratorById(rs.getInt("id_administrator"));
            session.setAttribute("admin_auth_user", administrator);
        }else{
            throw new ExceptionLogin("Přihlášení se nepodařilo");
        }
        
    }
    
    public static void logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("admin_auth_user");
    }
    
     
    public static Administrator getAdministratorById(int id) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = db.DB.getConnection().prepareStatement("select * from Administrator where id_administrator = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        Administrator administrator = new Administrator();
        
        while (rs.next()) {
            administrator.setIdAdministrator(rs.getInt("id_administrator"));
            administrator.setLogin(rs.getString("login"));
            administrator.setHeslo(rs.getString("heslo"));
        }
        
        return administrator;
        
    }
}
