package interfazsimple;

import javax.swing.*;
import java.awt.event.*;

public class ConversorEuros implements ActionListener {

    private JLabel etiqueta1;
    private JTextField campoDeTexto;
    private JButton boton;
    private JLabel resultado;

    public ConversorEuros() {
        //*********************************************
        // CREACIÓN DEL INTERFAZ GRÁFICO
        //*********************************************
        // Crear la ventana de la aplicacion
        JFrame ventana = new JFrame(
                "Conversor de Euros a pesetas");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        // Crear los componentes
        etiqueta1 = new JLabel("Importe en Leuros");

        campoDeTexto = new JTextField(20);
        boton = new JButton("Convertirse ar Tito Pako");
        resultado = new JLabel("Pulse para obtener el "
                + "importe en pesetas");
        
        // Crear un contenedor
        JPanel panelDeContenido = new JPanel();
        // Configurar el contenedor para mostrar los
        // componentes cuando se muestre.
        panelDeContenido.add(etiqueta1);
        panelDeContenido.add(campoDeTexto);
        panelDeContenido.add(boton);
        panelDeContenido.add(resultado);
        
        // Configurar la ventana para mostrar el panel cuando se muestre
        ventana.setContentPane(panelDeContenido);
        
        // ASOCIACIÓN DEL CÓDIGO DE MANEJO DE EVENTOS
        
        boton.addActionListener(this);
        
        // HACER VISIBLE LA VENTANA
        
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new ConversorEuros();
    }

    public void actionPerformed(ActionEvent e) {
        //**********************************************
        // CÓDIGO DE MANEJO DE EVENTOS
        //**********************************************
        try {
            double euros = Double.parseDouble(
                    campoDeTexto.getText());
            double pesetas = euros * 1.66386;
            resultado.setText("Equivale a " + pesetas
                    + " pejetas");
        } catch (NumberFormatException e2) {
            if(campoDeTexto.getText().compareToIgnoreCase("patata")==0 )
                resultado.setText("Ninio que pongas un numero, no Patata :)");
            else
                resultado.setText("Pon patata arriba :)");
        }
    }
}
 