package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    private static Connection connection;

    public static Connection getConnection() {
        if(connection == null){
            try {
                String url = "jdbc:mysql://localhost:3306/pro3_stopiv";
                String user = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
    
    public static String getVersion() {

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
}