/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GFAcrostico_Exa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author usuario
 */
public class SalidaDg extends JDialog {
    //Atributos
    private JScrollPane scrollSp;
    private JTextArea resultadoTa;
    private JButton guardarBt;
    private String texto;
    
    //Constructor
    public SalidaDg(JFrame padre, String texto,String operacion) {
        //Recojemos los parametros del constructor
        super(padre, true);
        this.texto = texto;
        
        //Instanciamos componentes
        resultadoTa = new JTextArea();
        scrollSp = new JScrollPane(resultadoTa, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        guardarBt = new JButton("Guardar");
        
        //Posicionamos los elementos
        scrollSp.setBounds(10, 10, 200, 300);
        guardarBt.setBounds(50, 320, 100, 20);
        
        //Configuracion Inicial
        resultadoTa.setText(this.texto);
        
        resultadoTa.setEnabled(false);
        if(operacion.compareToIgnoreCase("desencriptar")==0)
            guardarBt.setEnabled(false);
        
        
        //Configuracion de la ventana
        this.setTitle("Salida de la operación: "+operacion);
        this.setSize(280, 380);
        this.setLayout(null);
        
        //Añadimos Componentes
        this.add(scrollSp);
        this.add(guardarBt);
        
        //Nos ponemos a escuchar eventos
        guardarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(operacion.compareToIgnoreCase("acronimo")==0)
                   IO.escribe("salidaAcronimos.txt", texto);
                setVisible(false);
            }
        });

        //Ponemos visible la ventana
        this.setVisible(true);

    }

}
