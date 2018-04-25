/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimple_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class MySQL {

    static final String DDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/";
// Database credentials
    static String USER = "pepe";
    static String PASS = "pepa";
    static Statement stmt;
    static private ResultSet rs;
    static private ResultSetMetaData meta;
    static private Connection conex;
    //int numColumnas;

    public MySQL() {

    }

    public static void conecta(String user, String pass, String db) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Class.forName(DDBC_DRIVER);
            conex = DriverManager.getConnection(DB_URL + db, user, pass);
            stmt = conex.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    public static void cierra() {
        try {
            if (conex != null) {
                conex.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }

    public static boolean ejecutaConsulta(String sql) {
        try {
//        Statement stmt = conex.createStatement(
//        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //String sql = "SELECT id, first, fenac, age FROM empleados2";
            rs = stmt.executeQuery(sql);
            meta = rs.getMetaData();
            return true;
        } catch (SQLException se) {
//Handle errors for DDBC 
            // se.printStackTrace();
            return false;
        }

    }

    public static int ejecutaConsultaAccion(String sql) {
        try {
            Statement stmt = conex.createStatement();
            int filas = 0;

            //String sql = "SELECT id, first, fenac, age FROM empleados2";
            filas = stmt.executeUpdate(sql);

            return filas;
        } catch (SQLException se) {
//Handle errors for DDBC 
            // se.printStackTrace();
            return -1;
        }

    }

    public static void seleccionaBD(String baseDatos) {
//         Statement st = null;
        String queryUse = "use " + baseDatos;
        try {
//            stmt = conex.createStatement();
            stmt.executeUpdate(queryUse);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public static String[] getBDs() {

        // Connection serv = null;
//        Statement st = null;
        String[] bds = null;

        try {
            String query = "show databases";

            stmt = conex.createStatement();

            ResultSet res = stmt.executeQuery(query);

            //Obtenemos el numero de filas de la consulta
            res.last();
            int filas = res.getRow();
            bds = new String[filas];

            //Obtenemos el contenido
            int index = 0;
            res.beforeFirst();

            while (res.next()) {

                String bd_name = res.getString(1);

//                if (!bd_name.equals("information_schema")) {
                bds[index++] = bd_name;
//                }
            }

        } catch (SQLException e) {
        }

        return bds;

    }

    public static String[] getTablas(String database) {

        // Connection serv = null;
//        Statement st = null;
        String[] tablas = null;

        try {
            seleccionaBD(database);
//            String sql = "use "+ database;
            String query = "show tables";

            stmt = conex.createStatement();

//            ejecutaConsultaAccion(sql);
            ResultSet res = stmt.executeQuery(query);

            //Obtenemos el numero de filas de la consulta
            res.last();
            int filas = res.getRow();
            tablas = new String[filas];

            //Obtenemos el contenido
            int index = 0;
            res.beforeFirst();

            while (res.next()) {
                tablas[index++] = res.getString(1);
            }

        } catch (SQLException e) {
        }

        return tablas;

    }

    public static ResultSet getResultSet() {

        return rs;
    }

    public static String[] getColumnas() {
        String[] columnas = null;

        try {

            int numColumnas = meta.getColumnCount();
            columnas = new String[numColumnas];
            for (int i = 1; i <= numColumnas; i++) {
                columnas[i - 1] = meta.getColumnName(i);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return columnas;

    }

    //public Class[] getClases(){
    public static void getClases() {

        Class[] claseColumnas = null;

        try {

            int numColumnas = meta.getColumnCount();
            claseColumnas = new Class[numColumnas];
            rs.first();
            for (int i = 1; i <= numColumnas; i++) {
                //claseColumnas[i-1]=meta.getColumnClassName(i);
                claseColumnas[i - 1] = rs.getObject(i).getClass();
                System.out.println("clase-->>" + claseColumnas[i - 1]);

            }

        } catch (SQLException se) {
            se.printStackTrace();
        }

        // return claseColumnas;
    }

    public static String[] getCabecera() {

        String[] cabecera = null;
        try {
            int numColumnas = meta.getColumnCount();
            cabecera = new String[numColumnas];
            for (int i = 1; i <= numColumnas; i++) {
                cabecera[i - 1] = meta.getColumnName(i);
            }

            return cabecera;

        } catch (SQLException se) {
            se.printStackTrace();
            return cabecera;
        }

    }

    public static Object[][] getDatos() {

        Object[][] datos = null;
        int nFila = 0;

        try {
            rs.last();
            int cuantasFilas = rs.getRow();
            rs.beforeFirst();
            int cuantasColumnas = meta.getColumnCount();
            datos = new Object[cuantasFilas][cuantasColumnas];
            while (rs.next()) {
                // Se crea y rellena la fila para el modelo de la tabla.

                for (int i = 1; i <= cuantasColumnas; i++) {
                    datos[nFila][i - 1] = rs.getObject(i);
                }

                nFila++;
            }
            //rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return datos;
    }

    public Object[] getFilaDatos() {

        Object[] filaDatos = null;

        try {
            // Para cada registro de resultado en la consulta 
            //rs.absolute(fila );
            rs.last();
            int nCol = meta.getColumnCount();
            filaDatos = new Object[nCol];
            for (int i = 1; i <= nCol; i++) {
                filaDatos[i - 1] = rs.getObject(i);
            }

            //rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filaDatos;
    }

}
