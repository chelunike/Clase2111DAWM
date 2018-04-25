package aplicaciontraductor;
/**
 * @author yo
 */
public class AplicacionTraductor {
    
    public AplicacionTraductor(){
        //Da mas vueltas ...
        new Ventana(new Traductor());
    }
    
    public static void main(String[] args) {
        // TODO code aki
        new AplicacionTraductor();
        
        //System.out.println("Test: "+Traductor.test());
    }
    
    
}
