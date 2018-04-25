package empleadossinherencia;
/**
 * @author yo
 */
public class EmpleadoFijo {
    
    private String nombre;
    private double sueldoBase;
    private int añosAnt;
            
    public EmpleadoFijo(String nombre, double sueldobase, int añosAntiguedad){
        this.nombre = nombre;
        sueldoBase = sueldobase;
        añosAnt = añosAntiguedad;
    }

    public int getAñosAnt() {
        return añosAnt;
    }
    
    
    public double sueldo(){
        return sueldoBase+añosAnt;
    }
    
    @Override
    public String toString(){
        String cad ="";
        return cad += nombre+":\t" + this.sueldo();
    }
    
}
