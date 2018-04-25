package empleadosherencia;
/**
 * @author yo
 */
public class EmpleadosHerencia {
    /**
     * Empleado Con Herencia
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // codijo jere
        Empleado et = new EmpleadoComision("Patata",10,10,5.1);
        Empleado elf = new EmpleadoFijo("Sapato",8,100,782);
        
        Nomina mina = new Nomina();
        
        mina.insert(et);
        mina.insert(elf);
        
        System.out.println("Empleados en NoMina:\n"+mina.toString());
        
    }
    
}
