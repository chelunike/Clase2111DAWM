/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbventasempart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prg
 */
public class MySQL {
    // DDBC driver name and database URL

    static final String DDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
// Database credentials
//    static final String USER = "pepe";
//    static final String PASS = "pepa";
    static private ResultSetMetaData meta;
    static private ResultSet rs;
    static private Connection conn;
    static private Statement stmt;

    public static boolean conectar(String user, String pass, String bd) {
//         Connection conn = null;
        try {
            Class.forName(DDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL + bd, user, pass);
            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException se) {
            System.out.println("Error conectando " + se.getMessage());
            return false;
        }
        return true;
    }

    public static boolean ejecutaConsulta(String sql) {
        try {
            rs = stmt.executeQuery(sql);
            meta = rs.getMetaData();
            return true;
        } catch (SQLException se) {
            System.out.println("Error consulta: " + se.getMessage());
            return false;
        }

    }

    public static int ejecutaConsultaAccion(String sql) {

        try {
            return stmt.executeUpdate(sql);

        } catch (SQLException se) {
            System.out.println("Error consulta: " + se.getMessage());
            return -1;

        }

    }

    public static boolean cierraConexion() {

        try {
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public static ResultSet getDatos(){
        return rs;
    }
    
    public static ResultSetMetaData getMetaDatos(){
        return meta;
    }

}
