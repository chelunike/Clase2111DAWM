 package fecha;
/**
 * @author Yo
 */
public class Fecha {
    
    /**
     * @param args the command line arguments Actividad. 
     */
    public static void main(String[] args) {
        Flecha fecha1 = new Flecha( 1, 1, 1990);
        Flecha fecha2 = new Flecha( 15, 11, 2017);
        
        System.out.println("Comprueba fecha 2: ");
        Flecha.say(fecha2.comprobar());
        
        System.out.println("Hoy es: "+fecha2.hoy());
    }
    
}
