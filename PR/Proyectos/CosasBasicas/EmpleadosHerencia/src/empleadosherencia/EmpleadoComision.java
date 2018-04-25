package empleadosherencia;
/**
 * @author yo
 */
public class EmpleadoComision extends Empleado{
    
    private String nombre;
    private int ventas;
    private double comision;
            
    public EmpleadoComision(String nombre, int edad, int ventas, double comision){
        super(nombre);
        this.ventas = ventas;
        this.comision = comision;
        super.setEdad(edad);
    
    }

    public double getComision() {
        return comision;
    }
    
    @Override
    public double pagar(){
        return ventas*comision/100;
    }
    
    @Override
    public String toString(){
        String cad="";
        return cad += nombre+":\t" + this.pagar();
    }
    
    
}

