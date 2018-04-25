package escuela_2.pkg0;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * @author yo
 */
public class AlumnoBch extends Alumno{
    
    //Variables
    double notaPau;
    
    
    //Constructor
    //public AlumnoBch(){}
    private AlumnoBch(String nombre, LocalDate fechaNaci, double notaPAU){
        super(nombre,fechaNaci);
        notaPau = notaPAU;
        this.setCurso("Bachiller");
        this.insertarAsigs();
        this.insertaNotasRandom();
    }
    
    public static Alumno crearAlumno(String nombre, LocalDate fechaNacim, double notaPau){
        
        LocalDate hoy = LocalDate.now();
        if((int)ChronoUnit.YEARS.between(fechaNacim, hoy) < 0)
            return null;
        else
            return new AlumnoBch(nombre, fechaNacim, notaPau);
    }
    
    public static Alumno crearAlumno(String nombre, String fechaNacim, double notaPau){
        try{
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MM yyyy");
            if(fechaNacim.contains("/"))
                fmt = DateTimeFormatter.ofPattern("d/MM/yyyy");
            else if(fechaNacim.contains("-"))
                fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaNaci = LocalDate.parse(fechaNacim,fmt);
            LocalDate hoy = LocalDate.now();
            if((int)ChronoUnit.YEARS.between(fechaNaci, hoy) < 16)
                return null;
            else
                return new AlumnoBch(nombre, fechaNaci, notaPau);
        }catch (java.time.format.DateTimeParseException n){
            System.err.println("Error, Formato de fecha incorrecto\n\t Vayase a freir esparragos :) \n\t Y que tenga un buen dia");
            return null;
        }catch(Exception e){
            System.err.println("Error inesperado en tiempo de ejecucion");
            return null;
        }

    }
    
    
    //metodos
    
    @Override
    public double notaMedia(){
        double medias = 0;
        ArrayList <AsigNota> tmp = this.getNotas();
        for(AsigNota n:tmp)
            medias += n.getNota();

        medias += this.notaPau;
        medias /= tmp.size()+1;
        
        return medias;
    }
    
    @Override
    public String[] obtenerAsignaturas(){
        return Cursos.getAsigBch();
    }
    
    
}
