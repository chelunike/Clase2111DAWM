/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDFecha;

/**
 *
 * @author Diurno
 */
public class EDFecha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Fecha f1 = new Fecha(28,5,1999);
      Fecha f2 = new Fecha(8,11,2017);
    if(f1.correcta())
        System.out.println("CORRECTA");
      else
            System.out.println("FALLO");
//    int d,m,a;
//    d=Fecha.leerdia();
//    m=Fecha.leermes();
//    a=Fecha.leeraño();
//       
//    System.out.println(d+"/"+m+"/"+a);
if(f2.correcta())
        System.out.println("CORRECTA");
      else
            System.out.println("FALLO");
        if(f2.correcta()&&f1.correcta()){
            System.out.println(f1.mayorQue(f2));
     Fecha.intercambio(f1,f2);
     System.out.println("fecha 1 "+f1.cadenaSimple());    
     System.out.println("fecha 2 "+f2.cadenaSimple());  
           // System.out.println(f1.diferenciasDia(f2));
            System.out.println("Diferencia en años: "+f1.diferenciaAño(f2));
            System.out.println("Diferencia en meses: "+f1.diferenciaMes(f2));
        
      
   
   
        
        }
//    }    
    
    }
    
  
}
