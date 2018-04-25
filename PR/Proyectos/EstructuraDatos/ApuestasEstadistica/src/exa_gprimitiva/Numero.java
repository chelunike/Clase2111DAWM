package exa_gprimitiva;

/**
 * @author yo
 */
public class Numero implements Comparable <Numero>{
    //Atributos
    private int num;
    private int rep;
    private double desv;
    
    //Constructor
    public Numero(int n){
        num = n;
        rep = 0;
        desv = 0.0;
    }
    
    //Metodos
    public void sumRep(int n) {
        this.rep += n;
    }

    public void setDesv(double desv) {
        this.desv = desv;
    }

    public int getRep() {
        return rep;
    }

    public double getDesv() {
        return desv;
    }

    public int getNum() {
        return num;
    }
    
    @Override
    public String toString(){
        return ""+num+"\t"+rep+"\t"+trunca(desv);
    }
    
    public static double trunca(double n){
        return ((double)((int)(n*100)))/100;
    }

    @Override
    public int compareTo(Numero o) {
        return num-o.getNum();
    }
    
}
