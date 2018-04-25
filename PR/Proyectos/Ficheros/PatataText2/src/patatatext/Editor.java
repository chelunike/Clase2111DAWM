package patatatext;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author yo
 */
public class Editor extends JFrame{
    //Atributos / elementos
    private JPanel contentPn, menuPn;
    private JButton abrirBt, guardarBt, nuevoBt, salirBt;
    private JLabel fileLb, avisoLb;
    private JTextField fileJt;
    private JTextArea textoJt;
    private TextArea textoTa;
    private JScrollPane textoPn;
    
    private Fichero file;
    
    private int width, height;
    private static int minWidth=500, minHeight=800;
    private static String avisoInit = "Aviso: ";
    
    //Constructor
    public Editor(){
        width = Editor.minHeight;
        height = Editor.minWidth;
        init();
    }
    
    public Editor(int ancho, int alto){
        width = (ancho<minWidth)?minWidth:ancho;
        height = (alto<minHeight)?minHeight:alto;
        init();
    }
    
    //Inicializacion de los elementos
    
    public void init(){
        
        //Instanciamos Componentes
        contentPn = new JPanel(null);
        menuPn = new JPanel(null);
        
        abrirBt = new JButton("Abrir");
        guardarBt = new JButton("Guardar");
        nuevoBt = new JButton("Nuevo");
        salirBt = new JButton("Salir");
        fileLb = new JLabel("Fichero: ");
        avisoLb = new JLabel("Aviso: Iniciado Completado");
        fileJt = new JTextField();
        textoJt = new JTextArea();
        textoTa = new TextArea("", 20, 20, 1);
        textoPn = new JScrollPane(textoJt, 20, 31);
        textoPn.setBounds(0, 50, width-10, height-80);
        
        //Configuramos Componentes
        // --> Posicionar
        menuPn.setBounds(0, 0, width-10, 50);
        
        abrirBt.setBounds(0, 0, 100, 20);
        guardarBt.setBounds(100, 0, 100, 20);
        nuevoBt.setBounds(200, 0, 100, 20);
        salirBt.setBounds(width-110, 0, 100, 20);
        fileLb.setBounds(0, 30, 100, 20);
        avisoLb.setBounds(width-310, 30, 300, 20);
        fileJt.setBounds(100, 30, 200, 20);
        //textoJt.setBounds(0, 50, width-10, height-40);
        textoTa.setBounds(0, 50, width-10, height-80);
        
        // --> Configuracion
        salirBt.setEnabled(false);
        guardarBt.setEnabled(false);
        
        textoJt.setLineWrap(true);
        textoJt.setTabSize(4);
        textoJt.setBackground(Color.darkGray);
        Font f = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        textoJt.setFont(f);
        textoJt.setForeground(Color.white);
        
        //Configuramos la Ventana
        contentPn.setLayout(null);
        menuPn.setLayout(null);
        this.add(contentPn);
        this.setTitle("Patata Text V:1.0");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Añadimos Componentes
        menuPn.add(abrirBt);
        menuPn.add(guardarBt);
        menuPn.add(nuevoBt);
        menuPn.add(fileLb);
        menuPn.add(avisoLb);
        menuPn.add(fileJt);
        menuPn.add(salirBt);
        
        contentPn.add(menuPn);
        //contentPn.add(textoTa);
        contentPn.add(textoPn);
        
        //Los eventos y galas beneficas :)
        abrirBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                file = new Fichero(fileJt.getText());
                if(file.abrirFichero()){
                    textoJt.setEditable(true);
                    textoJt.setText(file.leerFichero());
                    avisoLb.setForeground(Color.black);
                    avisoLb.setText(avisoInit+"Archivo leido correctamente :)");
                    guardarBt.setEnabled(true);
                    salirBt.setEnabled(true);
                    fileJt.setEditable(false);
                    abrirBt.setEnabled(false);
                    nuevoBt.setEnabled(false);
                }else{
                    avisoLb.setForeground(Color.red);
                    avisoLb.setText(avisoInit+"Problema la abrir el archivo :( ");
                }
            }
        
        });
        /* -- esto es lo que quiere teacher, y hecho esta :) 
        nuevoBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                file = new Fichero(fileJt.getText());
                if(file.abrirFichero()){
                    textoJt.setEditable(true);
                    //textoJt.setText(file.leerFichero());
                    avisoLb.setForeground(Color.black);
                    avisoLb.setText(avisoInit+"Archivo leido correctamente :)");
                    guardarBt.setEnabled(true);
                    salirBt.setEnabled(true);
                    abrirBt.setEnabled(false);
                    nuevoBt.setEnabled(false);
                }else{
                    avisoLb.setForeground(Color.red);
                    avisoLb.setText(avisoInit+"Problema la abrir el archivo :( ");
                }
            }
        });
        */
        nuevoBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                file = new Fichero(fileJt.getText());
                if(file.nuevoFichero()){
                    textoJt.setEditable(true);
                    textoJt.setText(file.leerFichero());
                    avisoLb.setForeground(Color.black);
                    avisoLb.setText(avisoInit+"Archivo creado correctamente :)");
                    fileJt.setEditable(false);
                    guardarBt.setEnabled(true);
                    salirBt.setEnabled(true);
                    abrirBt.setEnabled(false);
                    nuevoBt.setEnabled(false);
                }else{
                    avisoLb.setForeground(Color.red);
                    avisoLb.setText(avisoInit+"Problemo al crear el archivo :( ");
                }
            }
        });
        
        guardarBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(file.escribirFichero(textoJt.getText())){
                    avisoLb.setForeground(Color.black);
                    avisoLb.setText(avisoInit+"Archivo guardado correctamente :)");
                }else{
                    avisoLb.setForeground(Color.red);
                    avisoLb.setText(avisoInit+"Problemo al guardar el archivo :( ");
                }
            }
        });
        
        salirBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Cierro el documento
                file.salirFichero();
                //Limpio los texto
                textoJt.setText("");
                //fileJt.setText(""); //Sin ganas de escribir
                //Botones
                guardarBt.setEnabled(false);
                salirBt.setEnabled(false);
                fileJt.setEditable(true);
                abrirBt.setEnabled(true);
                nuevoBt.setEnabled(true);
                //Aviso
                avisoLb.setForeground(Color.black);
                avisoLb.setText(avisoInit+"Gracias por su visita :)");
            }
        });
        
        //Y Ponenemos la ventana  a trabajar
        this.setVisible(true);
        
    }
    
    //Metodos 
    
    
    
    //Clase interna
    class eventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        
        
    }
    
    
}
