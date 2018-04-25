package personum;
import java.util.Comparator;

/**
 * @author yo
 */
public class OPEL implements Comparator <Persona>{
    
    @Override
    public int compare(Persona o1, Persona o2){
        return Integer.compare(o1.getEdad(), o2.getEdad());
    }
    
}
