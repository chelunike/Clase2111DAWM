package escuela_2.pkg0;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author SIDiu
 */
public class Escuela_20 {

    public static void main(String[] args) {
        // codigo <aqui> code </aqui>
        
        //-------------------Pruebas---------------------------
        
        //System.out.println("Numero dos: "+(double)((int)(Math.random()*1000))/100 );
        
        //------------------------------------------------------
        
        //Creamos Alumnos imajinarihos
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate test = LocalDate.parse("03-03-1999",fmt);
        
        Alumno yo = AlumnoBch.crearAlumno("yo", test, 0);
        Alumno david = AlumnoDa.crearAlumno("David", "10-12-1990", "Apto", 9.7);
        Alumno josemi = AlumnoBch.crearAlumno("Josemi", "12-10-1999", 5.5);
        

        //Creamos nuestra clase Clase Con Clase :)
        Clase pr = new Clase("Progrmacion");
        
        //Insertamos en la clase
        pr.insertarAlumno(yo);
        pr.insertarAlumno(david);
        pr.insertarAlumno(josemi);
       
        //Imprimido la clase
        System.out.println("Alumnos\n"+pr.toString());
       
    }
    
}
