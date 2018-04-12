package edfecha;

public class EDFecha {

    public static void main(String[] args) {

        Fecha1 f1 = new Fecha1(26, 3, 2018);
        Fecha1 f2 = new Fecha1("25-04-2020");
        if (f1.correcta() && f2.correcta()){
            
//            System.out.println("Diferencia en dias: "+f1.difDias(f2));
            System.out.println("Diferencia en meses: "+f1.difMeses(f2));
            System.out.println("Diferencia en años: "+f1.difAños(f2));
//            System.out.println("De la fecha  "+f1.cadenaCompleta(f2));
//            System.out.println("y de la fecha "+f1.cadenaSimple());
        
        System.out.println("Fecha: "+f1.cadenaSimple());
        System.out.println("Fecha: "+f2.cadenaSimple());
    }

    }
}
    

