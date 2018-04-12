
package edfechadavid;

public class EdfechaDavid {

    public static void main(String[] args) {
    
        Fecha2 f1 = new Fecha2(29, 07, 2017);
        Fecha2 f2= new Fecha2("29-09-2018");
       if (f1.correcto()){
           System.out.println("La fecha introducida es correcta.");
       
       if (f2.correcto()){
           System.out.println("La fecha introducida es correcta.");
        
       System.out.println("y de la fecha " +f1.cadenaSimple());
        System.out.println("y de la fecha " +f2.cadenaSimple());
              if (f1.correcto() && f2.correcto()){
                  if (f1.mayorQue(f2)){

                      System.out.println("queremos intercambiar "+ f1.cadenaSimple() + " con " + f2.cadenaSimple());
                
                      
                  }
              }      

            
               
    
}
}
    }
    }
    

