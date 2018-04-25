package ejecutasql;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author yo
 */
public class Puerta extends JFrame {
    //Atributos
    private JPanel contenido;
    private JComboBox basesDatosCb, tablasCB;
    private JScrollPane panelScroll;
    
    private String[] bds={""}, tablas={""};
    private MyPatataSql sql;
    private JTable tabla;
    
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
                       
        //Instanciamos Componentes
        contenido = new JPanel(null);
        basesDatosCb = new JComboBox(bds);
        tablasCB = new JComboBox(tablas);
        tabla = new JTable();
        panelScroll = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //Configuramos Componentes
        //Posicionamiento
        basesDatosCb.setBounds(20, 20, 200, 30);
        tablasCB.setBounds(250, 20, 200, 30);
        panelScroll.setBounds(20, 80, 430, 300);
        
        //Config Init
        basesDatosCb.setSelectedIndex(0);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
        
        //Config Ventana
        this.setSize(480, 450);
        contenido.setBackground(Color.white);
        this.setContentPane(contenido);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension tamañoVentana = getSize();
            setLocation(new Point((tamañoPantalla.width - tamañoVentana.width) / 2,
                              (tamañoPantalla.height - tamañoVentana.width) / 2));
        
        //Añadimos
        contenido.add(basesDatosCb);
        contenido.add(tablasCB);
        contenido.add(panelScroll);
        
        //Escuchamos eventos
        tabla.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Property change7");
            }
        });
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                int n = JOptionPane.showConfirmDialog(Puerta.this, "¿Seguro que quiere salir?","Nos Vamos ...", JOptionPane.YES_NO_OPTION);
                if(n==0){
                    sql.salir();
                    System.exit(0);
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
    
    public void actualizaTabla(){
        try{
            tabla.removeAll();
            int n = tablasCB.getSelectedIndex();
            if(n>=0){
                String tabla = tablas[n];
                ResultSet rs = sql.executeQuerry("select * from "+tabla);
                this.tabla.setModel(new DefaultTableModel(sql.getRawData(rs), sql.getColumnsNames(rs)));
            }
        }catch(SQLException s){
            System.out.println(""+s);
        }
    }
    
}
