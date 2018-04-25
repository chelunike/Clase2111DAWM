package aplicaciontraductor;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author yo
 */
public class Panel extends JPanel implements ActionListener {

    private Traductor traductor;
    private JLabel etiqueta;
    private JTextField campo;
    private JButton boton;
    private JButton change;
    private JLabel idioma;
    private JTextArea dibu;
    private JComboBox Iin;
    private JComboBox Iout;

    public Panel(Traductor traductor) {
        this.traductor = traductor;

        boton = new JButton("Traducir");
        etiqueta = new JLabel("Pulsa el boton para traducir");
        campo = new JTextField(20);
        dibu = new JTextArea();
        change = new JButton("Intercambia");
        idioma = new JLabel("Español - Ingles");
        Iin = new JComboBox(Traductor.getListaIdiomas());
        Iout = new JComboBox(Traductor.getListaIdiomas());

        dibu.setSize(20, 30);
        dibu.setEditable(false);

        //change.addActionListener(this);
        //campo.addActionListener(this);
        //boton.addActionListener(this);
        boton.addMouseListener(new GestorEventos());
        change.addMouseListener(new GestorEventos());
        dibu.addMouseListener(new GestorEventos());
        
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                traduce();
            }
        });
        
        campo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                traduce();
            }
        });
        
        change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizaIdioma();
            }
        });

        Iin.setBackground(Color.PINK);

        this.add(campo);
        this.add(boton);
        this.add(etiqueta);
        this.add(change);
        this.add(idioma);
        this.add(dibu);
        this.add(Iin);
        this.add(Iout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            traductor.invierteIdioma();
            this.actualizaIdioma();
        } else {
            this.traduce();
        }
    }
    
    public void traduce(){
        String tra = traductor.traducePalabra(campo.getText());
            String xd = tra.compareToIgnoreCase("X") == 0 ? " :( " : " :) ";
            etiqueta.setText("Traduccion: " + tra + xd);
            dibu.setText(this.dibuCorrecto(tra.compareTo("X") == 0 ? false : true));
    }
    
    private void actualizaIdioma() {
        idioma.setText(Traductor.getCadenaIdioma(traductor.getIdiomaOrigen()) + " - "
                + Traductor.getCadenaIdioma(traductor.getIdiomaDestino()));
    }
    
    /**
     * :)/ /| Aqui vuelvo :3 | / \
     *
     * @param correcto
     * @return Muñeco Feliz en String
     */
    private String dibuCorrecto(boolean correcto) {
        String cad1 = " :)/ \n /| \n / \\ ";
        String cad2 = " :(\n /|\\ \n / \\";
        if (correcto) {
            return cad1;
        } else {
            return cad2;
        }

    }

}
