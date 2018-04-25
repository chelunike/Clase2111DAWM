package ejecutasql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author yo
 */
public class MyPatataSql {
    //Atributos
        // DDBC driver name and database URL
    static String DDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/";

        // Database credentials niño la pazzwork
    static String USER = "pepe";
    static String PASS = "pepa";
    
    //STEP 1: Establecemos la conexion 
    private Connection conection = null;
    private Statement run;
    //Constructor
    public MyPatataSql(){
        init();
    }
    
    public MyPatataSql(String gbd, String user, String pass){
        DB_URL = "jdbc:mysql://"+gbd;
        USER = user;
        PASS = pass;
    }
    
    private void init(){
        try{
    //STEP 2: Register DDBC driver: que driver vamos a usar
	Class.forName(DDBC_DRIVER);
    //STEP 3: Open a connection: Nos conectamosç
	conection = DriverManager.getConnection(DB_URL, USER, PASS); 
	//pasamos url, user, pass
    //STEP 4: Execute a query to create statment with  required arguments. 
	run = conection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        }catch (ClassNotFoundException ent){
            System.out.println("Fallo en driver");
            this.cerrarConexion();
        }catch(SQLException e){
            System.out.println(""+e);
        }
        
        this.conectarBd("empleados");
    }
    
    //Metodos
    public String executeSQL(String code){
        String exit="";
        String[] statements = code.split(" ");
        for(String s: statements){
            if(s.compareToIgnoreCase("select")==0){
                exit += " --> Ejecutando consulta: \n";
                exit += ejecConsultas(code);
                return exit;
            }else if(s.compareToIgnoreCase("update")==0){
                exit += " --> Modificando datos: \n";
                exit += ejecUpdate(code);
                return exit;
            }else if(s.compareToIgnoreCase("insert")==0){
                exit += " --> Insertando Nuevos datos: \n";
                exit += ejecUpdate(code);
                return exit;
            }else if(s.compareToIgnoreCase("delete")==0){
                exit += " --> Eliminando datos: \n";
                exit += ejecUpdate(code);
                return exit;
            }else{
                exit += " --> Consulta no valida \n";
                return exit;
            }
            
        }
        return exit;
    }
    
    public String ejecConsultas(String code){
        String salida="";
        try {
                ResultSet rs = run.executeQuery(code);
                salida += this.printRs(rs)+"\n";
            } catch (SQLException ex) {
                salida +="\n ------ Error: -----\n"+ ex+"\n";
            }
        return salida;
    }
    
    public String ejecUpdate(String code){
        String salida="";
        try {
                int rs = run.executeUpdate(code);
                salida += " -> "+rs+" modificadas correctamente\n";
            } catch (SQLException ex) {
                salida +="\n ------ Error: -----\n"+ ex+"\n";
            }
        return salida;
    }
    
    private String printRs(ResultSet rs){
        String result ="";
        try{
            ResultSetMetaData meta = rs.getMetaData();
            int nCol = meta.getColumnCount();
            String[] nombreColumnas = new String[nCol];
            String[] tipoColumnas = new String[nCol];
            Object[] valColumnas = new Object[nCol];
            for (int i = 0; i < nCol; i++) {
                nombreColumnas[i] = meta.getColumnName(i + 1);
                tipoColumnas[i] = meta.getColumnTypeName(i + 1);
            }
            for (int i = 0; i < nCol; i++) {
                result += nombreColumnas[i] + "\t";//[" + tipoColumnas[i] + "]
            }
            result += "\n";
            rs.beforeFirst();
            while (rs.next()) {
                for (int i = 0; i < nCol; i++) {
                    valColumnas[i] = rs.getObject(i + 1);
                }
                for (int i = 0; i < nCol; i++) {
                   result += valColumnas[i].toString()+"\t";
                }
                result += "\n";
            }
        }catch(SQLException e){
            result += e.getMessage()+"\n";
        }
        return result;
    }
    
    private void conectarBd(String nombreBd){
        this.ejecConsultas("use "+nombreBd);
    }
    
    public void cerrarConexion(){
        if(conection != null)
            try {
                run.close();
                conection.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexion");
            }
    }
}
