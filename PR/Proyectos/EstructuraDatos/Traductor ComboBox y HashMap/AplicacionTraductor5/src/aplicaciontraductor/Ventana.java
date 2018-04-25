package aplicaciontraductor;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author yo
 */
public class Ventana extends JFrame {

    // ------------ Atributos --------------
    private Traductor traductor;
    //pirates int carive;

    //------------ Contructor INIT:D ---------------
    public Ventana(Traductor traductor) {
        this.setContentPane(new Panel(traductor));
        this.setTitle("Traductor de Español a Inglés");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setVisible(true);

    }

    
}
