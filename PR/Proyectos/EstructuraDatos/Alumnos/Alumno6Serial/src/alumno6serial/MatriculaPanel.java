package alumno6serial;


import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

/**
 * @author yo
 */
public class MatriculaPanel extends JPanel{
    //---Atributos
    private String[] asignaturas;
    private JCheckBox[] checkBoxs;
    private JButton guardarBt;
    
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
        guardarBt = new JButton("Guardar");
        
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
        this.add(guardarBt);
        
        
    }
    
    //---- Metodos
    public ArrayList <AsigNota> leerAsiganturas(){
        ArrayList <AsigNota> notas = new ArrayList <AsigNota>();
        for(JCheckBox cb :checkBoxs)
            if(cb.isSelected())
                notas.add(new AsigNota(cb.getText(), 0));
        return notas;
    }
    
    public void limpiaMatricula(){
        for(JCheckBox cb:checkBoxs)
            cb.setSelected(false);
    }
    
    public void escribeMatricula(Alumno al){
        for(JCheckBox cb:checkBoxs)
            if(al.tieneAsignatura(cb.getText()))
                cb.setSelected(true);
    }
    
    public void addActionListener(ActionListener al){
        guardarBt.addActionListener(al);
    }
  
    
}
