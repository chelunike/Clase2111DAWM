/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbventasempart;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author prg
 */
public class DBVentasEmpArt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MySQL.conectar("pepe", "pepa", "depemp");

        String sql = "SELECT idEmp,v.idArt,nombre, ppu, unidades, unidades*ppu importe , fecha "
                    + "from ventas v inner join articulos a on a.idArt= v.idArt"
                    + " order by idemp, v.idArt";
        
        
        

        MySQL.ejecutaConsulta(sql);
        ResultSet rs = MySQL.getDatos();
        ResultSetMetaData meta = MySQL.getMetaDatos();
        printRS(rs, meta);
       
        totalizaIdEmpIdArt(rs);
        


    }

    public static void printRS(ResultSet rs, ResultSetMetaData meta) {//throws SQLException 

        try {
            int nCol = meta.getColumnCount();
            String[] nombreColumnas = new String[nCol];
            String[] tipoColumnas = new String[nCol];
            Object[] valColumnas = new Object[nCol];
            for (int i = 0; i < nCol; i++) {
                nombreColumnas[i] = meta.getColumnName(i + 1);
                tipoColumnas[i] = meta.getColumnTypeName(i + 1);
            }

            for (int i = 0; i < nCol; i++) {
                System.out.print(nombreColumnas[i] + "[" + tipoColumnas[i] + "]\t");

            }
            System.out.println("");

            rs.beforeFirst();
            while (rs.next()) {

                for (int i = 0; i < nCol; i++) {
                    valColumnas[i] = rs.getObject(i + 1);
                }

                for (int i = 0; i < nCol; i++) {
                    System.out.print(valColumnas[i].toString());
                    System.out.print("\t\t");
                }
                System.out.println("");
            }

            System.out.println();

        } catch (SQLException ex) {
            System.out.println("Error sql " + ex.getMessage());

        }

    }//end printRs()

  
    
    
    
    
    public static void totalizaIdEmpIdArt(ResultSet rs) {
        ArrayList<EmpleadoArticuloTotal> datos = new ArrayList<EmpleadoArticuloTotal>();

        try {

        double totalEmp;
        double totalArt;
        int idEmpAux = 0;
        int idArtAux = 0;
        rs.beforeFirst();
        boolean bueno = rs.next();
        while (bueno) {
            totalEmp = 0;
            idEmpAux = rs.getInt("idEmp");
            EmpleadoArticuloTotal empTot = new EmpleadoArticuloTotal(idEmpAux);
            while (bueno && idEmpAux == rs.getInt("idEmp")) {        
//                totalEmp += rs.getDouble("importe");
                totalArt = 0;
                idArtAux = rs.getInt("idart");
                while (bueno && idEmpAux == rs.getInt("idEmp")&& idArtAux == rs.getInt("idArt")) {
                    totalEmp += rs.getDouble("importe");
                    totalArt += rs.getDouble("importe"); 
                    bueno = rs.next();
                }
               
                ArticuloTotal arTot = new ArticuloTotal(idArtAux,totalArt);
                empTot.insertaArticuloTotal(arTot);
            }
            datos.add(empTot);
           
            System.out.println("");
        }
        
            System.out.println("---");

            for (EmpleadoArticuloTotal arTot : datos) {
                System.out.println(arTot.toString());
            }

        } catch (SQLException ex) {
            System.out.println("Error sql " + ex.getMessage());

        }
    }

    public static void escribeArrayList(ArrayList<Object> datos){
        System.out.println("Desde escribeArrayList");
        for (Object o:datos)
                System.out.println(o.toString());
        
     
        
    }
}
