package ejecutasql;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 * @author yo
 */
public class Ventanilla implements ActionListener{
    //Atributos
    private MyPatataSql sql;
    
    private JFrame ventana;
    private JPanel contenido;
    
    private JTextArea inputTextoJt;
    private JTextArea outputTextoJt;
    private JScrollPane inputPn;
    private JScrollPane outputPn;
    
    private JButton runBt; 
    private JLabel statusLb;
    
    private JMenuBar menuJ;
    private JMenuItem archivoMenu;
    
    //Constructor e init
    public Ventanilla(MyPatataSql sql){
        this.sql = sql;
        init();
    }
    
    private void init(){
        //Instanciamos componentes
        ventana = new JFrame("MyPotato SQL Server Manager :) ");
        contenido = new JPanel();
        
        inputTextoJt = new JTextArea();
        outputTextoJt = new JTextArea();
        inputPn = new JScrollPane(inputTextoJt, 20, 31);
        outputPn = new JScrollPane(outputTextoJt, 21, 31);
        
        runBt = new JButton("Corre SQL como el viento :)");
        statusLb = new JLabel("Aviso: ");
        
        menuJ = new JMenuBar();
        archivoMenu = new JMenuItem("Archivo");
        //Configuramos Componentes
        // - TextArea
        inputTextoJt.setWrapStyleWord(true);
        outputTextoJt.setWrapStyleWord(true);
        
        // - Botones
        runBt.setBackground(Color.green);
        
        // - Label   
        
        // - Posicionamiento
        inputPn.setBounds(10, 10, 300, 200);
        outputPn.setBounds(10, 250, 300, 200);
        runBt.setBounds(60, 220, 200, 20);
        statusLb.setBounds(10, 460, 300, 20);
        
        //Paneles y Ventana
        contenido.setLayout(null);
        ventana.setContentPane(contenido);
        ventana.setSize(340, 520);
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Añadimos las cosas
        contenido.add(runBt);
        contenido.add(inputPn);
        contenido.add(outputPn);
        contenido.add(statusLb);
        
        //Nos poenemos a escuchar
        runBt.addActionListener(this);
        
        ventana.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                sql.cerrarConexion();
                System.exit(0);
            }
        });
        
        
        //Activamos la ventana
        ventana.setVisible(true);
        
    }
    
    //Metodos
    public void añadirSalida(String cad){
        String tmp=outputTextoJt.getText();
        outputTextoJt.setText(tmp+cad);
    }
    
    // -- -- Metodos del Actiion Listener -- -- 
    @Override
    public void actionPerformed(ActionEvent e) {
        String s="";
        if(inputTextoJt.getSelectedText()==null)
            s = inputTextoJt.getText();
        else
            s = inputTextoJt.getSelectedText();
        añadirSalida(sql.executeSQL(s));
    }
    
    public class InitDialog{
        //Atributos
        private JFrame padre;
        //private Exception Suegra;
        private JDialog ventanilla;
        private JLabel gbdLb, userLb, passLb;
        private JComboBox gbdCb;
        private JTextField userJt, passJt;
        
        //Constructor
        public InitDialog(JFrame padre){
            this.padre = padre;
            init();
        }
        
        public void init(){
            //Instanciamos los componentes
            ventanilla = new JDialog(padre, true);
            
            
        }
        
        //Metodos
        
    }
}
