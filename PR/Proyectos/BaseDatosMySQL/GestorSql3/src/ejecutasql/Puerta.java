package ejecutasql;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 * @author yo
 */
public class Puerta extends JFrame {
    //Atributos
    private JPanel contenido;
    private JComboBox basesDatosCb, tablasCB;
    private JScrollPane panelScroll;
    
    private JButton insetaBt, borrarBt;
//    
//    private JPanel insertaPn;
//    private JButton aceptaBt, cancelaBt;
//    
    private String[] bds={""}, tablas={""};
    private MyPatataSql sql;
    private Tabla tabla;
    private ResultSet tablaRs;
    
    //Constructor 
    public Puerta(){
        super("Visualizar Base de Datos");
        sql = new MyPatataSql();
        init();
    }
    
    public Puerta(String title){
        super(title);
        sql = new MyPatataSql();
        init();
    }
    
    public Puerta(String title, MyPatataSql sql){
        super(title);
        this.sql = sql;
        init();
    }
        
    // Init
        
    private void init(){
        bds = sql.listaBasesDatos();
        sql.conectarBd(bds[0]);
        tablas = sql.listaTablas();
        tablaRs = null;
        
        //Instanciamos Componentes
        contenido = new JPanel(null);
        basesDatosCb = new JComboBox(bds);
        tablasCB = new JComboBox(tablas);
        tabla = new Tabla();
        panelScroll = new JScrollPane(tabla.getTabla(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        insetaBt = new JButton("Insertar"); 
        borrarBt = new JButton("Borrar");
        
        //Configuramos Componentes
        //Posicionamiento
        basesDatosCb.setBounds(20, 20, 200, 30);
        tablasCB.setBounds(250, 20, 200, 30);
        panelScroll.setBounds(20, 80, 430, 300);
        insetaBt.setBounds(40, 400, 100, 25);
        borrarBt.setBounds(270, 400, 100, 25);
        
        //Config Init
        basesDatosCb.setSelectedIndex(0);
        
        //Config Ventana
        this.setSize(480, 470);
        this.setResizable(false);
        contenido.setBackground(Color.white);
        this.setContentPane(contenido);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension tamañoVentana = getSize();
            setLocation(new Point((tamañoPantalla.width - tamañoVentana.width) / 2,
                              (tamañoPantalla.height - tamañoVentana.width) / 2));
        
        //Añadimos
        contenido.add(basesDatosCb);
        contenido.add(tablasCB);
        contenido.add(panelScroll);
        contenido.add(insetaBt);
        contenido.add(borrarBt);
        
        //Escuchamos eventos
        insetaBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaInsertar v = new VentanaInsertar(Puerta.this, tabla.getCabecera(), tablaRs);
                String[] datos = v.insertDatos();
                sql.insertarDatos(tablaRs, datos);
                tabla.insertRow(datos);
            }
        });
        
        borrarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int r = tabla.getSelectedRow();
                tabla.deleteRow(r);
                sql.deleteRowFromTable(tablaRs, r+1);
            }
        });
        
        tabla.setTableChangeListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent evt){
                System.out.println("Tipo de Table Changed: "+evt.getType());
                if(evt.getType()==0){//For update
                    int row = evt.getFirstRow();
                    int col = evt.getColumn();
                    System.out.println("\tTableRow; "+row+", Column; "+col);
                    if(sql.updateCell(tablaRs, col, row, tabla.getCellData(col, row))){
                        System.out.println("Weeeeeeeeeeeeeeeeeeeeeeee");
                    }else{
                        JOptionPane.showMessageDialog(Puerta.this, 
                                "Error al Modificar dato erroneo", 
                                "¡¡¡ERROR CAZURRO!!!", 
                                JOptionPane.ERROR_MESSAGE);
                    }
                        
                }
            }
        });
                
        basesDatosCb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizaBDS();
            }
        });
        
        tablasCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizaTabla();
            }
        });
        
        actualizaBDS();
                
        //Ponemos visible la ventanas
        this.setVisible(true);
        
    }
    
    //Metodos
    
    public void actualizaBDS(){
        sql.conectarBd(bds[basesDatosCb.getSelectedIndex()]);
        tablasCB.setModel(new DefaultComboBoxModel(sql.listaTablas()));
        tablas = sql.listaTablas();
        actualizaTabla();
    }
    
    public void actualizaTabla() {
        int n = tablasCB.getSelectedIndex();
        if(n>=0){
            try{
            if(tablaRs!= null)
                tablaRs.close();
            }catch(SQLException e){
                System.out.println(""+e);
            }
            String tabla = tablas[n];
            tablaRs = sql.getRsTabla(tabla);
            this.tabla.rentablaLaTabla(sql.getColumnsNames(tablaRs), sql.getRawData(tablaRs));
        }
    }  
    
//------------------------------------------------------------------------------    
    
    private class VentanaInsertar extends JDialog{
        //Atributos
        private JScrollPane scrollPn;
        private JPanel contenido;
        private JLabel[] nombresLb;
        private JTextField[] insertaDatosTf;
        private JButton aceptBt, cancelBt;
        
        private String[] cabecera;
        private ResultSet tabla;
        private String[] datos;
        
        //Constructores e init
        public VentanaInsertar(JFrame padre, String[] cabecera, ResultSet tabla){
            super(padre, "Insertar nuevos datos", true);
            this.cabecera = cabecera;
            this.tabla = tabla;
            init();
        }
        
        private void init(){
            //Instanciamos componentes
            contenido = new JPanel(null);
            scrollPn = new JScrollPane(contenido, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            nombresLb = new JLabel[cabecera.length];
            insertaDatosTf = new JTextField[cabecera.length];
            aceptBt = new JButton("Aceptar");
            cancelBt = new JButton("Cancelar");
            
            //Configuramos Componentes
            //Posicionamiento
            scrollPn.setBounds(20, 20, 300, 300);
            aceptBt.setBounds(40, 340, 100, 20);
            cancelBt.setBounds(240, 340, 100, 20);
            
            //Configuracion Inicial
            for(int i=0; i<cabecera.length; i++){
                JLabel l = new JLabel(cabecera[i]);
                JTextField t = new JTextField();
                l.setBounds(10, (30*i)+10, 100, 20);
                l.setBackground(Color.white);
                l.setHorizontalAlignment(0);
                t.setBounds(120, (30*i)+10, 100, 20);
                t.setBackground(Color.white);
                t.setHorizontalAlignment(0);
                nombresLb[i] = l;
                insertaDatosTf[i] = t;
                contenido.add(l);
                contenido.add(t);
            }
            
            //Configuracion de la Ventana
            this.setSize(360, 390);
            //this.setResizable(false);
            this.setLayout(null);
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension tamañoVentana = getSize();
            setLocation(new Point((tamañoPantalla.width - tamañoVentana.width) / 2,
                              (tamañoPantalla.height - tamañoVentana.width) / 2));
            
            //Añadimos los componentes
            this.add(aceptBt);
            this.add(cancelBt);
            this.add(scrollPn);
            
            //Nos ponemos a la escucha
            aceptBt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if(compruebaTiposTabla()){
                        System.out.println("Todo Correcto");
                        Puerta.VentanaInsertar.this.setVisible(false);
                    }else
                        System.out.println("Inserta datos correctos");
                }
            });
            
            cancelBt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    sureExit();
                }
            });
            
            this.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    sureExit();
                }
            });
            
            //Abrimos la ventana
            //this.setVisible(true); // Era broma :)
        }
        
        //Metodos
        private void sureExit(){
            if(JOptionPane.showConfirmDialog(Puerta.this, "¿Seguro que quiere salir sin guardar?", "Nos Vamos ...", JOptionPane.YES_NO_OPTION)==0){
                this.setVisible(false);
            }
        }
        
        public String[] insertDatos(){
            datos= new String[insertaDatosTf.length];
            this.setVisible(true);
            return datos;
        }
        
        public boolean compruebaTiposTabla(){
            boolean c=false;
            try {                 
                ResultSetMetaData m = tabla.getMetaData();
                for(int i=0; i<insertaDatosTf.length; i++){
                    System.out.println(""+m.getColumnClassName(i+1));
                    if(tipoCorrecto(m.getColumnClassName(i+1), insertaDatosTf[i].getText())){
                        insertaDatosTf[i].setBackground(Color.white);
                        datos[i] = insertaDatosTf[i].getText();
                        c = true;
                    }else{
                        insertaDatosTf[i].setBackground(Color.red);
                        c = false;
                    }
                }
            } catch (SQLException ex) {System.out.println(""+ex);}
            return c;
        }
        
        public boolean tipoCorrecto(String tipo, String valor){
            boolean c=false;
            if(tipo.compareToIgnoreCase("java.lang.Long")==0){
                try {
                    Long.parseLong(valor);
                    c=true;
                } catch (Exception e) {
                    System.out.println("Parse error");
                }
            }else if(tipo.compareToIgnoreCase("java.lang.Integer")==0){
                try {
                    Integer.parseInt(valor);
                    c=true;
                } catch (Exception e) {
                    System.out.println("Parse error");
                }
            }else if(tipo.compareToIgnoreCase("java.math.BigDecimal")==0){
                try {
                    Double.parseDouble(valor);
                    c=true;
                } catch (Exception e) {
                    System.out.println("Parse error");
                }
            }else if(tipo.compareToIgnoreCase("java.sql.Date")==0){
                try {
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    fmt.parse(valor);
                    c=true;
                } catch (Exception e) {
                    System.out.println("Parse error");
                }
            }else
                c=true;
            return c;
        }
        
    }//End VentanaInsertar :) 

}// End Puerta
