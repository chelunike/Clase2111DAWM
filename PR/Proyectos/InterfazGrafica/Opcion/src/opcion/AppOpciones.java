package opcion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AppOpciones {

    private static final String mensaje = "Pase sobre alguna opción";
    private JLabel descLarga;
    private List opciones;

    public AppOpciones() {
        
        // Datos de prueba
        opciones = new ArrayList();
        opciones.add(new Opcion("Opcion A", "Desc Larga Opcion A"));
        opciones.add(new Opcion("Opcion B", "Desc Larga Opcion B"));
        opciones.add(new Opcion("Opcion C", "Desc Larga Opcion C"));
        opciones.add(new Opcion("Opcion D", "Desc Larga Opcion D"));

        // Construcción del interfaz gráfico
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(200, 200);

        JPanel panelContenido = new JPanel();
        ventana.setContentPane(panelContenido);
        
        for (int i = 0; i < opciones.size(); i++) {
            Opcion opcion = (Opcion) opciones.get(i);
            JButton b = new JButton(opcion.getDescCorta());
            panelContenido.add(b);
            // Declaración de variable debido a que desde
            // las clases anónimas sólo se pueda acceder a
            // variables locales o parámetros final.
            final int numOpcion = i;
            b.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {
                    setDescLarga(numOpcion);
                }

                public void mouseExited(MouseEvent e) {
                    resetMensaje();
                }

                public void mouseClicked(MouseEvent e) {}
                public void mousePressed(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
            });
        }
        descLarga = new JLabel(mensaje);
        panelContenido.add(descLarga);
        ventana.setVisible(true);
    }

    protected void resetMensaje() {
        this.descLarga.setText(mensaje);
    }

    protected void setDescLarga(int numOpcion) {
        Opcion opcion = (Opcion) opciones.get(numOpcion);
        this.descLarga.setText(opcion.getDescLarga());
    }

    public static void main(String[] args) {
        new AppOpciones();
    }
}
