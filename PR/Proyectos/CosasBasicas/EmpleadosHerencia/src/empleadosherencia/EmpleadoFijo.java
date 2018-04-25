package empleadosherencia;
/**
 * @author yo
 */
public class EmpleadoFijo extends Empleado{
    
    private String nombre;
    private double sueldoBase;
    private int añosAnt;
            
    public EmpleadoFijo(String nombre, int edad, double sueldobase, int añosAntiguedad){
        super(nombre);
        sueldoBase = sueldobase;
        añosAnt = añosAntiguedad;
        super.setEdad(edad);
    }

    public int getAñosAnt() {
        return añosAnt;
    }
    
    @Override
    public double sueldo(){
        return sueldoBase+añosAnt;
    }
    
    @Override
    public String toString(){
        String cad ="";
        return cad += nombre+":\t" + this.sueldo();
    }
    
}

