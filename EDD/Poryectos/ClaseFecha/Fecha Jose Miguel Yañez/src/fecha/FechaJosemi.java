package fecha;

public class FechaJosemi {

    public static void main(String[] args) {

        Fecha1Josemi fecha = new Fecha1Josemi(25, 11, 1999);
        Fecha1Josemi fecha2 = new Fecha1Josemi("25-10-2016");

        /*
        if(fecha.comprobar() && fecha2.comprobar()){
            if(fecha.menorFecha(fecha2))
                fecha.intercambia(fecha2);
            System.out.println("Diferencia en dias: "+fecha.diferenciaDias(fecha2));
        }*/
        System.out.println("Dia siguiente: " + fecha.diaNext() + " ");
        System.out.println("Diferencia año:" + fecha.difAño(fecha, fecha2));
        System.out.println("Diferencia dias:" + fecha.diferenciaDias(fecha2));

    }
}
