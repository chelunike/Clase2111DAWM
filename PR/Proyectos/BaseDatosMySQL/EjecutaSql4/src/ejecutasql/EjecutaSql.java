package ejecutasql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author yo
 */
public class EjecutaSql {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola :) ");
        MyPatataSql sql = new MyPatataSql("192.168.211.199", "pepe", "pepa");
        //MyPatataSql sql = new MyPatataSql();
        
        sql.conectarBd("departEmp18");
        
        /*
        //Totalizar Presios Articulo
        try {
            ResultSet rs = sql.executeQuerry("SELECT idEmp,v.idArt,nombre, ppu, "
                    + "unidades, unidades*ppu importe , fecha "
                    + "from ventas v inner join articulos a "
                    + "on a.idArt= v.idArt "
                    + "order by v.idart");
            totalizaIdArt(rs);
        } catch (SQLException s) {
            System.out.println("Totaliza 1: " + s);
        }
                
        //Totalizar Presios 2 Articulo
        try {
            ResultSet rs = sql.executeQuerry("SELECT idEmp,v.idArt,nombre, ppu, "
                    + "unidades, unidades*ppu importe , fecha "
                    + "from ventas v inner join articulos a "
                    + "on a.idArt= v.idArt "
                    + "order by v.idart");
            totalizaIdArt2(rs);
        } catch (SQLException s) {
            System.out.println("Totaliza 1: " + s);
        }
        
        //Totalizar Empleados
        try {
            ResultSet rs = sql.executeQuerry("SELECT idEmp,v.idArt,nombre, ppu, unidades, unidades*ppu importe , fecha "
                    + "from ventas v inner join articulos a "
                    + "on a.idArt= v.idArt"
                    + " order by idemp");
            totalizaIdEmp(rs);
        } catch (SQLException s) {
            System.out.println("Totaliza 2: " + s);
        }
        
        //Totalizar Empleados 2
        try {
            ResultSet rs = sql.executeQuerry("SELECT idEmp,v.idArt,nombre, ppu, unidades, unidades*ppu importe , fecha "
                    + "from ventas v inner join articulos a "
                    + "on a.idArt= v.idArt"
                    + " order by idemp");
            totalizaIdEmp2(rs);
        } catch (SQLException s) {
            System.out.println("Totaliza 2.2: " + s);
        }
        
        */
        //Totalizar Todo
        try {
            ResultSet rs = sql.executeQuerry("SELECT idEmp,v.idArt,nombre, ppu, unidades, unidades*ppu importe , fecha"
                    + "	from ventas v inner join articulos a"
                    + "	on a.idArt= v.idArt"
                    + "	order by idemp, v.idArt");
            totalizaTodo2(rs);
        } catch (SQLException s) {
            System.out.println("Totaliza 3  : " + s);
        }
        
        //Totalizar Todo 2
        try {
            ResultSet rs = sql.executeQuerry("SELECT idEmp,v.idArt,nombre, ppu, unidades, unidades*ppu importe , fecha"
                    + "	from ventas v inner join articulos a"
                    + "	on a.idArt= v.idArt"
                    + "	order by idemp, v.idArt");
            totalizaTodo3(rs);
        } catch (SQLException s) {
            System.out.println("Totaliza 3  : " + s);
        }
        
        sql.salir();

    }

    public static void totalizaIdArt(ResultSet rs) throws SQLException {
        double total = 0;
        int idArtAux = 0;
        rs.beforeFirst();
        boolean bueno = rs.next();
        while (bueno) {
            total = 0;
            idArtAux = rs.getInt("idArt");
            while (bueno && idArtAux == rs.getInt("idArt")) {
                total += rs.getDouble("importe");
                bueno = rs.next();
            }
            System.out.println("idArt: " + idArtAux + " Total: " + total);
        }
        System.out.println("");
    }

    public static void totalizaIdEmp(ResultSet rs) throws SQLException {
        System.out.println("     --     Totaliza IdEmp 1    --  ");
        double total = 0;
        int idTmp = 0;
        rs.beforeFirst();
        boolean bueno = rs.next();
        while (bueno) {
            total = 0;
            idTmp = rs.getInt("idEmp");
            while (bueno && idTmp == rs.getInt("idEmp")) {
                total += rs.getDouble("importe");
                bueno = rs.next();
            }
            System.out.println("idEmp: " + idTmp + " Total: " + total);
        }
        System.out.println("");
    }
    
    public static void totalizaIdEmp2   (ResultSet rs) throws SQLException {
        System.out.println("     --     Totaliza IdEmp 2    --  ");
        rs.last();
        double[] total = new double[rs.getInt("idEmp")];
        int idTmp = 0;
        rs.beforeFirst();
        boolean bueno = rs.next();
        while (bueno) {
            idTmp = rs.getInt("idEmp");
            while (bueno && idTmp == rs.getInt("idEmp")) {
                total[idTmp-1] += rs.getDouble("importe");
                bueno = rs.next();
            }
        }
        for(int i=0; i<total.length; i++)
            if(total[i]>0)
                System.out.println("IdEmp: "+(i+1)+" Total: "+total[i]);
        System.out.println("");
    }

    public static void totalizaTodo(ResultSet rs) throws SQLException {
        double importe = 0;
        int emp = 0, art = 0;
        rs.beforeFirst();
        boolean bueno = rs.next();
        while (bueno) {
            importe = 0;
            emp = rs.getInt("idEmp");
            art = rs.getInt("idArt");
            while (bueno && (emp == rs.getInt("idEmp") && art == rs.getInt("idArt"))) {
                importe += rs.getDouble("importe");
                bueno = rs.next();
            }
            System.out.println("idEmp: " + emp + " IdArt: " + art + " Total: " + importe);
        }
        System.out.println("");
    }
    
    public static void totalizaTodo2(ResultSet rs) throws SQLException {
        double importe = 0, total=0;
        int emp = 0, emp2=0, art = 0;
        rs.beforeFirst();
        boolean bueno = rs.next();
        while (bueno) {
            total = 0;
            emp = rs.getInt("idEmp");
            System.out.println("Empleado: "+emp);
            while(bueno && emp == rs.getInt("idEmp")){
                importe = 0;
                art = rs.getInt("idArt");
                while (bueno && (emp == rs.getInt("idEmp") &&  art == rs.getInt("idArt"))) {
                    importe += rs.getDouble("importe");
                    bueno = rs.next();
                }
                total += importe;
                System.out.println("\tIdArt: " + art + " Total: " + importe);
            }
            System.out.println("Total: "+total);
        }
        System.out.println("");
    }
    
    
    public static void totalizaIdArt2(ResultSet rs) throws SQLException{
        boolean bueno = rs.last();
        double[] importes = new double[rs.getInt("idArt")];
        rs.beforeFirst();
        bueno = rs.next();
        while(bueno){
            importes[rs.getInt("idArt")-1] += rs.getDouble("importe");
            bueno = rs.next();
        }
        for(int i=0; i<importes.length; i++)
            if(importes[i]!=0)
                System.out.println("IdArt: "+(i+1)+" Importe: "+importes[i]);
    }
    
    public static void totalizaTodo3(ResultSet rs) throws SQLException{
        ArrayList <EmpleadoArtImp> lista = new ArrayList();
        int idEmp = 0, idArt=0;
        rs.beforeFirst();
        boolean bueno = rs.next();
        while(bueno){
            idEmp = rs.getInt("idEmp");
            idArt = rs.getInt("idArt");
            EmpleadoArtImp emp = new EmpleadoArtImp(idEmp, rs.getInt("idArt"), 0);
            lista.add(emp);
            while(bueno && idEmp == rs.getInt("idEmp") && idArt == rs.getInt("idArt")){
                emp.sumImporte(rs.getDouble("importe"));
                bueno = rs.next();
            }
        }
        System.out.println(""+EjecutaSql.arrayToString(lista));
    }
    
    public static String arrayToString(Object[] a){
        String s="";
        for(Object o:a)
            s += o.toString()+"\n";
        return s;
    }
    
    public static String arrayToString(ArrayList a){
        String s="";
        for(Object o:a)
            s += o.toString()+"\n";
        return s;
    }
    
}
