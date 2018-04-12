package examenedd2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class ExamenEDD2 {

    public static void main(String[] args) {
        
        ArrayList <CD> cds = new ArrayList<CD>();
        
        LocalDate f1 = LocalDate.of(2011, 9, 20);
        LocalDate f2 = LocalDate.of(2012, 10, 22);
        LocalDate f3 = LocalDate.of(2002, 8, 22);
        LocalDate f4 = LocalDate.of(1993, 9, 23);
        LocalDate f5 = LocalDate.of(2014, 9, 21);
        
        CD cd1 = new CD("Maluma", 8, f1);
        CD cd2 = new CD("Pepito Grillo", 13, f2);
        CD cd3 = new CD("David Bisbal", 2, f3);
        CD cd4 = new CD("Pepe", 1, f4);
        CD cd5 = new CD("El cigala", 24, f5);
        
        cds.add(cd1);
        cds.add(cd2);
        cds.add(cd3);
        cds.add(cd4);
        cds.add(cd5);
        
        cds.sort(null);
        System.out.println(cds);
        
        System.out.println("--------------------");
        
        cds.sort(new OrdenacionPorPistas());
        System.out.println(cds);
        
        System.out.println("---------------");
        
        cds.sort(new OrdenacionPorMes());
        System.out.println(cds);
        
        
    }
    
    public static class OrdenacionPorPistas implements Comparator<CD> {

        @Override
        public int compare(CD o1, CD o2) {
            return Float.compare(o1.getPistas(), o2.getPistas());
        }
    }
    
    public static class OrdenacionPorMes implements Comparator<CD> {

        @Override
        public int compare(CD o1, CD o2) {
            int dif = (o1.getFecsal().getMonth().compareTo(o2.getFecsal().getMonth()));
            if (dif == 0){
                return (o1.getFecsal().compareTo(o2.getFecsal()));
            }
            return dif;
        }

    }
    
}


