package exa_gprimitiva;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 * @author yo
 */
public class ProgresionBar {
    //Atributos
    private JDialog ventana;
    private JProgressBar barrita;
    private int max, num;
    
    //Constructor
    public ProgresionBar(int numMax, String title){
        max = numMax;
        
        //Instanciar componentes
        ventana = new JDialog((JFrame)null, title);
        barrita = new JProgressBar(max);
        
        //
        
    }
    //Metodos
    
    
}
