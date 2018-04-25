
package guieditortexto;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Ventana {
    private JFrame ventana;
    private JPanel jpCabecera;
    private JPanel jpPrincipal;
    private JLabel jbFichero;
    private JTextField tfFichero;
    private JTextArea taEditor;
    private JScrollPane scroll;
    private JFileChooser jfcAbrir;
    private JButton jbAbrir;
    private JButton jbGuardar;
    private JButton jbNuevo;
    private JButton jbSalir;
    
    FileReader fileReader;
    FileWriter fileWriter;
    FileInputStream fis;
    FileOutputStream fos;
    IO entradaSalida;
    
    public Ventana(){
        entradaSalida = new IO();
        jfcAbrir = new JFileChooser();
        ventana = new JFrame("Editor texto");
        jpCabecera = new JPanel(null);
        jpPrincipal = new JPanel(null);
        jbFichero = new JLabel("Fichero: ");
        tfFichero = new JTextField();

        jbGuardar = new JButton("Guardar");
        jbSalir = new JButton("Salir");
        jbNuevo = new JButton("Nuevo");
        jbAbrir = new JButton("Abrir");
   
        ventana.setSize(800, 500);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setContentPane(jpPrincipal);
        jpPrincipal.add(jpCabecera);
        
        jpCabecera.setBounds(10, 5, 600, 50);
        jpCabecera.setBorder(BorderFactory.createLineBorder(java.awt.Color.black));
        jpCabecera.add(jbFichero);
        jbFichero.setBounds(20, 10, 60, 20);
        jpCabecera.add(tfFichero);
        tfFichero.setBounds(70, 15, 60, 15);
        
        taEditor = new JTextArea("", 20, 20);
        scroll = new JScrollPane(taEditor);
        scroll.setBounds(10, 100, 600, 250);
        jpPrincipal.add(scroll);

        jpCabecera.add(jbAbrir);
        jpCabecera.add(jbFichero);
        jpCabecera.add(jbGuardar);
        jpCabecera.add(jbNuevo);
        jpCabecera.add(jbSalir);
        
        jbAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getArchivo();
                    tfFichero.setText(String.valueOf(jfcAbrir.getSelectedFile()));
                } catch (IOException ex) {
                   JOptionPane.showMessageDialog(null, "Error al abrir el fichero");
                }
            }
        });
        
        jbGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfFichero.getText() == ""){
                    tfFichero.setBackground(java.awt.Color.red);
                }else{
                    entradaSalida.guardarFichero(tfFichero.getText(), taEditor.getText());
                    tfFichero.setBackground(java.awt.Color.WHITE);
                }
            }
        });
        
        jbNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               entradaSalida.nuevoArchivo(tfFichero.getText());
            }

        });
        
        jbSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               taEditor.setText(" ");
            }
        });
        
        jbAbrir.setBounds(150, 15, 90, 20);
        jbNuevo.setBounds(250, 15, 90, 20);
        jbGuardar.setBounds(350, 15, 90, 20);
        jbSalir.setBounds(450, 15, 90, 20);
 
    }
    
    public void getArchivo() throws IOException{
        
       int seleccion = jfcAbrir.showDialog(ventana, "seleccionar archivo");
       File archivo = jfcAbrir.getSelectedFile();
       
        try {
            taEditor.setText(entradaSalida.leerFichero(archivo));
        } catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null, "Error al abrir");
        }
        
    }
}
