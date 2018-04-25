package escuela_2.pkg0;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * @author yo
 */
public class AlumnoDa extends Alumno {
    
    //Variables
    String notaFct;
    double notaProyect;
    
    //Constructor
    //public AlumnoDa(){}
    private AlumnoDa(String nombre, LocalDate fechaNaci, String notaFct, double notaProyecto){
        super(nombre, fechaNaci);
        this.notaFct = notaFct;
        this.notaProyect = notaProyecto;
        this.setCurso("Formacion Profesional");
        this.insertarAsigs();
        this.insertaNotasRandom();
    }
    
    public static Alumno crearAlumno(String nombre, LocalDate fechaNacim, String notaFct, double notaProyecto){
        LocalDate hoy = LocalDate.now();
        if((int)ChronoUnit.YEARS.between(fechaNacim, hoy) < 18)
            return null;
        else
            return new AlumnoDa(nombre, fechaNacim, notaFct, notaProyecto);
    }
    
    public static Alumno crearAlumno(String nombre, String fechaNacim, String notaFct, double notaProyecto){
        try{
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MM yyyy");
            if(fechaNacim.contains("/"))
                fmt = DateTimeFormatter.ofPattern("d/MM/yyyy");
            else if(fechaNacim.contains("-"))
                fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaNaci = LocalDate.parse(fechaNacim,fmt);
            LocalDate hoy = LocalDate.now();
            if((int)ChronoUnit.YEARS.between(fechaNaci, hoy) < 18)
                return null;
            else
                return new AlumnoDa(nombre, fechaNaci, notaFct, notaProyecto);
        }catch (java.time.format.DateTimeParseException n){
            System.err.println("Error, Formato de fecha incorrecto\n\t Vayase a freir esparragos :) \n\t Y que tenga un buen dia");
            return null;
        }catch(Exception e){
            System.err.println("Error inesperado en tiempo de ejecucion");
            return null;
        }
    }
    
    
    //Get y Set

    //Metodos
    
    @Override
    public double notaMedia(){
        double medias = 0;
        ArrayList <AsigNota> tmp = this.getNotas();
        if(this.notaFct.compareToIgnoreCase("Apto") == 0){
            for(AsigNota n:tmp)
                medias += n.getNota();

            medias += this.notaProyect;
            medias /= tmp.size()+1;
        }

        return medias;
    }
    
    @Override
    public String[] obtenerAsignaturas(){
        return Cursos.getAsigFp();
    }
    
}
