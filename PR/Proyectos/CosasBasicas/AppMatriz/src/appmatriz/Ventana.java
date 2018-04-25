package appmatriz;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

/**
 * @author yo
 */
public class Ventana extends JFrame {
    //Atributos
    private Matriz matriz1, matriz2, matrizR;
    
    private JPanel mA, mB, mResultado;
    private JButton sumaBt, restaBt, multiBt;
    private JLabel igualLb;
    
    //Contructor
    public Ventana(Matriz m1, Matriz m2){
        matriz1 = m1;
        matriz2 = m2;
        matrizR = new Matriz();
        
        //Instanciamos Componentes
        mA = new JPanel();
        mB = new JPanel();
        mResultado = new JPanel();
        
        sumaBt = new JButton("Suma");
        restaBt = new JButton("Resta");
        multiBt = new JButton("Multiplicar");
        
        igualLb = new JLabel(" = ");
        
        //Configuramos Componentes
        mA.setBounds( 20, 20, 200, 300);
        mB.setBounds(340, 20, 200, 300);
        mResultado.setBounds(580, 20, 200, 300);
        
        mA.setBackground(Color.GRAY);
        mB.setBackground(Color.GRAY);
        mResultado.setBackground(Color.GRAY);
        
        sumaBt.setBounds(230, 130, 100, 20);
        restaBt.setBounds(230, 160, 100, 20);
        multiBt.setBounds(230, 190, 100, 20);
        
        igualLb.setBounds(550, 160, 20, 20);
        
        //Asignamos Paneles, Layout y configuramos ventana
        this.setTitle("Operaciones con matrizes :) ");
        this.setSize(800, 360);
        this.getContentPane().setBackground(Color.CYAN);
        this.setDefaultCloseOperation(3);
        
        //Asignamos 
        //this.getContentPane().setLayout(null);
        this.setLayout(null);
        GridLayout m = new GridLayout(3, 3, 10, 10);
        mA.setLayout(m);
        mB.setLayout(m);
        mResultado.setLayout(m);
        
        
        //AñadimosComponentes
        this.add(mA);
        this.add(mB);
        this.add(mResultado);
        this.add(sumaBt);
        this.add(restaBt);
        this.add(multiBt);
        this.add(igualLb);
        
        //Colorcar las Matrices
        this.pintaMatriz(mA);
        this.pintaMatriz(mB);
        this.pintaMatriz(mResultado);
        
        //Escribimos Matriz
        this.actualizaValores(mA, matriz1.getMatriz());
        this.actualizaValores(mB, matriz2.getMatriz());
        
        //NosPonemos a escuchar
        sumaBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Leemos matrizes antes de empezar
                matriz1.setMatriz(leerValores(mA, matriz1.getMatriz()));
                matriz2.setMatriz(leerValores(mB, matriz2.getMatriz()));
                //Calculamos y actualizamos
                matrizR.setMatriz(Matriz.suma(matriz1,matriz2));
                actualizaValores(mResultado, matrizR.getMatriz());
            }
        });
        
        restaBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Leemos matrizes antes de empezar
                matriz1.setMatriz(leerValores(mA, matriz1.getMatriz()));
                matriz2.setMatriz(leerValores(mB, matriz2.getMatriz()));
                //Calculamos y actualizamos
                matrizR.setMatriz(Matriz.resta(matriz1,matriz2));
                actualizaValores(mResultado, matrizR.getMatriz());
            }
        });
        
        multiBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Leemos matrizes antes de empezar
                matriz1.setMatriz(leerValores(mA, matriz1.getMatriz()));
                matriz2.setMatriz(leerValores(mB, matriz2.getMatriz()));
                //Calculamos y actualizamos
                matrizR.setMatriz(Matriz.multiplicacion(matriz1,matriz2));
                actualizaValores(mResultado, matrizR.getMatriz());
            }
        });
        
        
        //Activamos Ventana
        this.setVisible(true);
        
    }
    
    private void pintaMatriz(JPanel panel){
        for(int i=0; i<9; i++){
            JTextField tmp = new JTextField(" :) ");
            tmp.setBackground(Color.PINK);
            tmp.setHorizontalAlignment(0);
            //tmp.addActionListener(null);
            panel.add(tmp);
        }
    }
    
    private void actualizaValores(JPanel pane, double[][] d2){
        int numComp = pane.getComponentCount();
        Component[] componentes = pane.getComponents();
        if(numComp == d2.length * d2[0].length){
            int k=0;
            for(int i=0; i<d2.length; i++)
                for(int j=0; j<d2[i].length; j++){
                    JTextField tmp = (JTextField)componentes[k];
                    tmp.setText(""+d2[i][j]);
                    tmp.setBackground(Color.green);
                    k++;
                }   
        }else
            System.err.println("No Coincide los valores con los componentes");
    }
    
    
    private double[][] leerValores(JPanel pane, double[][] d2){
        int numComp = pane.getComponentCount();
        double[][] valores = new double[d2.length][d2[0].length];
        Component[] componentes = pane.getComponents();
        if(numComp == d2.length * d2[0].length){
            int k=0;
            for(int i=0; i<d2.length; i++)
                for(int j=0; j<d2[i].length; j++){
                    JTextField tmp = (JTextField)componentes[k];
                    try{
                        valores[i][j] = Double.parseDouble(tmp.getText());
                    }catch(Exception e){
                        System.err.println(""+e);
                    }
                    k++;
                }   
        }else
            System.err.println("No Coincide los valores con los componentes");
        return valores;
    }
    
    
    
}
