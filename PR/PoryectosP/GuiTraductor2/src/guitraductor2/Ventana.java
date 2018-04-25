
package guitraductor2;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener, MouseListener{
    
    private Traductor traductor;
    private JLabel etiqueta;
    private JTextField campo;
    private JButton boton;
    private JButton botonCambioIdioma;
    private JLabel etiquetaIdioma;
    
    public Ventana(Traductor traductor){
        this.traductor = traductor;
        this.setTitle("Traductor de Español a Inglés");
        JPanel panelContenido = new JPanel();
        this.setContentPane(panelContenido);
        
        boton = new JButton("Traducir");
        etiqueta = new JLabel("Pulsa el boton para traducir");
        botonCambioIdioma = new JButton("Invierte sentido traducción");
        etiquetaIdioma = new JLabel();
        this.muestraSentidoTraduccion();
        campo = new JTextField(20);
        boton.addActionListener(this);
        campo.addActionListener(this);
        botonCambioIdioma.addActionListener(this);
        
        /*eventos del raton*/
        
        etiqueta.addMouseListener(this);
        campo.addMouseListener(this);
        boton.addMouseListener(this);
        botonCambioIdioma.addMouseListener(this);
        etiquetaIdioma.addMouseListener(this);
        
        panelContenido.add(campo);
        panelContenido.add(boton);
        panelContenido.add(etiqueta);
        panelContenido.add(botonCambioIdioma);
        panelContenido.add(etiquetaIdioma);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCambioIdioma) {
        traductor.invierteIdioma();
        this.muestraSentidoTraduccion();
        } else {
        etiqueta.setText(traductor.traducePalabra(campo.getText()));
            if(traductor.traducePalabra(campo.getText()) == "X"){
                campo.setBackground(Color.red);
            }else{
                campo.setBackground(Color.WHITE);
            }
        }
    }
    
    private void muestraSentidoTraduccion() {
        etiquetaIdioma.setText(traductor.getCadenaIdioma(traductor.getIdiomaOrigen())
        + " - " + traductor.getCadenaIdioma(
        traductor.getIdiomaDestino()));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Al pinchar");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mantener pulsado");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       System.out.println("Sobreponer");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entrar");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Salir");
    }
    
}

