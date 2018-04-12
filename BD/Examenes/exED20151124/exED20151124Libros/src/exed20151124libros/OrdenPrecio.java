package exed20151124libros;

import java.util.Comparator;

public class OrdenPrecio implements Comparator<Libro> {

    @Override
    public int compare(Libro o1, Libro o2) {
        return Double.compare(o1.precio, o2.precio);
    }
    
}
