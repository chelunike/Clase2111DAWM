package empleadossinherencia;
/**
 * @author yo
 */
public class EmpleadoComision {
    
    private String nombre;
    private int ventas;
    private double comision;
            
    public EmpleadoComision(String nombre, int ventas, double comision){
        this.nombre = nombre;
        this.ventas = ventas;
        this.comision = comision;
    
    }

    public double getComision() {
        return comision;
    }
    
        
    public double sueldo(){
        return ventas*comision/100;
    }
    
    @Override
    public String toString(){
        String cad="";
        return cad += nombre+":\t" + this.sueldo();
    }
    
    
}
