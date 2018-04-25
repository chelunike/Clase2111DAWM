package personum;
import java.util.Comparator;

/**
 * @author yo
 */
public class OPA implements Comparator <Persona>{

    @Override
    public int compare(Persona p1, Persona p2) {
        return Double.compare(p1.getAltura(), p2.getAltura());
    }
    
    
}
