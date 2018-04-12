package fecha;

public class Fecha {

    public static void main(String[] args) {

        Fecha1 fecha = new Fecha1(25, 11, 2015);
        Fecha1 fecha2 = new Fecha1("10-01-2017");
        
//        if(fecha.comprobar() && fecha2.comprobar()){
//            if(fecha.menorFecha(fecha2))
//                fecha.intercambia(fecha2);
//            System.out.println("Diferencia en dias: "+fecha.diferenciaDias(fecha2));
//        }

        System.out.println("Dia siguiente: " + fecha.diaNext() + " ");
        System.out.println("Diferencia dias:" + fecha.diferenciaDias(fecha2));

    }
}

