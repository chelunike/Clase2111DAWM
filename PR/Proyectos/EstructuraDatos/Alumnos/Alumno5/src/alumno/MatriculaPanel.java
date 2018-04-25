package alumno;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;

/**
 * @author yo
 */
public class MatriculaPanel extends JPanel{
    //---Atributos
    private String[] asignaturas;
    private JCheckBox[] checkBoxs;
    
    //---Constructor
    public MatriculaPanel(String[] asigs, int width, int height){
        asignaturas = asigs;
        this.setSize(width, height);
    }
    
    public MatriculaPanel(String[] asigs){
        asignaturas = asigs;
        init();
    }
    
    public void init(){
        //Inicializo Array checksBoxs
        checkBoxs = new JCheckBox[asignaturas.length];
        
        //Configuro la ventana
        //GridLayout g = new GridLayout(asignaturas.length/2, 2, 20, 20);
        GridLayout g = new GridLayout(0, 2, 20, 20);
        this.setLayout(g);
        this.setBackground(Color.white);
        //Creo e inserto los checkBoxs
        for(int i=0; i<checkBoxs.length; i++){
            JCheckBox tmp = new JCheckBox(asignaturas[i]);
            tmp.setBackground(Color.white);
            if(i<5)
                tmp.setSelected(true);
            this.add(tmp);
            checkBoxs[i] = tmp;
        }
        
    }
    
    //---- Metodos
    public String[] leerAsiganturas(){
        int n=0;
        for(JCheckBox cb :checkBoxs)
            if(cb.isSelected())
                n++;
        String[] asigs = new String[n];
        n=0;
        for(JCheckBox cb :checkBoxs)
            if(cb.isSelected()){
                asigs[n]= cb.getText();
                n++;
            }
        return asigs;
    }
    
    
    
}
