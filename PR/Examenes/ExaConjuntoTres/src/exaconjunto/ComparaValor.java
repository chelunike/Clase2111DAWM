package exaconjunto;
import java.util.Comparator;

public class ComparaValor implements Comparator <Elemento> {

    @Override
    public int compare(Elemento o1, Elemento o2) {
        return Integer.compare(o1.getValor(), o2.getValor());
    }
     
}
