package exa_gprimitiva;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
   
   
    private JPanel panel;
    private JLabel apuestaLb;
    private JLabel numApuLb;
    private JTextField apuestaTf;
    private JButton resultadosBt;
    private JButton automaticaBt;
    private JButton estadisticaBt;
   
    private ArrayList<int[]> apuestas;
    
    public Ventana() {
        apuestas = new ArrayList();
        //Instanciamos componentes
        panel = new JPanel();
        apuestaLb = new JLabel("APUESTA: ");
        numApuLb = new JLabel("0");
        apuestaTf = new JTextField();
        resultadosBt = new JButton("Resultados");
        automaticaBt = new JButton("Automática");
        estadisticaBt = new JButton("Estadistica");
        
        //Posionamos
        apuestaLb.setBounds(20, 20, 90, 20);
        numApuLb.setBounds(125, 20, 40, 20);
        apuestaTf.setBounds(20, 60, 140, 20);
        automaticaBt.setBounds(20, 100, 140, 20);
        resultadosBt.setBounds(20, 140, 140, 20);
        estadisticaBt.setBounds(20, 180, 140, 20);
        
        //Configuramos Componentes
        apuestaTf.setBackground(Color.LIGHT_GRAY);
        apuestaTf.setForeground(Color.red);
        apuestaTf.setEditable(false);
        
        //COnifguramos Ventana
        panel.setLayout(null);
        this.setSize(200, 250);
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Añadimos componentes
        panel.add(apuestaLb);
        panel.add(numApuLb);
        panel.add(apuestaTf);
        panel.add(automaticaBt);
        panel.add(resultadosBt);
        panel.add(estadisticaBt);
        
        //Nos ponemos a escuchar
        automaticaBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tmp="";
                int[] apuesta = generaApuestaAutomatica();
                for(int n:apuesta)
                    tmp +=n+", ";
                apuestaTf.setText(tmp);
                apuestas.add(apuesta);
                numApuLb.setText(""+apuestas.size());
            }
        });
        
        resultadosBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Resultados(Ventana.this, apuestas, generaApuestaAutomatica(), "resultados");
                apuestas = new ArrayList();
                numApuLb.setText("0");
                apuestaTf.setText("");
            }
        });
        
        estadisticaBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apuestas = new ArrayList();
                for(int i=0; i<100000000; i++)
                    apuestas.add(generaApuestaAutomatica());
                new Resultados(Ventana.this, apuestas, generaApuestaAutomatica(), "estadistica");
                apuestas = new ArrayList();
                numApuLb.setText("0");
                apuestaTf.setText("");
            }
        });
 
        //Ponemos la ventana visible
        this.setVisible(true);
        
    }
    
    public static int[] generaApuestaAutomatica() {
        ArrayList<Integer> bombo = new ArrayList<Integer>();
        int[] aleatorio = new int[6];
        for (int i = 1; i <= 49; i++) {
            bombo.add(i);
        }
        Random random = new Random();
        int i=0, n;
        while(i<6){
            n=random.nextInt(49);
            if(bombo.contains(n)){
                aleatorio[i] = bombo.remove(bombo.indexOf(n));
                i++;
            }
        }
        return aleatorio;
    }
    
}
