package empleadossinherencia;
/**
 * @author yo
 */
public class EmpleadosSinHerencia {
    /**
     * Emleados Sin Herencia
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Codijo aki
        
        EmpleadoComision et = new EmpleadoComision("Patata",10,5.1);
        EmpleadoFijo elf = new EmpleadoFijo("Sapato",100,782);
        
        Nomina mina = new Nomina();
        
        mina.insert(et);
        mina.insert(elf);
        EmpleadosSinHerencia.say();
        
        System.out.println("Empleados en NoMina:\n"+mina.toString());
        
    }
    
    private static void say(){
        System.out.println("|-.-.-.-.-.-.-.-.-.-.-|");
        System.out.println("|     |--------------||");
        System.out.println("|:)/ <     QUIERO    ||");
        System.out.println("|/|   |    COBRAR    ||");
        System.out.println("| |   |     MAS!!    ||");
        System.out.println("|/ \\  |______________||");
        System.out.println("|                     |");
        System.out.println("|-.-.-.-.-.-.-.-.-.-.-|");
        
    }
    
    
    
}
