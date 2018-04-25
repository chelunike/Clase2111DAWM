package alumnos6s;

import java.io.Serializable;

/**
 * @author yo
 */
public class AsigNota implements Serializable{
    //Atributos
    private String asig;
    private double nota;
    
    //Constructor
    public  AsigNota(String asignatura, double nota){
        asig = asignatura;
        this.nota = nota;
    }
    
    //Get y Sets
    public String getAsig() {
        return asig;
    }

    public void setAsig(String asig) {
        this.asig = asig;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    @Override
    public String toString(){
        return asig+": "+nota+"\n";
    
    }
    
    
}
