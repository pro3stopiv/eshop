package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection == null){
       //     try {

               /* String url = "jdbc:mysql://localhost:3306/dbs2?useUnicode=yes&characterEncoding=utf8";
                String user = "root";
                String password = "";*/
            
            
                String url = "jdbc:mysql://localhost:3306/pro3_stopiv?useUnicode=yes&characterEncoding=utf8";
                String user = "root";
                String password = "";
                
            /*    String url = "jdbc:mysql://edu.uhk.cz:3306/dbs2?useUnicode=yes&characterEncoding=utf8";
                String user = "dbs2";
                String password = "bsnetcsf";*/
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                connection.prepareStatement("set names utf8").execute();
         //   } catch (ClassNotFoundException ex) {
           //     Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
           // } catch (SQLException ex) {
            //    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
           // }
        }
        return connection;
    }
    
    public static String getVersion() throws ClassNotFoundException {

        Statement st = null;
        ResultSet rs = null;
 
        String version = "";

        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                version = rs.getString(1);
            }

        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(DB.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
            version = ex.getMessage();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(DB.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
                version = ex.getMessage();
            }
        }
        return version;
    }
    
    public static int getLastId(PreparedStatement ps) throws SQLException, Exception{
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        throw new Exception("Nelze ziskat posledni id");
    }
}