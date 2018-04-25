package ejecutasql;


import java.sql.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * @author yo
 */
public class MyPatataSql {
    //Atributos
        // DDBC driver name and database URL
    static String DDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/";
    public static String[] bdDefecto = {"localhost","192.168.211.199"};
        // Database credentials niño la pazzwork
    static String USER = "pepe";
    static String PASS = "pepa";
    static String defaultBd = "empleados";
    
    //STEP 1: Establecemos la conexion 
    private Connection conection = null;
    private Statement run;
    //Constructor
    
    private String dataBaseSelected;
    
    public MyPatataSql(){
        InitDialog id = new InitDialog();   
    }
    
    public MyPatataSql(String gbd, String user, String pass){
        DB_URL = "jdbc:mysql://"+gbd;
        USER = user;
        PASS = pass;
        init();
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
        
            dataBaseSelected = "";
            
        }catch (ClassNotFoundException ent){
            System.out.println("Fallo en driver");
            this.cerrarConexion();
        }catch(SQLException e){
            System.out.println(""+e);
            this.cerrarConexion();
            JOptionPane.showMessageDialog(null, "Error de conexion");
            System.exit(0);
        }
        
        //this.conectarBd("empleados");
    }
    
    //Metodos
    
    public String[] listaBasesDatos(){
        String[] lista=null;
        try{
            ResultSet rs = conection.getMetaData().getCatalogs();
            //System.out.println(""+printRs(rs));
            String[] tmp = printRs(rs).split("\n");
            lista = new String[tmp.length-1];
            for(int i=0; i<lista.length; i++)
                lista[i] = tmp[i+1];
        }catch(SQLException e){
            System.out.println(""+e);
        }
        return lista;
    }
    
    public String[] listaTablas(){
        String[] lista=null;
        try{
            if(dataBaseSelected.compareToIgnoreCase("")!=0){
                ResultSet rs = run.executeQuery("show tables;");
                //System.out.println(""+printRs(rs));
                String[] tmp = printRs(rs).split("\n");
                lista = new String[tmp.length-1];
                for(int i=0; i<lista.length; i++)
                    lista[i] = tmp[i+1];
            }
        }catch(SQLException e){
            System.out.println("ListaTablas: "+e);
        }
        return lista;
    }
    
    public ResultSet executeQuerry(String code) throws SQLException{
        return run.executeQuery(code);
    }
    
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
    
    public boolean ejecOnly(String code){
        try {
                return run.execute(code);
            } catch (SQLException ex) {
                System.out.println(""+ex);
                return false;
            }
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
    
    public String printRs(ResultSet rs){
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
                   result += (valColumnas[i]==null?"NULL":valColumnas[i].toString())+"\t";
                }
                result += "\n";
            }
        }catch(SQLException e){
            result += e.getMessage()+"\n";
        }
        return result;
    }
    
    public String[] getColumnsNames(ResultSet rs){
        String[] result =null;
        try{
            ResultSetMetaData meta = rs.getMetaData();
            int nCol = meta.getColumnCount();
            result = new String[nCol];
            for (int i = 0; i < nCol; i++) {
                result[i] = meta.getColumnName(i + 1);
            }            
        }catch(SQLException e){
            System.out.println(""+e.getMessage());
        }
        return result;
    }
    
    public String[][] getRawData(ResultSet rs){
        String[][] result=null;
        try{
            ResultSetMetaData meta = rs.getMetaData();
            int nCol = meta.getColumnCount();
            int nRow = 0;
            String[] nombreColumnas = getColumnsNames(rs);
            rs.beforeFirst();
            while(rs.next())
                nRow++;
            rs.beforeFirst();
            result = new String[nRow][nCol];
            for (int i=0; rs.next() && i<nRow; i++){
                for (int j=0; j<nCol; j++){
                    Object obj = rs.getObject(nombreColumnas[j]);
                    result[i][j] = (obj==null?"Nada":obj.toString());
                }
            }
            /*
            for (int i=0; i<result.length; i++){
                for (int j=0; j<result[i].length; j++){
                    System.out.print(result[i][j]+"\t");
                }
                System.out.println("");
            }
            */
        }catch(SQLException e){
            System.out.println(""+e.getMessage());
        }
        return result;
    }
    
    public ResultSet getRsTabla(String nombreTabla){
        ResultSet rs = null;
        if(dataBaseSelected.compareTo("")!=0){
            try{
                rs = executeQuerry("select * from "+nombreTabla);
                return rs;
            }catch(SQLException s){
                System.out.println(""+s);
            }
        }
        return rs;
    }
    
    public boolean deleteRowFromTable(String tabla, int row){
        boolean c = true;
        if(dataBaseSelected.compareTo("")!=0){
            try{
                ResultSet rs = executeQuerry("select * from "+tabla);
                rs.absolute(row);
                rs.deleteRow();
                rs.close();
            }catch(SQLException s){
                System.out.println(""+s);
                c= false;
            }
        }
        return c;
    }
    
    public boolean deleteRowFromTable(ResultSet tabla, int row){
        boolean c = true;
        if(dataBaseSelected.compareTo("")!=0){
            try{
                tabla.absolute(row);
                tabla.deleteRow();
            }catch(SQLException s){
                System.out.println(""+s);
                c= false;
            }
        }
        return c;
    }
    
    public boolean insertarDatos(ResultSet tabla, String[] datos){
        boolean c = true;
        try{
            tabla.moveToInsertRow();
            for(int i=1; i<=tabla.getMetaData().getColumnCount(); i++){
                tabla.updateString(i, datos[i-1]);
            }
            tabla.insertRow();
        }catch(SQLException s){
            System.out.println(""+s);
            c= false;
        }
        return c;
    }
    
    public boolean updateCell(ResultSet tabla, int col, int row, String dato){
        try{
            tabla.absolute(row+1);
            tabla.updateString(col+1, dato);
            tabla.updateRow();
            return true;
        }catch(SQLException s){
            return false;
        }
    }
    
    public void conectarBd(String nombreBd){
        this.ejecOnly("use "+nombreBd);
        dataBaseSelected = nombreBd;
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
    
    public void salir(){
        this.cerrarConexion();
        System.exit(0);
    }


public class InitDialog{
        //Atributos
        private JFrame padre;
        //private Exception Suegra;
        private JDialog ventanilla;
        private JPanel contenido;
        private JLabel gbdLb, userLb, passLb;
        private JComboBox gbdCb;
        private JTextField userJt;
        private JPasswordField passJt;
        private JButton conectBt;
        
        private String gbd, user, pass;
        
        //Constructor
        public InitDialog(){
            this.padre = null;
            inicializar();
        }
        
        public InitDialog(JFrame padre){
            this.padre = padre;
            inicializar();
        }
        
        public void inicializar(){
            //Instanciamos los componentes
            ventanilla = new JDialog((JFrame)null, true);
            contenido = new JPanel();
            gbdLb = new JLabel("Base de Datos: ");
            userLb = new JLabel("Usuario: ");
            passLb = new JLabel("Contraseña: ");
            gbdCb = new JComboBox(MyPatataSql.bdDefecto);
            userJt = new JTextField();
            passJt = new JPasswordField();
            conectBt = new JButton("Conectar");
            
            gbd=""; user=""; pass="";
            
            //Configuramos Componentes
            // -- Configuracion Inicial
            gbdCb.setEditable(true);
            userJt.setText("pepe");
            passJt.setText("pepa");
            
            // -- Posicionamiento
            gbdLb.setBounds(10, 10, 100, 20);
            gbdCb.setBounds(120, 10, 100, 20);
            userLb.setBounds(10, 40, 100, 20);
            userJt.setBounds(120, 40, 100, 20);
            passLb.setBounds(10, 70, 100, 20);
            passJt.setBounds(120, 70, 100, 20);
            conectBt.setBounds(55, 100, 100, 20);
            
            //Ventana y Paneles
            ventanilla.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            ventanilla.setTitle("Datos para conectar");
            contenido.setLayout(null);
            ventanilla.setSize(240, 200);
            ventanilla.setContentPane(contenido);
            ventanilla.setAutoRequestFocus(true);
            ventanilla.setAlwaysOnTop(true);
            // Centramos la ventana
            Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension tamañoVentana = ventanilla.getSize();
            ventanilla.setLocation(new Point((tamañoPantalla.width - tamañoVentana.width) / 2,
                              (tamañoPantalla.height - tamañoVentana.width) / 2));
            
            //Añadimos componentes
            contenido.add(gbdLb);
            contenido.add(gbdCb);
            contenido.add(userLb);
            contenido.add(passLb);
            contenido.add(userJt);
            contenido.add(passJt);
            contenido.add(conectBt);
            
            //Nos Ponemos a escuchar
            conectBt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    gbd = (String)gbdCb.getSelectedItem();
                    user = userJt.getText();
                    pass = passJt.getText();
                    
                    gbdCb.setBackground(Color.white);
                    userJt.setBackground(Color.white);
                    passJt.setBackground(Color.white);
                    
                    boolean c = true;
                    if(gbd.equals("")){
                        c = false;
                        gbdCb.setBackground(Color.red);
                    }
                    if(user.equals("")){
                        c = false;
                        userJt.setBackground(Color.red);
                    }
                    if(pass.equals("")){
                        c = false;
                        passJt.setBackground(Color.red);
                    }
                    
                    if(c){
                        ventanilla.setVisible(false);
                        DB_URL = "jdbc:mysql://"+gbd+"/";
                        USER = user;
                        PASS = pass;
                        init();
                    }
                }
            });
            
            ventanilla.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    int n = JOptionPane.showConfirmDialog(ventanilla, "¿Seguro que quiere salir?","Nos Vamos antes de empezar", JOptionPane.YES_NO_OPTION);
                    if(n==0)
                        System.exit(0);
                }
            });
            
            //Mostramos ventana
            ventanilla.setVisible(true);
            
        }
        
        //Metodos


        
    }

}

