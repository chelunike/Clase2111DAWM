
package calendario;

import java.util.Scanner;


public class Calendario {

   
    public static void main(String[] args) {
        Fecha f1= new Fecha(01,12,2016);
        Fecha f2= new Fecha(01,02,2014);
        
       Scanner dia = new Scanner(System.in);
       Scanner mes = new Scanner(System.in);
       Scanner anno = new Scanner(System.in);
       
      Fecha fecha = new Fecha(02,02,2016);
      Fecha fecha2= new Fecha(01,02,2014);
      if(f1.correcta() && f2.correcta()){
          if(f1.mayorQue(f2));
              
          
      }
    


      
        System.out.println("¿La fecha es correcta?: " + fecha.correcta());
        System.out.println("¿El año es bisiesto?: " + fecha.bisiesto());
        System.out.println("¿El dia del mes es correcto?: " + fecha.correcta());
       
    }
      
        Fecha fecha2= new Fecha(01,13,2014);
//        System.out.println("¿La fecha es correcta?: " + Fecha.intercambio(fecha, fecha)
}
//       int dias, meses, annos;
//       
//        System.out.println("Introduzca un dia: ");
//        dias = dia.nextInt();
//        System.out.println("Introduzca un mes: ");
//        meses = mes.nextInt();
//        System.out.println("Introduzca un año: ");
//        annos = anno.nextInt();
//        
//        
//        System.out.println("La fecha: " + dia + "/" + mese + "/" + anno + " ¿es correcta?: " + correcta() + " y el año " + annos + " ¿es bisiesto?:  " + bisiesto(anno));
        }
    
    
    
     


