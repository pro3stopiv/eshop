/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author Roman
 */
public class ZpusobDoruceniService {
    
    public static List<ZpusobDoruceni> getAllZpusobyDoruceni() throws SQLException, ClassNotFoundException{
        List<ZpusobDoruceni> zpusoby = new ArrayList<>();

        PreparedStatement ps = db.DB.getConnection().prepareStatement("select ID_ZpusobDoruceni, NazevZpusobu, CenaDoruceni from ZpusobDoruceni");
        ResultSet rs = ps.executeQuery();
      
        while (rs.next()) {
            zpusoby.add(new ZpusobDoruceni(rs.getInt("ID_ZpusobDoruceni"), rs.getString("NazevZpusobu"), rs.getDouble("CenaDoruceni")));
        }
        
        return zpusoby;
    }
    
    public static ZpusobDoruceni getZpusobDoruceniById(int id_zpusob) throws ClassNotFoundException, SQLException{
       PreparedStatement ps = db.DB.getConnection().prepareStatement("select ID_ZpusobDoruceni, NazevZpusobu, CenaDoruceni from ZpusobDoruceni where ID_ZpusobDoruceni = ?");
        ps.setInt(1, id_zpusob);
        ResultSet rs = ps.executeQuery();
        
        ZpusobDoruceni zpusob = new ZpusobDoruceni();
        
        while (rs.next()) {
            zpusob.setIdZpusobDoruceni(rs.getInt("ID_ZpusobDoruceni"));
            zpusob.setNazevZpusobu(rs.getString("NazevZpusobu"));
            zpusob.setCenaDoruceni(rs.getDouble("CenaDoruceni"));

        }
	
        return zpusob;
    }
    
    
     public static ZpusobDoruceni save(ZpusobDoruceni zpusob) throws ClassNotFoundException, SQLException, Exception{
       
        // udpate
        if(zpusob.getIdZpusobDoruceni()> 0){
            PreparedStatement ps = db.DB.getConnection().prepareStatement("update ZpusobDoruceni set NazevZpusobu = ?, CenaDoruceni = ? where ID_ZpusobDoruceni = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, zpusob.getNazevZpusobu());
            ps.setDouble(2, zpusob.getCenaDoruceni());
            ps.setInt(3, zpusob.getIdZpusobDoruceni());
            ps.execute();
            return zpusob;
        }
        // insert
        else{
            PreparedStatement ps = db.DB.getConnection().prepareStatement("insert into ZpusobDoruceni (NazevZpusobu,CenaDoruceni) values(?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, zpusob.getNazevZpusobu());
            ps.setDouble(2, zpusob.getCenaDoruceni());
            ps.execute();
            
            int id = db.DB.getLastId(ps);
            
            zpusob = ZpusobDoruceniService.getZpusobDoruceniById(id);
            
            return zpusob;
        }
    }
     
    public static void delete(ZpusobDoruceni zpusob) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = db.DB.getConnection().prepareStatement("delete from ZpusobDoruceni where ID_ZpusobDoruceni = ?");
        ps.setInt(1, zpusob.getIdZpusobDoruceni());
        ps.execute();
    }
}
