package exed20151124libros;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;

public class ExED20151124Libros {

    public static void main(String[] args) {
        ArrayList<Libro> a= new ArrayList<>();
        LocalDate d= LocalDate.of(2015, 3, 6);
        a.add(new Libro("uno", 89.23, d));
        d= LocalDate.of(2015, 3, 7);
        a.add(new Libro("dos", 90, d));
        d= LocalDate.of(2015, 3, 8);
        a.add(new Libro("tres", 95, d));
        d= LocalDate.of(2015, 5, 8);
        a.add(new Libro("cuatro", 85, d));
        d= LocalDate.of(2015, 2, 8);
        a.add(new Libro("cinco", 15.4, d));
        d= LocalDate.of(2016, 3, 8);
        a.add(new Libro("seis", 95.33, d));
        //System.out.println(a.get(0));
        System.out.println("Por nombre:");
        Collections.sort(a);
        ver(a);
        System.out.println("Por precio:");
        Collections.sort(a, new OrdenPrecio());
        ver(a);
        System.out.println("Por mes-dia:");
        Collections.sort(a, new OrdenMesDia());
        ver(a);
    }
    static void ver(ArrayList<Libro> a){
        for(Libro l: a)
            System.out.println(l);
    }
    
}
