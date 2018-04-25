package escuela_2.pkg0;
/**
 * @author yo
 */
public class AsigNota {
    
    //Atributos
    String asig;
    double nota;
    
    //Contructores
    //public AsigNota(){}
    public AsigNota(String Asignatura, double nota){
        asig = Asignatura;
        this.nota = nota;
    }
    
    public AsigNota(String Asignatura){
        asig = Asignatura;
    }
    
    //Get y Set

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
    
    
}
