package alumno;
import java.time.LocalDate;

/**
 * @author yo
 */
public class Alumno extends Persona{
    
    //Atributos
    private int curso;
    
    //Constructor
    public Alumno(String nombre, LocalDate fechaNacimiento, int curso){
        super(nombre,fechaNacimiento);
        this.curso = curso;
    }
    
    public Alumno(String nombre, String fechaNacimiento, int curso){
        super(nombre,fechaNacimiento);
        this.curso = curso;
    }
    
    //Metodos
    
    
    //Get
    public int getCurso() {
        return curso;
    }
    
    
}
