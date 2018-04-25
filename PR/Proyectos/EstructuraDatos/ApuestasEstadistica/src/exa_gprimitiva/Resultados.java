package exa_gprimitiva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yo
 */
public class Resultados extends JDialog {

    private JLabel sorteoLb;

    private JScrollPane scrollSp;
    private JTextArea resultadosTa;
    private JButton guardarBt;


    public Resultados(JFrame padre, ArrayList<int[]> apuestas, int[] premiada, String operacion) {
        super(padre, true);
        
        //Instanciamos componentes
        sorteoLb = new JLabel();
        guardarBt = new JButton(" Guardar ");
        resultadosTa = new JTextArea(400, 400);
        scrollSp = new JScrollPane(resultadosTa);
        
        //Posicionamos elementos
        sorteoLb.setBounds(50, 10, 250, 50);
        scrollSp.setBounds(50, 70, 400, 300);
        guardarBt.setBounds(150, 380, 100, 40);
        
        //Configuramos Ventana
        this.setSize(500,600);
        this.setLayout(null);
        
        //Añadimos Componentes
        this.add(sorteoLb);
        this.add(scrollSp);
        this.add(guardarBt);
        
        //Nos ponemos a escuchar
        guardarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        //Ponemos los resultados
        if(operacion.compareToIgnoreCase("resultados")==0){
            String tmp ="";
            for(int n:premiada)
                tmp+=n+", ";
            sorteoLb.setText("Apuesta Ganadora: "+tmp);
            tmp =" - Apuesta - \t\t - Aciertos\n";
            int i=1;
            for(int[] apuesta:apuestas){
                tmp+=i+")";
                for(int n:apuesta)
                    tmp +=n+"-";
                tmp+="\t"+numAciertos(premiada, apuesta)+"\n";
                i++;
            }
            resultadosTa.setText(tmp);
        }else{
            String tmp="";
            int[] nums = new int[premiada.length+1];
            for(int[] apuesta:apuestas)
                nums[numAciertos(premiada, apuesta)]++;
            for(int i=0; i<nums.length; i++)
                tmp+="Apuestas con "+i+" aciertos: "+nums[i]+"\n";
            resultadosTa.setText(tmp);
        }
        
        
        //Ponemos visible la ventana
        this.setVisible(true);
    }

    private int numAciertos(int[] premiada, int[] apuesta) {
        int num=0;
        for (int i=0; i<premiada.length; i++)
            if(premiada[i] == apuesta[i])
                num++;
        return num;
    }

   
}
