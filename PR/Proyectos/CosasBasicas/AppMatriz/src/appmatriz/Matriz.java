package appmatriz;

import java.util.Arrays;


/**
 * @author yo
 */
public class Matriz {
    
    //Atributos
    private double[][] matriz;
    
    //Constructor
    public Matriz(){
        matriz = new double[3][3];
        //Genero numeros
        this.rellenaRandom();
    }
    
    public Matriz(double[][] matriz){
        this.matriz = matriz;
    }
    
    //Metodos
    
    //Metodos estaticos
    public static double[][] suma(Matriz m1, Matriz m2){
        double[][] tmp = new double[m1.getMatriz().length][m1.getMatriz()[0].length];
        for(int i=0; i<tmp.length; i++){
            for(int j=0; j<tmp[0].length; j++){
                tmp[i][j]= Matriz.round(m1.getMatriz()[i][j]+m2.getMatriz()[i][j]);
            }
        }
        return tmp;
    }
    
    public static double[][] resta(Matriz m1, Matriz m2){
        double[][] tmp = new double[m1.getMatriz().length][m1.getMatriz()[0].length];
        for(int i=0; i<tmp.length; i++){
            for(int j=0; j<tmp[0].length; j++){
                tmp[i][j]= Matriz.round(m1.getMatriz()[i][j]-m2.getMatriz()[i][j]);
            }
        }
        return tmp;
    }
    
    public static double[][] multiplicacion(Matriz m1, Matriz m2){
        double[][] tmp = new double[m1.getMatriz().length][m1.getMatriz()[0].length];
        for(int i=0; i<tmp.length; i++){
            for(int j=0; j<tmp[i].length; j++){
                for(int k=0; k<tmp[i].length; k++)
                    tmp[i][j] = Matriz.round(tmp[i][j]+(m1.getMatriz()[i][k] * m2.getMatriz()[k][j]));
            }
        }
        return tmp;
    }
    
    public static double checkMulti(double[][] d1, double[][] d2){        
       return d1[0][0]*d2[0][0]+ d1[0][1]*d2[1][0]+ d1[0][2]*d2[2][0]; 
    }
    
    
    public void rellenaRandom(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                double num = ((double)((int)(Math.random()*100)))/10;
                matriz[i][j]=num;
            }
        }
    }
    
    ///Get 
    public double[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }
    
    
    @Override
    public String toString(){
        String cad = "";
        for (int i=0; i<3; i++){
            cad += " - ";
            for(int j=0; j<3; j++)
                cad +=""+matriz[i][j]+" - ";
            cad += "\n";
        }
        return cad;
    }
    
    public static double round(double e){
        return ((double)((int)(e*100)))/100;
    }
    
}
