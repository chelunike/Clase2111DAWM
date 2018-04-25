package interfazsimple;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author yo
 */
public class InterfazSimple {

    public static void main(String[] args) {
        // TODO code aki.
        
        // Crear la ventana de la aplicacion.
        JFrame ventana = new JFrame("Ventana");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(3);// 3 = EXIT_ON_CLOSE :).
        //Layout por defecto FlowLayout.
        // Crear los componentes.
        JLabel etiqueta1 = new JLabel("Ponga argo en el campo :)");
        JTextField campoDeTexto = new JTextField(20);
        JButton boton = new JButton("Patata :)");

        // Crear un contenedor.
        JPanel panelDeContenido = new JPanel();
        
        // Asociar los componentes al contenedor para
        // que los muestre en su interior.
        panelDeContenido.add(etiqueta1);
        panelDeContenido.add(campoDeTexto);
        panelDeContenido.add(boton);
        
        // Asociar el contenedor a la ventana para
        // que le muestre en su interior.
        ventana.setContentPane(panelDeContenido);
        
        //Hacer visible la ventana.
        ventana.setVisible(true);
        
        
        
    }
}
