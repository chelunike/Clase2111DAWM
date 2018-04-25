package exa_gprimitiva;

import static exa_gprimitiva.Numero.trunca;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * @author yo
 */
public class Primitiva {
    
    static final int maxNumApu = 49;
    
    //Atributos
    private ArrayList <Numero> estadisticas;
    private ArrayList <int[]> apuestas;
    private int numApu;
    private double media;
    
    //Constructor
    public Primitiva(int numApu){
        estadisticas = new ArrayList();
        apuestas = new ArrayList();
        this.numApu = numApu;
        generaApuestas();
        generaEstadisticas();
    }
   
    //Metodos
    
    private void generaApuestas(){
        for(int i=0; i<numApu; i++)
            apuestas.add(generaApuestaAutomatica());
    }
    
    private void generaEstadisticas(){
        for(int i=1; i<=maxNumApu; i++)
            estadisticas.add(new Numero(i));
        for(int[] apu:apuestas)
            for(int i: apu)
                estadisticas.get(i-1).sumRep(1);
        media = 0.0;
        for(Numero n:estadisticas)
            media += n.getRep();
        media /= maxNumApu;
        for(Numero n:estadisticas)
            n.setDesv(media-n.getRep());
    }
    
    public void ordenaPorNumero(){
        estadisticas.sort(null);
    }
    
    public void ordenaPorRepeticion(){
        estadisticas.sort(new ordenaPorRepe());
    }
    
    public void ordenaPorDesviacion(){
        estadisticas.sort(new ordenaPorDesvi());
    }
    
    public String toString(){
        String tmp="Nº\tRepe\tDesv\n";
        for(Numero n:estadisticas)
            tmp += n.toString()+"\n";
        tmp += "\tMedia: "+trunca(media);
        return tmp;
    }
    
    public static int[] generaApuestaAutomatica() {
        ArrayList<Integer> bombo = new ArrayList<Integer>();
        int[] aleatorio = new int[6];
        for (int i = 1; i <= maxNumApu; i++) {
            bombo.add(i);
        }
        Random random = new Random();
        int i=0, n;
        while(i<6){
            n=random.nextInt(maxNumApu+1);
            if(bombo.contains(n)){
                aleatorio[i] = bombo.remove(bombo.indexOf(n));
                i++;
            }
        }
        return aleatorio;
    }
    
    public class ordenaPorRepe implements Comparator <Numero>{
        @Override
        public int compare(Numero o1, Numero o2) {
            return Integer.compare( o1.getRep(), o2.getRep());
        }
    }
    
    public class ordenaPorDesvi implements Comparator <Numero>{
        @Override
        public int compare(Numero o1, Numero o2) {
            return Double.compare(o1.getDesv(), o2.getDesv());
        }
    }
    
    

}
