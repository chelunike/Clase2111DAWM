 //q nos devuelva la fecha en formato de cadena 
package fecha2;
 

public class Edfecha {
    
    public static void main (String[] args) {
        Fecha2 f1 = new Fecha2(29, 02, 2016);
        Fecha2 f2= new Fecha2("25-04-2018");
       if (f1.correcto()){
           System.out.println("Es correcta");
       
       if (f2.correcto()){
           System.out.println("Es correcta");
        
       System.out.println("y de la fecha " +f1.cadenaSimple());
        System.out.println("y de la fecha " +f2.cadenaSimple());
              if (f1.correcto() && f2.correcto()){
                  if (f1.mayorQue(f2)){
                      System.out.println("Vamos a intercambiar... ");
                      
                
                      
                  }
              }      

            
               
    
}
}
    }
}

