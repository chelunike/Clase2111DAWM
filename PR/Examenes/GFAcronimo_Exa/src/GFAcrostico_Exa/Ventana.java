/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GFAcrostico_Exa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author prg
 */
public class Ventana extends JFrame {

    private JTextArea entradaTa, salidaTa;
    private JScrollPane entradaSp, salidaSp;
    private JButton acronimoBt;
    private JButton encriptarBt;
    private JButton desEncriptarBt;
    private String entrada, encriptada, desencriptada;

    public Ventana() {
        entrada = IO.leeFichero("entrada.txt");
        
        //Instanciamos Componentes
        entradaTa = new JTextArea();
        salidaTa = new JTextArea();
        entradaSp = new JScrollPane(entradaTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        salidaSp = new JScrollPane(salidaTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        acronimoBt = new JButton("Acronimo");
        encriptarBt = new JButton("Encriptar");
        desEncriptarBt = new JButton("Desencriptar");
        
        //Configuramos Componentes
        salidaTa.setEditable(false);
        //Añadimos el texto de entrada
        entradaTa.append(entrada);
        
        //Posicionamiento
        entradaSp.setBounds(10, 10, 300, 400);
        acronimoBt.setBounds(330, 175, 150, 30);
        encriptarBt.setBounds(330, 215, 150, 30);
        desEncriptarBt.setBounds(330, 255, 150, 30);
        salidaSp.setBounds(520, 10, 300, 400);
        
        //Configuramos la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(880, 500);
        
        //Añadimos los componentes
        this.add(entradaSp);
        this.add(salidaSp);
        this.add(acronimoBt);
        this.add(encriptarBt);
        this.add(desEncriptarBt);
        
        //Nos ponemos a escuchar los eventos
        acronimoBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entrada = entradaTa.getText();
                //Algoritmo de Acronimos
                String acronimo="";
                encriptada="";
                //Depuramos un poco el texto
                if(entrada.contains(","))
                    entrada = entrada.replace(",", "");
                if(entrada.contains("."))
                    entrada = entrada.replace(".", "");
                //Pasamos a generar los acronimos
                for(String linea:entrada.split("\n")){
                    for(String palabra:linea.split(" ")){
                        if(!palabra.equals(""))
                            acronimo += palabra.toUpperCase().charAt(0)+".";
                    }
                    acronimo += "\n";//System.lineSeparator();
                }
                System.out.println(""+acronimo);
                //Mostramos nuestra salida
                new SalidaDg(Ventana.this, acronimo, "acronimo");
            } 
        });

        encriptarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entrada = entradaTa.getText();
                //Algoritmo de encriptacion
                char c=0;
                for (int i=0; i<entrada.length(); i++){
                    c = entrada.charAt(i);
                    c+=10;
                    encriptada += c;
                }
                IO.escribe("salidaEncriptada.txt", encriptada);
                salidaTa.setText(encriptada);
                
            }
        });
        
        desEncriptarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Algoritmo de desencriptacion
                char c;
                desencriptada="";
                for (int i=0; i<encriptada.length(); i++){
                    c = encriptada.charAt(i);
                    c-=10;
                    desencriptada += c;
                }
                new SalidaDg(Ventana.this, desencriptada, "desencriptar");
            }
        });
        
        
        //Ponemos visible el boton
        this.setVisible(true);

    }

}
