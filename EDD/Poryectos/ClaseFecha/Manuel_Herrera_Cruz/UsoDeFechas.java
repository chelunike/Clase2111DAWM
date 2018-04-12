
package usodefechas;

import java.util.Scanner;

public class UsoDeFechas {

    public static void main(String[] args) throws Exception {
        Scanner e = new Scanner(System.in);
        System.out.println("Introduce una fecha dd/mm/aaaa o dd-mm-aaaa:");
        String x = e.nextLine();
        Fecha FechaIntroducida = new Fecha(x);
        Fecha Anterior = new Fecha(FechaIntroducida);
        Anterior.restarDias(1);
        System.out.println("FechaIntroducida "+FechaIntroducida.getString());
        System.out.println("Dia anterior "+Anterior.getString());
        System.out.println("Sumo 32 dias a Anterior");
        Anterior.añadirDias(32);
        System.out.println("Queda así: "+Anterior.getString());
        System.out.println("Resto 34 dias a Anterior");
        Anterior.restarDias(34);
        System.out.println("Queda así: "+Anterior.getString());
        System.out.println("Anterior es mayor que FechaIntroducida? = "+Anterior.mayor(FechaIntroducida));
        System.out.println(Anterior.diferenciaDias(FechaIntroducida)+" dias de diferencia entre Anterior y FechaIntroducida");
        System.out.println("Fecha completa Anterior: "+Anterior.getFullString());
        System.out.println("Fecha completa Introducida: "+FechaIntroducida.getFullString());
        System.out.println("Intercambio "+Anterior.getString()+" por "+FechaIntroducida.getString());
        Anterior.intercambio(FechaIntroducida);
        System.out.println("Intercambio realizado "+Anterior.getString()+" por "+FechaIntroducida.getString());   
        System.out.println("Calendario Anterior: \r\n"+Fecha.Calendario(Anterior));
        
        FechaIntroducida.añadirDias(100);
        System.out.println(Anterior.getString() +" - "+FechaIntroducida.getString());
        System.out.println("Añadi 100 dias, Diferencia meses: "+Anterior.diferenciaMes(FechaIntroducida));
        FechaIntroducida.añadirDias(300);
        System.out.println(Anterior.getString() +" - "+FechaIntroducida.getString());
        System.out.println("Añadi 300 dias, Diferencia años: "+Anterior.diferenciaAño(FechaIntroducida));
    }
    
}
