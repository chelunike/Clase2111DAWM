package gastosinterfaz;
/**
 * @author yo
 */
public abstract class Empleado implements IGastos{
    
    private String nombre;
    //pirates int carive;
    private int edad;
    
    public Empleado(String nombre){
        this.nombre = nombre;
    }
    
    public String descripcion(){
        return nombre;
    }
    
    public abstract double pagar();
    
    public void setEdad(int edad){
        if(edad<0)
            this.edad = -edad;
        else
            this.edad = edad;
    }
    
}
