package aplicaciontraductor;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author yo
 */
public class Ventana extends JFrame implements ActionListener {
    
    // ------------ Atributos --------------
    private Traductor traductor;
    
    private JLabel pulsa;
    private JTextField campo;
    //pirates int carive;
    private JButton traducir;
    private JButton change;
    private JLabel result;
    
    //------------ Contructor INIT:D ---------------
    public Ventana(Traductor traductor){
        //Cojemos el traductor
        this.traductor = traductor;
        
        //Configuracion Vnetana
        this.setTitle("Traductor Español a Ingles");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        
        //Creamos panel de Contenido
        JPanel contenido  = new JPanel();
        //Asignamos panel de contenido
        this.setContentPane(contenido);
        //Instanciamos Componentes
        pulsa = new JLabel("Pulsa Traducir para traducir :)");
        campo = new JTextField(20);
        traducir= new JButton("Traducir");
        change = new JButton("Intercambia Idiomas");
        result = new JLabel("Traduccion");
        
        //Nos ponemos a escuchar
        traducir.addActionListener(this);
        
        //Añadimos componentes
        contenido.add(pulsa);
        contenido.add(campo);
        contenido.add(traducir);
        contenido.add(change);
        contenido.add(result);
        
        //Activamos Ventana
        this.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tra = traductor.traducePalabra(campo.getText());
        String xd = tra.compareToIgnoreCase("X")==0?" :( ":" :) ";
        result.setText("Traduccion: "+tra+ xd);
    }
    
    
}
