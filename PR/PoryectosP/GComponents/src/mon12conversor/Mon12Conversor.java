/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mon12conversor;

import java.awt.Component;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author prg
 */
public class Mon12Conversor implements ActionListener {

    JPanel panelUno;
    JPanel panelDos;
    JLabel mensa;

    public Mon12Conversor() {
//*********************************************
// CREACIÓN DEL INTERFAZ GRÁFICO
//*********************************************
// Crear la ventana de la aplicacion
        JFrame ventana = new JFrame(
                "Componentes");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        mensa = new JLabel("hola");

// Crear un contenedor
        panelUno = new JPanel();
        panelDos = new JPanel();
        panelUno.add(mensa);
        for (int i = 0; i < 6; i++) {
            JTextField campoDeTexto = new JTextField(5);
            campoDeTexto.addActionListener(this);
            panelDos.add(campoDeTexto);

        }

// Configurar la ventana para mostrar el panel
// cuando se muestre
//        ventana.setContentPane(panelDos);
  //      ventana.getContentPane().setLayout(null);
        ventana.setLayout(null);
        panelUno.setBounds(10, 10, 100, 300);
        panelDos.setBounds(10, 50, 500, 50);

//        ventana.getContentPane().add(panelUno);
//        ventana.getContentPane().add(panelDos);
        
        ventana.add(panelUno);
        ventana.add(panelDos);

//*********************************************
// HACER VISIBLE LA VENTANA
//*********************************************
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new Mon12Conversor();
    }

    public void actionPerformed(ActionEvent e) {
        Component[] componentes;
        int nCom = panelDos.getComponentCount();

        componentes = panelDos.getComponents();
        Component compo = (Component) e.getSource();
        int i;
        for (i = 0; i < nCom; i++) {
            if (componentes[i].equals(compo)) {
                break;
            }
        }
        mensa.setText(String.valueOf(i));

    }

}
