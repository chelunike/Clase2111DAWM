package exed20151124libros;

import java.util.Comparator;

public class OrdenMesDia implements Comparator<Libro> {

    @Override
    public int compare(Libro o1, Libro o2) {
        if (o1.fecha.getMonthValue() < o2.fecha.getMonthValue())
            return -1;
        if (o1.fecha.getMonthValue() > o2.fecha.getMonthValue())
            return 1;
        return o1.fecha.getDayOfMonth() - o2.fecha.getDayOfMonth();
        
    }
    
}
