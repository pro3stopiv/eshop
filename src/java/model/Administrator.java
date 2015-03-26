/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author baresja1
 */
public class Administrator {
    private int idAdministrator;
    private String login;
    private String heslo;

    public Administrator() {
    }

    public Administrator(int idAdministrator, String login, String heslo) {
        this.idAdministrator = idAdministrator;
        this.login = login;
        this.heslo = heslo;
    }

    public void setIdAdministrator(int idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public int getIdAdministrator() {
        return idAdministrator;
    }

    public String getLogin() {
        return login;
    }

    public String getHeslo() {
        return heslo;
    }
    
    
}
