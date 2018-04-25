package escuela_2.pkg0;

import java.time.LocalDate;

/**
 * @author SIDiu
 */
public class Escuela_20 {

    public static void main(String[] args) {
        // codigo <aqui> code </aqui>
        
        /*//-------------------Pruebas---------------------------
        
        System.out.println("Numero dos: "+(double)((int)(Math.random()*1000))/100 );
        
        //------------------------------------------------------
        */
        
        //Creamos Alumnos imajinarihos
        LocalDate test = LocalDate.now();
        
        
        Alumno yo = new AlumnoBch("yo","12-12-2234",6.5);

        
        System.out.println("Alumno: "+yo.toString());
        
       
       
       
    }
    
}
