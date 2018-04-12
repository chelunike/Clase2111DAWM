package fecha;   //Sergio Muñoz Herrera

public class Fecha {

    public static void main(String[] args) {

        Fecha1 fecha = new Fecha1(19, 10, 1999);
        
        
        Fecha1 fecha2 = new Fecha1("19-11-2014");

  
        System.out.println("El dia siguientes es: " 
                + fecha.diaNext() + " ");
        
        System.out.println("La diferencia en dias es de: " 
                + fecha.diferenciaDias(fecha2));
				
        
        
        

    }
}
