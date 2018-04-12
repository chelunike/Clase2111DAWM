
package EDFecha;


public class EDFecha {
    
    public static void main(String[]args){
        Fecha f1 = new Fecha(27,02,2015);
        Fecha f2 = new Fecha("28-02-2012");
        
       
        if (f1.correcta()&&f2.correcta()){
            System.out.println("fecha 1 es correcta y es "+f1.cadenaSimple());
            System.out.println("fecha 2 es correcta y es "+f2.cadenaSimple());
            
            if (f1.mayorQue(f2)){
      
            System.out.println("la fecha 1 es mayor que la fecha 2");
            }
            if (f2.mayorQue(f1)){
            System.out.println("la fecha 1 es menor que la fecha 2");
            //metodo intercambio, en el que intercambiamos las fechas de los objetos
            Fecha.intercambio(f1, f2);
            System.out.println("fechas intercambiadas");
            System.out.println(f1.cadenaSimple());
            System.out.println(f2.cadenaSimple());
        }
        }
            else
            System.out.println("fallo al introducir fechas");
        
        // metodo difAños, nos dice la diferencia de años entre una fecha y otra
        System.out.println("la diferencia de años entra la fecha mayor y la menor es: "+f1.difAños(f2));      
        
        // metodo difMeses nos dice la diferencia de meses entre una fecha y otra
        System.out.println("la diferencia de meses entra la fecha mayor y la menor es: "+f1.difMeses(f2)); 
        
        // metodo difDias nos dice la diferencia de dias entre una fecha y otra
       // System.out.println("la diferencia de dias entra la fecha mayor y la menor es: "+f1.difDias(f2)); 
        
        //metodo cadenaCompleta que nos de la fecha con el nombre del dia el nombre del mes y el año
        
        
        
    }
    
    
}
