package gastosinterfaz;
/**
 * @author yo
 */
public class EmFijo extends Empleado {
    
    private String nombre;
    private double sueldoBase;
    private int añosAnt;
            
    public EmFijo(String nombre, int edad, double sueldobase, int añosAntiguedad){
        super(nombre);
        sueldoBase = sueldobase;
        añosAnt = añosAntiguedad;
        super.setEdad(edad);
    }

    public int getAñosAnt() {
        return añosAnt;
    }
    
    public double pagar(){
        return sueldoBase+añosAnt;
    }
    
    @Override
    public String toString(){
        String cad ="";
        return cad += nombre+":\t" + this.pagar();
    }
}
