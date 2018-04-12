

package EDFecha;


public class EDFecha {
    
    public static void main(String[]args){
        Fecha f1 = new Fecha(25,07,2017);
        Fecha f2 = new Fecha("28-06-2011");
        Fecha com1 = new Fecha(30,12,1999);
        Fecha com2 = new Fecha(30,12,1999); 
       
        if (f1.correcta()&&f2.correcta()){
            System.out.println(f1.cadenaSimple()+ " y " +f2.cadenaSimple()+ " son una fecha correctas");
            if (f1.mayorQue(f2)){
            com1=f1;
            com2=f2;
            System.out.println(com1.cadenaSimple()+" es mayor que "+com2.cadenaSimple());
            }
        else {
            com2=f1;
            com1=f2;
            System.out.println(com1.cadenaSimple()+" es mayor que "+com2.cadenaSimple());
            }
        }
            else
            System.out.println("Fechas incorrectas");
      
    }
    
    
}
